import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ChangeList {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> numbers = Arrays
                .stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String input = scan.nextLine();

        while(input.equals("end") == false){
            if(input.contains("Delete")){
                int toBeDeleted = Integer.parseInt(input.split(" ")[1]);

                deleteElementFromList(toBeDeleted, numbers);
            } else if(input.contains("Insert")){
                int numberToInsert = Integer.parseInt(input.split(" ")[1]);
                int indexToInsertAt = Integer.parseInt(input.split(" ")[2]);

                insertElements(numberToInsert, indexToInsertAt, numbers);
            }

            input = scan.nextLine();
        }

        System.out.println(joinElements(numbers, " "));
    }

    public static void deleteElementFromList(int valueToDelete, List<Integer> intList){
         intList.removeAll(Arrays.asList(valueToDelete));
    }

    public static void insertElements(int toBeInserted, int index, List<Integer> intList){
        intList.add(index, toBeInserted);
    }

    static String joinElements(List<Integer> items, String delimiter){
        String output = "";

        for(int item: items){
            output += item + delimiter;
        }

        return output;
    }
}
