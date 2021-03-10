package com.company.controllers;

import java.util.List;

import com.company.entities.User;
import com.company.repositories.interfaces.IAppointmentRepository;
import com.company.repositories.interfaces.IUserRepository;
import com.company.repositories.interfaces.IDoctorRepository;


public class UserController {
    private final IUserRepository userRepository;

    public UserController(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String createUser(String name, String surname, int yin, String login, String password, String telephone) {
        User user = new User(name, surname, yin, login, password, telephone);
        boolean created = userRepository.createUser(user);
        return (created ? "You have been successfully registered" : "Registration failed");
    }
}