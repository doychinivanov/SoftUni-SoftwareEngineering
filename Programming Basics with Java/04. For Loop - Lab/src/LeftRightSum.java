import java.util.Scanner;

public class LeftRightSum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int num = Integer.parseInt(scan.nextLine());
        int leftSum = 0;
        int rightSum = 0;

        for (int i = 0; i < num; i++){
            leftSum += Integer.parseInt(scan.nextLine());
        }

        for (int i = num; i < num+num; i++){
            rightSum += Integer.parseInt(scan.nextLine());
        }

        if( leftSum == rightSum){
            System.out.printf("Yes, sum = %d", leftSum);
        } else {
            System.out.printf("No, diff = %d", Math.abs(leftSum - rightSum));
        }
    }
}
