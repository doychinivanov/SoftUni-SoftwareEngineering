package restaurant.core;

import restaurant.common.ExceptionMessages;
import restaurant.common.OutputMessages;
import restaurant.core.interfaces.Controller;
import restaurant.entities.drinks.Fresh;
import restaurant.entities.drinks.Smoothie;
import restaurant.entities.healthyFoods.Salad;
import restaurant.entities.healthyFoods.VeganBiscuits;
import restaurant.entities.healthyFoods.interfaces.HealthyFood;
import restaurant.entities.drinks.interfaces.Beverages;
import restaurant.entities.tables.InGarden;
import restaurant.entities.tables.Indoors;
import restaurant.entities.tables.interfaces.Table;
import restaurant.repositories.interfaces.*;

import java.util.Collection;

public class ControllerImpl implements Controller {
    private final HealthFoodRepository<HealthyFood> healthFoodRepository;
    private final BeverageRepository<Beverages> beverageRepository;
    private final TableRepository<Table> tableRepository;
    private double totalIncome;

    public ControllerImpl(HealthFoodRepository<HealthyFood> healthFoodRepository, BeverageRepository<Beverages> beverageRepository, TableRepository<Table> tableRepository) {
        this.healthFoodRepository = healthFoodRepository;
        this.beverageRepository = beverageRepository;
        this.tableRepository = tableRepository;
    }

    @Override
    public String addHealthyFood(String type, double price, String name) {
        HealthyFood newFood = type.equals("Salad")
                ? new Salad(name, price)
                : new VeganBiscuits(name, price);

        HealthyFood existingFood = this.healthFoodRepository.foodByName(name);

        if(existingFood == null) {
            this.healthFoodRepository.add(newFood);
            return String.format(OutputMessages.FOOD_ADDED, name);
        }

        throw new IllegalArgumentException(String.format(ExceptionMessages.FOOD_EXIST, name));
    }

    @Override
    public String addBeverage(String type, int counter, String brand, String name){
        Beverages newBeverage = type.equals("Fresh")
                ? new Fresh(name, counter, brand)
                : new Smoothie(name, counter, brand);

        Beverages existingBeverage = this.beverageRepository.beverageByName(name, brand);

        if (existingBeverage == null) {
            this.beverageRepository.add(newBeverage);

            return String.format(OutputMessages.BEVERAGE_ADDED, type, brand);
        }

        throw new IllegalArgumentException(String.format(ExceptionMessages.BEVERAGE_EXIST, name));
    }

    @Override
    public String addTable(String type, int tableNumber, int capacity) {
        Table newTable = type.equals("Indoors")
                ? new Indoors(tableNumber, capacity)
                : new InGarden(tableNumber, capacity);

        Table previouslyAdded = this.tableRepository.byNumber(tableNumber);

        if (previouslyAdded == null) {
            this.tableRepository.add(newTable);
            return String.format(OutputMessages.TABLE_ADDED, tableNumber);
        }

        throw new IllegalArgumentException(String.format(ExceptionMessages.TABLE_EXIST, tableNumber));
    }

    @Override
    public String reserve(int numberOfPeople) {
        Collection<Table> tables = this.tableRepository.getAllEntities();

        Table suitableTable = tables.stream()
                .filter(t -> !t.isReservedTable() && t.getSize() >= numberOfPeople)
                .findFirst()
                .orElse(null);

        if (suitableTable == null) {
            return String.format(OutputMessages.RESERVATION_NOT_POSSIBLE, numberOfPeople);
        }

        suitableTable.reserve(numberOfPeople);
        return String.format(OutputMessages.TABLE_RESERVED, suitableTable.getTableNumber(), numberOfPeople);
    }

    @Override
    public String orderHealthyFood(int tableNumber, String healthyFoodName) {
        Table currentTable = tableRepository.byNumber(tableNumber);

        if (currentTable == null) {
            return String.format(OutputMessages.WRONG_TABLE_NUMBER, tableNumber);
        }

        HealthyFood food = healthFoodRepository.foodByName(healthyFoodName);

        if (food == null) {
            return String.format(OutputMessages.NONE_EXISTENT_FOOD, healthyFoodName);
        }

        currentTable.orderHealthy(food);

        return String.format(OutputMessages.FOOD_ORDER_SUCCESSFUL, healthyFoodName, tableNumber);
    }

    @Override
    public String orderBeverage(int tableNumber, String name, String brand) {
        Table currentTable = tableRepository.byNumber(tableNumber);

        if (currentTable == null) {
            return String.format(OutputMessages.WRONG_TABLE_NUMBER, tableNumber);
        }

        Beverages currentBeverage = beverageRepository.beverageByName(name, brand);

        if (currentBeverage == null) {
            return String.format(OutputMessages.NON_EXISTENT_DRINK, name, brand);
        }

        currentTable.orderBeverages(currentBeverage);

        return String.format(OutputMessages.BEVERAGE_ORDER_SUCCESSFUL, name, tableNumber);
    }

    @Override
    public String closedBill(int tableNumber) {
        Table currentTable = this.tableRepository.byNumber(tableNumber);

        double currentTableBill = currentTable.bill();
        currentTable.clear();
        this.totalIncome += currentTableBill;

        return String.format(OutputMessages.BILL, tableNumber, currentTableBill);
    }


    @Override
    public String totalMoney() {
        return String.format(OutputMessages.TOTAL_MONEY, totalIncome);
    }
}
