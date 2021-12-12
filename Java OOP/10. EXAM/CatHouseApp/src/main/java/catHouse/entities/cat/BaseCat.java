package catHouse.entities.cat;

import catHouse.common.ExceptionMessages;
import catHouse.utils.NumValidator;
import catHouse.utils.StringValidator;

public abstract class BaseCat implements Cat{
    private String name;
    private String breed;
    private int kilograms;
    private double price;

    protected BaseCat (String name, String breed, double price) {
        setName(name);
        setBreed(breed);
        setPrice(price);
    }

    public void setKilograms(int kilograms) {
        this.kilograms = kilograms;
    }

    public void setPrice(double price) {
        if (!NumValidator.isBiggerThanZero(price)) {
            throw new IllegalArgumentException(ExceptionMessages.CAT_PRICE_CANNOT_BE_BELOW_OR_EQUAL_TO_ZERO);
        }

        this.price = price;
    };

    public void setBreed(String breed) {
        if (!StringValidator.isValidName(breed)) {
            throw new NullPointerException(ExceptionMessages.CAT_BREED_CANNOT_BE_NULL_OR_EMPTY);
        }

        this.breed = breed;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        if (!StringValidator.isValidName(name)) {
            throw new NullPointerException(ExceptionMessages.CAT_NAME_NULL_OR_EMPTY);
        }

        this.name = name;
    }

    @Override
    public int getKilograms() {
        return this.kilograms;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public void eating() {

    }
}
