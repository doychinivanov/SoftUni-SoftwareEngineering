import java.util.Arrays;
import java.util.Scanner;
import java.util.function.DoubleConsumer;
import java.util.function.DoubleUnaryOperator;

public class AddVAT {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        DoubleUnaryOperator addVatToPrice = x -> x * 1.2;
        DoubleConsumer parsePrice = x -> System.out.printf("%.2f" + System.lineSeparator(), x);

        System.out.println("Prices with VAT:");

        Arrays.stream(scan.nextLine().split(", "))
                .mapToDouble(Double::parseDouble)
                .map(addVatToPrice)
                .forEach(parsePrice);
    }
}
