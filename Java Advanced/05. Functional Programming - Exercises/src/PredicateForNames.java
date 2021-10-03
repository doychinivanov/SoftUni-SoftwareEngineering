import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateForNames {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int maxLength = Integer.parseInt(scan.nextLine());

        Consumer<String> printNames = System.out::println;
        Predicate<String> getNamesBiggerThan = name -> name.length() <= maxLength;
        List<String> names = Arrays.stream(scan.nextLine().split("\\s+")).collect(Collectors.toList());

        names.stream()
                .filter(getNamesBiggerThan)
                .forEach(printNames);
    }
}
