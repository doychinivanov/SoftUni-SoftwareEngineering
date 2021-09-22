import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);

        LinkedHashMap<Double, Integer> realNumbersCount = new LinkedHashMap<>();
        double[] numbers = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble)
                .toArray();

        for (double n: numbers) {
            realNumbersCount.putIfAbsent(n, 0);
            realNumbersCount.put(n, realNumbersCount.get(n) + 1);
        }

        realNumbersCount.forEach((key, value) -> System.out.printf("%.1f -> %d" + System.lineSeparator(), key, value));

    }
}
