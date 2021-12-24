import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CyclesInGraph {
    private static Map<String, List<String>> graph = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String line = reader.readLine();

        String[] initialSource =  new String[1];

        createGraph(reader, line, initialSource);

        Set<String> visitedNodes = new HashSet<>();
        Set<String> cycles = new HashSet<>();

        String result = "";

        try{
            for (String src : graph.keySet()) {
                if (!visitedNodes.contains(src)) {
                    dfs(src, visitedNodes, cycles);
                    result = "Acyclic: Yes";
                }
            }
        } catch (IllegalStateException ex) {
            result = ex.getMessage();
        }

        System.out.println(result);
    }

    private static void dfs(String src, Set<String> visitedNodes, Set<String> cycles) {
        if (cycles.contains(src)) throw new IllegalStateException("Acyclic: No");

        if (visitedNodes.contains(src)) return;

        cycles.add(src);
        visitedNodes.add(src);

        if (graph.get(src) == null) return;

        for (String child : graph.get(src)) dfs(child, visitedNodes, cycles);

        cycles.remove(src);
    }

    private static void createGraph(BufferedReader reader, String line, String[] initialSource) throws IOException {
        while (!line.equals("End")) {
            String[] tokens = line.split("-");

            if(initialSource == null) initialSource[0] = tokens[0];

            String currentSource = tokens[0];
            String currentDestination = tokens[1];

            graph.putIfAbsent(currentSource, new ArrayList<>());
            graph.get(currentSource).add(currentDestination);

            line = reader.readLine();

        }
    }
}
