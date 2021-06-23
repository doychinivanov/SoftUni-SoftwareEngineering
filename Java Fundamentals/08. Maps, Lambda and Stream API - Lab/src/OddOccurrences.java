import java.util.*;
import java.util.stream.Collectors;

public class OddOccurrences {
    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);

        String[] words = scan.nextLine().split("\\s+");
        Map<String, Integer> dictionary = new LinkedHashMap<>();

        for (String word: words) {
            word = word.toLowerCase(Locale.ROOT);
            dictionary.putIfAbsent(word, 0);
            dictionary.put(word, dictionary.get(word) + 1);
        }

        List<String> oddOccurredWord = dictionary
                .keySet()
                .stream()
                .filter(x -> dictionary.get(x) % 2 != 0)
                .collect(Collectors.toList());


        System.out.println(String.join(", ", oddOccurredWord));
    }
}