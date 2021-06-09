import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListOperations {
    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);

        List<Integer> numbers = Arrays
                .stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String input = scan.nextLine();

        while (input.equals("End") == false){
            String[] tokens = input.split("\\s+");

            switch (tokens[0]){
                case "Add":
                    numbers.add(Integer.parseInt(tokens[1]));
                    break;
                case "Remove":
                    if(checkIndex(numbers, Integer.parseInt(tokens[1]))){
                        numbers.remove(Integer.parseInt(tokens[1]));
                    } else {
                        System.out.println("Invalid index");
                    }
                    break;
                case "Shift":
                    if (tokens[1].equals("left")){
                        for (int i = 0; i < Integer.parseInt(tokens[2]); i++) {
                            int firstNumber = numbers.get(0);
                            numbers.remove(0);
                            numbers.add(firstNumber);
                        }
                    } else {
                        for (int i = 0; i < Integer.parseInt(tokens[2]); i++) {
                            int lastNumber = numbers.get(numbers.size()-1);
                            numbers.remove(numbers.size()-1);
                            numbers.add(0, lastNumber);
                        }
                    }
                    break;
                case "Insert":
                    if(checkIndex(numbers, Integer.parseInt(tokens[2]))){
                        numbers.add(Integer.parseInt(tokens[2]), Integer.parseInt(tokens[1]));
                    } else {
                        System.out.println("Invalid index");
                    }
                    break;
            }

            input = scan.nextLine();
        }

        System.out.println(joinElements(numbers, " "));
    }

    static boolean checkIndex(List<Integer>list, int index){
        if(index >= 0 && index < list.size()){
            return true;
        }
        return false;
    }

    static String joinElements(List<Integer> items, String delimiter){
        String output = "";

        for(int item: items){
            output += item + delimiter;
        }

        return output;
    }
}
