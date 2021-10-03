import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PredicateParty {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<String> guests = Arrays.stream(scan.nextLine().split("\\s+")).collect(Collectors.toList());
        String input = scan.nextLine();

        BiFunction<String, String, List<String>> getNamesThatFulfilCondition = (command, str) -> {
            if(command.equals("StartsWith")){
                return guests.stream().filter(name -> name.startsWith(str)).collect(Collectors.toList());
            } else if(command.equals("EndsWith")) {
                return guests.stream().filter(name -> name.endsWith(str)).collect(Collectors.toList());
            } else {
                int nameLength = Integer.parseInt(str);

                return guests.stream().filter(name -> name.length() == nameLength).collect(Collectors.toList());
            }
        };
        Function<List<String>, List<String>> sortNamesInAscendingOrder = list -> list.stream().sorted().collect(Collectors.toList());

        Consumer<List<String>> printGuests = list -> {
            if(list.size() > 0){
                System.out.println(String.join(", ", sortNamesInAscendingOrder.apply(list)) + " are going to the party!");
            } else {
                System.out.println("Nobody is going to the party!");
            }
        };

        while (!input.equals("Party!")){
            String[] tokens = input.split("\\s+");

            String command = tokens[0];
            String condition = tokens[1];
            String value = tokens[2];

            List<String> foundNameByCondition = getNamesThatFulfilCondition.apply(condition, value);

            if(command.equals("Remove")){
                guests.removeAll(foundNameByCondition);
            } else if(command.equals("Double")){
                guests.addAll(foundNameByCondition);
            }

            input = scan.nextLine();
        }

        printGuests.accept(guests);
    }
}
