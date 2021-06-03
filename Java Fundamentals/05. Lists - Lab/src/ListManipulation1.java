import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulation1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);

        List<Integer> numbers = Arrays
                .stream(scan.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String input = scan.nextLine();

        while(input.equals("end") != true){
            String[] tokens = input.split(" ");

            switch (tokens[0]){
                case "Add":
                    numbers = add(numbers, tokens[1]);
                    break;
                case "Remove":
                    numbers = remove(numbers, tokens[1]);
                    break;
                case "RemoveAt":
                    numbers = removeAt(numbers, tokens[1]);
                    break;
                case "Insert":
                    numbers = insert(numbers, tokens[1], tokens[2]);
                    break;
            }

            input = scan.nextLine();
        }

        System.out.println(joinElements(numbers, " "));
    }

    static List<Integer> add(List<Integer> list, String num){
        list.add(Integer.parseInt(num));

        return list;
    }

    static List<Integer> remove(List<Integer> list, String num){
        list.remove(Integer.valueOf(Integer.parseInt(num)));

        return list;
    }

    static List<Integer> removeAt(List<Integer> list, String num){
        list.remove(Integer.parseInt(num));

        return list;
    }

    static List<Integer> insert(List<Integer> list, String numA, String numB){
        list.add(Integer.parseInt(numB), Integer.parseInt(numA));

        return list;
    }

    static String joinElements(List<Integer> items, String delimiter){
        String output = "";

        for (Integer item:items){
            output += item + delimiter;
        }

        return output;
    }
}
