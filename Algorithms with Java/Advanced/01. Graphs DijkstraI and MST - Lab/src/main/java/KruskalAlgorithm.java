import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class KruskalAlgorithm {

    public static List<Edge> kruskal(int numberOfVertices, List<Edge> edges) {
        Collections.sort(edges);

        List<Edge> forest = new ArrayList<>();

        int[] parents = new int[numberOfVertices];

        IntStream
                .range(0, parents.length)
                .forEach(i -> parents[i] = i);

        while (!edges.isEmpty()) {
            Edge edge = edges.remove(0);

            int source = edge.getStartNode();
            int destination = edge.getEndNode();

            int firstRoot = findRoot(source, parents);
            int secondRoot = findRoot(destination, parents);

            if (firstRoot != secondRoot) {
                forest.add(edge);
                parents[firstRoot] = secondRoot;
            }
        }


        return forest;
    }

    public static int findRoot(int node, int[] parents) {

        while (parents[node] != node) {
            node = parents[node];
        }

        return node;
    }
}
