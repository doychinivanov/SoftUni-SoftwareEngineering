import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ListOfPredicates {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        int n = Integer.parseInt(scan.nextLine());
        HashSet<Integer> divideByThose = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toCollection(HashSet::new));

        Predicate<Integer> filterThoseThatAreDivisibleByAll = x -> {
            boolean isDivisible = true;

            for (Integer current : divideByThose) {
                if (x % current != 0) {
                    isDivisible = false;
                    break;
                }
            }

            return isDivisible;
        };

        IntStream.rangeClosed(1, n)
                .boxed()
                .filter(filterThoseThatAreDivisibleByAll)
                .forEach(x -> System.out.print(x + " "));
    }
}
