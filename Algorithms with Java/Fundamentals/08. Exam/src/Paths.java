import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Paths {
    private static Map<Integer, List<Integer>> graph = new LinkedHashMap<>();
    private static int destinationNode;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int nodes = Integer.parseInt(reader.readLine());

        readGraphFromConsole(reader, nodes);

        destinationNode = nodes - 1;

        for (int i = 0; i < graph.size(); i++) {
            List<Integer> visited = new ArrayList<>();
            dfs(i, visited);
        }

    }

    private static void dfs(int node, List<Integer> visited) {
        if (destinationNode == node) {
            visited.add(node);
            printResult(visited);
            return;
        }

        if (!visited.contains(node)) {
            visited.add(node);

            if (graph.get(node) != null) {
                for (Integer child: graph.get(node)) {
                    dfs(child, visited);
                    visited.remove(child);
                }
            }
        }
    }

    private static void printResult(List<Integer> visited) {
        StringBuilder result = new StringBuilder();

        for (Integer integer : visited) {
            result.append(integer).append(" ");
        }

        System.out.println(result.toString().trim());
    }

    private static void readGraphFromConsole(BufferedReader reader, int nodes) throws IOException {
        for (int i = 0; i < nodes - 1; i++) {
            List<Integer> childNodes = Arrays
                    .stream(reader.readLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .boxed()
                    .collect(Collectors.toList());

            graph.put(i, childNodes);
        }
    }
}
