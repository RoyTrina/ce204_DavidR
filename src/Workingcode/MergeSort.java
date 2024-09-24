package Workingcode;

import java.util.Arrays;
import java.util.Random;

public class MergeSort {
    private static final Random nG = new Random();

    /*public static void findSort(Array arr, int left, int middle, int right) {
        int number = middle - left + 1;
        int number2 = right - middle;

        Array leftSide = new Array(number);
        Array rightSide = new Array(number2);

        for (int i = 0; i <= array.length(); i++) {


        }

        for (int e = 0; e <= array.length(); e++) {

        }
        System.arraycopy(array, left, leftSide, 0, number);
        System.arraycopy(array, right, rightSide, 0, number2);

        int s = 0, r = 0;

        int k = left;
        while (s < number && r < number2) {
            if (leftSide.getIndex(s) <= rightSide.getIndex(r)) {
                array.getIndex(k) = leftSide.getIndex(s);
                s++;
            } else {
                array[k] = rightSide[r];
                r++;
            }
            k++;
        }

        while (r < number2) {
            array[k] = rightSide[r];
            r++;
            k++;
        }


    }*/


    public void mergeSort(int[] array, int left, int middle, int right) {
        findSort(array, left, middle, right);

    }

    public static void findSort(int[] array, int left, int middle, int right) {
        int number = middle - left + 1;
        int number2 = right - middle;

        int[] leftSide = new int[number];
        int[] rightSide = new int[number2];

        System.arraycopy(array, left, leftSide, 0, number);
        System.arraycopy(array, right, rightSide, 0, number2);

        int s = 0, r = 0;

        int k = left;
        while (s < number && r < number2) {
            if (leftSide[s] <= rightSide[r]) {
                array[k] = leftSide[s];
                s++;
            } else {
                array[k] = rightSide[r];
                r++;
            }
            k++;
        }

        while (r < number2) {
            array[k] = rightSide[r];
            r++;
            k++;
        }
    }


    public static int[] randomIntArray(int number, int range) {
        Random numberGenerator = new Random();
        int[] rA = new int[number];
        for (int i = 0; i < rA.length; i++) {
            rA[i] = numberGenerator.nextInt(range);
        }
        return rA;
    }

    public static void main(String[] args) {
        int[] newArray = randomIntArray(10, 10);

        int number1 = nG.nextInt(10);
        int number2 = nG.nextInt(10);
        int number3 = nG.nextInt(10);

        System.out.println("The array is: " + Arrays.toString(newArray));
        MergeSort newSort = new MergeSort();
        newSort.mergeSort(newArray, number1, number2, number3);

    }

}
