import java.util.*;

public class ProductShop {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        TreeMap<String, LinkedHashMap<String, Double>> shopsRecord = new TreeMap<>();

        String input = scan.nextLine();

        while(!input.equals("Revision")){
            String[] productData = parseData(input, ", ");


            String shopName = productData[0];
            String product = productData[1];
            Double price = Double.parseDouble(productData[2]);

            shopsRecord.putIfAbsent(shopName, new LinkedHashMap<>());
            shopsRecord.get(shopName).put(product, price);

            input = scan.nextLine();
        }

        printFormattedResult(shopsRecord);
    }

    private static void printFormattedResult(TreeMap<String, LinkedHashMap<String, Double>> shopsRecord){
        shopsRecord
                .forEach((shop, products) -> {
                    System.out.printf("%s->" + System.lineSeparator(), shop);
                    System.out.println(formatProducts(products));
                });
    }

    private static String formatProducts(LinkedHashMap<String, Double> products){
        List<String> result = new ArrayList<>();

        products.forEach((product, price) -> {
            result.add(String.format("Product: %s, Price: %.1f", product, price));
        });

        return String.join(System.lineSeparator(), result);
    }

    public static String[] parseData(String input, String delimiter){
        return input.split(delimiter);
    }
}
