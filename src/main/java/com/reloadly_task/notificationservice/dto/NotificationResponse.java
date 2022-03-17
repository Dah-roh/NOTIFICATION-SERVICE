package com.reloadly_task.notificationservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
public class NotificationResponse {

    private String message;
    private boolean status;
    private Date timeStamp;
}
