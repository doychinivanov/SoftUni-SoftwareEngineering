import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class AreasInMatrix {

    public static class Edge {
        int[] source;
        int[] destination;

        Edge(int sourceRow, int sourceColumn) {
            this.source = new int[] {sourceRow, sourceColumn};
        }

        public void setDestination(int destinationRow, int destinationColumn) {
            this.destination = new int[] {destinationRow, destinationColumn};
        }
    }

    private static List<Edge> graph = new ArrayList<>();
    private static char[][] matrix;
    private static boolean[][] visited;
    private static boolean[] visitedNode;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int rows = Integer.parseInt(reader.readLine());

        matrix = new char[rows][];
        visited = new boolean[rows][];

        readCharMatrix(reader, rows);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(!visited[i][j]) {
                    dfs(i, j ,matrix[i][j]);
                }
            }
        }

        visitedNode = new boolean[graph.size()];

        Map<Character, Integer> areas = new TreeMap<>();

        for (int i = 0; i < graph.size(); i++) {
            if(!visitedNode[i]) {
                Edge currentEdge = graph.get(i);
                char fieldContent = matrix[currentEdge.source[0]][currentEdge.source[1]];

                areas.putIfAbsent(fieldContent, 0);
                areas.put(fieldContent, areas.get(fieldContent) + 1);
                bfs(i);
            }
        }

        printResult(areas);
    }

    private static void printResult(Map<Character, Integer> areas) {
        StringBuilder result = new StringBuilder();

        int totalSumOfAreas = areas.values().stream().mapToInt(e -> e).sum();

        result.append("Areas: ").append(totalSumOfAreas).append(System.lineSeparator());

        for (Map.Entry<Character, Integer> entry : areas.entrySet()) {
            result.append("Letter '").append(entry.getKey()).append("' -> ").append(entry.getValue()).append(System.lineSeparator());
        }

        System.out.print(result);
    }

    private static void bfs(int source) {
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(source);

        visitedNode[source] = true;

        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            Edge currentEdge = graph.get(currentNode);

            if(currentEdge.destination != null) {
                visitedNode[currentNode + 1] = true;
                queue.offer(currentNode + 1);
            }
        }
    }

    private static void dfs(int row, int col, char symbol) {
        visited[row][col] = true;

        Edge currentEdge = new Edge(row, col);
        graph.add(currentEdge);

        if(isInBounds(row, col + 1) && !visited[row][col + 1] &&matrix[row][col + 1] == symbol) {
            graph.get(graph.size() - 1).setDestination(row, col + 1);
            dfs(row, col + 1, symbol);
        }

        if (isInBounds(row, col - 1) && !visited[row][col - 1] && matrix[row][col - 1] == symbol) {
            graph.get(graph.size() - 1).setDestination(row, col - 1);
            dfs(row, col - 1, symbol);
        }
        if (isInBounds(row + 1, col) && !visited[row + 1][col] && matrix[row + 1][col] == symbol) {
            graph.get(graph.size() - 1).setDestination(row + 1, col);
            dfs(row + 1, col, symbol);
        }
        if (isInBounds(row - 1, col) && !visited[row - 1][col] && matrix[row - 1][col] == symbol) {
            graph.get(graph.size() - 1).setDestination(row - 1, col);
            dfs(row - 1, col, symbol);
        }

    }

    private static boolean isInBounds(int row, int col) {
        return !isOutOfBounds(row, col);
    }

    private static boolean isOutOfBounds(int row, int col) {
        return row < 0 || row >= matrix.length || col < 0 || col >= matrix[row].length;
    }

    private static void readCharMatrix(BufferedReader reader, int rows) throws IOException {
        for (int i = 0; i < rows; i++) {
            matrix[i] = reader.readLine().toCharArray();
            visited[i] = new boolean[matrix[i].length];
        }
    }
}
