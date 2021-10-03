import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CustomComparator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Function<Scanner, Integer[]> readIntegers = scanner -> Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).boxed().toArray(Integer[]::new);

        Consumer<Integer[]> printIntegers = arr -> System.out.println(Arrays.stream(arr).mapToInt(x->x).mapToObj(String::valueOf).collect(Collectors.joining(" ")));

        Comparator<Integer> sortEvenAndOdd = (a, b) -> {
            boolean firstIsEven = a % 2 == 0;
            boolean secondIsEven = b % 2 == 0;

            if (firstIsEven && !secondIsEven){
                return -1;
            } else if (!firstIsEven && secondIsEven){
                return 1;
            }else {
                return a - b;
            }
        };

        Integer[] numbersInNoOrder = readIntegers.apply(scan);

        Integer[] sortedNumbers = Arrays.stream(numbersInNoOrder).sorted(sortEvenAndOdd).toArray(Integer[]::new);

        printIntegers.accept(sortedNumbers);
    }
}
