import java.util.Scanner;

public class OddEven {
    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);

        int n = Integer.parseInt(scan.nextLine());
        double oddSum = 0;
        double oddMin = Integer.MAX_VALUE;
        double oddMax = Integer.MIN_VALUE;

        double evenSum = 0;
        double evenMin = Integer.MAX_VALUE;
        double evenMax = Integer.MIN_VALUE;

        for (int i = 1; i <= n; i++){
            double currentNum = Double.parseDouble(scan.nextLine());

            if(i % 2 == 0){
                evenSum += currentNum;

                if(currentNum > evenMax){
                    evenMax = currentNum;
                }

                if(currentNum < evenMin){
                    evenMin = currentNum;
                }
            } else {
                oddSum += currentNum;

                if(currentNum > oddMax){
                    oddMax = currentNum;
                }

                if(currentNum < oddMin){
                    oddMin = currentNum;
                }
            }
        }

        System.out.printf("OddSum=%.2f,%n", oddSum);

        if(oddSum == 0){
            System.out.println("OddMin=No,");
            System.out.println("OddMax=No,");
        } else {
            System.out.printf("OddMin=%.2f,%n", oddMin);
            System.out.printf("OddMax=%.2f,%n", oddMax);
        }

        System.out.printf("EvenSum=%.2f,%n", evenSum);

        if(evenSum == 0){
            System.out.println("EvenMin=No,");
            System.out.println("EvenMax=No");
        } else {
            System.out.printf("EvenMin=%.2f,%n", evenMin);
            System.out.printf("EvenMax=%.2f", evenMax);
        }
    }
}