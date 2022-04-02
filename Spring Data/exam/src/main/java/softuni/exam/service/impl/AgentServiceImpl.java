package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.agent.ImportAgentDTO;
import softuni.exam.models.entity.Agent;
import softuni.exam.models.entity.Town;
import softuni.exam.repository.AgentRepository;
import softuni.exam.repository.TownRepository;
import softuni.exam.service.AgentService;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;
import java.util.Set;

@Service
public class AgentServiceImpl implements AgentService {
    private final Path path = Path.of("src", "main", "resources", "files", "json", "agents.json");
    private final AgentRepository agentRepository;
    private final TownRepository townRepository;
    private final Gson gson;
    private Validator validator;
    private ModelMapper modelMapper;

    @Autowired
    public AgentServiceImpl(AgentRepository agentRepository, TownRepository townRepository) {
        this.agentRepository = agentRepository;
        this.townRepository = townRepository;

        this.gson = new Gson();
        this.validator = Validation.buildDefaultValidatorFactory().getValidator();
        this.modelMapper = new ModelMapper();
    }

    @Override
    public boolean areImported() {
        return this.agentRepository.count() > 0;
    }

    @Override
    public String readAgentsFromFile() throws IOException {
        return Files.readString(path);
    }

    @Override
    public String importAgents() throws IOException {
        StringBuilder result = new StringBuilder();
        String json = this.readAgentsFromFile();

        ImportAgentDTO[] importAgentDTOS = this.gson.fromJson(json, ImportAgentDTO[].class);

        for (ImportAgentDTO agentDTO : importAgentDTOS) {
            Set<ConstraintViolation<ImportAgentDTO>> errors = this.validator.validate(agentDTO);

            if(errors.isEmpty()) {
                Optional<Agent> optAgent = this.agentRepository.findByFirstName(agentDTO.getFirstName());

                if(optAgent.isPresent()) {
                    result.append("Invalid agent").append(System.lineSeparator());
                } else {
                    Agent newAgent = this.modelMapper.map(agentDTO, Agent.class);
                    Optional<Town> agentTown = this.townRepository.findByTownName(agentDTO.getTown());

                    newAgent.setTown(agentTown.get());
                    this.agentRepository.save(newAgent);
                    String successMsg = String.format("Successfully imported agent - %s %s", newAgent.getFirstName(), newAgent.getLastName());
                    result.append(successMsg).append(System.lineSeparator());
                }

            } else {
                result.append("Invalid agent").append(System.lineSeparator());
            }
        }

        return result.toString();
    }
}
