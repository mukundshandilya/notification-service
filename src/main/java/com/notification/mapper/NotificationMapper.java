package com.notification.mapper;

import com.notification.dto.NotificationRequest;
import com.notification.dto.NotificationResponse;
import com.notification.model.Notification;
import com.notification.model.NotificationStatus;

import java.time.LocalDateTime;

public class NotificationMapper {


    public static NotificationResponse toNotificationResponseDTO(Notification notification) {
        NotificationResponse notificationResponse = new NotificationResponse();
        notificationResponse.setId(notification.getId());
        notificationResponse.setMessage(notification.getMessage());
        notificationResponse.setRecipient(notification.getRecipient());
        notificationResponse.setStatus(notification.getStatus());
        notificationResponse.setCreatedAt(notification.getCreatedAt());
        return notificationResponse;
    }

    public static Notification toNotificationModel(NotificationRequest notificationRequest) {
        Notification notification = new Notification();
        notification.setRecipient(notificationRequest.getRecipient());
        notification.setMessage(notificationRequest.getMessage());
        notification.setCreatedAt(LocalDateTime.now());
        notification.setUpdatedAt(LocalDateTime.now());
        notification.setStatus(NotificationStatus.PENDING);
        return notification;
    }
    
}
