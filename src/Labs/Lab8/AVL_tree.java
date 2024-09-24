package Labs.Lab8;

import java.util.LinkedList;
import java.util.Queue;

public class AVL_tree {
    private static class Node {
        Node parent;
        Node left, right;
        final int value;
        int balance_factor;

        private Node(int value, Node parent) {
            this.value = value;
            this.parent = parent;
        }

        //Is this node its parent's left/right child? ("No", if parent==null.)

        private boolean isLeftChild() {
            return parent != null && parent.left == this;
        }

        private boolean isRightChild() {
            return parent != null && parent.right == this;
        }

        //Is this node left/right-heavy?

        private boolean isLeftHeavy() {
            return balance_factor < 0;
        }

        private boolean isRightHeavy() {
            return balance_factor > 0;
        }
    }

    /*
    Tree is initialized
     */
    private Node root = null;


    private Node findNode(int value) {
        Node current = root;

        while (current != null && value != current.value) {
            if (value < current.value) {
                if (current.left == null) {
                    break;
                } else {
                    current = current.left;
                }
            } else {
                /* value > current.value */
                if (current.right == null) {
                    break;
                } else {
                    current = current.right;
                }
            }
        }
        return current;
    }


    public boolean contains(int value) {
        Node node;
        node = findNode(value);

        return node != null && node.value == value;
    }

    public void insert(int value) {
        Node current;

        current = findNode(value);
        if (current == null) {
            root = new Node(value, null);
        } else if (value < current.value) {
            current.left = new Node(value, current);
            current.left.balance_factor--;
        } else {
            current.right = new Node(value, current);
            current.balance_factor++;
        }
        while (true) {
            assert current != null;
            if (!(current.parent != null && (current.balance_factor == -1 || current.balance_factor == 1))) break;
            if (current.isLeftChild()) {
                current.parent.balance_factor--;
            } else {
                current.parent.balance_factor++;
            }
            current = current.parent;
        }

        if (current.balance_factor == -2) {
            if (current.left.isLeftHeavy()) {
                rotateRight(current);
            } else {
                rotateLeftRight(current);
            }
        } else if (current.balance_factor == 2) {
            if (current.right.isRightHeavy()) {
                rotateLeft(current);
            } else {
                rotateRightLeft(current);
            }
        }
    }

    /*************************************************************
     --Commented out by Inspection START (01/08/2021 18:07):
     --Commented out by Inspection START (01/08/2021 18:07):
     * Test methods
     *
     --Commented out by Inspection STOP (01/08/2021 18:07)
     */

    private void inOrderTraversal() {
        if (root != null) {
            inOrderTraversal(root);
            System.out.println();
        }
    }

    private void inOrderTraversal(Node node) {
        if (node.left != null) {
            inOrderTraversal(node.left);
            System.out.print(node.value + " (" + node.balance_factor + ") ");
        }
        if (node.right != null) {
            inOrderTraversal(node.right);
        }
    }

    private void insertWithCommentary(int[] ints) {
        for (int i : ints) {
            insert(i);
            inOrderTraversal();
        }
    }


    private void rotateLeft(Node x) {
        System.out.println("rotateLeft at: " + x.value);

        Node r = x.right;
        Node w = r.left;

        x.right = w;
        if (w != null) {
            w.parent = x;
        }
        r.left = x;

        r.parent = x.parent;
        if (x.isLeftChild()) {
            r.parent.left = r;
        } else if (x.isRightChild()) {
            r.parent.right = r;
        } else {
            root = r;
            x.parent = r;
        }
        x.balance_factor = r.balance_factor = 0;
    }


    private void rotateRight(Node x) {
        System.out.println("rotateRight at: " + x.value);

        Node t = x.left;
        Node g = t.right;

        x.left = g;
        if (g != null) {
            g.parent = x;
        }
        t.right = x;

        t.parent = x.parent;
        if (x.isLeftChild()) {
            t.parent.left = t;
        } else if (x.isRightChild()) {
            t.parent.right = t;
        } else {
            root = t;
            x.parent = t;
        }
        x.balance_factor = t.balance_factor = 0;
    }

    private void rotateRightLeft(Node x) {
        System.out.println("rotateRightLeft at: " + x.value);
        rotateRight(x.right);
        rotateLeft(x);

    }

    private void rotateLeftRight(Node x) {
        System.out.println("rotateLeftRight at: " + x.value);
        rotateLeft(x.left);
        rotateRight(x);

    }


    private int calculateHeight(Node node) {
        root = node;
        if (node == null) {
            return -1;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        int height = -1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            height++;
            while (size > 0) {
                Node secondNode = queue.remove();
                if (secondNode.left != null) {
                    queue.add(secondNode.left);
                }
                if (secondNode.right != null) {
                    queue.add(secondNode.right);
                }
                size--;
            }
        }
        return height;
    }


    public static void main(String[] args) {
        System.out.println("Insertion order 4,7,9: should cause left-rotation");
        new AVL_tree().insertWithCommentary(new int[]{4, 7, 9});

        System.out.println("\nInsertion order 9,7,4: should cause right-rotation");
        new AVL_tree().insertWithCommentary(new int[]{9, 7, 4});

    }

}
