package com.example.SmallTasks.controller;

import com.example.SmallTasks.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mail")
public class SendEmailController {

    @Autowired
    private EmailService emailService;


    @PostMapping("/send")
    public ResponseEntity<String> sendMail(@RequestParam String to, @RequestParam String subject, @RequestParam String content){

        emailService.sendEmail(to, subject, content);

        return new ResponseEntity<>("Email Sent Successfully", HttpStatus.OK);

    }

}
