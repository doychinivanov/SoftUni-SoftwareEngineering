import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class BellmanFord {
    private static int[][] graph;
    private static int[] distance;
    private static int[] prev;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int nodesCount = Integer.parseInt(reader.readLine());
        int edgesCount = Integer.parseInt(reader.readLine());

        graph = new int[nodesCount + 1][nodesCount + 1];

        readGraph(reader, edgesCount);

        int source = Integer.parseInt(reader.readLine());
        int destination = Integer.parseInt(reader.readLine());

        try {
            bellmanFord(source);
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
            return;
        }

        List<Integer> path = retrievePath(destination);

        System.out.println(path.stream().map(String::valueOf).collect(Collectors.joining(" ")));
        System.out.println(distance[destination]);
    }

    private static List<Integer> retrievePath(int destination) {
        List<Integer> path = new ArrayList<>();

        path.add(destination);

        int node = prev[destination];

        while (node != -1) {
            path.add(node);
            node = prev[node];
        }

        Collections.reverse(path);

        return path;
    }

    private static void bellmanFord(int source) {
        distance = new int[graph.length];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[source] = 0;

        prev = new int[graph.length];
        Arrays.fill(prev, -1);

        for (int i = 1; i < graph.length - 1; i++) {

            for (int curNode = 1; curNode < graph.length; curNode++) {
                for (int destinationForCurNode = 1; destinationForCurNode < graph[curNode].length; destinationForCurNode++) {
                    int weight = graph[curNode][destinationForCurNode];

                    if (weight != 0) {

                        if (distance[curNode] != Integer.MAX_VALUE) {
                            int newValue = distance[curNode] + weight;

                            if (newValue < distance[destinationForCurNode]) {
                                distance[destinationForCurNode] = newValue;
                                prev[destinationForCurNode] = curNode;
                            }
                        }
                    }
                }
            }

        }

//        Check for cycles
        for (int r = 1; r < graph.length; r++) {
            for (int c = 1; c < graph[r].length; c++) {
                int weight = graph[r][c];

                if (weight != 0) {

                    if (distance[r] != Integer.MAX_VALUE) {
                        int newValue = distance[r] + weight;

                        if (newValue < distance[c]) {
                            throw new IllegalStateException("Negative Cycle Detected");
                        }
                    }
                }
            }
        }

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
