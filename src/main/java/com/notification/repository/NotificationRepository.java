package com.notification.repository;

import com.notification.model.Notification;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class NotificationRepository {

    private final Map<Long, Notification> storage =
            new HashMap<>();

    public void save(Notification notification) {
        storage.put(notification.getId(), notification);
    }

    public Notification findById(Long id) {
        return storage.get(id);
    }
}