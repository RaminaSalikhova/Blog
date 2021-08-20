package com.example.blog.services;

import com.example.blog.repo.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

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

//    @Autowired
//    private PostRepository postRepository;
//
//
//    public void mailingSend() {
//
//
//        SimpleMailMessage msg = new SimpleMailMessage();
//        msg.setTo("slkhvaRamina@gmail.com");
//
//        msg.setSubject("Name "+ name+ " email: "+ email);
//        msg.setText(message);
//
//        javaMailSender.send(msg);
//
//    }


}
