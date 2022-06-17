package com.example.demo.services.impl;

import com.example.demo.models.User;
import com.example.demo.models.dto.LoginDTO;
import com.example.demo.models.dto.UserRegistrationDTO;
import com.example.demo.repositories.UserRepository;
import com.example.demo.services.AuthService;
import com.example.demo.session.UserSession;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService {
    private UserRepository userRepository;
    private ModelMapper modelMapper;
    private PasswordEncoder passwordEncoder;
    private UserSession userSession;

    @Autowired
    public AuthServiceImpl(UserRepository userRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder, UserSession userSession) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
        this.userSession = userSession;
    }

    @Override
    public boolean register(UserRegistrationDTO registrationDTO) {
        if (!registrationDTO.getPassword().equals(registrationDTO.getConfirmPassword())) {
            return false;
        }

        Optional<User> byEmail = this.userRepository.findByEmail(registrationDTO.getEmail());
        Optional<User> byUsername = this.userRepository.findByUsername(registrationDTO.getUsername());

        if (byEmail.isPresent() || byUsername.isPresent()) {
            return false;
        }

        registrationDTO.setPassword(passwordEncoder.encode(registrationDTO.getPassword()));
        User newUser = this.modelMapper.map(registrationDTO, User.class);
        this.userRepository.save(newUser);
        this.userSession.login(newUser);
        return true;
    }

    @Override
    public boolean login(LoginDTO loginDTO) {
        Optional<User> optUser = this.userRepository.findByUsername(loginDTO.getUsername());

        if (optUser.isEmpty() || !passwordEncoder.matches(loginDTO.getPassword(), optUser.get().getPassword())) {
            return false;
        }

        userSession.login(optUser.get());
        return true;
    }

    @Override
    public boolean logout() {
        this.userSession.logout();
        return true;
    }
}
