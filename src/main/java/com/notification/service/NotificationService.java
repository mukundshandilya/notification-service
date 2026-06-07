package com.notification.service;

import com.notification.dto.NotificationRequest;
import com.notification.model.Notification;
import com.notification.repository.NotificationRepository;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    private final NotificationRepository repository;

    private Long counter = 1L;

    public NotificationService(
            NotificationRepository repository) {

        this.repository = repository;
    }

    public Notification createNotification(
            NotificationRequest request) {

        Notification notification =
                new Notification(
                        counter++,
                        request.getRecipient(),
                        request.getMessage()
                );

        repository.save(notification);

        return notification;
    }

    public Notification getNotification(Long id) {
        return repository.findById(id);
    }
}