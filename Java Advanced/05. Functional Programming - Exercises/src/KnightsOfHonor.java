import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class KnightsOfHonor {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Consumer<String> printName = name -> System.out.println("Sir " + name);

        List<String> names = Arrays.stream(scan.nextLine().split("\\s+")).collect(Collectors.toList());

        names.forEach(printName);
    }
}
