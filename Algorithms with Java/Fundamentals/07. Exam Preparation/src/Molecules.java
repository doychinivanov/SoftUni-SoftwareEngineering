import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Molecules {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int nodes = Integer.parseInt(reader.readLine());
        int edges = Integer.parseInt(reader.readLine());

        int[][] graph = new int[nodes + 1][nodes + 1];

        for (int i = 0; i < edges; i++) {
            int[] connections = Arrays
                    .stream(reader.readLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            graph[connections[0]][connections[1]] = 1;
        }

        int start = Integer.parseInt(reader.readLine());

        boolean[] visited = bfs(nodes, graph, start);

        printResult(visited);
    }

    private static void printResult(boolean[] visited) {
        StringBuilder result = new StringBuilder();

        for (int i = 1; i < visited.length; i++) {
            if (!visited[i]) result.append(i).append(" ");
        }

        System.out.println(result.toString().trim());
    }

    private static boolean[] bfs(int nodes, int[][] graph, int start) {
        Deque<Integer> queue = new ArrayDeque<>();

        queue.add(start);
        boolean[] visited = new boolean[nodes + 1];

        while (!queue.isEmpty()) {
            int curNode = queue.poll();
            visited[curNode] = true;

            for (int i = 0; i < graph[curNode].length; i++) {
                if (graph[curNode][i] != 0 && !visited[i]) {
                    queue.offer(i);
                }
            }
        }
        return visited;
    }
}
