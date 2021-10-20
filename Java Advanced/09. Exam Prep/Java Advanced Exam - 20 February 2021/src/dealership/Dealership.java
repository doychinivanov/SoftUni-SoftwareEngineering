package dealership;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Dealership {
    private List<Car> data;
    private String name;
    private int capacity;

    public Dealership(String name, int capacity){
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Car car){
        if(capacity > this.data.size()){
            data.add(car);
        }
    }

    public boolean buy(String manufaturer, String model){
        Car foundCar = findCarByManufacturerAndModel(manufaturer, model);

        if(foundCar != null){
            this.data.remove(foundCar);
            return true;
        }

        return false;
    }

    public Car getCar(String manufacturer, String model){
        return findCarByManufacturerAndModel(manufacturer, model);
    }

    public Car getLatestCar(){
        return this.data.stream().sorted(Comparator.comparing(Car::getYear).reversed()).collect(Collectors.toList()).get(0);
    }

    public Car findCarByManufacturerAndModel(String manufacturer, String model){
        Car found = null;

        for (Car car : this.data) {
            if (car.getManufacturer().equals(manufacturer) && car.getModel().equals(model)) {
                found = car;
                break;
            }
        }

        return found;
    }

    public int getCount(){
        return this.data.size();
    }

    public String getStatistics(){
        StringBuilder result = new StringBuilder();

        result.append(String.format("The cars are in a car dealership %s:", this.name)).append(System.lineSeparator());

        this.data.forEach(car -> result.append(car.toString()).append(System.lineSeparator()));

        return result.toString();
    }
}
