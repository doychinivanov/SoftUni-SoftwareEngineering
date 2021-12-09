package glacialExpedition.models.explorers;

public class GlacierExplorer extends BaseExplorer{
    private static final double INITIAL_ENERGY_FOR_GLACIER_EXPLORER = 40;

    public GlacierExplorer(String name) {
        super(name, INITIAL_ENERGY_FOR_GLACIER_EXPLORER);
    }

}
