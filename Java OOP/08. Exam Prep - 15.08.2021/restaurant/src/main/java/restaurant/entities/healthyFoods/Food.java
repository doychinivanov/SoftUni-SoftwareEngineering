package restaurant.entities.healthyFoods;

import restaurant.common.ExceptionMessages;
import restaurant.entities.healthyFoods.interfaces.HealthyFood;
import restaurant.utils.NumValidator;
import restaurant.utils.StringValidator;

public abstract class Food implements HealthyFood {
    private String name;
    private double portion;
    private double price;

    protected Food (String name, double portion, double price) {
        setName(name);
        setPortion(portion);
        setPrice(price);
    }

    private void setName (String name) {
        if (!StringValidator.isValidName(name)) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_NAME);
        }

        this.name = name;
    }

    private void setPortion (double portion) {
        if (!NumValidator.isBiggerThanZero(portion)) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_PORTION);
        }

        this.portion = portion;
    }

    private void setPrice (double price) {
        if (!NumValidator.isBiggerThanZero(price)) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_PRICE);
        }

        this.price = price;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getPortion() {
        return this.portion;
    }

    @Override
    public double getPrice() {
        return this.price;
    }
}
