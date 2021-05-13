import java.util.Scanner;

public class MaxNum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int x = Integer.parseInt(scan.nextLine());
        int minNum = Integer.MAX_VALUE;
        int maxNum = Integer.MIN_VALUE;


        for (int i =0; i < x; i++){
            int num = Integer.parseInt(scan.nextLine());

            if(num > maxNum){
                maxNum = num;
            }

            if(num < minNum){
                minNum = num;
            }
        }

        System.out.printf("Max number: %d%n", maxNum);
        System.out.printf("Min number: %d", minNum);
    }
}
