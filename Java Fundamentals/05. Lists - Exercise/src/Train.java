import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Train {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> train = Arrays
                .stream(scan.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int maxCapacity = Integer.parseInt(scan.nextLine());
        String input = scan.nextLine();

        while(input.equals("end") == false){
            if(input.contains("Add")){
                int newWagoon = Integer.parseInt(input.split(" ")[1]);

                train.add(newWagoon);
            } else {
                int amountOfPeople = Integer.parseInt(input);
                populateTrain(amountOfPeople, train, maxCapacity);
            }

            input = scan.nextLine();
        }

        System.out.println(joinElements(train, " "));
    }

    public static void populateTrain(int newPeople, List<Integer> train, int capacity){
        for (int i = 0; i < train.size(); i++) {
            if(train.get(i) + newPeople <= capacity){
                int newAmount = train.get(i) + newPeople;
                train.set(i, newAmount);
                break;
            }
        }
    }

    static String joinElements(List<Integer> items, String delimiter){
        String output = "";

        for(int item: items){
            output += item + delimiter;
        }

        return output;
    }
}
