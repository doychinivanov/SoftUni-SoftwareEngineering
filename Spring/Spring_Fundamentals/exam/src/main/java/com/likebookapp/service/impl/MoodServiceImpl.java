package com.likebookapp.service.impl;

import com.likebookapp.model.dto.MoodOptionDTO;
import com.likebookapp.model.entity.Mood;
import com.likebookapp.model.enums.MoodType;
import com.likebookapp.repository.MoodRepository;
import com.likebookapp.service.MoodService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MoodServiceImpl implements MoodService {
    private MoodRepository moodRepository;
    private ModelMapper modelMapper;

    @Autowired
    public MoodServiceImpl(MoodRepository moodRepository, ModelMapper modelMapper) {
        this.moodRepository = moodRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void initMoods() {
        if(this.moodRepository.count() == 0) {
            List<Mood> moods = Arrays
                    .stream(MoodType.values())
                    .map(Mood::new)
                    .collect(Collectors.toList());

            this.moodRepository.saveAll(moods);
        }
    }

    @Override
    public List<MoodOptionDTO> getAllMoods() {
        List<Mood> allMoods = this.moodRepository.findAll();
        return Arrays.stream(this.modelMapper.map(allMoods, MoodOptionDTO[].class)).collect(Collectors.toList());
    }
}
