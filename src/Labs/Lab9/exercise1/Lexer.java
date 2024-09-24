package Labs.Lab9.exercise1;

import java.io.BufferedReader;

public class Lexer {

    private static BufferedReader buf = null;

    int token;
    String id_val;
    int num_val;

    public Lexer(String s) {
        this(s, buf);
    }

    public Lexer(String s, BufferedReader buf) {
        Lexer.buf = buf;
    }

    public String getId_val() {
        return id_val;
    }

    public String getLine() {
        return "";
    }

    public int getToken() {
        return token;
    }

    public static BufferedReader getBuf() {
        return buf;
    }

    public int getNum_val() {
        return num_val;
    }

    public Token nextToken() {
        return new Token(num_val);
    }

    public Token lookAhead() {
        return null;
    }
}
