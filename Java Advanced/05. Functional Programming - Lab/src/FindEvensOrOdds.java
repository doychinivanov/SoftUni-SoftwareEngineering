import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class FindEvensOrOdds {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] range = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int lower = range[0];
        int higher = range[1];

        String condition = scan.nextLine();

        Predicate<Integer> filterByCondition = getFilter(condition);
        Consumer<Integer> print = x -> System.out.print(x + " ");

        IntStream.rangeClosed(lower, higher)
                .boxed()
                .filter(filterByCondition)
                .forEach(print);
    }

    private static Predicate<Integer> getFilter(String condition){
        if(condition.equals("even")){
            return x -> x % 2 == 0;
        }

        return x -> x % 2 != 0;
    }
}
