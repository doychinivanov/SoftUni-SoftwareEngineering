package glacialExpedition.models.explorers;

public class NaturalExplorer extends BaseExplorer{
    private static final double INITIAL_ENERGY_FOR_NATURAL_EXPLORER = 60;
    private static final int ENERGY_REQUIRED_FOR_SEARCH_FOR_NATURAL_EXPLORER = 7;

    public NaturalExplorer(String name) {
        super(name, INITIAL_ENERGY_FOR_NATURAL_EXPLORER);
    }

    @Override
    public void search() {
        super.setEnergy(Math.max(0, super.getEnergy() - ENERGY_REQUIRED_FOR_SEARCH_FOR_NATURAL_EXPLORER));
    }
}
