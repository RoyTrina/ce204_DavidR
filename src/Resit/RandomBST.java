package Resit;

import java.util.Objects;
import java.util.Random;

public class RandomBST {
    public RandomBST() {
        root = null;
    }

//    //public RandomBST(int value, double balanceValue, RandomBST l, RandomBST r) {
//        root = new Node(value, balanceValue, l.root, r.root);
//    }

    private RandomBST(Node n) {
        root = n;
    }

    private static class Node {
        public int value;
        public final double balanceValue;
        Node leftChild, rightChild;

        public Node(int value, double balanceValue) {
            this.value = value;
            this.balanceValue = balanceValue;
            leftChild = rightChild = null;
        }

        public Node(int value, double balanceValue, Node l, Node r) {
            this.value = value;
            this.balanceValue = balanceValue;
            leftChild = l;
            rightChild = r;
        }

        public boolean contains(int i) {
            //return (value != 0 && Integer.compare(value,i)) || (value != 0);
            if (value == 0 || Objects.equals(value, i)) {
                return true;
            }
            return (leftChild != null && leftChild.contains(i)) || (rightChild != null && rightChild.contains(i));
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

    }

    public Node leftChild;
    public Node rightChild;
    private static Node root;

    public Node left() {
        return leftChild;
    }

    public Node right() {
        return rightChild;
    }

    public void insert(int i) {
        Random newRandom = new Random();
        double random_number = newRandom.nextDouble();
        Node pointer;
        Node parent = null;

        if (root == null) {
            root = new Node(i, random_number);
            return;
        }
        pointer = root;

        while (true) {
            if (pointer.value == i) {
                return;
            } else if (pointer.value < i) {
                if (pointer.leftChild != null) {
                    pointer = pointer.leftChild;
                } else {
                    pointer.leftChild = new Node(i, random_number);
                    return;
                }
            } else {
                if (pointer.rightChild != null) {
                    pointer = pointer.rightChild;
                } else {
                    pointer.rightChild = new Node(i, random_number);
                }
            }
            if (Objects.requireNonNull(parent).balanceValue > pointer.balanceValue) {
                if (parent.leftChild != null) {
                    inOrderTraversal(parent.leftChild);
                    System.out.println();
                    if (pointer.rightChild != null) {
                        inOrderTraversal(pointer.rightChild);
                    }

                }
            }
        }

    }

    private void inOrderTraversal(Node node) {
        if (node.leftChild != null) {
            inOrderTraversal(node.leftChild);
            System.out.println();
            if (node.rightChild != null) {
                inOrderTraversal(node.rightChild);
            }
        }
    }


    private static int calculateHeight(Node node) {
        if (root == null) {
            return 0;
        }
        int left_sub_tree_height = calculateHeight(root.leftChild);
        int right_sub_tree_height = calculateHeight(root.rightChild);
        return Math.max(left_sub_tree_height, right_sub_tree_height) + 1;
    }

    public static void main(String[] args) {
        Random newRandom = new Random();
        RandomBST newTree = new RandomBST();

        double randomNumber = newRandom.nextDouble();

        for (int a = 0; a <= 1000; a++) {
            for (int i = 0; i <= 999; i++) {
                newTree.insert(i);
            }
        }


        int heightOfTree = calculateHeight(root);
    }


}