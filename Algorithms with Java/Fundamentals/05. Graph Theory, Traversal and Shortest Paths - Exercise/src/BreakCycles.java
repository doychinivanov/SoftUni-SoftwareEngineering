import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class BreakCycles {
    private static Map<String, Set<String>> graph = new HashMap<>();
    private static List<String> removedEdges = new ArrayList<>();
    private static SortedSet<String> outputCycle;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();

        while (line != null && !line.equals("")) {
            String[] nodeData = line.split(" -> ");
            String node = nodeData[0];
            String[] childNodes = nodeData.length > 1 ? nodeData[1].split("\\s+") : new String[0];

//            Holding the child nodes. One node cannot have more than one edge to a single child. A cycle can occur otherwise.
            Set<String> temp = new HashSet<>();

            for (String curChild : childNodes) {
//                If an edge between tha parent node and the child node already exists the new edge won't be added.
//                Success will be false
                boolean edgeAddedSuccessfully = temp.add(curChild.trim());

//                If the node has more than one edge to a single child an edge must be removed.
//                node.compareTo(curChild) <= 0 is simply for output reasons. So that we represent the removed edge alphabetically: A-Z and not Z-A
                if (!edgeAddedSuccessfully && node.compareTo(curChild) <= 0) {
                    removedEdges.add(String.format("%s - %s", node, curChild));
                }
            }

//            We put the current node with its child nodes in the graph.
            graph.put(node, temp);
            line = reader.readLine();
        }

        while (true) {
            Set<String> visited = new HashSet<>();
            boolean hasSomeCycles = false;

            for (String node : graph.keySet()) {
                SortedSet<String> cycle = new TreeSet<>();
                outputCycle = new TreeSet<>();

                boolean currentGraphIsCyclic = searchForCycles(node, visited, cycle, null);

                if (currentGraphIsCyclic) {
                    hasSomeCycles = true;
                    breakCycle();
                    break;
                }
            }

            if (!hasSomeCycles) break;
        }

        System.out.println("Edges to remove: " + removedEdges.size());
        removedEdges = removedEdges.stream().sorted().collect(Collectors.toList());
        for (String edge : removedEdges) {
            System.out.println(edge);
        }
    }

    private static void breakCycle() {

        Map<String, Integer> vertexEdges = new HashMap<>();

//        Find how many edges each node that cause a cycle has.
        for (String node : outputCycle) {
            for (String nextNode : outputCycle) {
                if (graph.get(node).contains(nextNode)) {
                    vertexEdges.putIfAbsent(node, 0);
                    vertexEdges.put(node, vertexEdges.get(node) + 1);
                }
            }
        }

        while (true) {
            boolean hasChanged = false;

            for (String node : vertexEdges.keySet()) {
//                In undirected graph we know for sure that if a node has only one edge this node can not be a cause for cycle.
//                If the current node hase only one edge remove from the set of nodes that causes a cycle.
                if (vertexEdges.get(node) == 1 && outputCycle.contains(node)) {
                    outputCycle.remove(node);
                    hasChanged = true;
                    break;
                }
            }

            if (!hasChanged) {
                break;
            }
        }

        for (String node : outputCycle) {
            for (String nextNode : outputCycle) {
                if (graph.get(node).contains(nextNode)) {
//                    We remove the edge between the node and the child node. Then return;
//                    It does not mean that all the cycles are broken, but we are a step closer.
//                    The searchForCycles method will be called again and in case a cycle still exists on the next iteration another edge will be removed.
//                    Until no cycles are left.
                    removedEdges.add(String.format("%s - %s", node, nextNode));
                    graph.get(node).remove(nextNode);
                    graph.get(nextNode).remove(node);
                    return;
                }
            }
        }
    }

    private static boolean searchForCycles(String node, Set<String> visited, SortedSet<String> cycle, String parent) {
        boolean output = false;

//        If the current node is a reason for a cycle we break saying a cycle has been found.
        if (cycle.contains(node)) {
            outputCycle.addAll(cycle);
            return true;
        }

//        If we have not visited the node yet
        if (!visited.contains(node)) {
//            Say we visited it
            visited.add(node);
//            Add it for observing as a cycle cause
            cycle.add(node);

            if (graph.containsKey(node)) {
                for (String child : graph.get(node)) {
//                    Call recursion only if the child has no edge to itself.
//                    Otherwise, don't remove the child from the cycle and say the graph is cyclic.
                    if (!child.equals(parent)) {
                        output = output || searchForCycles(child, visited, cycle, node);
                    }
                }
//                If no cycles appear, remove the node from the cycles set when backtracking.
                cycle.remove(node);
            }
        }

        return output;
    }
}
