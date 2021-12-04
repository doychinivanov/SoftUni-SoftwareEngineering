import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class WordCruncher {
    private static List<String> words;
    private static List<String> permutation = new ArrayList<>();
    private static String target;

    private static Map<Integer, List<String>> table = new HashMap<>();
    private static Map<String, Integer> occurrences = new HashMap<>();
    private static Set<String> out = new TreeSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        words = Arrays.stream(reader.readLine().split(", ")).collect(Collectors.toList());
        target = reader.readLine();

        words = words
                .stream()
                .filter(chunk -> target.contains(chunk))
                .collect(Collectors.toList());

        for (String subst : words) {
            occurrences.putIfAbsent(subst, 0);
            occurrences.put(subst, occurrences.get(subst) + 1);
            int index = target.indexOf(subst);

            while (index != -1) {
                table.putIfAbsent(index, new ArrayList<>());
                table.get(index).add(subst);
                index = target.indexOf(subst, index + 1);
            }
        }

        permute(0);

        printResult();
    }

    private static void printResult() {
        StringBuilder result = new StringBuilder();

        for (String str: out) {
            result.append(str).append(System.lineSeparator());
        }

        System.out.print(result);
    }

    private static void permute(int index) {
        if (index == target.length()) {
            createNewSolution();
            return;
        }

        if (table.containsKey(index)) {
            List<String> strings = table.get(index);
            for (String str : strings) {
                if (occurrences.get(str) > 0) {
                    occurrences.put(str, occurrences.get(str) - 1);
                    permutation.add(str);
                    permute(index + str.length());
                    permutation.remove(permutation.size() - 1);
                    occurrences.put(str, occurrences.get(str) + 1);
                }

            }
        }
    }

    private static void createNewSolution() {
        String actual = String.join("", permutation);

        if (actual.contains(target)) {
            out.add(String.join(" ", permutation));
        }
    }
}
