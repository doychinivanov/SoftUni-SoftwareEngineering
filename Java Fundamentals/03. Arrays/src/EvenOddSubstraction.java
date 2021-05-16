import java.util.Arrays;
import java.util.Scanner;

public class EvenOddSubstraction {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int evenSum = 0;
        int oddSum = 0;

        int[] arr = Arrays
                .stream(scan.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] % 2 == 0){
                evenSum += arr[i];
            } else {
                oddSum += arr[i];
            }
        }

        System.out.println(evenSum - oddSum);
    }
}