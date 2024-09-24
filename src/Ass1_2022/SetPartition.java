package Ass1_2022;

import java.util.Arrays;
import java.util.Random;

public class SetPartition {
    private final int numElements;
    private final int[] parentArray;

    public int getNumElements() {
        return numElements;
    }

    public boolean isEmpty() {
        return parentArray[numElements] == 0;
    }

    public boolean isFull() {
        if (isEmpty()) {
            System.out.println("The set partition is empty.");
            return false;
        } else {
            return true;
        }
    }


    public SetPartition(int numElements) {
        this.numElements = numElements;

        parentArray = new int[numElements];

        for (int i = 0; i <= parentArray.length; i++) {
            int setNumber = 0;
            setNumber += i;
            System.out.print("{" + setNumber + "}");
        }
        System.out.print("\n");


    }

    private int root = 0;


    public int getRoot(int x) {
        if (x == parentArray[x]) {
            setRoot(x);
        } else {
            getRoot(parentArray[x + 1]);
        }
        return parentArray[x];
    }


    public boolean inSameSubset(int x, int y) throws StackOverflowError {
        try {
            if (parentArray[0] == x && parentArray[0] == y) {
                parentArray[0] = root;
                return true;
            }
        } catch (StackOverflowError e) {
            System.out.println("There is an error.");
        }
        return false;
    }


    public void merge(int x, int y) throws ArrayIndexOutOfBoundsException {
        int[] rootTracker = new int[parentArray.length];
        Arrays.fill(rootTracker, 1);

        try {
            if (parentArray[x] == parent(x) && parent(x) == y) {
                System.out.println("The numbers are in the same subset");
            } else if (!(parentArray[x] == parent(x)) && parent(x) == y) {
                int X_root = rootTracker[x];
                int Y_root = rootTracker[y];

                if (rootTracker[X_root] == parentArray[X_root] && rootTracker[Y_root] == parentArray[Y_root]) {
                    rootTracker[X_root] = 0;
                    rootTracker[Y_root] = 0;
                }
                parentArray[Y_root] = X_root;
                System.out.println(parentArray[x] + "is the root");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            e.addSuppressed(new ArrayIndexOutOfBoundsException());
        }
    }

    public int depth(int x) {
        if (root == 0) {
            return 0;
        }
        for (int e = 0; e <= parentArray.length; e++) {
            x = Math.max(x, depth(x));
        }
        return x + 1;
    }


    public int maxDepth() {
        int depth = 0;

        if (root == 0) {
            return depth;
        }

        if (isEmpty()) {
            return -1;
        }

        for (int w = 0; w <= parentArray.length; w++) {
            depth = Math.max(depth, maxDepth());
        }
        return depth + 1;
    }


    public int parent(int index) {
        return (index - 1) / 2;
    }


    public int setRoot(int number) {
        if (number == parentArray[number]) {
            root = parentArray[number];
        } else {
            return 0;
        }
        return root;
    }


    public static void main(String[] args) throws Exception {
        Random random = new Random();
        SetPartition newPartition = new SetPartition(1000);
        System.out.print("\n");


        for (int a = 0; a <= 1000; a++) newPartition.merge(a, a + 1);
        int firstMax = newPartition.maxDepth();
        System.out.println("The max depth is: " + firstMax);
        System.out.print("\n");
        System.out.print("\n");

        for (int b = 1000; b >= 1000; b--) newPartition.merge(b, b - 1);
        int secondMax = newPartition.maxDepth();
        System.out.println("The max depth is: " + secondMax);
        System.out.print("\n");
        System.out.print("\n");


        for (int c = 0; c <= newPartition.numElements; c++) {
            new SetPartition(1000);
            System.out.print("\n");
            for (int d = 0; d <= 749; d++) {
                int x = random.nextInt();
                int y = random.nextInt();
                newPartition.merge(x, y);
            }
        }
        System.out.println("The average maximum node depth is: " + Math.addExact(firstMax, secondMax) / newPartition.numElements);
        System.out.print("\n");
        System.out.print("\n");
    }
}
