import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DFS {
    private static final Map<String, List<String>> graph = new LinkedHashMap<>();
    private static final List<String> visited = new ArrayList<>();
    private static final Deque<String> exploredNodes = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int notesAmount = Integer.parseInt(reader.readLine());

        readGraphFromConsole(reader, notesAmount);

        for (String node: graph.keySet()) {
            bfs(node);
        }

        printResult();
    }

    private static void dfs(String node) {
        if(!visited.contains(node)) {
            visited.add(node);

            exploredNodes.offer(node);

            if (graph.get(node) != null) {
                for (String child: graph.get(node)) {
                    dfs(child);
                }
            }
        }
    }

    private static void bfs(String node) {
        if(!visited.contains(node)) {
            Deque<String> queue = new ArrayDeque<>();

            queue.offer(node);
            visited.add(node);
            exploredNodes.offer(node);

            while (!queue.isEmpty()) {
                String currentNode = queue.poll();

                if (graph.get(currentNode) != null) {

                    for (String child: graph.get(currentNode)) {
                        if (!visited.contains(child)) {
                            visited.add(child);
                            exploredNodes.offer(child);
                            queue.offer(child);
                        }
                    }
                }

            }
        }
    }

    private static void readGraphFromConsole(BufferedReader reader, int notesAmount) throws IOException {
        for (int i = 1; i <= notesAmount; i++) {
            String nextLine = reader.readLine();


          String[] data = nextLine.split(" -> ");
          String node = data[0];
          String[] childNodes;

          if (data.length > 1) {
            childNodes = data[1].split(", ");
          } else {
              childNodes = new String[0];
          }

          List<String> children = childNodes.length > 0 ? Arrays.stream(childNodes).toList() : new ArrayList<>();

          graph.put(node, children);
        }
    }

    private static void printResult() {
        System.out.println(String.join(" ", exploredNodes));
    }
}
