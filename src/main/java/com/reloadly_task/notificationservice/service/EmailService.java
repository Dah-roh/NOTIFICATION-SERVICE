package com.reloadly_task.notificationservice.service;

import com.reloadly_task.notificationservice.dto.EmailNotificationRequest;
import com.reloadly_task.notificationservice.dto.NotificationResponse;

public interface EmailService {

    NotificationResponse sendEmail(final EmailNotificationRequest emailNotificationRequest);
}
