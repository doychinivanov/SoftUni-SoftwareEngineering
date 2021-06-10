import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BombNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> numbers = Arrays
                .stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int[] bombInfo = Arrays
                .stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int bombNumber = bombInfo[0];
        int bombPower = bombInfo[1];

        detonateList(bombNumber, bombPower, numbers);

        int listSum = numbers.stream().reduce(0, (acc, curr) -> acc + curr);
        System.out.println(listSum);
    }

    static void detonateList(int specialNumber, int power, List<Integer> numbers){
        while(numbers.contains(specialNumber)){
            int startIndex = setStartIndex(specialNumber, power, numbers);
            int endIndex = setEndIndex(specialNumber, power, numbers);


            for (int i = startIndex; i <= endIndex ; i++) {
                numbers.remove(startIndex);
            }
        }
    }

    static int setStartIndex(int specialNumber, int power, List<Integer> numbers){
        int index = 0;

        if(numbers.indexOf(specialNumber) - power > 0){
            index = numbers.indexOf(specialNumber) - power;
        }

        return index;
    }

    static int setEndIndex(int specialNumber, int power, List<Integer> numbers){
        int index = numbers.size()-1;

        if(numbers.indexOf(specialNumber) + power < numbers.size() -1){
            index = numbers.indexOf(specialNumber) + power;
        }

        return index;
    }
}
