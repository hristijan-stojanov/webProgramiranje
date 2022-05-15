package com.webshop.web;

import com.webshop.model.Category;
import com.webshop.service.impl.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UserController {
    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }
    @GetMapping("/register")
    public String showRegister(Model model) {

        return "register.html";
    }
    @PostMapping("/register")
    public String create(@RequestParam  String username,
                         @RequestParam String password,
                         @RequestParam String firstName,
                         @RequestParam String lastName,
                         @RequestParam int phoneNumber,
                         @RequestParam String adres) {
        this.userService.createUser(username, password, firstName, lastName,phoneNumber, adres);

        return "redirect:/loin";
    }
}
