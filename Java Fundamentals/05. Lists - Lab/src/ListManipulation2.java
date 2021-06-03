import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulation2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> numbers = Arrays
                .stream(scan.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String input = scan.nextLine();

        while (input.equals("end") != true){
            String[] tokens = input.split(" ");

            switch (tokens[0]){
                case "Contains":
                    checkIfContains(numbers, tokens[1]);
                    break;
                case "Print":
                    printElements(numbers, tokens[1]);
                    break;
                case "Get":
                    getSum(numbers);
                    break;
                case "Filter":
                    filterList(numbers, tokens[1], tokens[2]);
                    break;
            }

            input = scan.nextLine();
        }

    }
    static void checkIfContains(List<Integer> list, String num){
        if(list.contains(Integer.parseInt(num))){
            System.out.println("Yes");
        } else {
            System.out.println("No such number");
        }
    }

    static void printElements(List<Integer> list, String type){
        String output = "";

        if(type.equals("even")){
            for (int i = 0; i < list.size(); i++) {
                if(list.get(i) % 2 == 0){
                    output += list.get(i) + " ";
                }
            }
        } else if(type.equals("odd")){
            for (int i = 0; i < list.size(); i++) {
                if(list.get(i) % 2 != 0){
                    output += list.get(i) + " ";
                }
            }
        }

        System.out.println(output);
    }

    static void getSum(List<Integer> list){
        Integer sum = list.stream().reduce(0, (a,b) -> a+b);
        System.out.println(sum);
    }

    static void filterList(List<Integer> list, String value, String n){
        int num = Integer.parseInt(n);

        if(value.equals(">")){
            list = list.stream().filter(x -> x > num).collect(Collectors.toList());
        } else if(value.equals("<")){
            list = list.stream().filter(x -> x < num).collect(Collectors.toList());
        } else if(value.equals(">=")){
            list = list.stream().filter(x -> x >= num).collect(Collectors.toList());
        } else if(value.equals("<=")){
            list = list.stream().filter(x -> x <= num).collect(Collectors.toList());
        }

        System.out.println(joinElements(list, " "));
    }

    static String joinElements(List<Integer> items, String delimiter){
        String output = "";

        for(int item: items){
            output += item + delimiter;
        }

        return output;
    }
}
