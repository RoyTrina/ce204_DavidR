package Labs.Lab6.exercise1;

import java.util.ArrayList;


public class ListGraph extends Graph {
    private final boolean isDirected;
    protected final int numVertices;
    public static final boolean DIRECTED_GRAPH = true;

    private static class ListGraphException extends RuntimeException {
        public ListGraphException(String s) {
            super("Tried to" + s + "to the ListGraph.");
        }

    }

    private static class Edge {
        final int target;
        double weight;

        Edge(int target, double weight) {
            this.target = target;
            this.weight = weight;
        }

        public Edge(int target) {
            this.target = target;
            this.weight = 1;
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof Edge)) {
                return false;
            }
            return ((Edge) obj).target == this.target;
        }

        @Override
        public String toString() {
            return "" + target + "(" + weight + ")";
        }
    }

    private final ArrayList<Edge>[] comingInEdges;
    private final ArrayList<Edge>[] goingOutEdges;


    ListGraph(int numVertices, boolean isDirected) {
        this.numVertices = numVertices;
        this.isDirected = isDirected;

        comingInEdges = (ArrayList<Edge>[]) new ArrayList[numVertices];
        goingOutEdges = (ArrayList<Edge>[]) new ArrayList[numVertices];

        for (int i = 0; i < numVertices; i++) {
            comingInEdges[i] = new ArrayList<>();
            goingOutEdges[i] = new ArrayList<>();
        }
    }

    @Override
    public void addEdge(int x, int y, double weight) {
        directedAdd(x, y, weight);
        if (!isDirected()) {
            directedAdd(y, x, weight);
        }
    }


    private void directedAdd(int number, int q, double weight) {
        Edge eFromNumber = new Edge(q, weight);
        Edge eFromQ = new Edge(number, weight);

        int i = goingOutEdges[number].indexOf(eFromNumber);
        if (i != -1) {
            goingOutEdges[number].get(i).weight = weight;
        } else {
            goingOutEdges[number].add(eFromNumber);
        }

        int j = comingInEdges[q].indexOf(eFromQ);
        if (j != -1) {
            comingInEdges[q].get(i).weight = weight;
        } else {
            comingInEdges[q].add(eFromQ);
        }


    }


    @Override

    public void deleteEdge(int x, int y) {
        directedDeleteEdge(x, y);

        if (!isDirected()) {
            directedDeleteEdge(y, x);
        }
    }

    private void directedDeleteEdge(int number, int number2) {
        Edge eFromNumber = new Edge(number2);
        Edge fromNumber2 = new Edge(number);

        goingOutEdges[number].remove(eFromNumber);
        comingInEdges[number2].remove(fromNumber2);
    }


    @Override
    public boolean isDirected() {
        return isDirected;
    }

    @Override

    public boolean isEdge(int x, int y) {
        return goingOutEdges[x].contains(new Edge(y));
    }


    @Override

    public double weight(int x, int y) {
        int i = goingOutEdges[x].indexOf(new Edge(x));

        return i < 0 ? Double.NaN : goingOutEdges[x].get(i).weight;
    }

    @Override
    public int inDegree(int x) {
        return comingInEdges[x].size();
    }

    @Override
    public int outDegree(int x) {
        return goingOutEdges[x].size();
    }

    @Override
    public int[] inNeighbours(int x) {
        int[] result = new int[comingInEdges[x].size()];

        int l = 0;

        for (Edge e : comingInEdges[x]) {
            result[l++] = e.target;
        }
        return result;
    }

    @Override
    public int[] outNeighbours(int x) {
        int[] result = new int[goingOutEdges[x].size()];

        int d = 0;

        for (Edge e : goingOutEdges[x]) {
            result[d++] = e.target;

        }
        return result;
    }

    public static void main(String[] args) {
        ListGraph graph = new ListGraph(3, UNDIRECTED_GRAPH);

        graph.addEdge(0, 1);
        for (int i = 0; i < 2; i++) {
            System.out.println(i + "'s neighbours: " + graph.goingOutEdges[i].toString());
        }

        graph.deleteEdge(1, 0);
        for (int i = 0; i < 2; i++)
            System.out.println(i + "'s neighbours: " + graph.goingOutEdges[i]);
    }
}