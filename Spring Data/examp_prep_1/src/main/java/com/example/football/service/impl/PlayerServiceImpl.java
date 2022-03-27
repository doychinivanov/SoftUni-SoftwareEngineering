package com.example.football.service.impl;

import com.example.football.models.dto.BestPlayerDTO;
import com.example.football.models.dto.ImportPlayerDTO;
import com.example.football.models.dto.ImportPlayerRootDTO;
import com.example.football.models.entity.Player;
import com.example.football.models.entity.Stat;
import com.example.football.models.entity.Team;
import com.example.football.models.entity.Town;
import com.example.football.repository.PlayerRepository;
import com.example.football.repository.StatRepository;
import com.example.football.repository.TeamRepository;
import com.example.football.repository.TownRepository;
import com.example.football.service.PlayerService;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PlayerServiceImpl implements PlayerService {
    private final Path path = Path.of("src", "main", "resources", "files", "xml", "players.xml");
    private final PlayerRepository playerRepository;
    private final TownRepository townRepository;
    private final StatRepository statRepository;
    private final TeamRepository teamRepository;
    private final Unmarshaller unmarshaller;
    private final Validator validator;
    private final ModelMapper modelMapper;

    @Autowired
    public PlayerServiceImpl(PlayerRepository playerRepository, TownRepository townRepository, StatRepository statRepository, TeamRepository teamRepository) throws JAXBException {
        this.playerRepository = playerRepository;
        this.townRepository = townRepository;
        this.statRepository = statRepository;
        this.teamRepository = teamRepository;

        JAXBContext ctx = JAXBContext.newInstance(ImportPlayerRootDTO.class);
        this.unmarshaller = ctx.createUnmarshaller();

        this.validator = Validation.buildDefaultValidatorFactory().getValidator();
        this.modelMapper = new ModelMapper();

        this.modelMapper.addConverter(new Converter<String, LocalDate>() {
            @Override
            public LocalDate convert(MappingContext<String, LocalDate> context) {
                return LocalDate.parse(context.getSource(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            }
        });
    }


    @Override
    public boolean areImported() {
        return this.playerRepository.count() > 0;
    }

    @Override
    public String readPlayersFileContent() throws IOException {
        return Files.readString(path);
    }

    @Override
    public String importPlayers() throws FileNotFoundException, JAXBException {
        ImportPlayerRootDTO playerDTOs = (ImportPlayerRootDTO) this.unmarshaller.unmarshal(new FileReader(path.toAbsolutePath().toString()));

        return playerDTOs
                .getPlayers()
                .stream()
                .map(this::importPlayer)
                .collect(Collectors.joining(System.lineSeparator()));
    }

    private String importPlayer(ImportPlayerDTO dto) {
        Set<ConstraintViolation<ImportPlayerDTO>> errors = this.validator.validate(dto);

        if (!errors.isEmpty()) {
            return "Invalid Player";
        }

        Optional<Player> optPlayer = this.playerRepository.findByEmail(dto.getEmail());

        if (optPlayer.isPresent()) {
            return "Invalid Player";
        }

        Optional<Team> team = this.teamRepository.findByName(dto.getTeam().getName());
        Optional<Town> town = this.townRepository.findByName(dto.getTown().getName());
        Optional<Stat> stats = this.statRepository.findById(dto.getStat().getId());

        Player newPlayer = this.modelMapper.map(dto, Player.class);

        newPlayer.setTeam(team.get());
        newPlayer.setTown(town.get());
        newPlayer.setStat(stats.get());

        this.playerRepository.save(newPlayer);

        return String.format("Successfully imported Player %s %s - %s", newPlayer.getFirstName(), newPlayer.getLastName(), newPlayer.getPosition().toString());
    }

    @Override
    public String exportBestPlayers() {
        LocalDate before = LocalDate.of(2003, 1, 1);
        LocalDate after = LocalDate.of(1995, 1, 1);

        List<Player> bestPlayers = this.playerRepository.findBestPlayers(after, before);

        List<BestPlayerDTO> bestPlayerDTOS = bestPlayers.stream().map(player -> this.modelMapper.map(player, BestPlayerDTO.class)).toList();

        return bestPlayerDTOS
                .stream()
                .map(BestPlayerDTO::toString)
                .collect(Collectors.joining(System.lineSeparator()));
    }
}
