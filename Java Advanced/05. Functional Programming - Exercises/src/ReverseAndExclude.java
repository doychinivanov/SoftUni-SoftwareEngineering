import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

public class ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Function<Scanner, int[]> readIntegers = scanner -> Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        BiFunction<int[], Integer, Integer[]> filterNumbersNotDivisibleByX = (arr, x) -> Arrays.stream(arr).filter(y -> y % x != 0).boxed().toArray(Integer[]::new);
        Consumer<List<Integer>> printNumbers = list -> list.forEach(x -> System.out.print(x + " "));

        int[] numbers = readIntegers.apply(scan);

        int toDivideBy = Integer.parseInt(scan.nextLine());

        List<Integer> nonDivisibleNumbers = Arrays.asList(filterNumbersNotDivisibleByX.apply(numbers, toDivideBy));
        Collections.reverse(nonDivisibleNumbers);

        printNumbers.accept(nonDivisibleNumbers);
    }
}
