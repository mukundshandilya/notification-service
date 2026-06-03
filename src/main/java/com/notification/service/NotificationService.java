package com.notification.service;

import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    public String sendNotification() {
        return "Notification accepted";
    }
}