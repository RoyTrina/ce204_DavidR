package Labs.Lab6.exercise2;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Insertion_sort {
    public static void insert_Sort(int[] array) throws ArrayIndexOutOfBoundsException {
        try {
            int n = array.length;

            for (int i = 0; i < n; i++) {
                int key = array[i];
                int j = i - 1;
                while ((j >= 1) && (array[j] > key)) {
                    array[i + 1] = array[i];
                    i--;
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("The array is too big.");

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
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the number of elements for the array:  ");
        int array_elements = input.nextInt();

        System.out.println("Please enter the range of elements for the array:  ");
        int range = input.nextInt();
        String s = "\r\n";
        int[] newArray = randomIntArray(array_elements, range);

        System.out.println("Array before sorting: " + Arrays.toString(newArray) + s);
        insert_Sort(newArray);
        System.out.println("Array after sorting: " + Arrays.toString(newArray));


    }

}
