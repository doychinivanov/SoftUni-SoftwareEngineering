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
//                bfs(start, components, graph, visited);
            }
        }

        return components;
    }

    private static void bfs(int start, List<Deque<Integer>> components, List<List<Integer>> graph, boolean[] visited) {
        Deque<Integer> queue = new ArrayDeque<>();
        visited[start] = true;
        queue.offer(start);

        while (!queue.isEmpty()) {
            int node = queue.poll();

            components.get(components.size() - 1).offer(node);

            for (int child : graph.get(node)) {
                if (!visited[child]) {
                    visited[child] = true;
                    queue.offer(child);
                }
            }
        }
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

    private static void dfs(String key, Set<String> visited, Map<String, List<String>> graph, List<String> sorted, Set<String> detectCycles) {
        if (detectCycles.contains(key)) throw new IllegalArgumentException();

        if (!visited.contains(key)) {
            visited.add(key);
            detectCycles.add(key);

            for (String child : graph.get(key)) {
                dfs(child, visited, graph, sorted, detectCycles);
            }

            detectCycles.remove(key);
            sorted.add(key);
        }
    }

    public static Collection<String> topSort(Map<String, List<String>> graph) {
        List<String> sortedByTopologicalDependencies = new ArrayList<>();

        Set<String> visited = new HashSet<>();
        Set<String> detectCycles = new HashSet<>();

        for (Map.Entry<String, List<String>> node : graph.entrySet()) {
            dfs(node.getKey(), visited, graph, sortedByTopologicalDependencies, detectCycles);
        }

        Collections.reverse(sortedByTopologicalDependencies);

        return sortedByTopologicalDependencies;
    }

    public static Collection<String> topSort2(Map<String, List<String>> graph) {
        Map<String, Integer> dependenciesCount = getDependenciesCount(graph);

        List<String> sortedByTopologicalDependencies = new ArrayList<>();

        while (!graph.isEmpty()){
            String currentNodeWithoutDependencies = graph
                    .keySet()
                    .stream()
                    .filter(k -> dependenciesCount.get(k) == 0)
                    .findFirst()
                    .orElse(null);

            if (currentNodeWithoutDependencies == null) break;

            graph.get(currentNodeWithoutDependencies)
                    .forEach(child -> dependenciesCount.put(child, dependenciesCount.get(child) - 1));

            sortedByTopologicalDependencies.add(currentNodeWithoutDependencies);
            graph.remove(currentNodeWithoutDependencies);
        }

        if (!graph.isEmpty()) throw new IllegalArgumentException();

        return sortedByTopologicalDependencies;

    }

    private static Map<String, Integer> getDependenciesCount(Map<String, List<String>> graph) {
        Map<String, Integer> dependenciesCount = new LinkedHashMap<>();

        for (Map.Entry<String, List<String>> node : graph.entrySet()) {
            dependenciesCount.putIfAbsent(node.getKey(), 0);

            for (String child: node.getValue()) {
                dependenciesCount.putIfAbsent(child, 0);
                dependenciesCount.put(child, dependenciesCount.get(child) + 1);
            }
        }

        return dependenciesCount;
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
