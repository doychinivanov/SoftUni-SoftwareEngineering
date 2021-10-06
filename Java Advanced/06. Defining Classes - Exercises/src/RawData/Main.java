package RawData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Car> cars = new ArrayList<>();
        int n = Integer.parseInt(scan.nextLine());

        createCars(scan, cars, n);

        String cargoSearchParam = scan.nextLine();
        Predicate<Car> getCarsBySearchParam = car -> car.getCargo().getType().equals(cargoSearchParam);

        cars
                .stream()
                .filter(getCarsBySearchParam)
                .filter(cargoSearchParam.equals("fragile") ? Car::oneTirePressureIsLessThanOne : Car::enginePowerIsBiggerThan250)
                .forEach(car -> System.out.println(car.getModel()));
    }

    private static void createCars(Scanner scan, List<Car> cars, int n) {
        for (int i = 0; i < n; i++) {
            String[] tokens = scan.nextLine().split("\\s+");

            String model = tokens[0];
            int engineSpeed = Integer.parseInt(tokens[1]);
            int enginePower = Integer.parseInt(tokens[2]);
            int cargoWeight = Integer.parseInt(tokens[3]);
            String cargoType = tokens[4];
            List<Tires> tires = createTires(tokens);

            cars.add(new Car(model, engineSpeed, enginePower, cargoWeight, cargoType, tires));
        }
    }

    public static List<Tires> createTires(String[] tokens){
        List<String> tiresData = extractTiresFromTokens(tokens);
        List<Tires> tires = new ArrayList<>();

        for (int i = 0; i < tiresData.size(); i+=2) {
            double tirePressure = Double.parseDouble(tiresData.get(i));
            int tireAge = Integer.parseInt(tiresData.get(i+1));

            tires.add(new Tires(tirePressure, tireAge));
        }

        return tires;
    }

    public static List<String> extractTiresFromTokens(String[] tokens){
        List<String> tiresData = new ArrayList<>();

        for (int i = 5; i < tokens.length; i++) {
            tiresData.add(tokens[i]);
        }

        return tiresData;
    }
}
