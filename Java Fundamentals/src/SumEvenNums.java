import java.util.Arrays;
import java.util.Scanner;

public class SumEvenNums {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int sum = 0;

        int[] numbers = Arrays
                .stream(scan.nextLine()
                        .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();



        for(int i = 0; i < numbers.length; i++){
            if(numbers[i] % 2 == 0){
                sum += numbers[i];
            }
        }

        System.out.println(sum);
    }
}
