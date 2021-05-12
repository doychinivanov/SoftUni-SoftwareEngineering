import java.util.Scanner;

public class FruitShop {
    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);

        String item = scan.nextLine();
        String day = scan.nextLine();
        double amount = Double.parseDouble(scan.nextLine());
        double price = 0;
        boolean isError = false;

        if(day.equals("Monday") || day.equals("Tuesday") || day.equals("Wednesday") || day.equals("Thursday") || day.equals("Friday")){
            switch (item){
                case "banana":
                    price = amount * 2.5;
                    break;
                case "apple":
                    price = amount * 1.2;
                    break;
                case "kiwi":
                    price = amount * 2.7;
                    break;
                case "orange":
                    price = amount * 0.85;
                    break;
                case "grapefruit":
                    price = amount * 1.45;
                    break;
                case "pineapple":
                    price = amount * 5.50;
                    break;
                case "grapes" :
                    price = amount * 3.85;
                    break;
                default:
                    isError = true;
                    System.out.println("error");
                    break;
            }
        } else if (day.equals("Saturday") || day.equals("Sunday")){
            switch (item){
                case "banana":
                    price = amount * 2.7;
                    break;
                case "apple":
                    price = amount * 1.25;
                    break;
                case "kiwi":
                    price = amount * 3;
                    break;
                case "orange":
                    price = amount * 0.9;
                    break;
                case "grapefruit":
                    price = amount * 1.6;
                    break;
                case "pineapple":
                    price = amount * 5.6;
                    break;
                case "grapes" :
                    price = amount * 4.2;
                    break;
                default:
                    isError = true;
                    System.out.println("error");
                    break;
            }
        } else {
            isError = true;
            System.out.println("error");
        }

        if(isError == false){
            System.out.printf("%.2f", price);
        }

    }
}
