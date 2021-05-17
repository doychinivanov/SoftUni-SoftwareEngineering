import java.util.Scanner;

public class SumOfTwo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int combinations = 0;
        int start = Integer.parseInt(scan.nextLine());
        int end = Integer.parseInt(scan.nextLine());
        int magicNum = Integer.parseInt(scan.nextLine());
        int num1 = 0;
        int num2 = 0;
        boolean isFound = false;

        for (int i = start; i <=end ; i++) {
            if(isFound){
                break;
            }

            for (int j = start; j <= end ; j++) {
                combinations++;

                 if(i + j == magicNum){
                     num1 = i;
                     num2 = j;
                     isFound = true;
                     break;
                }
            }
        }

        if(num1 != 0){
            System.out.printf("Combination N:%d ", combinations);
            System.out.printf("(%d + %d = %d)", num1, num2, num1 + num2);
        } else {
            System.out.printf("%d combinations - neither equals %d", combinations, magicNum);
        }
    }
}