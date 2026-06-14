package com.notification.service;

import com.notification.dto.NotificationRequest;
import com.notification.model.Notification;
import com.notification.repository.NotificationRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class NotificationService {

    private final NotificationRepository repository;


    public NotificationService(
            NotificationRepository repository) {

        this.repository = repository;
    }

    public Notification createNotification(
            NotificationRequest request) {

        Notification notification =
                new Notification(
                        request.getRecipient(),
                        request.getMessage(),
                        LocalDateTime.now(),
                        LocalDateTime.now()
                );

        repository.save(notification);

        return notification;
    }

    public Notification getNotification(Long id) {
        Optional<Notification> optionalEntity = repository.findById(id);
        Notification result = optionalEntity.get();
        return result;
    }
}