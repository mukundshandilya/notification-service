package com.notification.service;

import com.notification.dto.NotificationRequest;
import com.notification.dto.NotificationResponse;
import com.notification.model.Notification;
import com.notification.model.NotificationStatus;
import com.notification.repository.NotificationRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import com.notification.exception.NotificationNotFoundException;
import com.notification.mapper.NotificationMapper;
import com.notification.exception.NotificationInsertException;


@Service
public class NotificationService {

    private static final Logger log = LoggerFactory.getLogger(NotificationService.class);

    private final NotificationRepository repository;

    public NotificationService(
            NotificationRepository repository) {

        this.repository = repository;
    }

    public NotificationResponse createNotification(
            NotificationRequest request) {
        Notification jpaNotification;

        try {
            log.info("Initiated insert notification request");
            jpaNotification = repository.save(NotificationMapper.toNotificationModel(request));
            log.info("Notification inserted successfully, id={}", jpaNotification.getId());

        } catch (Exception e) {

            log.error("Failed to insert notification " + e.getStackTrace());

            throw new NotificationInsertException("Notification insertion failed");
        }

        NotificationResponse insertResult = NotificationMapper.toNotificationResponseDTO(jpaNotification);

        return insertResult;
    }

    public NotificationResponse getNotification(Long id) {

         log.info("Fetch notification using id={}", id);

        Optional<Notification> optionalEntity = repository.findById(id);

        if (optionalEntity.isEmpty()) {
            throw new NotificationNotFoundException("Notification not found");
        }
        Notification notification = optionalEntity.get();

        NotificationResponse result = NotificationMapper.toNotificationResponseDTO(notification);
         log.info("Fetched notification successfully : {}", result );

        return result;
    }

    public List<NotificationResponse> getNotificationByStatus(NotificationStatus status) {

        log.info("Fetch notifications using status={}", status);


        List<Notification> notifications = repository.findByStatus(status);

        if (notifications.isEmpty()) {
            return Collections.emptyList();
        }

        List<NotificationResponse> notificationResponses = new ArrayList<>();
        
        for (Notification notification : notifications) {
            NotificationResponse result = NotificationMapper.toNotificationResponseDTO(notification);
            notificationResponses.add(result);
        }

        log.info("Fetched notifications successfully : {}", notificationResponses );

        return notificationResponses;
    }
}