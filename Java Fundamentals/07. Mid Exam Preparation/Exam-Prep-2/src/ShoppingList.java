import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ShoppingList {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<String> shoppingCart = Arrays
                .stream(scan.nextLine().split("!"))
                .collect(Collectors.toList());

        String input = scan.nextLine();

        while(input.equals("Go Shopping!") == false){
            String[] inputData = input.split("\\s+");
            String command = inputData[0];
            String item = inputData[1];

            if(command.equals("Urgent")){
                if(!isPresent(shoppingCart, item)){
                    shoppingCart.add(0, item);
                }
            } else if(command.equals("Unnecessary")){
                if(isPresent(shoppingCart, item)){
                    shoppingCart.remove(item);
                }
            } else if(command.equals("Correct")){
                String newItem = inputData[2];

                if(isPresent(shoppingCart, item)){
                    int index = shoppingCart.indexOf(item);
                    shoppingCart.set(index, newItem);

                }
            } else if(command.equals("Rearrange")) {
                if(isPresent(shoppingCart, item)){
                    shoppingCart.remove(item);
                    shoppingCart.add(item);
                }
            }

            input = scan.nextLine();
        }

        System.out.println(String.join(", ", shoppingCart));
    }

    public static boolean isPresent(List<String> items, String product){
        return items.contains(product);
    }
}