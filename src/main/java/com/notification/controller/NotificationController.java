package com.notification.controller;

import com.notification.dto.NotificationRequest;
import com.notification.service.NotificationService;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    private final NotificationService notificationService;

    public NotificationController(
            NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping
    public String sendNotification(
            @RequestBody NotificationRequest request) {

        return notificationService.sendNotification();
    }
}