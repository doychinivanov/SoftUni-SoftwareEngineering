import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SofUniBar {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double income = 0.0;
        String regex = "%(?<name>[A-Z][a-z]+)%([^\\|\\$%\\.]+)?<(?<product>\\w+)>([^\\|\\$%\\.]+)?\\|(?<quantity>[0-9]+)\\|([^\\|\\$%\\.\\d]+)?(?<price>\\d+[\\.]?[0-9]+?)\\$";
        Pattern regexPattern = Pattern.compile(regex);

        String input = scan.nextLine();

        while(input.equals("end of shift") == false){
            Matcher match = regexPattern.matcher(input);

            if (match.find()){
                double currentIncome = Integer.parseInt(match.group("quantity")) * Double.parseDouble(match.group("price"));
                income += currentIncome;
                System.out.printf("%s: %s - %.2f\n", match.group("name"), match.group("product"), currentIncome);
            }

            input = scan.nextLine();
        }

        System.out.printf("Total income: %.2f", income);
    }
}
