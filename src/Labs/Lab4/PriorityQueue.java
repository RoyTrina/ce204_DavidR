package Labs.Lab4;

import java.util.Arrays;
import java.util.Collections;

public class PriorityQueue {

    public void setPriority(double newDistance, int y) {
    }

    /*
     *  An exception that will be thrown by next() if called on an empty
     *  priority queue. This allows all integer priorities to be stored,
     *  instead of, e.g., reserving negative priorities to mean errors.
     */
    public static class EmptyException extends RuntimeException {
    }

    private static class Node {
        final int priority;
        final Object data;

        Node(int priority, Object data) {
            this.priority = priority;
            this.data = data;
        }
    }

    private Node[] items = new Node[10];
    private int size = 0;

    /*
     *  Functions to calculate the indices of children and parents in
     *  the array.
     */
    private static int leftChild(int index) {
        return 2 * index + 1;
    }

    private static int rightChild(int index) {
        return 2 * index + 2;
    }

    private static int parent(int index) {
        return (index - 1) / 2;
    }

    /*
     *  The function swap() swaps the entries at indices index1 and
     *  index2 in the array.
     */
    private void swap(int index1, int index2) {
        Node temp = items[index1];

        items[index1] = items[index2];
        items[index2] = temp;
    }

    /*
    The function sort() sorts an array of integers into ascending or descending order
     */

    public static void sort(int[] ints, boolean ascending) {
        if (ascending) {
            Arrays.sort(ints);
            System.out.println("Sorted array in ascending order:  %s" + Arrays.toString(ints));
        } else {
            int[] desc_ints = Arrays.stream(ints).boxed().sorted(Collections.reverseOrder()).mapToInt(Integer::intValue).toArray();
            System.out.println("Sorted array in descending order: %s" + Arrays.toString(desc_ints));
        }
    }

    /*
     *  Insert an item with priority p.
     */
    public void insert(int p, Object obj) {
        /*
         *  Extend the array if it is full.
         */
        if (size == items.length) {
            Node[] newItems = new Node[size * 2];
            System.arraycopy(items, 0, newItems, 0, size);
            items = newItems;
        }

        /*
         *  We initially try to insert in the next available leaf
         *  position (at the end of the used part of the array).
         *  Then, as long as the priority being inserted is higher
         *  (a smaller number) than its parent, we swap it and the
         *  parent, moving up the tree.
         */
        int cur = size;


        items[size++] = new Node(p, obj);
        while (cur > 0 && items[cur].priority < items[parent(cur)].priority) {
            swap(cur, parent(cur));
            cur = parent(cur);
        }
    }

    /*
     *  Return the highest priority (the smallest number) in the tree. The
     *  value to be returned is the current root of the tree. We
     *  replace it in the tree with the value in the last leaf. As
     *  long as this value is bigger than one of its children, we
     *  swap it with its smallest child, moving it down the tree.
     */
    public Object next() throws EmptyException {
        if (isEmpty())
            throw new EmptyException();

        Node next = items[0]; /* Remember value at root. */
        size--;

        items[0] = items[size]; /* Move last leaf to root. */
        int cur = 0;
        while (true) {
            /*
             *  smallestInFamily(cur) returns the index of the node
             *  containing the smallest number, among cur, its left
             *  child (if it has one) and its right child (if it
             *  has one). If cur has a smaller child, swap it with
             *  that child. If it has no smaller child, we are done.
             */
            if (smallestInFamily(cur) == rightChild(cur)) {
                swap(cur, rightChild(cur));
                cur = rightChild(cur);
            } else if (smallestInFamily(cur) == leftChild(cur)) {
                swap(cur, leftChild(cur));
                cur = leftChild(cur);
            } else
                break;
        }
        return next;
    }

    /*
     *  smallestInFamily returns the index of the node containing the
     *  smallest value among 'index', 'index's left child (if it exists)
     *  and 'index's right child (if it exists). Note that, because of
     *  the way the tree is organized, if the right child exists, the
     *  left child must exist, too.
     */
    private int smallestInFamily(int index) {
        int lc = leftChild(index);
        int rc = rightChild(index);

        if (rc < size && items[rc].priority < items[index].priority
                && items[rc].priority < items[lc].priority)
            return rc;
        if (lc < size && items[lc].priority < items[index].priority)

            return lc;
        else
            return index;
    }


    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    void changePriority(int oldP, int newP) {
        Node node = new Node(oldP, "");
    }

    public boolean contains(Object obj) {

        return Arrays.asList(items).contains(Arrays.asList(items).get((Integer) obj));
    }

    void delete(int p) {
        Arrays.asList(items).remove(items[p]);
    }

    int insertThenNext(int p) {
        return p;
    }


    @Override
    public String toString() {
        return "PriorityQueue: {" +
                "items=" + Arrays.toString(items) +
                ", size=" + size +
                '}';
    }

    /*
     *  Test code to insert some values into the queue and check
     *  they come back out again.
     */
    public static void main(String[] args) {
        PriorityQueue pq = new PriorityQueue();

        for (int i = 0; i < 30; i++)
            pq.insert(i, i);

        while (!pq.isEmpty()) {
            //System.out.println(Arrays.toString(pq.items));
            System.out.println(pq.next());
        }
    }
}
