package CarSalesman;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        HashMap<String, Engine> allPossibleEngines = new HashMap<>();
        List<Car> allCars = new ArrayList<>();

        int enginesCount = Integer.parseInt(scan.nextLine());

        createEngines(scan, allPossibleEngines, enginesCount);

        int carsCount = Integer.parseInt(scan.nextLine());

        createCars(scan, allPossibleEngines, allCars, carsCount);

        allCars
                .forEach(System.out::println);
    }

    private static void createCars(Scanner scan, HashMap<String, Engine> allPossibleEngines, List<Car> allCars, int carsCount) {
        for (int i = 0; i < carsCount; i++) {
            String[] carInfo = scan.nextLine().split("\\s+");

            String carModel = carInfo[0];
            String carEngineModel = carInfo[1];

            if(carInfo.length == 4){
                int carWeight = Integer.parseInt(carInfo[2]);
                String carColor = carInfo[3];

                allCars.add(new Car(carModel, allPossibleEngines.get(carEngineModel), carWeight, carColor));

            } else if(carInfo.length == 3){
                try{
                    int carWeight = Integer.parseInt(carInfo[2]);
                    allCars.add(new Car(carModel, allPossibleEngines.get(carEngineModel), carWeight));
                } catch(Exception err){
                    String carColor = carInfo[2];
                    allCars.add(new Car(carModel, allPossibleEngines.get(carEngineModel), carColor));
                }

            } else {
                allCars.add(new Car(carModel, allPossibleEngines.get(carEngineModel)));
            }
        }
    }

    private static void createEngines(Scanner scan, HashMap<String, Engine> allPossibleEngines, int enginesCount) {
        for (int i = 0; i < enginesCount; i++) {
            String[] engineInfo = scan.nextLine().split("\\s+");

            String engineModel = engineInfo[0];
            int enginePower = Integer.parseInt(engineInfo[1]);

            if(engineInfo.length == 4){
                int engineDisplacement = Integer.parseInt(engineInfo[2]);
                String engineEfficiency = engineInfo[3];

                allPossibleEngines.put(engineModel, new Engine(engineModel, enginePower, engineDisplacement, engineEfficiency));
            } else if(engineInfo.length == 3){
                try{
                    int engineDisplacement = Integer.parseInt(engineInfo[2]);

                    allPossibleEngines.put(engineModel, new Engine(engineModel, enginePower, engineDisplacement));
                } catch (Exception err){
                    String engineEfficiency = engineInfo[2];

                    allPossibleEngines.put(engineModel, new Engine(engineModel, enginePower, engineEfficiency));
                }
            } else {
                allPossibleEngines.put(engineModel, new Engine(engineModel, enginePower));
            }
        }
    }
}
