package com.likebookapp.controller;

import com.likebookapp.model.dto.PostDisplayDTO;
import com.likebookapp.service.PostService;
import com.likebookapp.session.UserSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
    private UserSession userSession;
    private PostService postService;

    @Autowired
    public HomeController(UserSession userSession, PostService postService) {
        this.userSession = userSession;
        this.postService = postService;
    }

    @GetMapping("/")
    public String loadHomePage(Model model) {
        if (this.userSession.getId() == null) {
            return "index";
        }

        List<PostDisplayDTO> userPosts = this.postService.getUserPosts(this.userSession.getId());
        List<PostDisplayDTO> othersPosts = this.postService.getOthersPosts(this.userSession.getId());

        model.addAttribute("userPosts", userPosts);
        model.addAttribute("othersPosts", othersPosts);
        model.addAttribute("currentUsername", this.userSession.getUsername());
        return "home";
    }
}
