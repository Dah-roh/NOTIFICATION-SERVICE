package com.reloadly_task.notificationservice.dto;

import lombok.Data;

@Data
public class EmailNotificationRequest {

    private String from;
    private String to;

    private String subject;

    private String narration;
}
