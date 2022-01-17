import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class LongestPath {
    private static int[][] graph;
    private static boolean[] visited;
    private static int[] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int nodesCount = Integer.parseInt(reader.readLine());
        int edgesCount = Integer.parseInt(reader.readLine());

        graph = new int[nodesCount + 1][nodesCount + 1];

        readGraph(reader, edgesCount);

        int source = Integer.parseInt(reader.readLine());
        int destination = Integer.parseInt(reader.readLine());

//        longest path
        distance = new int[graph.length];
        Arrays.fill(distance, Integer.MIN_VALUE);
        distance[source] = 0;

        visited = new boolean[graph.length];

//        get topological sort
        Deque<Integer> sorted = new ArrayDeque<>();
        for (int i = 1; i < graph.length; i++) {
            topologicalSort(i, sorted);
        }

        while (!sorted.isEmpty()) {
            int node = sorted.pop();

            for (int i = 1; i < graph[node].length; i++) {
                int weight = graph[node][i];

                if (weight != 0) {
                   if (distance[node] + weight > distance[i]) {
                       distance[i] = distance[node] + weight;
                   }
                }
            }
        }

        System.out.println(distance[destination]);
    }

    private static void topologicalSort(int node, Deque<Integer> sorted) {
        if (visited[node]) return;

        visited[node] = true;

        for (int i = 1; i < graph[node].length; i++) {
            if (graph[node][i] != 0) {
                topologicalSort(i, sorted);
            }
        }

        sorted.push(node);
    }

    private static void readGraph(BufferedReader reader, int edgesCount) throws IOException {
        for (int i = 0; i < edgesCount; i++) {
            int[] tokens = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

            int source = tokens[0];
            int destination = tokens[1];
            int weight = tokens[2];

            graph[source][destination] = weight;
        }
    }
}
