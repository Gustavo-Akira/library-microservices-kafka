package br.com.gustavoakira.library.notification.adapter.outbound.service;

import jakarta.mail.SendFailedException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    private final JavaMailSender sender;


    public EmailService(JavaMailSender sender) {
        this.sender = sender;
    }

    public void sendEmail(String to, String subject, String message) throws SendFailedException {
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setFrom("");
        mail.setTo(to);
        mail.setSubject(subject);
        mail.setText(message);
        sender.send(mail);
    }
}
