import java.util.LinkedHashSet;
import java.util.Scanner;

public class ParkingLot {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        LinkedHashSet<String> parking = new LinkedHashSet<>();

        String input = scan.nextLine();

        while(!input.equals("END")){
            String[] inputData = parseData(input, ", ");

            String direction = inputData[0];
            String carNumber = inputData[1];

            if(direction.equals("IN")){
                parking.add(carNumber);
            } else if (direction.equals("OUT")) {
                parking.remove(carNumber);
            }

            input = scan.nextLine();
        }

        if(parking.isEmpty()){
            System.out.println("Parking Lot is Empty");
        } else {
            System.out.println(String.join(System.lineSeparator(), parking));
        }
    }

    public static String[] parseData(String input, String delimiter){
        return input.split(delimiter);
    }
}
