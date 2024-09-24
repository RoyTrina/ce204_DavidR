package Labs.Lab8;

/***********************************************************************
 *  Lab 8, exercise 1                                                  *
 ***********************************************************************
 *  An implementation of binary search trees, suitable for extension to
 *  an implementation of AVL trees.
 */
public class BST {
    /*
     *  Standard binary search tree node, plus a field to store the
     *  balance factor.
     */
    private static class Node {
        final Node parent;
        Node left, right;
        final int value;
        int bf;

        /*
         *  Constructor. Newly-created nodes have no children, so the
         *  default initializers of left = right = null and bf = 0 are
         *  correct.
         */
        private Node(int value, Node parent) {
            this.value = value;

            this.parent = parent;
        }

        /*
         *  Is this node its parent's left/right child? ("No", if
         *  parent==null.)

         */
        private boolean isLeftChild() {
            return parent != null && parent.left == this;


        }

        private boolean isRightChild() {
            return parent != null && parent.right == this;

        }

        /*
         *  Is this node left/right-heavy?
         */
        private boolean isLeftHeavy() {
            return bf < 0;
        }

        private boolean isRightHeavy() {
            return bf > 0;
        }
    }

    /*
     *  Tree is initialized to be empty.
     */
    private Node root = null;

    /*
     *  findNode is a helper method that's useful for both insert and
     *  contains. If the tree is empty, it returns null. Otherwise, it
     *  returns either the node containing 'value' or the node that
     *  will be the parent of 'value' when 'value' is inserted.
     */
    private Node findNode(int value) {
        Node cur = root;

        while (cur != null && value != cur.value) {
            if (value < cur.value) {
                if (cur.left == null)
                    break;
                else cur = cur.left;
            } else /* value > cur.value */ {
                if (cur.right == null)
                    break;
                else cur = cur.right;

            }
        }
        return cur;
    }

    /*
     *  Find if a value is in the tree by calling findNode and seeing
     *  if the resulting node holds the value we're looking for.
     */
    public boolean contains(int value) {
        Node node = findNode(value);
        return node != null && node.value == value;

    }

    /*
     *  Insert a value into the tree. This requires inserting as in an
     *  ordinary BST, then adjusting balance factors, then possibly
     *  performing rotations.
     */
    public void insert(int value) {
        Node cur;

        cur = findNode(value);
        if (cur == null)
            root = new Node(value, null);
        else if (value < cur.value)
            cur.left = new Node(value, cur);
        else
            cur.right = new Node(value, cur);
    }

    /***********************************************************************
     *  Test methods                                                       *
     **********************************************************************/

    /*
     *  inOrderTraversal prints out all the nodes in order, with their
     *  balance factors.
     */
    private void inOrderTraversal() {
        if (root != null) {
            inOrderTraversal(root);
            System.out.println();
        }
    }

    private void inOrderTraversal(Node node) {
        if (node.left != null)
            inOrderTraversal(node.left);
        System.out.print(node.value + " (" + node.bf + ") ");
        if (node.right != null)
            inOrderTraversal(node.right);
    }

    /*
     *  insertWithCommentary inserts all the integers from an array and
     *  prints out the tree contents after each one.
     */
    private void insertWithCommentary(int[] ints) {
        for (int i : ints) {
            insert(i);
            inOrderTraversal();
        }
    }

    public static void main(String[] args) {
        System.out.println("Insertion order 1,2,3: should cause left-rotation");
        new BST().insertWithCommentary(new int[]{1, 2, 3});

        System.out.println("\nInsertion order 3,2,1: should cause right-rotation");
        new BST().insertWithCommentary(new int[]{3, 2, 1});
    }
}