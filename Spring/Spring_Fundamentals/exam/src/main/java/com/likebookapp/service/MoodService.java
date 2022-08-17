package com.likebookapp.service;

import com.likebookapp.model.dto.MoodOptionDTO;

import java.util.List;

public interface MoodService {

    void initMoods();

    List<MoodOptionDTO> getAllMoods();
}
