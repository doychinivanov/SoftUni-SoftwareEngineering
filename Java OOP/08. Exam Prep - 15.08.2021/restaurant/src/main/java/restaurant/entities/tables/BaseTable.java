package restaurant.entities.tables;

import restaurant.common.ExceptionMessages;
import restaurant.entities.drinks.interfaces.Beverages;
import restaurant.entities.healthyFoods.interfaces.HealthyFood;
import restaurant.entities.tables.interfaces.Table;
import restaurant.utils.NumValidator;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseTable implements Table {
    private List<HealthyFood> healthyFood;
    private List<Beverages> beverages;
    private int number;
    private int size;
    private int numberOfPeople;
    private double pricePerPerson;
    private boolean isReservedTable;
    private double allPeople;

    protected BaseTable (int number, int size, double pricePerPerson) {
        setNumber(number);
        setSize(size);
        setPricePerPerson(pricePerPerson);
        this.healthyFood = new ArrayList<>();
        this.beverages = new ArrayList<>();
    }

    private void setNumber(int number) {
        this.number = number;
    }

    private void setPricePerPerson(double pricePerPerson) {
        this.pricePerPerson = pricePerPerson;
    }

    private void setNumberOfPeople (int numberOfPeople) {
        if (!NumValidator.isBiggerThanZero(numberOfPeople)) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_NUMBER_OF_PEOPLE);
        }

        this.numberOfPeople = numberOfPeople;
    }

    private void setSize (int size) {
        if (!NumValidator.isBiggerThanZero(size)) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_TABLE_SIZE);
        }

        this.size = size;
    }


    @Override
    public int getTableNumber() {
        return this.number;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public int numberOfPeople() {
        return this.numberOfPeople;
    }

    @Override
    public double pricePerPerson() {
        return pricePerPerson;
    }

    @Override
    public boolean isReservedTable() {
        return this.isReservedTable;
    }

    @Override
    public double allPeople() {
        return this.allPeople;
    }

    @Override
    public void reserve(int numberOfPeople) {
        setNumberOfPeople(numberOfPeople);

        this.isReservedTable = true;
    }

    @Override
    public void orderHealthy(HealthyFood food) {
        this.healthyFood.add(food);
    }

    @Override
    public void orderBeverages(Beverages beverages) {
        this.beverages.add(beverages);
    }

    @Override
    public double bill() {
        double totalFoodPrice = this.healthyFood
                .stream()
                .mapToDouble(HealthyFood::getPrice)
                .sum();

        double totalBeveragePrice = this.beverages
                .stream()
                .mapToDouble(Beverages::getPrice)
                .sum();

        double totalPriceForTable = this.pricePerPerson * this.numberOfPeople;

        return totalFoodPrice + totalBeveragePrice + totalPriceForTable;
    }

    @Override
    public void clear() {
        this.healthyFood.clear();
        this.beverages.clear();
        this.numberOfPeople = 0;
        this.isReservedTable = false;
    }

    @Override
    public String tableInformation() {
        StringBuilder result = new StringBuilder();

        result.append("Table - ").append(this.number).append(System.lineSeparator());
        result.append("Size - ").append(this.size).append(System.lineSeparator());
        result.append("Type - ").append(this.getClass().getSimpleName()).append(System.lineSeparator());
        result.append(String.format("All price - %.2f", this.pricePerPerson()));

        return null;
    }
}
