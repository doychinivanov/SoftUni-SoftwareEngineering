import java.util.Scanner;

public class FruitMarket {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double strawberPrice = Double.parseDouble(scan.nextLine());
        double bananaKg = Double.parseDouble(scan.nextLine());
        double orangeKg = Double.parseDouble(scan.nextLine());
        double raspberKg = Double.parseDouble(scan.nextLine());
        double strawberKg = Double.parseDouble(scan.nextLine());

        double raspberPrice = strawberPrice / 2;
        double orangePrice = raspberPrice - (raspberPrice * 0.4);
        double bananaPrice = raspberPrice - (raspberPrice * 0.8);

        double totalPrice = strawberPrice * strawberKg + bananaPrice * bananaKg + orangePrice * orangeKg + raspberPrice * raspberKg;

        System.out.printf("%.2f", totalPrice);
    }
}
