package com.saieeash.Authentication.with.Jpa.controllers;

import com.saieeash.Authentication.with.Jpa.entity.User;
import com.saieeash.Authentication.with.Jpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HomeController {

    @Autowired
    UserRepository repo;

    @GetMapping("/")
    public String home(){
        return ("<h1> Welcome </h1>");
    }

    @GetMapping("/user")
    public String user(){
        return ("<h1> Welcome User </h1>");
    }

    @GetMapping("/admin")
    public String admin(){
        return ("<h1> Welcome Admin </h1>");
    }

    @GetMapping("/getUsers")
    public List<User> getUsers(){
        return repo.findAll();
    }
}
