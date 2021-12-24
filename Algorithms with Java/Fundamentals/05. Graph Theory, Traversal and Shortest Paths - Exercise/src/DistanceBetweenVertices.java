import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DistanceBetweenVertices {
    private static int[][] graph;
    private static Map<Integer, Integer> indexMapper = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int nodes = Integer.parseInt(reader.readLine());
        int pairs = Integer.parseInt(reader.readLine());

        graph = new int[nodes + 1][];

        readGraphFromConsole(reader, nodes);

        while (pairs-- > 0) {
            StringBuilder currentResult = new StringBuilder();

            int[] relations = Arrays
                    .stream(reader.readLine().split("-"))
                    .mapToInt(Integer::parseInt).toArray();

            int source = relations[0];
            int destination = relations[1];
            
            int[] prev = new int[graph.length];
            Arrays.fill(prev, -1);

            bfs(graph, indexMapper.get(source), indexMapper.get(destination), prev);

            List<Integer> path = new ArrayList<>();

            int parent = prev[indexMapper.get(destination)];

            while (parent != -1) {
                path.add(parent);
                parent = prev[parent];
            }

            int size = path.isEmpty() ? -1 : path.size();

            currentResult.append(String.format("{%d, %d} -> ", source, destination));
            currentResult.append(size);

            System.out.println(currentResult);
        }
    }

    private static void readGraphFromConsole(BufferedReader reader, int nodes) throws IOException {
        for (int i = 1; i <= nodes; i++) {
            String[] edges = reader.readLine().split(":");

            indexMapper.put(Integer.parseInt(edges[0]), i);

            if (edges.length == 1) {
                graph[i] = new int[0];
            } else {
                graph[i] = Arrays.stream(edges[1]
                        .split("\\s+"))
                        .mapToInt(Integer::parseInt)
                        .toArray();
            }
        }
    }

    private static void bfs(int[][] graph, int source, int destination, int[] prev) {
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(source);

        boolean[] visited = new boolean[graph.length + 1];
        visited[source] = true;

        while (!queue.isEmpty()) {
            Integer node = queue.poll();

            if (node == destination) return;

            for (int i = 0; i < graph[node].length; i++) {
                int child = indexMapper.get(graph[node][i]);
                if (!visited[child]) {
                    prev[child] = node;
                    visited[child] = true;
                    queue.offer(child);
                }
            }
        }

        prev[source] = -1;
    }
}
