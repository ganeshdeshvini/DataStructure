package graphs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AdjacentGraph {
    Map<Integer, Set<Integer>> adjacentMaps = new HashMap<>();

    void addVertex(Integer node) {
        adjacentMaps.put(node, new HashSet<>());
    }

    void addEdge(Integer node1, Integer node2) {
        adjacentMaps.get(node1).add(node2);
        adjacentMaps.get(node2).add(node1);
    }

    void print() {
        adjacentMaps.forEach((node, adjacentList) -> {
            System.out.println(node + ": " + adjacentList);
        });
    }

    public static void main(String[] args) {
        AdjacentGraph adjacentGraph = new AdjacentGraph();
        adjacentGraph.addVertex(1);
        adjacentGraph.addVertex(2);
        adjacentGraph.addVertex(3);
        adjacentGraph.addEdge(1, 2);
        adjacentGraph.addEdge(1, 3);
        adjacentGraph.addEdge(2, 3);
        adjacentGraph.print();
    }
}
