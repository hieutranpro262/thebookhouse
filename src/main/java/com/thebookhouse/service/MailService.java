package com.thebookhouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import com.thebookhouse.model.User;

@Service
public class MailService {

    @Autowired
    private MailSender mailSender;

    public void sendUserConfirmationMail(User user) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("noreply@thebookhouse.com");
        message.setTo(user.getEmail());
        message.setSubject("New registration from " + user.getName());
        message.setText("Click here to finish your registration.");

        mailSender.send(message);
    }

}
