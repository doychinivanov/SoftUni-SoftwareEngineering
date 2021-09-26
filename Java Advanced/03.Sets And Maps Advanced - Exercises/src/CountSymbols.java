import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        TreeMap<Character, Integer> lettersCount = new TreeMap<>();

        String input = scan.nextLine();

        for (int i = 0; i < input.length(); i++) {
            char currentSymbol = input.charAt(i);

            lettersCount.putIfAbsent(currentSymbol, 0);
            lettersCount.put(currentSymbol, lettersCount.get(currentSymbol) + 1);
        }

        lettersCount.forEach((key, value) -> System.out.printf("%s: %d time/s" + System.lineSeparator(), key, value));
    }
}
