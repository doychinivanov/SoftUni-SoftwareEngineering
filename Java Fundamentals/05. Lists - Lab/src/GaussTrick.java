import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GaussTrick {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Double> numbers = Arrays
                .stream(scan.nextLine().split(" "))
                .map(Double::parseDouble)
                .collect(Collectors.toList());

        List<Double> result = new ArrayList<>();

        for (int i = 0; i < numbers.size()/2; i++) {
            result.add(numbers.get(i) + numbers.get(numbers.size() -1 - i));
        }

        if(numbers.size() % 2 != 0){
            result.add(numbers.get(numbers.size()/2));
        }

        System.out.println(joinElements(result, " "));
    }

    static String joinElements(List<Double> items, String delimiter){
        String output = "";

        for(Double item: items){
            output += new DecimalFormat("0.#").format(item) + delimiter;
        }

        return output;
    }
}
