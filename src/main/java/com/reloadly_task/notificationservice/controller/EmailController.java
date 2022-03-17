package com.reloadly_task.notificationservice.controller;


import com.reloadly_task.notificationservice.dto.EmailNotificationRequest;
import com.reloadly_task.notificationservice.dto.NotificationResponse;
import com.reloadly_task.notificationservice.service.EmailService;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmailController {

    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping("notification/email")
    NotificationResponse sendEmail(@RequestBody EmailNotificationRequest emailNotificationRequest){
        return emailService.sendEmail(emailNotificationRequest);
    };

}
