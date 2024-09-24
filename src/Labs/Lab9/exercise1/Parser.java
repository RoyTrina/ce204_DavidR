package Labs.Lab9.exercise1;

import java.util.Objects;

public class Parser {
    private final Lexer lexer;

    public Parser(Lexer lexer) {
        this.lexer = lexer;
    }

    public ParseTree parse() {
        return parseEXPR();
    }

    private ParseTree parseEXPR() {
        ParseTree left = parseVAL();
        char operator = parseOP();
        ParseTree right = parseVAL();

        return new ParseTree.OperatorNode(operator, left, right);
    }


    private char parseOP() {
        return switch (lexer.nextToken().type) {
            case Token.PLUS -> '+';
            case Token.MINUS -> '-';
            case Token.TIMES -> '*';
            case Token.DIVIDE -> '/';
            default -> throw new IllegalStateException("Unexpected value: " + lexer.nextToken().type);
        };

    }

    private ParseTree parseVAL() {
        Token t = lexer.nextToken();
        switch (t.type) {
            case Token.NUMBER -> {
                return new ParseTree.NumberNode(Integer.parseInt(!Objects.equals(t.value, String.valueOf(null)) ? Objects.requireNonNull(t.value) : String.valueOf(null)));
            }
            case Token.LEFT_PARENT -> {
                ParseTree tree = parseEXPR();
                if (lexer.nextToken().type != Token.RIGHT_PARENT) {
                    throw new IllegalArgumentException();
                }
                return tree;
            }
            default -> throw new IllegalArgumentException();
        }
    }


    private ParseTree parseExp() {
        ParseTree tree = parseTERM();

        int next = lexer.lookAhead().type;
        while (next == Token.PLUS || next == Token.MINUS) {
            Token t = lexer.nextToken();
            char operator = (t.type == Token.PLUS) ? '+' : '-';
            tree = new ParseTree.OperatorNode(operator, tree, parseTERM());
            next = lexer.lookAhead().type;
        }
        return tree;
    }

    private ParseTree parseTERM() {
        ParseTree tree = parsePOW();

        int next = lexer.lookAhead().type;
        while (next == Token.PLUS || next == Token.MINUS) {
            Token t = lexer.nextToken();
            char operator = (t.type == Token.PLUS) ? '+' : '-';
            tree = new ParseTree.OperatorNode(operator, tree, parseTERM());
            next = lexer.lookAhead().type;
        }
        return tree;
    }

    private ParseTree parsePOW() {
        ParseTree left = parseVAL();
        if (/*lexer.lookAhead() != null &&*/ lexer.lookAhead().type == Token.POWER) {
            lexer.nextToken();
            left = new ParseTree.OperatorNode('^', left, parsePOW());

        }
        return left;
    }
}
