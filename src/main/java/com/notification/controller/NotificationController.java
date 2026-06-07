package com.notification.controller;

import com.notification.dto.NotificationRequest;
import com.notification.model.Notification;
import com.notification.service.NotificationService;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    private final NotificationService service;

    public NotificationController(
            NotificationService service) {

        this.service = service;
    }

    @PostMapping
    public Notification createNotification(
            @RequestBody NotificationRequest request) {

        return service.createNotification(request);
    }

    @GetMapping("/{id}")
    public Notification getNotification(
            @PathVariable Long id) {

        return service.getNotification(id);
    }
}