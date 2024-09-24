package Labs.Lab4;


import java.util.Arrays;
import java.util.Random;

public class Heapsort {

    //Heapsort is specific to heap data structures, in other words trees.
    //

    public static void heapify(int[] array) {
        int root = array[0];

        int largest = Math.max(array[0], Math.max(array[1], array[2]));

        if (root != largest) {
            swap(root, largest);
        }
    }


    private static void swap(int number, int number2) {
        int setter;

    }

    public static int[] randomArray(int number, int range) {
        Random numberGenerator = new Random();
        int[] rA = new int[number];
        for (int i = 0; i < rA.length; i++) {
            rA[i] = numberGenerator.nextInt(range);
        }
        return rA;
    }

    public static void main(String[] args) {
        int[] heap = randomArray(10, 10);
        System.out.println("Before heapifying: " + Arrays.toString(heap));

        for (int i = 0; i <= heap.length; i++) {
            heapify(heap);
            System.out.println("After heapifying: " + Arrays.toString(heap));
        }


    }

}
