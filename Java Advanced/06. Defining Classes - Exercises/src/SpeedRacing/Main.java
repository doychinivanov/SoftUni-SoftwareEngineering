package SpeedRacing;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        LinkedHashMap<String, Car> cars = new LinkedHashMap<>();
        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {
            String[] tokens = scan.nextLine().split("\\s+");

            String model = tokens[0];
            double fuel = Double.parseDouble(tokens[1]);
            double perOneKm = Double.parseDouble(tokens[2]);

            cars.putIfAbsent(model, new Car(model, fuel, perOneKm));
        }

        String input = scan.nextLine();

        while(!input.equals("End")){

            String[] tokens = input.split("\\s+");

            String model = tokens[1];
            double distance = Double.parseDouble(tokens[2]);

            cars.get(model).travel(distance);

            input = scan.nextLine();
        }

        cars.forEach((key, value) -> System.out.println(value.toString()));
    }
}
