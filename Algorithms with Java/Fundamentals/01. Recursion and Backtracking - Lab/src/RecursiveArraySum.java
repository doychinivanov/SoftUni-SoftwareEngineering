import java.util.Arrays;
import java.util.Scanner;

public class RecursiveArraySum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] numbers = Arrays
                .stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        long sumOfArr = sumArray(numbers, 0);

        System.out.println(sumOfArr);

    }

    public static long sumArray(int[] arr, int index) {
        if (index >= arr.length) {
            return 0;
        }

        return arr[index] + sumArray(arr, index + 1);
    }
}
