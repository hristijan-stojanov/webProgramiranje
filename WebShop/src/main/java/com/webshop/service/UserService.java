package com.webshop.service;

import com.webshop.model.Role;
import com.webshop.model.User;

import java.util.Optional;

public interface UserService {
    User create(String username, String password, Role role);
    User createUser(String username, String password, String firstName, String lastName, int phoneNumber, String adres);
    User SearchUser(String username);
}
