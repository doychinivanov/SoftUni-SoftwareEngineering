import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class HeartDelivery {
    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);

        List<Integer> neighborhood = Arrays
                .stream(scan.nextLine().split("@"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String input = scan.nextLine();
        int index = 0;

        while (input.equals("Love!") == false){
            String[] inputData = input.split("\\s+");
            int lengthJump = Integer.parseInt(inputData[1]);

            index = lengthJump + index >= neighborhood.size() ? 0 : index + lengthJump;

            if(neighborhood.get(index) <= 0){
                System.out.printf("Place %d already had Valentine's day.\n", index);
                input = scan.nextLine();
                continue;
            }

            neighborhood.set(index, neighborhood.get(index) - 2);

            if(neighborhood.get(index) <= 0){
                System.out.printf("Place %d has Valentine's day.\n", index);
            }

            input = scan.nextLine();
        }

        List<Integer> housesWithoutValentinesDay = neighborhood.stream().filter(x -> x > 0).collect(Collectors.toList());
        System.out.printf("Cupid's last position was %d.\n", index);

        if(housesWithoutValentinesDay.size() > 0){
            System.out.printf("Cupid has failed %d places.", housesWithoutValentinesDay.size());
        } else {
            System.out.println("Mission was successful.");
        }
    }
}