package com.example.demo.session;

import com.example.demo.models.User;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class UserSession {
    private Long id;
    private String fullName;

    public void logout() {
        this.id = null;
        this.fullName = null;
    }

    public Long getId() {
        return id;
    }

    public void login(User user){
        this.id = user.getId();
        this.fullName = user.getFullName();
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
