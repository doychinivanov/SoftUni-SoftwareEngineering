package com.likebookapp.model.entity;

import com.likebookapp.model.enums.MoodType;

import javax.persistence.*;

@Table(name = "moods")
@Entity
public class Mood {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
    @Column(unique = true, nullable = false)
    private MoodType name;

    @Column(columnDefinition = "text")
    private String description;

    public Mood () {}

    public Mood(MoodType type) {
        this.name = type;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public MoodType getName() {
        return name;
    }

    public void setName(MoodType name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
