package restaurant.entities.drinks;

import restaurant.common.ExceptionMessages;
import restaurant.entities.drinks.interfaces.Beverages;
import restaurant.utils.NumValidator;
import restaurant.utils.StringValidator;

public abstract class BaseBeverage implements Beverages {
    private String name;
    private int counter;
    private double price;
    private String brand;

    protected BaseBeverage (String name, int counter, double price, String brand) {
        setName(name);
        setCounter(counter);
        setPrice(price);
        setBrand(brand);
    }

    private void setName (String name) {
        if (!StringValidator.isValidName(name)) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_NAME);
        }

        this.name = name;
    }

    private void setCounter (int counter) {
        if (!NumValidator.isBiggerThanZero(counter)) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_COUNTER);
        }

        this.counter = counter;
    }


    private void setPrice (double price) {
        if (!NumValidator.isBiggerThanZero(price)) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_PRICE);
        }

        this.price = price;
    }


    private void setBrand (String brand) {
        if (!StringValidator.isValidName(brand)) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_BRAND);
        }

        this.brand = brand;
    }


    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getCounter() {
        return this.counter;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public String getBrand() {
        return this.brand;
    }
}
