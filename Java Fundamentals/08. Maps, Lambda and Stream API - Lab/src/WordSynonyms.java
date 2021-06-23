import java.util.*;

public class WordSynonyms {
    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);

        int wordPairs = Integer.parseInt(scan.nextLine());
        Map<String, List<String>> dictionary = new LinkedHashMap<>();

        for (int i = 0; i < wordPairs; i++) {
            String word = scan.nextLine();
            String synonym = scan.nextLine();

            dictionary.putIfAbsent(word, new ArrayList<>());
            dictionary.get(word).add(synonym);
        }

        for (Map.Entry<String, List<String>> word : dictionary.entrySet()){
            System.out.printf("%s - %s\n", word.getKey(), String.join(", ", word.getValue()));
        }
    }
}
