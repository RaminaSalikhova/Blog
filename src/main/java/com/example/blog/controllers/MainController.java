package com.example.blog.controllers;

import com.example.blog.models.Post;
import com.example.blog.repo.PostRepository;
import com.example.blog.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class MainController {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private EmailService emailService;
//    @Autowired
//    private JavaMailSender javaMailSender;
//
//
//    public void sendMeEmail(String name, String message, String email) {
//
//        SimpleMailMessage msg = new SimpleMailMessage();
//        msg.setTo("slkhvaRamina@gmail.com");
//
//        msg.setSubject("Name " + name + " email: " + email);
//        msg.setText(message);
//
//        javaMailSender.send(msg);
//
//    }

    @GetMapping("/")
    public String home(Model model) {
        Iterable<Post> posts = postRepository.findAll();
        model.addAttribute("posts", posts);
//        model.addAttribute("title", "Main page");
        return "home";
    }

    @GetMapping("/about")
    public String about(Model model) {
        model.addAttribute("title", "About us");
        return "about";
    }


    @GetMapping("/{id}")
    public String blogDetails(@PathVariable(value = "id") long id, Model model) {
        if (!postRepository.existsById(id)) {
            return "redirect:/blog";
        }
        Optional<Post> post = postRepository.findById(id);
        ArrayList<Post> res = new ArrayList<>();
        post.ifPresent(res::add);
        model.addAttribute("post", res);
        return "blog-details";
    }

    @GetMapping("/subscribe")
    public String subscribe(Model model) {
        model.addAttribute("title", "Subscribe");
        return "subscribe";
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("title", "Login");
        return "login";
    }

    @PostMapping("/sendMessage")
    public String sendMessage(@RequestParam String name, @RequestParam String email, @RequestParam String message, Model model) {
        emailService.sendMeEmail(name, message, email);
//        model.addAttribute("title", "Login");
        return "redirect:/";
    }

//    @GetMapping("/publisher")
//    public String publisherAccount(Model model) {
//        model.addAttribute("title", "Publisher account");
//        return "publisher-home";
//    }
//
//    @GetMapping("/publisher/home")
//    public String publisherHome(Model model) {
//        model.addAttribute("title", "Publisher account");
//        return "publisher-home";
//    }

}
