package Workingcode;

import Ass2_2022.Graph;
import Ass2_2022.MatrixGraph;
import Labs.Lab4.PriorityQueue;

import java.util.Arrays;
import java.util.Scanner;


public class Algorithm extends Ass2_2022.MatrixGraph {

    public Algorithm(int numVertices, boolean isDirected) {
        super(numVertices, isDirected);
    }

    public static void Dijkstra_lectures(Graph graph, int source) {
        Graph g = new MatrixGraph(100, true);
        boolean[] solved = new boolean[g.numVertices()];
        double[] distance = new double[g.numVertices()];

        PriorityQueue Q;

        for (int i = 0; i <= solved.length; i++) {
            Arrays.fill(solved, false);
        }

        for (int i = 0; i <= distance.length; i++) {
            Arrays.fill(distance, Double.POSITIVE_INFINITY);
        }

        Q = new PriorityQueue();


        solved[source] = true;
        distance[source] = 0;

        Q.insert(0, source);


        while (!Q.isEmpty()) {
            Object x = Q.next();
            solved[(int) x] = true;

            for (int y : graph.outNeighbours((Integer) x)) {
                if (!solved[y]) {
                    double newDistance = distance[(int) x] + g.weight((Integer) x, y);
                    if (newDistance < distance[y]) {
                        distance[y] = newDistance;
                        if (Q.contains(y)) {
                            Q.setPriority(newDistance, y);
                        } else {
                            Q.insert(y, newDistance);
                        }
                    }
                }

            }
        }
    }


    public static void dijkstra_online(Graph g, int source) {
        int count = g.numVertices();
        boolean[] visitedVertex = new boolean[count];
        int[] distance = new int[count];
        for (int i = 0; i < count; i++) {
            visitedVertex[i] = false;
            distance[i] = Integer.MAX_VALUE;
        }

        // Distance of self loop is zero
        distance[source] = 0;
        for (int i = 0; i < count; i++) {

            // Update the distance between neighbouring vertex and source vertex
            int u = findMinDistance(distance, visitedVertex);
            visitedVertex[u] = true;

            // Update all the neighbouring vertex distances
            for (int v = 0; v < count; v++) {
                if (!visitedVertex[v] && g.weight(u, v) != 0 && (distance[u] + g.weight(u, v) < distance[v])) {
                    distance[v] = (int) (distance[u] + g.weight(u, v));
                }
            }
        }
        for (int i = 0; i < distance.length; i++) {
            System.out.printf("Distance from %s to %s is %s%n", source, i, distance[i]);
        }

    }

    // Finding the minimum distance
    private static int findMinDistance(int[] distance, boolean[] visitedVertex) {
        int minDistance = Integer.MAX_VALUE;
        int minDistanceVertex = 0;
        for (int i = 0; i < distance.length; i++) {
            if (!visitedVertex[i] && distance[i] < minDistance) {
                minDistance = distance[i];
                minDistanceVertex = i;
            }
        }
        return minDistanceVertex;
    }

    public static void main(String[] args) {
        Scanner newScanner = new Scanner(System.in);
        Graph g = new MatrixGraph(10, true);
        System.out.println("Enter a number: ");
        int number = newScanner.nextInt();

        if (number == 1) {
            Dijkstra_lectures(g, 3);
        } else if (number == 2) {
            dijkstra_online(g, 8);
        } else if (number == 3) {
            new Prim();
        }

    }

}
