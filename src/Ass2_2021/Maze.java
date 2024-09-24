package Ass2_2021;

import Labs.Lab1.exercise1.LinkedStack;
import Labs.Lab6.exercise1.MatrixGraph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;


public class Maze extends MatrixGraph {
    public final int height;
    public final int width;
    public String start = "*";
    public String end = "*";
    public final String horizontal_edge = "-";
    public final String vertical_edge = "|";
    public final String vertex = "+";
    public final int vertices = 0;
    private Slot[][] slots;
    final Random newRandom = new Random();

    private final String[][] mazeStructure;
    private final boolean isDirected;


    public Maze(int width, int height, boolean isDirected) {
        this.width = width;
        this.height = height;
        this.isDirected = isDirected;

        mazeStructure = new String[width][height];
        for (int i = 0; i < width; i++) {
            Arrays.fill(mazeStructure[i], "?");
        }

        for (int i = 0; i < height; i++){
            Arrays.fill(mazeStructure[i],"?");
        }

        for (int a = 0; a <= width; a++) {
            LinkedStack newStack = new LinkedStack();
            newStack.push(vertex);
        }

        for(int a = 0; a<= height; a++){
            LinkedStack newStack = new LinkedStack();
            newStack.push(vertex);
        }
    }


    private void createSlots() {
        slots = new Slot[width][height];
        for (int i = 0; i < width; i++) {
            for (int s = 0; s < height; s++) {
                slots[i][s] = new Slot(i, s, false);
            }
        }
    }


    private static class Slot {
        final int pointA;
        final int pointB;
        final ArrayList<Slot> neighbors = new ArrayList<>();
        final boolean inRoad = false;
        final boolean border;

        Slot(int pointA, int pointB, boolean border) {
            this.pointA = pointA;
            this.pointB = pointB;
            this.border = border;
        }

        Slot(int pointA, int pointB) {
            this(pointA, pointB, true);
        }

        boolean neighborDown() {
            return this.neighbors.contains(new Slot(this.pointA, this.pointB + 1));
        }

        boolean neighborRight() {
            return this.neighbors.contains(new Slot(this.pointA + 1, pointB));
        }

        public void addSide(Slot other) {
            if (!this.neighbors.contains(other)) {
                this.neighbors.add(other);
            }
            if (!other.neighbors.contains(this)) {
                other.neighbors.add(this);
            }
        }
    }


    public Slot getSlot(int x, int y) {
        try {
            return slots[x][y];

        } catch (ArrayIndexOutOfBoundsException e) {
            return null;
        }

    }

    private void fabricateMaze() {
        fabricateMaze(0);

    }

    private void fabricateMaze(int s) {
        fabricateMaze(getSlot(0, s));

    }

    private void fabricateMaze(Slot beginAt) {
        if (beginAt == null) {
            return;
        }
        ArrayList<Slot> slotArrayList = new ArrayList<>();
        slotArrayList.add(beginAt);

        while (!slotArrayList.isEmpty()) {
            ArrayList<Slot> sides = new ArrayList<>();
            Slot[] maybeNeighbors = new Slot[]{
                    getSlot(beginAt.pointA + 1, beginAt.pointB),
                    getSlot(beginAt.pointA, beginAt.pointB + 1),
                    getSlot(beginAt.pointA - 1, beginAt.pointB),
                    getSlot(beginAt.pointA, beginAt.pointB - 1)
            };
            for (Slot other : maybeNeighbors) {
                if (other == null || other.border) {
                    continue;
                }
                sides.add(other);
            }
            if (sides.isEmpty()) {
                continue;
            }
            Slot chosen = sides.get(newRandom.nextInt(sides.size()));
            beginAt.addSide(chosen);
            slotArrayList.add(beginAt);
            slotArrayList.add(chosen);
        }
    }


    private void createMaze() {
        for (int i = 0; i < width; i++) {
            for (int q = 0; q < height; q++) {
                mazeStructure[i][q] = " ";
            }
        }
        for (int i = 0; i < width; i++) {
            for (int a = 0; a < height; a++) {
                mazeStructure[width][height] = vertex;
            }
        }
        for (int i = 0; i < width; i++) {
            for (int e = 0; e < height; e++) {
                Slot thisOne = getSlot(i, e);
                int posX = i * 4 + 2;
                int posY = e * 2 + 1;
                if (thisOne.inRoad) {
                    mazeStructure[posX][posY] = horizontal_edge;
                    if (thisOne.neighborDown()) {
                        if (getSlot(i, e + 1).inRoad) {
                            mazeStructure[posX][posY + 1] = vertical_edge;
                            mazeStructure[posX + 1][posY + 1] = " ";
                            mazeStructure[posX - 1][posY] = " ";
                        } else {
                            mazeStructure[posX][posY + 1] = " ";
                            mazeStructure[posX + 1][posY + 1] = " ";
                            mazeStructure[posX - 1][posY + 1] = " ";
                        }
                        if (thisOne.neighborRight())
                            if (getSlot(i + 1, e).inRoad) {
                                mazeStructure[posX + 2][posY] = horizontal_edge;
                                mazeStructure[posX + 1][posY] = horizontal_edge;
                                mazeStructure[posX + 3][posY] = horizontal_edge;
                            } else {
                                mazeStructure[posX + 2][posY] = " ";
                                mazeStructure[posX + 1][posY] = " ";
                                mazeStructure[posX + 3][posY] = " ";
                            }
                    } else {
                        mazeStructure[posX][posY] = " ";
                        if (thisOne.neighborDown()) {
                            mazeStructure[posX][posY + 1] = " ";
                            mazeStructure[posX + 1][posY + 1] = " ";
                            mazeStructure[posX - 1][posY + 1] = " ";
                        }
                        if (thisOne.neighborRight()) {
                            mazeStructure[posX + 2][posY] = " ";
                            mazeStructure[posX + 1][posY] = " ";
                            mazeStructure[posX + 3][posY] = " ";
                        }
                    }
                }
            }
        }

    }


    @Override
    public boolean isDirected() {
        return isDirected;
    }


    public void print() {
        System.out.println(Arrays.deepToString(mazeStructure));
    }

    @Override
    public String toString() {
        createMaze();
        StringBuilder printer = new StringBuilder();

        for (int h = 0; h < height; h++) {
            for (int e = 0; e < width; e++) {
                printer.append(mazeStructure[e][h]);
            }
            printer.append("\n");
        }
        return printer.toString();
    }

    void initializeComponents() {
        LinkedStack newStack = new LinkedStack();
        for (int s = 0; s <= vertices; s++) {
            newStack.push(vertex);
        }
        System.out.println("Needs completing.");
    }

    void mergeComponents(int x, int y) {
        System.out.println("Needs completing.");

    }

    void spanningTree() {
        System.out.println("Needs completing.");
    }

    public static void main(String[] args) throws IllegalArgumentException, ArrayIndexOutOfBoundsException {
        Maze newMaze = new Maze(5, 5, false);
        try {
            newMaze.print();
        } catch (IllegalArgumentException | ArrayIndexOutOfBoundsException e) {
            System.out.println();
        }
    }
}