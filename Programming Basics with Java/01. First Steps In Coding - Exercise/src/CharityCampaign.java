import java.util.Scanner;

public class CharityCampaign {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int days = Integer.parseInt(scan.nextLine());
        int cooks = Integer.parseInt(scan.nextLine());
        int cakes = Integer.parseInt(scan.nextLine());
        int waffles = Integer.parseInt(scan.nextLine());
        int pancakes = Integer.parseInt(scan.nextLine());

        double revenuePerDay = (cakes * 45 + waffles * 5.8 + pancakes * 3.2) * cooks;
        double revenuePerWhole = revenuePerDay * days;
        double profit = revenuePerWhole - revenuePerWhole / 8;

        System.out.printf("%.2f", profit);

    }
}
