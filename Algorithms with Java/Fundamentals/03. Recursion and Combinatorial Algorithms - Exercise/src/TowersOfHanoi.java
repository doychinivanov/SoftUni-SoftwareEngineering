import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.stream.Collectors;

public class TowersOfHanoi {
    private static StringBuilder output = new StringBuilder();
    private static Deque<Integer> source = new ArrayDeque<>();
    private static Deque<Integer> spare = new ArrayDeque<>();
    private static Deque<Integer> destination = new ArrayDeque<>();

    private static int steps = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int disk = Integer.parseInt(reader.readLine());

        for (int i = disk; i >= 1 ; i--) {
            source.push(i);
        }

        output.append(printRods()).append(System.lineSeparator());
        solvePuzzle(disk, source, destination, spare);
        System.out.println(output.toString().trim());
    }

    private static void solvePuzzle(int disk, Deque<Integer> source, Deque<Integer> destination, Deque<Integer> spare) {
        if (disk == 1) {
            destination.push(source.pop());
            output.append(String.format("Step #%d: Moved disk" + System.lineSeparator(), steps++));
            output.append(printRods()).append(System.lineSeparator());
            return;
        }

        solvePuzzle(disk - 1, source, spare, destination);
        solvePuzzle(1, source, destination, spare);
        solvePuzzle(disk - 1, spare, destination, source);

    }

    public static String printRods(){
        return String.format("Source: %s%n" +
                "Destination: %s%n" +
                "Spare: %s%n", formatRod(source), formatRod(destination), formatRod(spare));
    }

    private static String formatRod(Deque<Integer> stack) {
        return stack
                .stream()
                .sorted(Comparator.reverseOrder())
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
    }
}
