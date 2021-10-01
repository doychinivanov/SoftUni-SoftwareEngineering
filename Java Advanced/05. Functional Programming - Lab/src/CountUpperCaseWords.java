import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CountUpperCaseWords {
    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);

        Predicate<String> isItUpperCase = word -> Character.isUpperCase(word.charAt(0));
        Consumer<List<String>> printList = list -> list.forEach(System.out::println);

        List<String> upperCaseWords = Arrays
                .stream(scan.nextLine().split("\\s+"))
                .filter(isItUpperCase)
                .collect(Collectors.toList());

        System.out.println(upperCaseWords.size());
        printList.accept(upperCaseWords);

    }
}
