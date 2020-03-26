package com.learning.spring.githubapiwrapper.controller;

import com.learning.spring.githubapiwrapper.entities.User;
import com.learning.spring.githubapiwrapper.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MyController {
    @Autowired
    private UserRepo userRepo;

    @GetMapping("/")
    public String greeting() {
        return "redirect:/home";
    }

    @GetMapping("/home")
    public String greeting2() {
        return "home";
    }

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(User user) {
        User userFromDB = userRepo.findByEmail(user.getEmail());

        if (userFromDB != null) {
            return "redirect:/exist";
        }

        userRepo.save(user);

        return "redirect:/login";
    }

    @GetMapping("exist")
    public String exist() {
        return "exist";
    }
}
