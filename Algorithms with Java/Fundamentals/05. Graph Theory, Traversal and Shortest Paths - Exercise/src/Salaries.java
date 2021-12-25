import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Salaries {
    private static final char MANAGER_SYMBOL = 'Y';
    private static List<List<Integer>> graph = new ArrayList<>();

    private static long[] salaries;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int employeesCount = Integer.parseInt(reader.readLine());

        salaries = new long[employeesCount];
        visited = new boolean[employeesCount];

        int[] managersCount = new int[employeesCount];

        for (int i = 0; i < employeesCount; i++) {
            graph.add(new ArrayList<>());
            String line = reader.readLine();

            for (int emp = 0; emp < line.length(); emp++) {
                char letter = line.charAt(emp);

                if (letter == MANAGER_SYMBOL) {
                    managersCount[emp]++;
                    graph.get(i).add(emp);
                }
            }
        }

        List<Integer> sources = new ArrayList<>();

        for (int i = 0; i < managersCount.length; i++) {
            if (managersCount[i] == 0) sources.add(i);
        }

        for (Integer currentSource : sources) {
            dsf(currentSource);
        }

        long sumOfAllSalaries = Arrays.stream(salaries).sum();

        System.out.println(sumOfAllSalaries);
    }

    private static void dsf(int currentNode) {
        if (visited[currentNode]) return;

        visited[currentNode] = true;

        for (Integer child : graph.get(currentNode)) {
            if (!visited[child]) {
                dsf(child);

                long sum = graph.get(child)
                        .stream()
                        .mapToLong(c -> salaries[c])
                        .sum();

                salaries[child] = sum == 0 ? 1 : sum;
            }
        }

        long sum = graph.get(currentNode)
                .stream()
                .mapToLong(c -> salaries[c])
                .sum();

        salaries[currentNode] = sum == 0 ? 1 : sum;
    }
}
