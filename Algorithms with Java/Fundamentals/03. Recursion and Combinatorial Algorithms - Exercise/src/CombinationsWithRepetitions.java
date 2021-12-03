import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class CombinationsWithRepetitions {
    private static int elementsCount;
    private static int slots;
    private static int[] combinations;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        elementsCount = Integer.parseInt(reader.readLine());
        slots = Integer.parseInt(reader.readLine());
        combinations = new int[slots];

        createCombinations(0, 1);
    }

    private static void createCombinations(int index, int start) {
        if(index == slots) {
            printArr();
            return;
        }

        for (int i = start; i <= elementsCount ; i++) {
            combinations[index] = i;

            createCombinations(index + 1, i);
        }
    }

    private static void printArr() {
        String output = Arrays
                .stream(combinations)
                .mapToObj(Integer::toString)
                .collect(Collectors.joining(" "));

        System.out.println(output);
    }
}
