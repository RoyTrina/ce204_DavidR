package Labs.Lab9.exercise1;

public class Token {
    static final int NUMBER = 0;
    static final int PLUS = 1;
    static final int MINUS = 2;
    static final int TIMES = 3;
    static final int DIVIDE = 4;
    static final int POWER = 5;
    static final int LEFT_PARENT = 6;
    static final int RIGHT_PARENT = 7;


    final int type;
    final String value;


    Token(int type) {
        this.type = type;
        this.value = null;
    }

    Token(int type, String value) {
        this.type = type;
        this.value = value;
    }


}
