import java.util.Scanner;

public class SumOfPrime {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        int primeSum = 0;
        int nonprimeSum = 0;

        while(input.equals("stop") == false){
            int num = Integer.parseInt(input);
            boolean isPrime = false;

            if(num < 0){
                System.out.println("Number is negative.");
                input = scan.nextLine();
                continue;
            }

            for (int i = 2; i <= num/2 ; i++) {
                if(num % i == 0){
                    isPrime = true;
                    break;
                }
            }
            
            if(isPrime){
                nonprimeSum += num;
            } else {
                primeSum += num;
            }
            input = scan.nextLine();
        }

        System.out.printf("Sum of all prime numbers is: %d%n", primeSum);
        System.out.printf("Sum of all non prime numbers is: %d", nonprimeSum);

    }
}