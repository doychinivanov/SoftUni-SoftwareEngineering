import java.util.Scanner;

public class BlackFlag {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double totalPlundered = 0;
        int days = Integer.parseInt(scan.nextLine());
        int dailyPlunder = Integer.parseInt(scan.nextLine());
        double goal = Double.parseDouble(scan.nextLine());

        for (int i = 1; i <= days; i++) {
            if(i % 3 == 0){
                totalPlundered += dailyPlunder * 1.5;
            } else {
                totalPlundered += dailyPlunder;
            }

            if(i % 5 == 0){
                totalPlundered *= 0.7;
            }
        }

        if(totalPlundered >= goal){
            System.out.printf("Ahoy! %.2f plunder gained.", totalPlundered);
        } else {
            System.out.printf("Collected only %.2f%% of the plunder.", (totalPlundered/goal)*100);
        }
    }
}