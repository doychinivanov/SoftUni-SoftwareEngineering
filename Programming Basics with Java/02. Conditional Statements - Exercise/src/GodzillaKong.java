import java.util.Scanner;

public class GodzillaKong {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double budget = Double.parseDouble(scan.nextLine());
        int statists = Integer.parseInt(scan.nextLine());
        double pricePerOne = Double.parseDouble(scan.nextLine());
        double decor = budget * 0.1;

        if(statists > 150){
            pricePerOne *= 0.9;
        }

        double expenses = statists * pricePerOne + decor;

        if(budget - expenses >= 0){
            System.out.println("Action!");
            System.out.printf("Wingard starts filming with %.2f leva left.", budget - expenses);
        } else {
            System.out.println("Not enough money!");
            System.out.printf("Wingard needs %.2f leva more.", Math.abs(budget - expenses));
        }
    }
}
