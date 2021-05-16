import java.util.Arrays;
import java.util.Scanner;

public class EqualArrs {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] firstArr = Arrays
                .stream(scan.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] secondArr = Arrays
                .stream(scan.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int sum = 0;
        boolean areEqual = true;

        for (int i = 0; i < firstArr.length; i++) {
            sum += firstArr[i];

            if(firstArr[i] != secondArr[i]){
                areEqual = false;
                System.out.printf("Arrays are not identical. Found difference at %d index.", i);
                break;
            }
        }

        if(areEqual){
            System.out.printf("Arrays are identical. Sum: %d", sum);
        }
    }
}