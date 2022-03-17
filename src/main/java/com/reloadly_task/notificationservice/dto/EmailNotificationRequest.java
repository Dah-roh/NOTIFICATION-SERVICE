package com.reloadly_task.notificationservice.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
public class EmailNotificationRequest {

    private String from;
    private String to;

    private String subject;

    private String narration;
}
