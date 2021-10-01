import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Stream;

public class SumNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Function<String[], Stream<Integer>> mapToStreamInt = arr -> Arrays.stream(arr).map(Integer::parseInt);

        Function<Stream<Integer>, Integer> findSum = strm -> strm.mapToInt(x -> x).sum();

        Function<Stream<Integer>, Long> findNumbersCount = Stream::count;

        String[] tokens = scan.nextLine().split(", ");

        long count = findNumbersCount.apply(mapToStreamInt.apply(tokens));
        int sum = findSum.apply(mapToStreamInt.apply(tokens));

        System.out.printf("Count = %d" + System.lineSeparator(), count);
        System.out.printf("Sum = %d" + System.lineSeparator(), sum);


    }
}
