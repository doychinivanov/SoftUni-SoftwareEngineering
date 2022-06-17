package com.example.demo.services;

import com.example.demo.models.dto.LoginDTO;
import com.example.demo.models.dto.UserRegistrationDTO;

public interface AuthService {

    boolean register(UserRegistrationDTO registrationDTO);

    boolean login(LoginDTO loginDTO);
}
