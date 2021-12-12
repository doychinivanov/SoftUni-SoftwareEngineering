package catHouse.entities.cat;

public class LonghairCat extends BaseCat{
    private static final int LONG_HAIR_CAT_KILOGRAMS = 9;
    private static final int KILOGRAMS_INCREASE_BY_EATING = 3;

    public LonghairCat(String name, String breed, double price) {
        super(name, breed, price);
        super.setKilograms(LONG_HAIR_CAT_KILOGRAMS);
    }

    @Override
    public void eating() {
        super.setKilograms(super.getKilograms() + KILOGRAMS_INCREASE_BY_EATING);
    }
}
