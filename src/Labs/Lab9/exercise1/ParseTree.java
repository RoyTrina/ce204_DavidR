package Labs.Lab9.exercise1;

public abstract class ParseTree {
    ParseTree left, right;

    static class NumberNode extends ParseTree {
        final int value;

        NumberNode(int value) {
            this.value = value;
        }
    }

    static class OperatorNode extends ParseTree {
        final char value;

        OperatorNode(char op, ParseTree left, ParseTree right) {
            this.value = op;
            this.left = left;
            this.right = right;
        }
    }
}
