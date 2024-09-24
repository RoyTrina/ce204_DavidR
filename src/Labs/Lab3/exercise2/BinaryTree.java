package Labs.Lab3.exercise2;

public class BinaryTree {
    private final String value;
    private final BinaryTree leftTree;
    private final BinaryTree rightTree;

    public BinaryTree(String value) {
        this(value, null, null);
    }

    public BinaryTree(String value, BinaryTree leftTree, BinaryTree rightTree) {
        this.value = value;
        this.leftTree = leftTree;
        this.rightTree = rightTree;
    }


    boolean isLeaf() {
        return leftTree == null && rightTree == null;
    }


    BinaryTree leftTreeChild() {
        return leftTree;
    }

    BinaryTree rightTreeChild() {
        return rightTree;
    }


    String value() {
        return value;
    }


    boolean contains(String s) {
        return (value != null && value.equals(s)) || (leftTree != null && leftTree.contains(s)) || (rightTree != null && rightTree.contains(s));
    }

    void join(String s, BinaryTree leftTree, BinaryTree rightTree) {
        new BinaryTree(s, leftTree, rightTree);
    }


    void preOrder() {
        System.out.println(value);
        if (leftTree != null) leftTree.preOrder();
        if (rightTree != null) rightTree.preOrder();
    }


    void inOrder() {
        if (leftTree != null) leftTree.inOrder();
        System.out.println(value);
        if (rightTree != null) rightTree.inOrder();
    }

    void postOrder() {
        if (leftTree != null) leftTree.postOrder();
        if (rightTree != null) rightTree.postOrder();
        System.out.println(value);
    }
}
