package com.example.BackEndDevelopment.service;

import com.example.BackEndDevelopment.entity.EmailForm;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailService {


    @Autowired
    private JavaMailSender javaMailSender;

    public boolean sendEmail(EmailForm emailForm,String Email) {
        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setTo(Email);
            helper.setSubject("New Contact Form Submission");
            helper.setText("Name: " + emailForm.getName() + "\nEmail: " + emailForm.getEmail() + "\nMessage: " + emailForm.getMessage());
            javaMailSender.send(message);
            return true;
        } catch (MessagingException e) {
            e.printStackTrace();
            return false;
        }
    }
}
