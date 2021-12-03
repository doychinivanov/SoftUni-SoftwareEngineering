import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class NestedRecursion {
    public static int[] permutations;
    public static  int slots;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        slots = Integer.parseInt(reader.readLine());
        permutations = new int[slots];

        createPermutation(0);
    }

    private static void createPermutation(int index) {
        if (index == slots) {
            printArr();
            return;
        }

        for (int i = 1; i <= slots; i++) {
            permutations[index] = i;

            createPermutation(index + 1);
        }
    }

    private static void printArr() {
        String output = Arrays
                .stream(permutations)
                .mapToObj(Integer::toString)
                .collect(Collectors.joining(" "));

        System.out.println(output);
    }
}
