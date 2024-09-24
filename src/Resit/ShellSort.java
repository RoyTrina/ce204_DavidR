package Resit;

import java.util.Arrays;
import java.util.Random;

public class ShellSort {
    private final int length;
    private static final int[] Int_array = new int[10];

    ShellSort(int length) {
        this.length = length;
    }

    public boolean isEmpty() {
        return length == 0;

    }

    public boolean isFull() {
        return Int_array.length == length;

    }

    public int length() {
        if (isEmpty()) {
            System.out.println("The array is empty.");
        } else if (isFull()) {
            System.out.println("The array is full.");
        }
        return Int_array.length;
    }

    private static void sort(int[] a) {
        int gap = a.length / 2;
        int counter = 0;


        while (gap >= 1) {
            for (int i = 0; i <= counter; i++) {
                for (int q = 0; q <= gap; q++) {
                    int j = i;
                    j++;
                    while (a[j] > a[j - gap]) {
                        exchange(a[j], a[gap]);
                        j = j - gap;
                    }
                    gap = gap / 2;
                }
            }

        }


    }


    static void exchange(int index, int second_index) {
        int[] sr = new int[30];
        int number = sr[index];
        sr[index] = sr[second_index];
        sr[second_index] = number;
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
        String s = "\r\n";
        int[] newArray = randomIntArray(20, 10);

        System.out.println("Array before sorting: " + Arrays.toString(newArray) + s);
        sort(newArray);

        for (int i = 0; i <= newArray.length; i++) {
            newArray[i + 1] = newArray[i];
            i--;
        }

        System.out.println("Array after sorting: " + Arrays.toString(newArray));


    }


}
