import java.util.Scanner;

public class Vacation {
    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);

        double moneyNeeded = Double.parseDouble(scan.nextLine());
        double money = Double.parseDouble(scan.nextLine());
        int daysCount = 0;
        int spendingDays = 0;

        while(money < moneyNeeded && spendingDays < 5){
            String action = scan.nextLine();
            double currentSum = Double.parseDouble(scan.nextLine());
            daysCount++;

            if(action.equals("spend")){
                spendingDays ++;
                money -= currentSum;

                if(money < 0){
                    money = 0;
                }

            } else if(action.equals("save")){
                spendingDays = 0;
                money += currentSum;
            }
        }

        if(spendingDays == 5){
            System.out.println("You can't save the money.");
            System.out.println(daysCount);
        } else {
            System.out.printf("You saved the money for %d days.", daysCount);
        }

    }
}