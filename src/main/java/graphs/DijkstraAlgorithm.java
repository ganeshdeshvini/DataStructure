package graphs;

import java.util.*;

/**
 * ---Input Graph Data
 * A : [B|10, C|20]
 * B : [D|50, E|10]
 * C : [E|33, D|20]
 * D : [E|20, F|2]
 * E : [F|1]
 * F : []
 *
 * ---Output
 * A : 0, Path: A
 * B : 10, Path: A -> B
 * C : 20, Path: A -> C
 * D : 40, Path: A -> C -> D
 * E : 20, Path: A -> B -> E
 * F : 21, Path: A -> B -> E -> F
 */
public class DijkstraAlgorithm {
    private Map<Node, List<Edge>> graphAdjacencyList = new HashMap<>();

    public void startDijkstraAlgorithm(Node sourceNode) {
        if (graphAdjacencyList.containsKey(sourceNode)) {
            //create a map for key as Node & Value as Distance + ParentNode (NodeMetaDataWrapper)
            Map<Node, NodeMetaDataWrapper> mapNodeDistance = new HashMap();

            //initialize sourceNode distance as 0, Parent will be NULL as this is the source node
            mapNodeDistance.put(sourceNode, new NodeMetaDataWrapper(0, null));

            //push the sourceNode into minHeap as Edge
            PriorityQueue<Edge> minHeapEdge = new PriorityQueue<>();
            minHeapEdge.add(new Edge(sourceNode, 0));

            while (!minHeapEdge.isEmpty()) {
                //Get minimum/shortest Node from the Queue
                Node currentNode = minHeapEdge.poll().getNode();

                //get Parent Distance of the current Node
                int parentDistance = getParentDistance(mapNodeDistance, currentNode);

                //get all the Edges of Node, from the Graph
                List<Edge> edges = graphAdjacencyList.get(currentNode);

                edges.forEach(edge -> {
                    int currentChildDistance = edge.getDistance();
                    int totalChildDistanceIncludingParent = parentDistance + currentChildDistance;
                    Node childNode = edge.getNode();
                    //If the Node is already Present, then compare the Current distance with the Previous Distance & if found less/shorter, than Replace it, else keep the Previous distance
                    if (mapNodeDistance.containsKey(childNode)) {
                        if (totalChildDistanceIncludingParent < mapNodeDistance.get(childNode).getDistance()) {
                            mapNodeDistance.put(childNode, new NodeMetaDataWrapper(totalChildDistanceIncludingParent, currentNode));
                        }
                    } else {
                        mapNodeDistance.put(childNode, new NodeMetaDataWrapper(totalChildDistanceIncludingParent, currentNode));
                    }
                    minHeapEdge.add(edge);
                });
            }

            // Print the Node & Shortest Distance
            printAllVertexWithShortestDistance(mapNodeDistance);

            //Print the Node & Shortest Distance along with all the Hops/Path
            printAllVertexWithShortestDistanceAlongWithAllPathNeedsToBeTaken(mapNodeDistance);
        }
    }

    private void printAllVertexWithShortestDistanceAlongWithAllPathNeedsToBeTaken(Map<Node, NodeMetaDataWrapper> mapNodeDistance) {
        System.out.println("\nVertex with Distance & Path");
        mapNodeDistance.forEach((node, nodeMetaDataWrapper) -> {
            System.out.print(node + " : " + nodeMetaDataWrapper.distance + ", Path: ");
            printPathRecursive(mapNodeDistance, nodeMetaDataWrapper);
            System.out.print(node);
            System.out.println();
        });
    }

    void printPathRecursive(Map<Node, NodeMetaDataWrapper> mapNodeDistance, NodeMetaDataWrapper nodeMetaDataWrapper) {
        if (nodeMetaDataWrapper == null || nodeMetaDataWrapper.getParent() == null) {
            return;
        }
        printPathRecursive(mapNodeDistance, mapNodeDistance.get(nodeMetaDataWrapper.getParent()));
        System.out.print(nodeMetaDataWrapper.getParent() + " -> ");
    }

    private void printAllVertexWithShortestDistance(Map<Node, NodeMetaDataWrapper> mapNodeDistance) {
        System.out.println("Vertex with Distance");
        mapNodeDistance.forEach((node, nodeMetaDataWrapper) -> System.out.println(node + " : " + nodeMetaDataWrapper));
    }

    private int getParentDistance(Map<Node, NodeMetaDataWrapper> mapTemporaryDistance, Node node) {
        return mapTemporaryDistance.get(node).getDistance();
    }

    static class NodeMetaDataWrapper {
        private int distance;
        private Node parent;

        public NodeMetaDataWrapper(int distance, Node parent) {
            this.distance = distance;
            this.parent = parent;
        }

        public Node getParent() {
            return parent;
        }

        public int getDistance() {
            return distance;
        }

        @Override
        public String toString() {
            return parent + "(" + distance + ")";
        }
    }

    public void addVertex(Node... nodes) {
        for (Node node : nodes) {
            graphAdjacencyList.putIfAbsent(node, new ArrayList<>());
        }
    }

    public void createEdge(Node src, Node dest, int distance) {
        if (graphAdjacencyList.containsKey(src) && graphAdjacencyList.containsKey(dest)) {
            List<Edge> edges = graphAdjacencyList.get(src);
            edges.add(new Edge(dest, distance));
        }
    }

    public void printGraph() {
        graphAdjacencyList.forEach((node, edges) -> System.out.println(node + " : " + edges));
    }

    public static class Node {
        private String placeName;

        public Node(String placeName) {
            this.placeName = placeName;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return placeName.equals(node.placeName);
        }

        @Override
        public int hashCode() {
            return Objects.hash(placeName);
        }

        @Override
        public String toString() {
            return placeName;
        }
    }

    public class Edge implements Comparable<Edge> {
        private Node node;
        private int distance;

        public Edge(Node node, int distance) {
            this.node = node;
            this.distance = distance;
        }

        public Node getNode() {
            return node;
        }

        public int getDistance() {
            return distance;
        }


        @Override
        public String toString() {
            return node + "|" + distance;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.distance, o.distance);
        }
    }


    public static void main(String[] args) {
        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeE = new Node("E");
        Node nodeF = new Node("F");
        DijkstraAlgorithm dijkstraAlgorithm = new DijkstraAlgorithm();
        dijkstraAlgorithm.addVertex(nodeA, nodeB, nodeC, nodeD, nodeE, nodeF);
        dijkstraAlgorithm.createEdge(nodeA, nodeB, 10);
        dijkstraAlgorithm.createEdge(nodeA, nodeC, 20);
        dijkstraAlgorithm.createEdge(nodeB, nodeD, 50);
        dijkstraAlgorithm.createEdge(nodeC, nodeE, 33);
        dijkstraAlgorithm.createEdge(nodeC, nodeD, 20);
        dijkstraAlgorithm.createEdge(nodeB, nodeE, 10);
        dijkstraAlgorithm.createEdge(nodeD, nodeE, 20);
        dijkstraAlgorithm.createEdge(nodeD, nodeF, 2);
        dijkstraAlgorithm.createEdge(nodeE, nodeF, 1);
        dijkstraAlgorithm.printGraph();
        System.out.println("-----------------\n");
        dijkstraAlgorithm.startDijkstraAlgorithm(nodeA);
    }
}
