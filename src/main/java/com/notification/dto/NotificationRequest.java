package com.notification.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class NotificationRequest {

    @NotBlank
    private String recipient;
    @Size(max = 500)
    private String message;

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "NotificationRequest{" +
                "recipient='" + recipient + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}