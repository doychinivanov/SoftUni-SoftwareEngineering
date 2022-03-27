package com.example.football.service.impl;

import com.example.football.models.dto.ImportTeamDTO;
import com.example.football.models.entity.Team;
import com.example.football.models.entity.Town;
import com.example.football.repository.TeamRepository;
import com.example.football.repository.TownRepository;
import com.example.football.service.TeamService;
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
public class TeamServiceImpl implements TeamService {
    private final TeamRepository teamRepository;
    private final TownRepository townRepository;
    private final Path path = Path.of("src", "main", "resources", "files", "json", "teams.json");
    private final Gson gson;
    private final Validator validator;
    private final ModelMapper modelMapper;

    @Autowired
    public TeamServiceImpl(TeamRepository teamRepository, TownRepository townRepository) {
        this.teamRepository = teamRepository;
        this.townRepository = townRepository;
        this.gson = new Gson();
        this.validator = Validation.buildDefaultValidatorFactory().getValidator();
        this.modelMapper = new ModelMapper();
    }

    @Override
    public boolean areImported() {
        return this.teamRepository.count() > 0;
    }

    @Override
    public String readTeamsFileContent() throws IOException {
        return Files.readString(path);
    }

    @Override
    public String importTeams() throws IOException {
        StringBuilder result = new StringBuilder();
        String json = this.readTeamsFileContent();

        ImportTeamDTO[] importTeamDTOS = this.gson.fromJson(json, ImportTeamDTO[].class);

        for (ImportTeamDTO importTeamDTO : importTeamDTOS) {
            Set<ConstraintViolation<ImportTeamDTO>> errors = validator.validate(importTeamDTO);

            if(errors.isEmpty()) {
                Optional<Town> optTown = this.townRepository.findByName(importTeamDTO.getName());

                if(optTown.isPresent()){
                    result.append("Invalid Team").append(System.lineSeparator());
                } else {
                    Team newTeam = this.modelMapper.map(importTeamDTO, Team.class);
                    Town town = this.townRepository.findByName(importTeamDTO.getTownName()).get();

                    newTeam.setTown(town);
                    this.teamRepository.save(newTeam);

                    String successImport = String.format("Successfully imported Team %s - %d", newTeam.getName(), newTeam.getFanBase());
                    result.append(successImport).append(System.lineSeparator());
                }

            } else {
                result.append("Invalid Team").append(System.lineSeparator());
            }
        }

        return result.toString();
    }
}
