package com.likebookapp.model.dto;

import com.likebookapp.model.entity.Mood;
import com.likebookapp.model.entity.User;
import com.likebookapp.model.enums.MoodType;

import java.util.Set;

public class PostDisplayDTO {

    private Mood mood;

    private Set<User> likes;

    private String content;

    private long id;

    private User creator;

    public PostDisplayDTO() {}

    @Override
    public String toString() {
        return "PostDisplayDTO{" +
                "mood=" + mood +
                ", likes=" + likes +
                ", content='" + content + '\'' +
                ", id=" + id +
                ", creator=" + creator +
                '}';
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public Mood getMood() {
        return mood;
    }

    public void setMood(Mood mood) {
        this.mood = mood;
    }

    public Set<User> getLikes() {
        return likes;
    }

    public void setLikes(Set<User> likes) {
        this.likes = likes;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
