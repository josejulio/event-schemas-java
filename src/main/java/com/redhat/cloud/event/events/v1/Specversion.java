package com.redhat.cloud.event.events.v1;

import java.io.IOException;
import com.fasterxml.jackson.annotation.*;

/**
 * Specifies the version of the CloudEvents spec targeted.
 */
public enum Specversion {
    THE_10;

    @JsonValue
    public String toValue() {
        switch (this) {
            case THE_10: return "1.0";
        }
        return null;
    }

    @JsonCreator
    public static Specversion forValue(String value) throws IOException {
        if (value.equals("1.0")) return THE_10;
        throw new IOException("Cannot deserialize Specversion");
    }
}
