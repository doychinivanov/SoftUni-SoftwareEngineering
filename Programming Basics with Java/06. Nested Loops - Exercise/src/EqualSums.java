import java.util.Arrays;
import java.util.Scanner;

public class EqualSums {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int start = Integer.parseInt(scan.nextLine());
        int end = Integer.parseInt(scan.nextLine());

        for (int i = start; i <= end ; i++) {
            int evenSum = 0;
            int oddSum = 0;

            String numStr = Integer.toString(i);
            int[] num = new int[numStr.length()];

            for (int k = 0; k < numStr.length(); k++) {
                num[k] = numStr.charAt(k) - '0';
            }

            for (int j = 0; j < num.length; j++) {
                if(j % 2 == 0){
                    evenSum += num[j];
                } else {
                    oddSum += num[j];
                }
            }

            if(evenSum == oddSum){
                System.out.print(i + " ");
            }
        }
    }
}