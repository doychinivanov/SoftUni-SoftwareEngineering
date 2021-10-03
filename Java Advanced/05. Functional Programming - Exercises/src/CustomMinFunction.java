import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class CustomMinFunction {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Function<int[], Integer> getTheSmallest = arr -> Arrays.stream(arr).min().orElse(0);

        int[] numbers = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        System.out.println(getTheSmallest.apply(numbers));
    }
}
