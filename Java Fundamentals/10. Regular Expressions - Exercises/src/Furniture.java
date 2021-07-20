import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Furniture {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        double totalMoney = 0.0;
        List<String> items = new ArrayList<>();

        String pattern = ">>(?<item>\\w+)<<(?<price>\\d+\\.?\\d+)!(?<quantity>\\d+)";
        Pattern regex = Pattern.compile(pattern);

        while(input.equals("Purchase") == false){
            Matcher match = regex.matcher(input);

            if(match.find()){
                items.add(match.group("item"));
                totalMoney += Double.parseDouble(match.group("price")) * Integer.parseInt(match.group("quantity"));
            }

            input = scan.nextLine();
        }

        System.out.println("Bought furniture:");

        if(items.size() > 0){
            System.out.println(String.join("\n", items));
        }

        System.out.printf("Total money spend: %.2f", totalMoney);
    }
}
