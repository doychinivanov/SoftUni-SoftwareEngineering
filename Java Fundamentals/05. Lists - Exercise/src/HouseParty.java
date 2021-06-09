import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HouseParty {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        List<String> guests = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String currentLine = scan.nextLine();
            String[] tokens = currentLine.split(" ");
            String currentGuest = tokens[0];

            if(currentLine.contains("not")){
                if(guests.contains(currentGuest)){
                    guests.remove(currentGuest);
                } else {
                    System.out.printf("%s is not in the list!\n", currentGuest);
                }
            } else {
                if(guests.contains(currentGuest) == false){
                    guests.add(currentGuest);
                } else {
                    System.out.printf("%s is already in the list!\n", currentGuest);
                }
            }
        }

        System.out.println(printOutput(guests, "\n"));
    }

    static String printOutput(List<String> guests, String delimiter){
        String result = "";

        for (String guest:guests) {
            result += guest + delimiter;
        }

        return result;
    }
}
