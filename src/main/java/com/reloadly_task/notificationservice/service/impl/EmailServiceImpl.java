package com.reloadly_task.notificationservice.service.impl;

import com.reloadly_task.notificationservice.dto.EmailNotificationRequest;
import com.reloadly_task.notificationservice.dto.NotificationResponse;
import com.reloadly_task.notificationservice.service.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class EmailServiceImpl implements EmailService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());
    JavaMailSender emailSender;


    @Override
    public NotificationResponse sendEmail(EmailNotificationRequest emailNotificationRequest) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(emailNotificationRequest.getFrom());
            message.setTo(emailNotificationRequest.getTo());
            message.setSubject(emailNotificationRequest.getSubject());
            message.setText(emailNotificationRequest.getNarration());
            this.emailSender.send(message);
            return new NotificationResponse("Sent successfully!", true, new Date());
        } catch (Exception e) {
            log.info("Failed to send Notification", e.getMessage());
        }

        return new NotificationResponse("Sending Failed!", false, new Date());
    }
}
