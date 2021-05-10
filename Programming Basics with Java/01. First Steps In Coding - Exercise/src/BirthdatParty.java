import java.util.Scanner;

public class BirthdatParty {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double rent = Double.parseDouble(scan.nextLine());

        double cakePrice = rent * 0.2;
        double animatorPrice = rent / 3;
        double drinksPrice = cakePrice - cakePrice * 0.45;

        System.out.println(rent + cakePrice + drinksPrice + animatorPrice);
    }
}
