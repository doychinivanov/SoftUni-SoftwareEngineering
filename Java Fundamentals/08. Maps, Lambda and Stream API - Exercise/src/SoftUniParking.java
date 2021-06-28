import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SoftUniParking {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, String> parkingLot = new LinkedHashMap<>();
        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {
            String[] data = scan.nextLine().split("\\s+");
            String command = data[0];
            String name = data[1];

            if(command.equals("register")){
                String licenseNumber = data[2];

                registerCar(parkingLot, name, licenseNumber);
            } else if(command.equals("unregister")){
                unregisterCar(parkingLot, name);
            }
        }

        parkingLot.forEach((k,v) -> System.out.printf("%s => %s\n", k, v));
    }

    public static void registerCar(Map<String, String> parkingLot, String name, String license){
        if(parkingLot.containsKey(name)){
            System.out.printf("ERROR: already registered with plate number %s\n", license);
        } else {
            parkingLot.put(name, license);
            System.out.printf("%s registered %s successfully\n", name, license);
        }
    }

    public static void unregisterCar(Map<String, String> parkingLot, String name){
        if(parkingLot.containsKey(name)){
            parkingLot.remove(name);
            System.out.printf("%s unregistered successfully\n", name);
        } else {
            System.out.printf("ERROR: user %s not found\n", name);
        }
    }
}
