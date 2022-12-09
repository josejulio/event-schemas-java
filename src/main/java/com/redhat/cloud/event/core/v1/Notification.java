package com.redhat.cloud.event.core.v1;

import com.fasterxml.jackson.annotation.*;

/**
 * Notification event. Appropriate when an event has no data aside from recipient settings.
 * If the event requires data, then it should reference the Recipient object definition in a
 * separate schema.
 */
public class Notification {
    private Recipients notificationRecipients;

    @JsonProperty("notification_recipients")
    public Recipients getNotificationRecipients() { return notificationRecipients; }
    @JsonProperty("notification_recipients")
    public void setNotificationRecipients(Recipients value) { this.notificationRecipients = value; }
}
