package com.likebookapp.repository;

import com.likebookapp.model.entity.Mood;
import com.likebookapp.model.enums.MoodType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoodRepository extends JpaRepository<Mood, Long> {

    Mood findByName(MoodType name);
}
