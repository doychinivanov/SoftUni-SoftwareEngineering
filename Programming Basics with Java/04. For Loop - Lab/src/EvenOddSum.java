import java.util.Scanner;

public class EvenOddSum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int x = Integer.parseInt(scan.nextLine());
        int oddSum = 0;
        int evenSum = 0;

        for (int i = 0; i < x; i++){
            int num = Integer.parseInt(scan.nextLine());

            if(i % 2 == 0){
                evenSum += num;
            } else {
                oddSum += num;
            }
        }

        if(oddSum == evenSum){
            System.out.printf("Yes%nSum = %d", evenSum);
        } else {
            System.out.printf("No%nDiff = %d", Math.abs(evenSum-oddSum));
        }
    }
}
