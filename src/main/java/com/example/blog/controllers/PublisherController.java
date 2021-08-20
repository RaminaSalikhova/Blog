package com.example.blog.controllers;

import com.example.blog.models.Post;
import com.example.blog.repo.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class PublisherController {

    @Autowired
    private PostRepository postRepository;

//    @GetMapping("/publisher")
//    public String publisherAccount(Model model) {
//        model.addAttribute("title", "Publisher account");
//        return "publisher-home";
//    }
//
    @GetMapping("/publisher/home")
    public String publisherHome(Model model) {
        Iterable<Post> posts = postRepository.findAll();
        model.addAttribute("posts", posts);
        return "publisher-home";
    }

//    @GetMapping("/publisher/{id}")
//    public String publisherBlogDetails(@PathVariable(value = "id") long id, Model model) {
//        if (!postRepository.existsById(id)) {
//            return "redirect:/blog";
//        }
//        Optional<Post> post = postRepository.findById(id);
//        ArrayList<Post> res = new ArrayList<>();
//        post.ifPresent(res::add);
//        model.addAttribute("post", res);
//        return "blog-details";
//    }
//

    @GetMapping("/publisher/about")
    public String publisherAbout(Model model) {
        model.addAttribute("title", "About us");
        return "publisher-about";
    }

//    @GetMapping("/publisher/blog")
//    public String publisherBlogMain(Model model) {
//        Iterable<Post> posts = postRepository.findAll();
//        model.addAttribute("posts", posts);
//        return "blog-main";
//    }


}
