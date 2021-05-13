import java.util.Scanner;

public class HalfSum {
    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);

        int n = Integer.parseInt(scan.nextLine());
        int max = Integer.MIN_VALUE;
        int sum = 0;


        for (int i = 0; i < n; i++){
            int currentNum = Integer.parseInt(scan.nextLine());
            sum += currentNum;

            if(currentNum > max){
                max = currentNum;
            }
        }

        sum -= max;

        if(max == sum){
            System.out.printf("Yes%nSum = %d", sum);
        } else {
            System.out.printf("No%nDiff = %d", Math.abs(sum - max));
        }
    }
}
