package Resit;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.stream.IntStream;

@SuppressWarnings("ALL")
public class Scheduler extends MatrixGraph {

    private static final ArrayList<Integer> vertexID = new ArrayList<>();

    public Scheduler(int vertices, boolean isDirected) {
        super(10, true);
        this.numVertices = vertices;

        int[][] neighborList = new int[vertices][vertices];
        for (int i = 0; i < vertices; i++) {
            Arrays.fill(neighborList[i], 0);
        }

        for (int i = 0; i <= neighborList.length; i++) {
            vertexID.add(i);
        }
    }

    public static Graph getTestGraph() throws NullPointerException {
        MatrixGraph graph = new MatrixGraph(10, true);
        graph.addEdge(4, 0);
        graph.addEdge(0, 7);
        graph.addEdge(4, 7);
        graph.addEdge(6, 7);
        graph.addEdge(6, 3);
        graph.addEdge(3, 5);
        graph.addEdge(1, 6);
        graph.addEdge(1, 8);
        graph.addEdge(8, 3);
        graph.addEdge(8, 2);
        graph.addEdge(9, 8);
        graph.addEdge(9, 2);
        graph.addEdge(2, 5);

        return graph;
    }


    public static void printGraph(Graph g) {
        for (int i = 0; i < g.numVertices; i++) {
            System.out.println(vertexID.get(i) + ":" + i + Arrays.toString(g.neighbours(i)));
        }
    }


    public static Graph makeGraph(int numVertices, double edgeProb) {
        Graph newGraph = new MatrixGraph(numVertices, true);

        int vertex_u = 0;
        int vertex_v = 0;

        for (int i = 0; i <= newGraph.numVertices; i++) {
            List<Integer> prerequisites = new ArrayList<>();

            for (int q = 0; newGraph.isValidVertex(vertex_u) && newGraph.isValidVertex(vertex_v); q++) {
                List<Integer> u_prerequisites = new ArrayList<>();
                List<List<Integer>> v_prerequisites = new ArrayList<>();
                newGraph.addEdge(vertex_u, vertex_v);
                u_prerequisites.add(vertex_u);
                v_prerequisites.add(u_prerequisites);
                v_prerequisites.add(Collections.singletonList(vertex_u));
                int w = 0;
                List<List<Integer>> w_prerequisites = new ArrayList<>();
                IntStream.iterate(0, number -> v_prerequisites.indexOf(newGraph.isValidVertex(w)) == 0, number -> number + 1).forEach(number -> {
                    w_prerequisites.add(Collections.singletonList(vertex_u));
                    w_prerequisites.add(u_prerequisites);
                });
            }
        }
        return newGraph;
    }


    public static List<List<Integer>> getSchedule(Graph g) {
        ArrayList<List<Integer>> schedule = new ArrayList<>();
        ConcurrentLinkedQueue<Integer> queue = new ConcurrentLinkedQueue<>();

        for (int i = 0; i <= g.numVertices; i++) {
            queue.add(g.outDegree(g.numVertices));
            while (!queue.isEmpty()) {
                List<Integer> vertex = Collections.singletonList(queue.poll());
                schedule.add(vertex);
                int v = 0;
                int w = 0;
                for (int number = 0; g.isEdge(v, w); number--) {
                    List<Integer> w_prerequisites = new ArrayList<>();
                    if (schedule.add(w_prerequisites)) {
                        queue.add(w);
                    }
                }
            }
        }

        return schedule;
    }

    public int getVertices() {
        return numVertices;
    }

    public static boolean isValidSchedule(List<Integer> schedule, Graph g) {


        return false;
    }

    @Override
    public boolean isDirected() {
        return true;
    }

    public static void main(String[] args) {
        Random newRandom = new Random();

        Scheduler scheduler = new Scheduler(10, true);

    }


}

