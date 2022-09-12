const {
  quicktypeMultiFile,
  InputData,
  JSONSchemaInput,
  JSONSchemaStore,
} = require("quicktype-core");
const { execSync } = require("child_process");
const fsPromises = require("fs/promises");
const fs = require("fs");
const path = require("path");
const BASE_JAVA_PACKAGE = 'com.redhat.cloud.event';
const BASE_JAVA_SRC_PATH = "src/main/java";

class StaticJSONSchemaStore extends JSONSchemaStore {
  constructor() {
    super();
  }
  async fetch(address) {
    const contents = await fsPromises.readFile(address);
    return JSON.parse(contents);
  }
}

async function generateFiles(repoRoot, subdir) {
  const versions = await fsPromises.readdir(`${repoRoot}/api/schemas/${subdir}`);
  for (const version of versions) {
    const schemas = await fsPromises.readdir(`${repoRoot}/api/schemas/${subdir}/${version}`);
    for (const schema of schemas) {
      const schemaPath = `${repoRoot}/api/schemas/${subdir}/${version}/${schema}`;
      let jsonSchemaString = await fsPromises.readFile(schemaPath, {encoding: 'utf8'});
      const filename = path.basename(schemaPath);
      const schemaInput = new JSONSchemaInput(new StaticJSONSchemaStore());
      const inputData = new InputData();

      // overrides
      if (schema === 'events.json' && subdir === 'events') {
        // Data takes types from other schemas - to avoid repeating common schemas lets just have anything in this property.
        const eventsSchema = JSON.parse(jsonSchemaString);
        if (eventsSchema.properties.data) {
          eventsSchema.properties.data = true
        }

        jsonSchemaString = JSON.stringify(eventsSchema);
      }

      await schemaInput.addSource({
        name: filename.replace('.json', ''),
        uris: [schemaPath],
        schema: jsonSchemaString
      });
      inputData.addInput(schemaInput);
      await generateJavaFiles(subdir, version, inputData, schema);
    }
  }
}

async function generateJavaFiles(subdir, version, inputData, _schema) {
  const subPackage = `${subdir.replaceAll('/', '.')}.${version}`;
  const packageName = `${BASE_JAVA_PACKAGE}.${subPackage}`;
  const outputPath = `${BASE_JAVA_SRC_PATH}/${packageName.replaceAll('.', '/')}`;
  const result = await quicktypeMultiFile({
    inputData,
    lang: "java",
    rendererOptions: {
      package: packageName,
    },
  });
  await fsPromises.mkdir(outputPath, {recursive: true});
  for (const [filename, contents] of result) {
    await fsPromises.writeFile(`${outputPath}/${filename}`, contents.lines.join('\n'));
  }
}

async function main() {
  const repoRoot = execSync('git rev-parse --show-toplevel', { encoding: 'utf8' }).trim();
  console.info('Clearing out existing source files')
  for (const path of ['apps', 'core']) {
    fs.rmSync(`${repoRoot}/${path}`, {recursive: true, force: true});
  }
  console.info('Generating source files');
  const apps = await fsPromises.readdir(`${repoRoot}/api/schemas/apps/`);
  await generateFiles(repoRoot, 'events');
  await generateFiles(repoRoot, 'core');
  for (const app of apps) {
    await generateFiles(repoRoot, `apps/${app}`);
  }
}

main();
