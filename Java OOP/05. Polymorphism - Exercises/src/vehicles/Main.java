package vehicles;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, Vehicle> vehicles = new LinkedHashMap<>();

        String[] carTokens = scan.nextLine().split("\\s+");
        Vehicle car = createVehicle(carTokens);


        String[] truckTokens = scan.nextLine().split("\\s+");
        Vehicle truck = createVehicle(truckTokens);

        vehicles.put("Car", car);
        vehicles.put("Truck", truck);

        int commandCount = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < commandCount; i++) {
            String[] tokens = scan.nextLine().split("\\s+");

            String command = tokens[0];
            String vehicleType = tokens[1];
            double amount = Double.parseDouble(tokens[2]);

            switch (command){
                case "Drive":
                    System.out.println(vehicles.get(vehicleType).drive(amount));
                    break;
                case "Refuel": {
                    vehicles.get(vehicleType).refuel(amount);
                    break;
                }
            }
        }

        vehicles.forEach((key, value) -> System.out.println(value.toString()));
    }

    private static Vehicle createVehicle(String[] tokens) {
        String vehicleType = tokens[0];
        double fuelAmount = Double.parseDouble(tokens[1]);
        double consumption = Double.parseDouble(tokens[2]);
        Vehicle vehicle = null;


        switch (vehicleType) {
            case "Car":
                vehicle = new Car(fuelAmount, consumption);
                break;
            case "Truck":
                vehicle = new Truck(fuelAmount, consumption);
                break;
        }
        return vehicle;
    }
}