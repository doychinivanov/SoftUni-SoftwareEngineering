package com.softuni.exam.session;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class UserSession {
    private Long id;
//    maybe another prop

    public void logout() {
        this.id = null;
    }

//    public void login(User user){
//        this.id = user.getId();
//        this.fullName = user.getFullName();
//    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
