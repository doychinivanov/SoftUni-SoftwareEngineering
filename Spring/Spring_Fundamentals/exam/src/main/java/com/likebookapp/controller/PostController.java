package com.likebookapp.controller;

import com.likebookapp.model.dto.MoodOptionDTO;
import com.likebookapp.model.dto.PostCreateDTO;
import com.likebookapp.service.MoodService;
import com.likebookapp.service.PostService;
import com.likebookapp.session.UserSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/post")
public class PostController {
    private UserSession userSession;
    private MoodService moodService;

    private PostService postService;

    @Autowired
    public PostController(UserSession userSession, MoodService moodService, PostService postService) {
        this.userSession = userSession;
        this.moodService = moodService;
        this.postService = postService;
    }

    @ModelAttribute("postCreateDTO")
    public PostCreateDTO initCreatePostDto() {
        return new PostCreateDTO();
    }

    @GetMapping("/create")
    public String loadCreateForm(Model model) {
        if (this.userSession.getId() == null) return "redirect:/";

        List<MoodOptionDTO> allMoods = this.moodService.getAllMoods();

        model.addAttribute("moods", allMoods);
        return "post-add";
    }

    @PostMapping("/create")
    public String createPost(@Valid PostCreateDTO postCreateDTO,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes) {
        if (this.userSession.getId() == null) return "redirect:/";

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("postCreateDTO", postCreateDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.postCreateDTO", bindingResult);

            return "redirect:/post/create";
        }

        this.postService.createPost(postCreateDTO, this.userSession.getId());
        return "redirect:/";
    }

    @GetMapping("/delete/{postId}")
    public String deletePost(@PathVariable long postId) {
        if (this.userSession.getId() == null) return "redirect:/";

        this.postService.deletePost(postId, this.userSession.getId());
        return "redirect:/";
    }

    @GetMapping("/like/{postId}")
    public String likePost(@PathVariable long postId, RedirectAttributes redirectAttributes) {
        if (this.userSession.getId() == null) return "redirect:/";

        try {
            this.postService.likePost(postId, this.userSession.getId());
        } catch (Exception err) {
            redirectAttributes.addFlashAttribute("likeError", true);
        }
        return "redirect:/";
    }
}
