package com.likebookapp.service;

import com.likebookapp.model.dto.LoginDTO;
import com.likebookapp.model.dto.UserRegistrationDTO;

public interface AuthService {
    boolean register(UserRegistrationDTO registrationDTO);

    boolean login(LoginDTO loginDTO);

    boolean logout();
}
