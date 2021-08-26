package com.example.blog.services;

import com.example.blog.models.Post;
import com.example.blog.models.Subscriber;
import com.example.blog.repo.PostRepository;
import com.example.blog.repo.SubscriberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Optional;
import java.util.Properties;

@Component
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;


    public void sendMeEmail(String name, String message, String email) {

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo("slkhvaRamina@gmail.com");

        msg.setSubject("Name " + name + " email: " + email);
        msg.setText(message);

        javaMailSender.send(msg);

    }

    public void mailingSend(String email) {

            SimpleMailMessage msg = new SimpleMailMessage();
            msg.setTo(email);
            msg.setSubject("Blog mailing");
            msg.setText("Hurry up! You can read new post at our website.");
            javaMailSender.send(msg);

    }
}
