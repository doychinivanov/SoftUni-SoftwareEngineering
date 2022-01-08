import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

public class MonkeyBusiness {
    private static int n;
    private static int[] combination;
    private static final StringBuilder results = new StringBuilder();
    private static int totalSolutions = 0;
    private static int[] numbers;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(reader.readLine());
        combination = new int[n];
        numbers = new int[n];

        IntStream.range(0, n).forEach(x -> numbers[x] = x + 1);

        combinationNoRep(0);

        printResult();
    }

    private static void combinationNoRep(int index) {
        if (index >= n) {
            countSolution();
            return;
        }

        combination[index] = numbers[index];
        combinationNoRep(index + 1);
        combination[index] = -numbers[index];
        combinationNoRep(index + 1);
    }

    private static void countSolution() {
        int sum = Arrays.stream(combination).sum();

        if (sum == 0) {
            totalSolutions++;
            StringBuilder currentResult = new StringBuilder();

            for (int j : combination) {
                currentResult.append(j > 0 ? "+" + j : j);

                if (Math.abs(j) != n) {
                    currentResult.append(" ");
                }

            }
            currentResult.append(System.lineSeparator());
            results.append(currentResult.toString());
        }
    }

    private static void printResult() {
        System.out.println(results.toString().trim());

        System.out.println("Total Solutions: " + totalSolutions);
    }
}
