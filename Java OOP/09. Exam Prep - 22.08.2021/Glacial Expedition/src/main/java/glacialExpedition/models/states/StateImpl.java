package glacialExpedition.models.states;

import glacialExpedition.common.ExceptionMessages;
import glacialExpedition.utils.StringValidator;

import java.util.ArrayList;
import java.util.Collection;

public class StateImpl implements State{
    private String name;
    private Collection<String> exhibits;

    public StateImpl(String name) {
        setName(name);
        this.exhibits = new ArrayList<>();
    }

    private void setName(String name) {
        if (!StringValidator.isValidName(name)){
            throw new NullPointerException(ExceptionMessages.STATE_NAME_NULL_OR_EMPTY);
        }

        this.name = name;
    }

    @Override
    public Collection<String> getExhibits() {
        return this.exhibits;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
