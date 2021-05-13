import java.util.Scanner;

public class NewHouse {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String type = scan.nextLine();
        int amount = Integer.parseInt(scan.nextLine());
        int budget = Integer.parseInt(scan.nextLine());
        double price = 0;

        if(type.equals("Roses")){
            price = amount * 5;

            if(amount > 80){
                price *= 0.9;
            }

        } else if(type.equals("Dahlias")){
            price = amount * 3.8;

            if(amount > 90){
                price *= 0.85;
            }

        } else if(type.equals("Tulips")){
            price = amount * 2.8;

            if(amount > 80){
                price *= 0.85;
            }

        } else if(type.equals("Narcissus")){
            price = amount * 3;

            if(amount < 120){
                price *= 1.15;
            }
        } else if(type.equals("Gladiolus")){
            price = amount * 2.5;

            if(amount < 80){
                price *= 1.2;
            }
        }

        if(budget >= price){
            System.out.printf("Hey, you have a great garden with %d %s and %.2f leva left.", amount, type, budget-price);
        } else {
            System.out.printf("Not enough money, you need %.2f leva more.", Math.abs(price-budget));
        }
    }
}
