import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SortEvenNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Predicate<Integer> getEvenInts = x -> x % 2 == 0 ;

        Function<IntStream, String> parseStreamToString = strm -> strm
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(", "));

        int[] numbers = Arrays.stream(scan.nextLine().split(", "))
                .map(Integer::parseInt)
                .filter(getEvenInts)
                .mapToInt(x-> x)
                .toArray();

        String evenValues = parseStreamToString.apply(Arrays.stream(numbers));

        String sortedEvenNumbers = parseStreamToString.apply(Arrays.stream(numbers).sorted());

        System.out.println(evenValues);
        System.out.println(sortedEvenNumbers);
    }
}
