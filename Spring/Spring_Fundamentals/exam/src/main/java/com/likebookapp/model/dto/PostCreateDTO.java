package com.likebookapp.model.dto;

import com.likebookapp.model.enums.MoodType;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class PostCreateDTO {

    @Size(min = 2, max = 150, message = "Content length must be between 2 and 150 characters!")
    @NotBlank(message = "Content cannot be empty!")
    private String content;

    @NotNull(message = "You must select a mood!")
    private MoodType mood;

    public PostCreateDTO() {}

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public MoodType getMood() {
        return mood;
    }

    public void setMood(MoodType mood) {
        this.mood = mood;
    }
}
