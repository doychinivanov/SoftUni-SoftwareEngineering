import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RemoveNegative {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> numbers = Arrays
                .stream(scan.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        for (int i = 0; i < numbers.size(); i++) {
            if(numbers.get(i) < 0){
                numbers.remove(i);
                i--;
            }
        }

        Collections.reverse(numbers);

        if(numbers.isEmpty()){
            System.out.println("empty");
        } else {
            System.out.println(joinElements(numbers, " "));
        }
    }

    static String joinElements(List<Integer> items, String delimiter){
        String output = "";

        for(int item:items){
            output += item + delimiter;
        }

        return output;
    }
}
