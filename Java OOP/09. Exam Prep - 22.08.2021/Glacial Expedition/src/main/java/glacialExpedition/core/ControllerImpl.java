package glacialExpedition.core;

import glacialExpedition.common.ConstantMessages;
import glacialExpedition.common.ExceptionMessages;
import glacialExpedition.models.explorers.AnimalExplorer;
import glacialExpedition.models.explorers.Explorer;
import glacialExpedition.models.explorers.GlacierExplorer;
import glacialExpedition.models.explorers.NaturalExplorer;
import glacialExpedition.models.mission.Mission;
import glacialExpedition.models.mission.MissionImpl;
import glacialExpedition.models.states.State;
import glacialExpedition.models.states.StateImpl;
import glacialExpedition.repositories.ExplorerRepository;
import glacialExpedition.repositories.Repository;
import glacialExpedition.repositories.StateRepository;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {
    private Repository<Explorer> explorerRepository;
    private Repository<State> stateRepository;
    private int exploredStates;

    public ControllerImpl() {
        this.explorerRepository = new ExplorerRepository();
        this.stateRepository = new StateRepository();
        this.exploredStates = 0;
    }

    @Override
    public String addExplorer(String type, String explorerName) {
        Explorer explorer = null;
        switch (type) {
            case "AnimalExplorer":
                explorer = new AnimalExplorer(explorerName);
                break;
            case "GlacierExplorer":
                explorer = new GlacierExplorer(explorerName);
                break;
            case "NaturalExplorer":
                explorer = new NaturalExplorer(explorerName);
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.EXPLORER_INVALID_TYPE);
        }

        this.explorerRepository.add(explorer);
        return String.format(ConstantMessages.EXPLORER_ADDED, type, explorerName);
    }

    @Override
    public String addState(String stateName, String... exhibits) {
        State currentState = new StateImpl(stateName);

        currentState
                .getExhibits()
                .addAll(Arrays.stream(exhibits).collect(Collectors.toList()));

        this.stateRepository.add(currentState);
        return String.format(ConstantMessages.STATE_ADDED, stateName);
    }

    @Override
    public String retireExplorer(String explorerName) {
        Explorer explorer = explorerRepository.byName(explorerName);

        if (explorer == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.EXPLORER_DOES_NOT_EXIST, explorerName));
        }

        this.explorerRepository.remove(explorer);
        return String.format(ConstantMessages.EXPLORER_RETIRED, explorerName);
    }

    @Override
    public String exploreState(String stateName) {
        Predicate<Explorer> getExplorersWithEnergyMoreTn50 = explorer -> explorer.getEnergy() > 50;
        Predicate<Explorer> getExplorersWithNoEnergy = explorer -> explorer.getEnergy() == 0 ;

        List<Explorer> explorersWithRequiredEnergy = this.explorerRepository
                .getCollection()
                .stream()
                .filter(getExplorersWithEnergyMoreTn50)
                .collect(Collectors.toList());

        if (explorersWithRequiredEnergy.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessages.STATE_EXPLORERS_DOES_NOT_EXISTS);
        }

        State targetState = this.stateRepository.byName(stateName);
        Mission newMission = new MissionImpl();
        newMission.explore(targetState, explorersWithRequiredEnergy);

        long retiredAfterExploration = explorersWithRequiredEnergy
                .stream()
                .filter(getExplorersWithNoEnergy)
                .count();

        this.exploredStates++;

        return String.format(ConstantMessages.STATE_EXPLORER, stateName, retiredAfterExploration);
    }

    @Override
    public String finalResult() {
        StringBuilder result = new StringBuilder();
        result.append(String.format(ConstantMessages.FINAL_STATE_EXPLORED, this.exploredStates)).append(System.lineSeparator());
        result.append(ConstantMessages.FINAL_EXPLORER_INFO).append(System.lineSeparator());

        Collection<Explorer> explorers = this.explorerRepository.getCollection();

        for (Explorer explorer : explorers) {
            result.append(String.format(ConstantMessages.FINAL_EXPLORER_NAME, explorer.getName())).append(System.lineSeparator());
            result.append(String.format(ConstantMessages.FINAL_EXPLORER_ENERGY, explorer.getEnergy())).append(System.lineSeparator());

            if(explorer.getSuitcase().getExhibits().isEmpty()){
                result.append(String.format(ConstantMessages.FINAL_EXPLORER_SUITCASE_EXHIBITS, "None")).append(System.lineSeparator());
            } else {
                result.append(String.format(ConstantMessages.FINAL_EXPLORER_SUITCASE_EXHIBITS,
                        String.join(ConstantMessages.FINAL_EXPLORER_SUITCASE_EXHIBITS_DELIMITER, explorer.getSuitcase().getExhibits()))).append(System.lineSeparator());
            }
        }

        return result.toString().trim();
    }
}
