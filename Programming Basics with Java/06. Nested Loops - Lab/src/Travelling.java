import java.util.Scanner;

public class Travelling {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        while (input.equals("End") == false){
            String destination = input;
            double price = Double.parseDouble(scan.nextLine());

            while (price > 0){
                price -= Double.parseDouble(scan.nextLine());
            }

            if(price <= 0){
                System.out.printf("Going to %s!%n", destination);
            }

            input = scan.nextLine();
        }
    }
}