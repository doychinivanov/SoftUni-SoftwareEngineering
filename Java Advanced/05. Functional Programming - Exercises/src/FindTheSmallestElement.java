import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindTheSmallestElement {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Function<List<Integer>, Integer> findTheSmallestElementIndex = list -> list.lastIndexOf(list.stream().mapToInt(x->x).min().orElse(0));

        List<Integer> numbers = Arrays.stream(scan.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        System.out.println(findTheSmallestElementIndex.apply(numbers));
    }
}
