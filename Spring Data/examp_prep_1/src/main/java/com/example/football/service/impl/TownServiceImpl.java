package com.example.football.service.impl;

import com.example.football.models.dto.ImportTownDTO;
import com.example.football.models.entity.Town;
import com.example.football.repository.TownRepository;
import com.example.football.service.TownService;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;
import java.util.Set;


@Service
public class TownServiceImpl implements TownService {
    Path path = Path.of("src", "main", "resources", "files", "json", "towns.json");
    private final TownRepository townRepository;
    private final Gson gson;
    private final Validator validator;
    private final ModelMapper modelMapper;

    @Autowired
    public TownServiceImpl(TownRepository townRepository) {
        this.townRepository = townRepository;
        this.gson = new Gson();
        this.validator = Validation.buildDefaultValidatorFactory().getValidator();
        this.modelMapper = new ModelMapper();
    }

    @Override
    public boolean areImported() {
        return this.townRepository.count() > 0;
    }

    @Override
    public String readTownsFileContent() throws IOException {
        return Files.readString(path);
    }

    @Override
    public String importTowns() throws IOException {
        StringBuilder result = new StringBuilder();
        String json = this.readTownsFileContent();

        ImportTownDTO[] importTownDTOS = this.gson.fromJson(json, ImportTownDTO[].class);

        for (ImportTownDTO importTownDTO : importTownDTOS) {
            Set<ConstraintViolation<ImportTownDTO>> errors = this.validator.validate(importTownDTO);

            if(errors.isEmpty()) {
                Optional<Town> optTown = this.townRepository.findByName(importTownDTO.getName());

                if (optTown.isPresent()) {
                    result.append("Invalid Town").append(System.lineSeparator());
                } else {
                    Town newTown = this.modelMapper.map(importTownDTO, Town.class);

                    this.townRepository.save(newTown);
                    String successMsg = String.format("Successfully imported Town %s - %d", newTown.getName(), newTown.getPopulation());
                    result.append(successMsg).append(System.lineSeparator());
                }

            } else {
                result.append("Invalid Town").append(System.lineSeparator());
            }

        }

        return result.toString();
    }
}
