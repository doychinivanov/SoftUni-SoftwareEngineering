import java.util.Scanner;

public class ToyShop {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double puzzlePrice = 2.6;
        double dollPrice = 3.0;
        double teddyBearPrice = 4.1;
        double minionPrice = 8.2;
        double truckPrice = 2.0;

        double tripPrice = Double.parseDouble(scan.nextLine());
        int puzzleAmount = Integer.parseInt(scan.nextLine());
        int dollAmount = Integer.parseInt(scan.nextLine());
        int teddyBearAmount = Integer.parseInt(scan.nextLine());
        int minionsAmount = Integer.parseInt(scan.nextLine());
        int trucksAmount = Integer.parseInt(scan.nextLine());

        double profit = puzzlePrice * puzzleAmount + dollPrice * dollAmount + teddyBearPrice * teddyBearAmount + minionPrice * minionsAmount + truckPrice * trucksAmount;
        int orderedToys = puzzleAmount + dollAmount + teddyBearAmount + minionsAmount + trucksAmount;

        if(orderedToys >= 50){
            profit *= 0.75;
        }

        profit *= 0.9;

        if(profit >= tripPrice){
            System.out.printf("Yes! %.2f lv left.", Math.abs(tripPrice-profit));
        } else {
            System.out.printf("Not enough money! %.2f lv needed.", tripPrice-profit);
        }
    }
}
