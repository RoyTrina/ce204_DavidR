package Labs.Lab6.exercise2;

import java.util.ArrayList;

public class Selection_sort {
    private final ArrayList<Object> input;
    private ArrayList<Object> output;

    public Selection_sort(ArrayList<Object> input) {
        this.input = input;

        for (int i = 0; i <= input.size(); i++) {
            input.add(i);
        }
    }


    public Object sort() {
        output = new ArrayList<>();
        int smallestItem = input.indexOf(0);


        while (!input.isEmpty()) {
            input.remove(smallestItem);
            output.add(smallestItem);
        }
        return null;
    }


    public static void main(String[] args) {
        Selection_sort newSort = new Selection_sort(new ArrayList<>());
        newSort.sort();

    }

    public ArrayList<Object> getOutput() {
        return output;
    }

    public void setOutput(ArrayList<Object> output) {
        this.output = output;
    }
}
