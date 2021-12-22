import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ShortestPath {
    private static boolean[] visited;
    private static int[] previousNodes;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int nodesCount = Integer.parseInt(reader.readLine());

        List<List<Integer>> graph = new ArrayList<>();

        readGraphFromConsole(reader, nodesCount, graph);

        int source = Integer.parseInt(reader.readLine());
        int destination = Integer.parseInt(reader.readLine());

        visited = new boolean[nodesCount + 1];
        previousNodes = new int[nodesCount + 1];

        Arrays.fill(previousNodes, -1);

        bfs(graph, source, destination);

        List<Integer> path = new ArrayList<>();

        path.add(destination);

        int previousNode = previousNodes[destination];

        while (previousNode != -1) {
            path.add(previousNode);
            previousNode = previousNodes[previousNode];
        }

        printResult(path);

    }

    private static void bfs(List<List<Integer>> graph, int source, int destination) {
        Deque<Integer> queue = new ArrayDeque<>();

        queue.offer(source);
        visited[source] = true;

        while (!queue.isEmpty()) {
            int currentNode = queue.poll();

            if (currentNode == destination) return;

            for (int child :graph.get(currentNode)) {
                if (!visited[child]) {
                    visited[child] = true;
                    previousNodes[child] = currentNode;
                    queue.offer(child);
                }
            }
        }
    }

    private static void readGraphFromConsole(BufferedReader reader, int nodesCount, List<List<Integer>> graph) throws IOException {
        for (int i = 0; i < nodesCount + 1; i++) {
            graph.add(new ArrayList<>());
        }

        int edges = Integer.parseInt(reader.readLine());

        for (int i = 0; i < edges; i++) {
            int[] connectionBetweenNodes = Arrays.stream(reader
                    .readLine()
                    .split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int sourceNode = connectionBetweenNodes[0];
            int destinationNode = connectionBetweenNodes[1];

            graph.get(sourceNode).add(destinationNode);
        }
    }


    private static void printResult(List<Integer> path) {
        System.out.println("Shortest path length is: " + (path.size() - 1));

        for (int i = path.size() - 1; i >= 0; i--) {
            System.out.print(path.get(i) + " ");
        }
    }
}
