import java.util.*;

public class Dijkstra {

    public static List<Integer> dijkstraAlgorithm(int[][] graph, int sourceNode, int destinationNode) {

        boolean[] visited = new boolean[graph.length];
        int[] distances = new int[graph.length];
        int[] prev = new int[graph.length];

        Arrays.fill(prev, - 1);
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[sourceNode] = 0;

        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(node -> distances[node]));
        queue.offer(sourceNode);

        while (!queue.isEmpty()) {
            Integer parentNode = queue.poll();
            visited[parentNode] = true;
            int[] children = graph[parentNode];

            for (int curChild = 0; curChild < children.length; curChild++) {
                if (children[curChild] != 0 && !visited[curChild]) {
                    queue.offer(curChild);

                    int newDistance = distances[parentNode] + graph[parentNode][curChild];

                    if (newDistance < distances[curChild]) {
                        distances[curChild] = newDistance;
                        prev[curChild] = parentNode;
                    }
                }
            }
        }

        List<Integer> path = new ArrayList<>();
        path.add(destinationNode);

        int prevNode = prev[destinationNode];

        while (prevNode != -1) {
            path.add(prevNode);
            prevNode = prev[prevNode];
        }

        Collections.reverse(path);
        return path.size() == 1 ? null : path;

    }
}
