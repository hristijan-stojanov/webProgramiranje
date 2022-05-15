package com.webshop.config;

import com.webshop.model.Role;
import com.webshop.model.User;
import com.webshop.service.impl.UserServiceImpl;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Initializer {
    public static final String ADMIN = "admin";

    private final UserServiceImpl userService;

    public Initializer(UserServiceImpl userService) {
        this.userService = userService;
    }

    @PostConstruct
    public void initData() {
        User admin = this.userService.create(ADMIN, ADMIN, Role.ROLE_ADMIN);
        User user = this.userService.create("hristijan", "hs",Role.ROLE_USER);

    }
}


