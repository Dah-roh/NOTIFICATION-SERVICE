package com.reloadly_task.notificationservice.service.impl;

import com.reloadly_task.notificationservice.dto.EmailNotificationRequest;
import com.reloadly_task.notificationservice.dto.NotificationResponse;
import com.reloadly_task.notificationservice.service.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

import static org.bouncycastle.asn1.iana.IANAObjectIdentifiers.mail;

@Service
public class EmailServiceImpl implements EmailService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private JavaMailSender mailSender;

    @Override
    public NotificationResponse sendEmail(EmailNotificationRequest emailNotificationRequest) {
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();

            SimpleMailMessage msg = new SimpleMailMessage();
            msg.setFrom(emailNotificationRequest.getFrom());
            msg.setText(emailNotificationRequest.getNarration());
            msg.setTo(emailNotificationRequest.getTo());

            msg.setSubject("Testing from Spring Boot");
            msg.setText("Hello World \n Spring Boot Email");

            mailSender.send(msg);
            return null;
        } catch (Exception e) {
            log.info("Failed to send message!", e.getCause());
        }
        return new NotificationResponse("FAILED TO SEND NOTIFICATION", false, new Date());
    }
}