package com.notification.dto;

import java.time.LocalDateTime;

import com.notification.model.NotificationStatus;

public class NotificationResponse {

    private Long id;
    private String recipient;
    private String message;
    private NotificationStatus status;
    private LocalDateTime createdAt;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
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
    public NotificationStatus getStatus() {
        return status;
    }
    public void setStatus(NotificationStatus status) {
        this.status = status;
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

        @Override
    public String toString() {
        return "NotificationResponse{" +
                "id='" + id + '\'' +
                ", recipient='" + recipient + '\'' +
                ", message='" + message + '\'' +
                ", status='" + status + '\'' +
                ", createdAt='" + createdAt + '\'' +
                '}';
    }
}
