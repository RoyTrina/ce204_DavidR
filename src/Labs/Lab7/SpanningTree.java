package Labs.Lab7;


import Labs.Lab6.exercise1.Graph;
import Labs.Lab6.exercise1.MatrixGraph;

public class SpanningTree {
    int vertices;

    int[] component = new int[vertices];
    final int[] weights = new int[10];

    public Graph SpanTree() {
        MatrixGraph sT = new MatrixGraph(10, Graph.UNDIRECTED_GRAPH);
        int i = weights[weights.length - 1];
        sT.addEdge(2, 5, weights[i]);


        return null;
    }

}