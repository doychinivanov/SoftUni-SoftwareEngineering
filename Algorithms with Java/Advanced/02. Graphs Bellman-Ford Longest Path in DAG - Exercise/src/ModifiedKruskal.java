import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class ModifiedKruskal {
    public static Map<Integer, List<Edge>> graph = new LinkedHashMap<>();

    public static class Edge implements Comparable<Edge> {
        public int from;
        public int to;
        public int weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }


        @Override
        public int compareTo(Edge other) {
            return Integer.compare(this.weight, other.weight);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int forestWeight = 0;
        int nodes = Integer.parseInt(reader.readLine().split("\\s+")[1]);
        int edgeCount = Integer.parseInt(reader.readLine().split("\\s+")[1]);

        readGraph(reader, edgeCount);

        int[] parents = new int[nodes];
        for (int i = 0; i < nodes; i++) {
            parents[i] = i;
        }

        PriorityQueue<Edge> edges = graph
                .values()
                .stream()
                .flatMap(List::stream)
                .collect(Collectors.toCollection(PriorityQueue::new));


        StringBuilder builder = new StringBuilder();

        while (!edges.isEmpty()) {
            Edge minEdge = edges.poll();

            int firstRoot = findRoot(minEdge.from, parents);
            int secondRoot = findRoot(minEdge.to, parents);

            if (firstRoot != secondRoot) {
                builder.append(String.format("(%d %d) -> %d%n", minEdge.from, minEdge.to, minEdge.weight));
                forestWeight += minEdge.weight;
                parents[secondRoot] = firstRoot;

                for (int i = 0; i < parents.length; i++) {
                    if (parents[i] == secondRoot) {
                        parents[i] = firstRoot;
                    }
                }
            }
        }

        System.out.println("Minimum spanning forest weight: " + forestWeight);
//        System.out.println(builder.toString().trim());
    }

    private static void readGraph(BufferedReader reader, int edgeCount) throws IOException {
        for (int i = 0; i < edgeCount; i++) {
            String[] tokens = reader.readLine().split("\\s+");

            int from = Integer.parseInt(tokens[0]);
            int to = Integer.parseInt(tokens[1]);
            int weight = Integer.parseInt(tokens[2]);

            Edge edge = new Edge(from, to, weight);

            graph.putIfAbsent(from, new ArrayList<>());
            graph.get(from).add(edge);
        }
    }

    private static int findRoot(int node, int[] parents) {
        int root = parents[node];

        while (parents[node] != root) {
            root = parents[root];
        }

        return root;
    }
}
