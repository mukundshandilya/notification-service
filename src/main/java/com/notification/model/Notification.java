package com.notification.model;

public class Notification {

    private Long id;
    private String recipient;
    private String message;

    public Notification() {
    }

    public Notification(Long id,
                        String recipient,
                        String message) {
        this.id = id;
        this.recipient = recipient;
        this.message = message;
    }

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
}