package CarInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int carsCount = Integer.parseInt(scan.nextLine());
        List<Car> carHolder = new ArrayList<>();

        for (int i = 0; i < carsCount; i++) {
            String[] carData = scan.nextLine().split("\\s+");

            String brand = carData[0];
            String model = carData[1];
            int horsePowers = Integer.parseInt(carData[2]);

            Car car = new Car();

            car.setBrand(brand);
            car.setModel(model);
            car.setHorsePower(horsePowers);

            carHolder.add(car);
        }

        carHolder.forEach(System.out::println);

    }
}
