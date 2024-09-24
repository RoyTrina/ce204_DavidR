package Workingcode;

import java.util.Random;

public class SetPartitionCopy {
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

    public SetPartitionCopy(int numElements) {
        this.numElements = numElements;

        parentArray = new int[numElements];

        for (int i = 0; i <= parentArray.length; i++) {
            int setNumber = 0;
            setNumber += i;
            System.out.print("{" + setNumber + "}");
        }
        System.out.print("\n");
    }

    private final int root = 0;

    public int getRoot(int x) {
        if (x == parentArray[x]) {
            parentArray[x] = parentArray[root];
        } else {
            getRoot(parentArray[x + 1]);
        }
        return x;
    }


    public boolean inSameSubset(int x, int y) throws StackOverflowError {
        try {
            if (parentArray[0] == x || parentArray[0] == y) {
                parentArray[0] = root;
                return true;
            }
        } catch (StackOverflowError e) {
            System.out.println("There is an error.");
        }
        return false;
    }


    public void merge(int x, int y) throws ArrayIndexOutOfBoundsException {
        try {
            if (parentArray[x] == parent(x) && parent(x) == y) {
                System.out.println("The numbers are in the same subset");
            } else {
                int rootAtY;
                //noinspection SuspiciousNameCombination
                rootAtY = getRoot(y);
                System.out.println("The root at y is: " + rootAtY);
                System.out.println("\n");
                int n = parent(setRoot());
                System.out.println("The parent of n is:" + n);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            e.addSuppressed(new ArrayIndexOutOfBoundsException());
        }
    }

    public int depth(int x) {
        if (parentArray[x] == 0) return 0;
        else return (int) Math.pow(2, x + 1) - 1;
    }

    public int maxDepth() throws ArrayIndexOutOfBoundsException {
        try {
            if (isFull()) return 31;
            if (isEmpty()) {
                return 0;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            e.addSuppressed(new ArrayIndexOutOfBoundsException());
        }
        return Math.max(parentArray[0], depth(parentArray[Math.max(parentArray[0], parentArray[numElements - 1])]));
    }

    public int parent(int index) {
        return (index - 1) / 2;
    }

    public int setRoot() {
        return root;
    }


    public static void main(String[] args) {
        Random random = new Random();
        SetPartitionCopy newPartition = new SetPartitionCopy(1000);
        System.out.print("\n");
        System.out.print("\n");


        for (int a = 0; a <= 1000; a++) newPartition.merge(a, a + 1);
        System.out.println("The max depth is: " + newPartition.maxDepth());
        System.out.print("\n");
        System.out.print("\n");

        for (int b = 1000; b >= 1000; b--) newPartition.merge(b, b - 1);
        System.out.println("The max depth is: " + newPartition.maxDepth());
        System.out.print("\n");
        System.out.print("\n");

        System.out.println(newPartition.getRoot(100));

        for (int c = 0; c <= newPartition.numElements; c++) {
            new SetPartitionCopy(1000);
            for (int d = 0; d <= 749; d++) {
                int x = random.nextInt();
                int y = random.nextInt();
                newPartition.merge(x, y);
            }
        }
        System.out.print("\n");
        System.out.print("\n");
    }

}

