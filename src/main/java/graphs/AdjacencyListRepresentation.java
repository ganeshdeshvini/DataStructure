package graphs;

import java.util.*;

public class AdjacencyListRepresentation {
    private final Map<Node, List<Node>> mapAdjacentList;

    static class Node {
        int data;

        public Node(int data) {
            this.data = data;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return data == node.data;
        }

        @Override
        public int hashCode() {
            return Objects.hash(data);
        }

        @Override
        public String toString() {
            return String.valueOf(data);
        }
    }

    public AdjacencyListRepresentation() {
        this.mapAdjacentList = new HashMap<>();
    }

    public void addEdge(Node src, Node dest) {
        createEdge(src, dest);
        createEdge(dest, src);
    }

    private void createEdge(Node src, Node dest) {
        if (!mapAdjacentList.containsKey(src)) {
            mapAdjacentList.putIfAbsent(src, new ArrayList<>());
        }
        mapAdjacentList.get(src).add(dest);
    }

    public void removeEdge(Node src, Node dest) {
        deleteEdge(src, dest);
        deleteEdge(dest, src);
    }

    private void deleteEdge(Node src, Node dest) {
        List<Node> adjacentSet = mapAdjacentList.get(src);
        if (adjacentSet != null) {
            adjacentSet.remove(dest);
        }
    }

    public void print() {
        mapAdjacentList.forEach((key, value) -> {
            System.out.println(String.format("%s: %s", key, value));
        });
    }

    public void bfs(Node node) {
        System.out.println("BFS");
        Queue<Node> queue = new LinkedList<>();
        Set<Node> visitedNodes = new HashSet<>();
        if (!mapAdjacentList.containsKey(node)) {
            System.out.println("Not Found");
            return;
        }
        queue.add(node);
        visitedNodes.add(node);
        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            System.out.print(currentNode + " - ");

            List<Node> adjacentNodes = mapAdjacentList.get(currentNode);
            adjacentNodes.forEach(adjacentNode -> {
                if (!visitedNodes.contains(adjacentNode)) {
                    queue.add(adjacentNode);
                    visitedNodes.add(adjacentNode);
                }
            });
        }
        System.out.println();
    }

    private void dfs(Node node) {
        System.out.println("DFS");
        if (!mapAdjacentList.containsKey(node)) {
            System.out.println("Not Found");
            return;
        }
        Set<Node> visitedNodes = new HashSet<>();
        Stack<Node> stack = new Stack<>();
        stack.push(node);
        visitedNodes.add(node);

        while (!stack.isEmpty()) {
            Node currentNode = stack.pop();
            System.out.print(currentNode + " - ");

            List<Node> adjacentNodes = mapAdjacentList.get(currentNode);
            adjacentNodes.forEach(adjacentNode -> {
                if (!visitedNodes.contains(adjacentNode)) {
                    stack.push(adjacentNode);
                    visitedNodes.add(adjacentNode);
                }
            });
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node node40 = new Node(40);
        Node node10 = new Node(10);
        Node node20 = new Node(20);
        Node node30 = new Node(30);
        Node node60 = new Node(60);
        Node node50 = new Node(50);
        Node node70 = new Node(70);
        AdjacencyListRepresentation adjacencyListRepresentation = new AdjacencyListRepresentation();
        adjacencyListRepresentation.addEdge(node40, node10);
        adjacencyListRepresentation.addEdge(node40, node20);
        adjacencyListRepresentation.addEdge(node10, node30);
        adjacencyListRepresentation.addEdge(node20, node10);
        adjacencyListRepresentation.addEdge(node20, node30);
        adjacencyListRepresentation.addEdge(node20, node60);
        adjacencyListRepresentation.addEdge(node20, node50);
        adjacencyListRepresentation.addEdge(node30, node60);
        adjacencyListRepresentation.addEdge(node60, node70);
        adjacencyListRepresentation.addEdge(node50, node70);
        adjacencyListRepresentation.print();
        System.out.println("------------");

        //40 10 20 30 60 50 70
        adjacencyListRepresentation.bfs(node40);

        //40 20 50 70 60 30 10
        adjacencyListRepresentation.dfs(node40);
    }
}
