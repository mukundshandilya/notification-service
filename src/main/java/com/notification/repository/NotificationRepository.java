package com.notification.repository;

import com.notification.model.Notification;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.HashMap;
import java.util.Map;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
}