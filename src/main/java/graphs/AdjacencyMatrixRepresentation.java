package graphs;

/**
 * 0: 0 1 1 0
 * 1: 1 0 1 0
 * 2: 1 1 0 1
 * 3: 0 0 1 0
 */
public class AdjacencyMatrixRepresentation {

    final private int numVertices;
    final private int[][] arrAdjacentMatrix;

    public AdjacencyMatrixRepresentation(int numVertices) {
        this.numVertices = numVertices;
        this.arrAdjacentMatrix = new int[numVertices][numVertices];
    }

    public void addEdge(int src, int dest) {
        createEdge(src, dest);
        createEdge(dest, src);
    }

    private void createEdge(int src, int dest) {
        arrAdjacentMatrix[src][dest] = 1;
    }

    public void removeEdge(int src, int dest) {
        deleteEdge(src, dest);
        deleteEdge(dest, src);
    }

    private void deleteEdge(int src, int dest) {
        arrAdjacentMatrix[src][dest] = 0;
    }

    void print() {
        for (int i = 0; i < numVertices; i++) {
            System.out.print(i + " : ");
            for (int j = 0; j < numVertices; j++) {
                System.out.print(arrAdjacentMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    boolean isEdgePresent(int src, int dest) {
        return arrAdjacentMatrix[src][dest] == 1;
    }

    public static void main(String[] args) {
        AdjacencyMatrixRepresentation adjacencyMatrixRepresentation = new AdjacencyMatrixRepresentation(4);
        adjacencyMatrixRepresentation.addEdge(0, 1);
        adjacencyMatrixRepresentation.addEdge(0, 2);
        adjacencyMatrixRepresentation.addEdge(1, 2);
        adjacencyMatrixRepresentation.addEdge(2, 0);
        adjacencyMatrixRepresentation.addEdge(2, 3);
        adjacencyMatrixRepresentation.print();
        System.out.println("-----------");
        adjacencyMatrixRepresentation.removeEdge(2, 3);
        adjacencyMatrixRepresentation.print();
        System.out.println("Edge Present 0 -> 1: " + adjacencyMatrixRepresentation.isEdgePresent(0, 1));
        System.out.println("Edge Present 3 -> 3: " + adjacencyMatrixRepresentation.isEdgePresent(3, 3));
    }
}
