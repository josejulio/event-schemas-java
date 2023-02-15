package com.redhat.cloud.event.core;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.redhat.cloud.event.core.v1.RHELSystem;
import com.redhat.cloud.event.core.v1.SystemClass;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ParserTest {

    @Test
    public void omitEmptyFieldsTest() throws JsonProcessingException {
        RHELSystem rhelSystem = new RHELSystem();
        SystemClass system = new SystemClass();
        system.setInventoryID(UUID.randomUUID().toString());
        rhelSystem.setSystem(system);

        ObjectMapper mapper = new ObjectMapper();

        String jsonString = mapper.writeValueAsString(rhelSystem);

        JsonNode node = mapper.readTree(jsonString).get("system");

        assertNull(system.getDisplayName());
        assertFalse(node.has("display_name"));
    }
}
