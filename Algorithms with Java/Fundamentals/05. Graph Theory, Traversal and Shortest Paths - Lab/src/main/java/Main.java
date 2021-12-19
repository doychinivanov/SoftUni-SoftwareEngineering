import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int notesAmount = Integer.parseInt(reader.readLine());

        List<List<Integer>> graph = new ArrayList<>();

        readGraphFromConsole(reader, notesAmount, graph);

        List<Deque<Integer>> connectedComponents = getConnectedComponents(graph);

        printResult(connectedComponents);
    }

    public static List<Deque<Integer>> getConnectedComponents(List<List<Integer>> graph) {
        boolean[] visited = new boolean[graph.size()];
        List<Deque<Integer>> components = new ArrayList<>();

        for (int start = 0; start < graph.size(); start++) {
            if(!visited[start]) {
                components.add(new ArrayDeque<>());
                dfs(start, components, graph, visited);
            }
        }

        return components;
    }

    private static void dfs(int node, List<Deque<Integer>> components, List<List<Integer>> graph, boolean[] visited) {
        if(!visited[node]) {
            visited[node] = true;

            for (int child: graph.get(node)) {
                dfs(child, components, graph, visited);
            }

            components.get(components.size() - 1).offer(node);
        }
    }

    public static Collection<String> topSort(Map<String, List<String>> graph) {
        throw new AssertionError("Not Implemented");
    }

    private static void printResult(List<Deque<Integer>> connectedComponents) {
        for (Deque<Integer> connectedComponent : connectedComponents) {
            StringBuilder result = new StringBuilder();

            result.append("Connected component: ");

            for (int n: connectedComponent) {
                result.append(n).append(" ");
            }

            System.out.println(result);
        }
    }

    private static void readGraphFromConsole(BufferedReader reader, int notesAmount, List<List<Integer>> graph) throws IOException {
        for (int i = 0; i < notesAmount; i++) {
            String nextLine = reader.readLine();

            if(nextLine.trim().equals("")) {
                graph.add(new ArrayList<>());
                continue;
            }

            List<Integer> nextNode = Arrays
                    .stream(nextLine.split("\\s+"))
                    .map(Integer::parseInt).collect(Collectors.toList());

            graph.add(nextNode);
        }
    }
}
