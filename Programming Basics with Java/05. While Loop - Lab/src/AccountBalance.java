import java.util.Scanner;

public class AccountBalance {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double balance = 0;
        String input = scan.nextLine();

        while(input.equals("NoMoreMoney") == false){
            double money = Double.parseDouble(input);

            if(money <= 0){
                System.out.printf("Invalid operation!%n");
                break;
            }

            balance += money;
            System.out.printf("Increase: %.2f%n", money);

            input = scan.nextLine();
        }

        System.out.printf("Total: %.2f", balance);
    }
}
