package glacialExpedition.models.explorers;

import glacialExpedition.common.ExceptionMessages;
import glacialExpedition.models.suitcases.Carton;
import glacialExpedition.models.suitcases.Suitcase;
import glacialExpedition.utils.NumValidator;
import glacialExpedition.utils.StringValidator;

public abstract class BaseExplorer implements Explorer{
    private static final int ENERGY_WASTE_FOR_SEARCH = 15;

    private String name;
    private double energy;
    private Suitcase suitcase;


    protected BaseExplorer(String name, double energy) {
        setName(name);
        setEnergy(energy);
        this.suitcase = new Carton();
    }

    public void setName(String name) {
        if (!StringValidator.isValidName(name)){
            throw new NullPointerException(ExceptionMessages.EXPLORER_NAME_NULL_OR_EMPTY);
        }

        this.name = name;
    }

    public void setEnergy(double energy) {
        if (NumValidator.isLessThanZero(energy)) {
            throw new IllegalArgumentException(ExceptionMessages.EXPLORER_ENERGY_LESS_THAN_ZERO);
        }

        this.energy = energy;
    }


    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getEnergy() {
        return this.energy;
    }

    @Override
    public boolean canSearch() {
        return this.energy > 0;
    }

    @Override
    public Suitcase getSuitcase() {
        return this.suitcase;
    }

    @Override
    public void search() {
        setEnergy(Math.max(0, this.energy - ENERGY_WASTE_FOR_SEARCH));
    }
}
