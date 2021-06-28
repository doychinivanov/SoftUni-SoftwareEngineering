import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Scanner;

public class Orders {
    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);

        Map<String, Map<String, Double>> orders = new LinkedHashMap<>();
        String input = scan.nextLine();

        while(!input.equals("buy")){
            String product = input.split("\\s+")[0];
            double price = Double.parseDouble(input.split("\\s+")[1]);
            double quantity = Double.parseDouble(input.split("\\s+")[2]);

            Map<String, Double> productInfo = new LinkedHashMap<>();
            productInfo.put("price", 0.00);
            productInfo.put("quantity", 0.00);

            orders.putIfAbsent(product, productInfo);
            orders.get(product).put("price", price);
            orders.get(product).put("quantity", orders.get(product).get("quantity") + quantity);

            input = scan.nextLine();
        }

        orders.forEach((k,v) -> System.out.printf("%s -> %.2f\n", k, v.get("price") * v.get("quantity")));
    }
}