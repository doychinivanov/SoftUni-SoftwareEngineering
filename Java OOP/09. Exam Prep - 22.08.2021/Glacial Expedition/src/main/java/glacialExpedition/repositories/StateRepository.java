package glacialExpedition.repositories;

import glacialExpedition.models.states.State;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class StateRepository implements Repository<State> {
    Map<String, State> allStates;

    public StateRepository() {
        this.allStates = new LinkedHashMap<>();
    }

    @Override
    public Collection<State> getCollection() {
        return Collections.unmodifiableCollection(this.allStates.values());
    }

    @Override
    public void add(State newState) {
        this.allStates.put(newState.getName(), newState);
    }

    @Override
    public boolean remove(State stateToRemove) {
        return this.allStates.remove(stateToRemove.getName()) != null;
    }

    @Override
    public State byName(String stateName) {
        return this.allStates.get(stateName);
    }
}
