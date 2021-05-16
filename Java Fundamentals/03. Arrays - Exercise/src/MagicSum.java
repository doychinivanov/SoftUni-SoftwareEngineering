import java.util.Arrays;
import java.util.Scanner;

public class MagicSum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] arr = Arrays
                .stream(scan.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int sum = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < arr.length; i++) {
            int current = arr[i];

            for (int j = i + 1; j < arr.length; j++) {
                if(current + arr[j] == sum){
                    System.out.println(current + " " + arr[j]);
                }
            }
        }
    }
}