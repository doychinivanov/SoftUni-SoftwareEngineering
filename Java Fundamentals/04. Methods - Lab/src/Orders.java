import java.util.Scanner;

public class Orders {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String product = scan.nextLine();
        int amount = Integer.parseInt(scan.nextLine());
        calculatePrice(product, amount);

    }

    public static void calculatePrice(String product, int amount){
        double price = 0;

        if(product.equals("coffee")){
            price = amount * 1.5;
        } else if(product.equals("water")){
            price = amount;
        } else if(product.equals("coke")){
            price = amount * 1.4;
        } else if (product.equals("snacks")){
            price = amount * 2;
        }

        System.out.printf("%.2f", price);
    }
}
