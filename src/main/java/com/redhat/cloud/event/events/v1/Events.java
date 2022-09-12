package com.redhat.cloud.event.events.v1;

import com.fasterxml.jackson.annotation.*;
import java.time.OffsetDateTime;
import java.util.UUID;

/**
 * See
 * https://raw.githubusercontent.com/cloudevents/spec/main/cloudevents/formats/cloudevents.json
 * for base CloudEvents schema. NOTE: this schema inlines and further constrains some
 * CloudEvents properties
 */
public class Events {
    private Object data;
    private String dataschema;
    private UUID id;
    private String redhataccount;
    private String redhatorgid;
    private String source;
    private Specversion specversion;
    private String subject;
    private OffsetDateTime time;
    private String type;

    @JsonProperty("data")
    public Object getData() { return data; }
    @JsonProperty("data")
    public void setData(Object value) { this.data = value; }

    /**
     * Identifies the schema that data adheres to.
     */
    @JsonProperty("dataschema")
    public String getDataschema() { return dataschema; }
    @JsonProperty("dataschema")
    public void setDataschema(String value) { this.dataschema = value; }

    /**
     * Identifies the event. Unique for this source.
     */
    @JsonProperty("id")
    public UUID getID() { return id; }
    @JsonProperty("id")
    public void setID(UUID value) { this.id = value; }

    /**
     * Red Hat account number. Deprecated; redhatorgid should be used instead.
     */
    @JsonProperty("redhataccount")
    public String getRedhataccount() { return redhataccount; }
    @JsonProperty("redhataccount")
    public void setRedhataccount(String value) { this.redhataccount = value; }

    /**
     * Red Hat Organization ID
     */
    @JsonProperty("redhatorgid")
    public String getRedhatorgid() { return redhatorgid; }
    @JsonProperty("redhatorgid")
    public void setRedhatorgid(String value) { this.redhatorgid = value; }

    /**
     * Describes the source (or app) that generated the event.
     */
    @JsonProperty("source")
    public String getSource() { return source; }
    @JsonProperty("source")
    public void setSource(String value) { this.source = value; }

    /**
     * Specifies the version of the CloudEvents spec targeted.
     */
    @JsonProperty("specversion")
    public Specversion getSpecversion() { return specversion; }
    @JsonProperty("specversion")
    public void setSpecversion(Specversion value) { this.specversion = value; }

    /**
     * Describes the subject of the event. URN in format urn:redhat:subject:$instance_type:$id.
     * The urn may be longer to accommodate hierarchies
     */
    @JsonProperty("subject")
    public String getSubject() { return subject; }
    @JsonProperty("subject")
    public void setSubject(String value) { this.subject = value; }

    /**
     * Timestamp of when the occurrence happened. Must adhere to RFC 3339.
     */
    @JsonProperty("time")
    public OffsetDateTime getTime() { return time; }
    @JsonProperty("time")
    public void setTime(OffsetDateTime value) { this.time = value; }

    /**
     * The type of the event.
     */
    @JsonProperty("type")
    public String getType() { return type; }
    @JsonProperty("type")
    public void setType(String value) { this.type = value; }
}
