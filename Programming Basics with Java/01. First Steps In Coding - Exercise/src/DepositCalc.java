import java.util.Scanner;

public class DepositCalc {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double initialAmount = Double.parseDouble(scan.nextLine());
        int time = Integer.parseInt(scan.nextLine());
        double interestRate = Double.parseDouble(scan.nextLine());

        double finalAmount = initialAmount + time * ((initialAmount * (interestRate / 100)) / 12);

        System.out.println(finalAmount);
    }
}
