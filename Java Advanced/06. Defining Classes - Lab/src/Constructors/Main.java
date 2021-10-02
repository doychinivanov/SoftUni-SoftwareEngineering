package Constructors;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Car> carCollection = new ArrayList<>();
        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {
            String[] carData = scan.nextLine().split("\\s+");

            Car car = null;
            if(carData.length == 1 ){
                car = new Car(carData[0]);
            } else if(carData.length == 2){
                car = new Car(carData[0], carData[1]);
            } else {
                car = new Car(carData[0], carData[1], Integer.parseInt(carData[2]));
            }

            carCollection.add(car);
        }

        carCollection.forEach(car -> System.out.println(car.toString()));
    }
}
