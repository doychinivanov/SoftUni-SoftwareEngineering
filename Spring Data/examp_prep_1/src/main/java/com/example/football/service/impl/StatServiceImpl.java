package com.example.football.service.impl;

import com.example.football.models.dto.ImportStatDTO;
import com.example.football.models.dto.ImportStatRootDTO;
import com.example.football.models.entity.Stat;
import com.example.football.repository.StatRepository;
import com.example.football.service.StatService;
import org.modelmapper.ModelMapper;
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
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class StatServiceImpl implements StatService {
    private final Path path = Path.of("src", "main", "resources", "files", "xml", "stats.xml");
    private final StatRepository statRepository;
    private final Unmarshaller unmarshaller;
    private final Validator validator;
    private final ModelMapper modelMapper;

    @Autowired
    public StatServiceImpl(StatRepository statRepository) throws JAXBException {
        this.statRepository = statRepository;

        JAXBContext ctx = JAXBContext.newInstance(ImportStatRootDTO.class);
        this.unmarshaller = ctx.createUnmarshaller();

        this.validator = Validation.buildDefaultValidatorFactory().getValidator();
        this.modelMapper = new ModelMapper();
    }

    @Override
    public boolean areImported() {
        return this.statRepository.count() > 0;
    }

    @Override
    public String readStatsFileContent() throws IOException {
        return Files.readString(path);
    }

    @Override
    public String importStats() throws FileNotFoundException, JAXBException {
        ImportStatRootDTO statsDTOs = (ImportStatRootDTO) this.unmarshaller.unmarshal(new FileReader(path.toAbsolutePath().toString()));

        return statsDTOs
                .getStats()
                .stream()
                .map(this::importStat)
                .collect(Collectors.joining(System.lineSeparator()));
    }

    private String importStat(ImportStatDTO dto) {
        Set<ConstraintViolation<ImportStatDTO>> errors = this.validator.validate(dto);

        if(!errors.isEmpty()) {
            return "Invalid Stat";
        }

        Optional<Stat> optStat = this.statRepository.findByShootingAndPassingAndEndurance(dto.getShooting(), dto.getPassing(), dto.getEndurance());

        if(optStat.isPresent()) return "Invalid Stat";

        Stat newStat = this.modelMapper.map(dto, Stat.class);
        this.statRepository.save(newStat);
        return String.format("Successfully imported Stat %.2f - %.2f - %.2f", newStat.getPassing(), newStat.getShooting(), newStat.getEndurance());

    }
}
