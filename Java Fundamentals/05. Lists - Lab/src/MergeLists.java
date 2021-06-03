import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MergeLists {
    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);

        List<Double> firstList = Arrays
                .stream(scan.nextLine().split(" "))
                .map(Double::parseDouble)
                .collect(Collectors.toList());

        List<Double> secondList = Arrays
                .stream(scan.nextLine().split(" "))
                .map(Double::parseDouble)
                .collect(Collectors.toList());

        List<Double> result = new ArrayList<>();
        result = mergeLists(firstList, secondList, result);

        System.out.println(joinElements(result, " "));
    }

    static List<Double> mergeLists (List<Double> first, List<Double> second, List<Double> result){

        for (int i = 0; i < Math.min(first.size(), second.size()); i++) {
            result.add(first.get(i));
            result.add(second.get(i));
        }

        if(first.size() > second.size()){
            for (int i = second.size(); i < first.size(); i++) {
                result.add(first.get(i));
            }
        }

        if(second.size() > first.size()){
            for (int i = first.size(); i < second.size(); i++) {
                result.add(second.get(i));
            }
        }

        return result;
    }

    static String joinElements(List<Double> list, String delimiter){
        String output = "";

        for (int i = 0; i < list.size(); i++) {
            output += new DecimalFormat("0.#").format(list.get(i)) + delimiter;
        }

        return output;
    }
}
