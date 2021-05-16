import java.util.Arrays;
import java.util.Scanner;

public class EqualSum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean noMatches = true;
        int[] arr = Arrays
                .stream(scan.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int i = 0; i < arr.length; i++) {
            int left = 0;
            int right = 0;

            for (int j = 0; j <= i - 1; j++) {
                left += arr[j];
            }

            for (int k = i + 1; k < arr.length; k++) {
                right += arr[k];
            }

            if(left == right){
                noMatches = false;
                System.out.println(i);
            }
        }

        if(noMatches){
            System.out.println("no");
        }

    }
}
