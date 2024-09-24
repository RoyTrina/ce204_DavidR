package Ass2_2022;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;


//I have included and altered the Edge class

public class MST {
    private static class Edge implements Comparable<Ass2_2022.Edge> {
        final int x;
        final int y; /* Endpoints */
        final double w; /* Weight    */
        Ass2_2022.Edge this_edge;
        private Ass2_2022.Edge that_edge;

        public Edge(int x, int y, double w) {
            this.x = x;
            this.y = y;
            this.w = w;
        }

        public double getW() {
            return this_edge.w;
        }

        @Override
        public int compareTo(Ass2_2022.Edge that) {
            this.that_edge = that;
            if (this_edge.w < that.w) {
                return -1;
            } else if (that == this_edge) {
                return 0;
            } else {
                return 1;
            }
        }

        public Ass2_2022.Edge getThat() {
            return that_edge;
        }

        public void setThat(Ass2_2022.Edge that) {
            this.that_edge = that;
        }
    }

    private boolean isDirected;
    private final int vertex;
    private static double weight;
    public static Random numberGenerator;

    public MST(int vertices) {
        this.vertex = vertices;
        System.out.println(getRandomGraph(vertices));
        weight = 0;
    }

    public boolean isDirected() {
        return isDirected;
    }

    public void setDirected(boolean directed) {
        isDirected = directed;
    }


    public static Graph getRandomGraph(int n) {
        Graph newGraph = new MatrixGraph(n, false);

        for (int a = 0; a < n; a++) {
            for (int b = 1; b < n; b++) {
                if (a != b) {
                    newGraph.addEdge(a, b, ThreadLocalRandom.current().nextDouble(10));
                }
            }
        }
        return newGraph;
    }


    public static double getTotalEdgeWeight(Graph g) throws ArrayIndexOutOfBoundsException {
        double weightCounter = 0;
        double[] weightArray = new double[g.numVertices];

        for (int c = 0; c < g.numVertices; c++) {
            for (int d = 1; d < g.numVertices; d++) {
                Edge edge = new Edge(c, d, weight);
                weightArray[c] = edge.w;
                weightCounter = weightCounter + weightArray[c];
            }

        }
        return weightCounter;
    }

    public static boolean isConnected(Graph g) {
        Queue<Integer> inLine = new PriorityQueue<>(g.numVertices);
        int[] visited = new int[g.numVertices];
        int vertex = numberGenerator.nextInt(g.numVertices);

        inLine.add(vertex);
        while (!inLine.isEmpty()) {
            int pointer = inLine.remove();

            if (visited[pointer] == pointer) {
                continue;
            }
            visited[pointer] = pointer;
            for (int e = 0; e <= g.numVertices; e++) {
                if (!(vertex == visited[vertex])) {
                    inLine.add(vertex);
                }
            }
        }
        return true;
    }


    public static void makeMST(Graph g) {
        ArrayList<Edge> edgeList = new ArrayList<>(g.numVertices);

        for (int f = 0; f <= g.numVertices; f++) {
            for (int h = 1; h <= g.numVertices; h++) {
                if (f < h) {
                    edgeList.add(new Edge(f, h, g.weight(f, h)));
                    edgeList.sort(Comparator.comparingDouble(Edge::getW).reversed());
                }
                if (MST.isConnected(g)) {
                    for (Edge edge : edgeList) {
                        g.deleteEdge(edge.x, edge.y);
                    }
                }
            }
        }
    }


    public int getVertex() {
        return vertex;
    }

    private static double getTotalEdgeWeight(MST mst) {
        double weightCounter = 0;
        double[] weightArray = new double[mst.vertex];

        for (int c = 0; c < mst.vertex; c++) {
            for (int d = 1; d < mst.vertex; d++) {
                Edge edge = new Edge(c, d, weight);
                weightArray[c] = edge.w;
                weightCounter = weightCounter + weightArray[c];
            }

        }
        return weightCounter;
    }

    public static void main(String[] args) {
        //part A
        //test with GraphOfEssex
        double graphWeight = getTotalEdgeWeight(GraphOfEssex.getGraph());
        if (graphWeight == 95) {
            System.out.println("Everything is alright");
        } else {
            System.out.println("There is an error.");
        }


        //part B
        double[] weightArray = new double[new MST(100).vertex];
        double weight = 0;
        for (int number = 0; number <= 20; number++) {
            new MST(100);
            weightArray[number] = MST.getTotalEdgeWeight(new MST(100));
            weight = weight + weightArray[number];
        }
        System.out.println("The resulting total weight is: " + (double) Math.round(weight));


    }


}
