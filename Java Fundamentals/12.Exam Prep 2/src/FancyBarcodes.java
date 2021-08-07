import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FancyBarcodes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        String regex = "(@#+)(?<barcode>[A-Z][A-Za-z\\d]{4,}[A-Z])(@#+)";
        Pattern pattern = Pattern.compile(regex);


        for (int i = 0; i < n; i++) {
            String input = scan.nextLine();

            Matcher match = pattern.matcher(input);

            if(match.find()){
                String product = match.group("barcode");
                String productGroup = findProductGroup(product);

                System.out.printf("Product group: %s\n", productGroup);
            } else {
                System.out.println("Invalid barcode");
            }
        }
    }

    public static String findProductGroup(String product){
        StringBuilder result = new StringBuilder();

        String regex = "\\d";
        Pattern pattern = Pattern.compile(regex);
        Matcher match = pattern.matcher(product);

        while(match.find()){
            result.append(match.group());
        }

        if (result.length() == 0){
            result.append("00");
        }
        return result.toString();
    }
}
