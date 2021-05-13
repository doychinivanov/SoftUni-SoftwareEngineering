import java.util.Scanner;

public class CleverLilly {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int age = Integer.parseInt(scan.nextLine());
        double price = Double.parseDouble(scan.nextLine());
        int toyPrice = Integer.parseInt(scan.nextLine());
        int amountToys = 0;
        int money = 0;
        int giftMoney = 10;

        for (int i = 1; i<=age; i++){

            if(i % 2 == 0){
                money += giftMoney - 1;
                giftMoney += 10;
            } else {
                amountToys++;
            }
        }

        money += amountToys * toyPrice;


        if(money - price >= 0){
            System.out.printf("Yes! %.2f", Math.abs(money - price));
        } else {
            System.out.printf("No! %.2f", Math.abs(price - money));
        }


    }
}
