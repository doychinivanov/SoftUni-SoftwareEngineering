package catHouse.entities.cat;

public class ShorthairCat extends BaseCat{
    private static final int SHORT_HAIR_CAT_KILOGRAMS = 7;
    private static final int KILOGRAMS_INCREASE_BY_EATING = 1;

    public ShorthairCat(String name, String breed, double price) {
        super(name, breed, price);
        super.setKilograms(SHORT_HAIR_CAT_KILOGRAMS);
    }

    @Override
    public void eating() {
        super.setKilograms(super.getKilograms() + KILOGRAMS_INCREASE_BY_EATING);
    }
}
