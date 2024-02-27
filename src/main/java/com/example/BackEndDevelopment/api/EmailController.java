package com.example.BackEndDevelopment.api;

import com.example.BackEndDevelopment.entity.EmailForm;
import com.example.BackEndDevelopment.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:4200")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/api/send-email/{Email}")
    public ResponseEntity<String> sendEmail(@RequestBody EmailForm emailForm,@PathVariable String Email) {
        boolean result = emailService.sendEmail(emailForm,Email);
        if (result) {
            return ResponseEntity.ok("Email sent successfully");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to send email");
        }
    }
}