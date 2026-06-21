package com.notification.repository;

import com.notification.model.Notification;
import com.notification.model.NotificationStatus;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Long> {

    List<Notification> findByStatus(NotificationStatus status);
}