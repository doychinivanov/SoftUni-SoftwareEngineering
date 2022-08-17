package com.likebookapp.controller;

import com.likebookapp.model.dto.LoginDTO;
import com.likebookapp.model.dto.UserRegistrationDTO;
import com.likebookapp.service.AuthService;
import com.likebookapp.session.UserSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/auth")
public class AuthController {
    private AuthService authService;
    private UserSession userSession;

    @Autowired
    public AuthController(AuthService authService, UserSession userSession) {
        this.authService = authService;
        this.userSession = userSession;
    }

    @ModelAttribute("registrationDTO")
    public UserRegistrationDTO initRegistrationDto() {
        return new UserRegistrationDTO();
    }

    @ModelAttribute("loginDTO")
    public LoginDTO initLoginDto() {
        return new LoginDTO();
    }

    @GetMapping("/login")
    public String getLoginPage() {
        if (this.userSession.getId() == null) {
            return "login";
        } else {
            return  "redirect:/";
        }
    }

    @GetMapping("/register")
    public String getRegisterPage() {
        if (this.userSession.getId() == null) {
            return "register";
        } else {
            return  "redirect:/";
        }
    }

    @PostMapping("/register")
    public String registerUser(@Valid UserRegistrationDTO registrationDTO,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes) {
        if (this.userSession.getId() != null ) return "redirect:/";

        if (bindingResult.hasErrors() || !this.authService.register(registrationDTO)) {
            redirectAttributes.addFlashAttribute("registrationDTO", registrationDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.registrationDTO", bindingResult);

            if (bindingResult.hasGlobalErrors()) {
                redirectAttributes.addFlashAttribute("confirmPassNotMatching", true);
            }

            return "redirect:/auth/register";
        }

        return "redirect:/";
    }

    @PostMapping("/login")
    public String loginUser(@Valid LoginDTO loginDTO,
                            BindingResult bindingResult,
                            RedirectAttributes redirectAttributes) {

        if (this.userSession.getId() != null ) return "redirect:/";

        if (bindingResult.hasErrors() || !this.authService.login(loginDTO)) {
            redirectAttributes.addFlashAttribute("loginDTO", loginDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.loginDTO", bindingResult);

            return "redirect:/auth/login";
        }

        return "redirect:/";
    }


    @GetMapping("/logout")
    public String logout() {
        this.authService.logout();

        return "redirect:/";
    }
}
