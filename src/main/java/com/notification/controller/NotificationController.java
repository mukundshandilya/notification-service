package com.notification.controller;

import com.notification.dto.NotificationRequest;
import com.notification.dto.NotificationResponse;
import com.notification.model.NotificationStatus;
import com.notification.service.NotificationService;
import jakarta.validation.Valid;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    private static final Logger log = LoggerFactory.getLogger(NotificationController.class);

    private final NotificationService service;

    public NotificationController(
            NotificationService service) {

        this.service = service;
    }

    @PostMapping
    public NotificationResponse createNotification(
            @RequestBody @Valid NotificationRequest request) {

        log.info("Notification POST request : {}", request);

        return service.createNotification(request);
    }

    @GetMapping("/{id}")
    public NotificationResponse getNotification(
            @PathVariable Long id) {

        log.info("Notification GET request id={}", id);

        return service.getNotification(id);
    }

    @GetMapping("/status")
    public List<NotificationResponse> getNotificationByStatus(
            @RequestParam NotificationStatus status) {

        log.info("Notification GET request by status={}", status);


        return service.getNotificationByStatus(status);
    }
}