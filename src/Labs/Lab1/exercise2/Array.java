package Labs.Lab1.exercise2;


import java.util.ArrayList;

public class Array implements ArrayInt {
    private final ArrayList<Object> array;



    public Array() {
        array = null;
    }


    public void create(int length) {
        new ArrayList<>(length);
    }

    public void set(int index, Object value) {
        if (array != null) {
            array.set(index, value);
        }
    }

    @Override
    public Object get(int index) {
        if (array != null) {
            return array.get(index);
        }
        return null;
    }

// --Commented out by Inspection START (01/04/2022 19:39):
//    public ArrayList<Object> getArray() {
//        return array;
//    }
// --Commented out by Inspection STOP (01/04/2022 19:39)

    public static void main(String[] args){
        Array newArray = new Array();
        newArray.create(10);
    }
}
