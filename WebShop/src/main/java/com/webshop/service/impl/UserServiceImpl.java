package com.webshop.service.impl;

import com.webshop.model.Role;
import com.webshop.model.User;
import com.webshop.model.exceptions.InvalidUserException;
import com.webshop.repository.UserRepository;
import com.webshop.service.UserService;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {
    private final UserRepository userRepository;
    private  final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User create(String username, String password , Role role) {
        String pascript= this.passwordEncoder.encode(password);
        User user = new User (username,pascript,role);
        return this.userRepository.save(user);
    }

    @Override
    public User createUser(String username, String password, String firstName, String lastName, int phoneNumber, String adres) {
        String pascript= this.passwordEncoder.encode(password);
        User user = new User(username, pascript, firstName, lastName,phoneNumber, adres);

        return this.userRepository.save(user);
    }

    @Override
    public User SearchUser(String username) {
        return this.userRepository.findByUsername(username).orElseThrow(InvalidUserException::new);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       User user = this.userRepository.findByUsername(username).orElseThrow(InvalidUserException::new);
       UserDetails userDetails = new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), Stream.of(new SimpleGrantedAuthority(user.getRole().toString())).collect(Collectors.toList()));
       return userDetails;
   }



}
