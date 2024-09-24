package Workingcode;

import java.util.LinkedHashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
         int x = 100;
        System.out.printf("Printing simple integer: x = %d\n", x);

        // this will print it up to 2 decimal places
        System.out.printf("Formatted with precision: PI = %.2f\n", Math.PI);

        float n = 5.2f;

        // automatically appends zero to the rightmost part of decimal
        System.out.printf("Formatted to specific width: n = %.4f\n", n);

        n = 2324435.3f;

        // here number is formatted from right margin and occupies a
        // width of 20 characters
        System.out.printf("Formatted to right margin: n = %20.4f\n", n);


        Set<String> stringSet = new LinkedHashSet<>();
        stringSet.add("1");
        stringSet.add("2");
        stringSet.add("3");
        stringSet.add("4");
        stringSet.add("5");
        stringSet.add("6");
        stringSet.add("27");
        stringSet.add("r3");
        stringSet.add("49");
        stringSet.add("559");
        stringSet.add("31");
        stringSet.add("23");
        stringSet.add("3w3");
        stringSet.add("34");
        stringSet.add("35");
        stringSet.add("113");
        stringSet.add("123");
        stringSet.add("133");
        stringSet.add("64");
        stringSet.add("54");
        stringSet.add("17");
        stringSet.add("20");
        stringSet.add("53");
        stringSet.add("42");
        stringSet.add("55");
        int i = 0;
        for (String value : stringSet) {
            if (i < stringSet.size() - 1) {
                System.out.print(value + ",");
            } else {
                System.out.print(value);
            }
            i++;
        }
    }
}

