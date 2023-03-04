package Calculate;

import java.util.ArrayList;
import java.util.List;


public class Lexem {
    public enum LexemType{
        left_bracket, rigth_bracket,
        op_plus, op_minus, op_mul, op_div,
        number,
        EOF
    }

    public static class Lexeme {
        LexemType type;
        String value;

        public Lexeme(LexemType type, String value) {
            this.type = type;
            this.value = value;
        }

        public Lexeme(LexemType type, Character value) {
            this.type = type;
            this.value = value.toString();
        }

        @Override
        public String toString() {
            return "Lexeme{" +
                    "type=" + type +
                    ", value='" + value + '\'' +
                    '}';
        }
    }


    public static class LexemeBuffer {
        private int pos;
        public List<Lexeme> lexemes;

        public LexemeBuffer(List<Lexeme> lexemes) {
            this.lexemes = lexemes;
        }

        public Lexeme next() {
            return lexemes.get(pos++);
        }

        public void back() {
            pos--;
        }

        public int getPos() {
            return pos;
        }
    }

    public static List<Lexeme> lexAnalyze(String uravn) {
        ArrayList<Lexeme> lexemes = new ArrayList<>();
        int pos = 0;
        while (pos< uravn.length()) {
            char c = uravn.charAt(pos);
            switch (c) {
                case '(':
                    lexemes.add(new Lexeme(LexemType.left_bracket, c));
                    pos++;
                    continue;
                case ')':
                    lexemes.add(new Lexeme(LexemType.rigth_bracket, c));
                    pos++;
                    continue;
                case '+':
                    lexemes.add(new Lexeme(LexemType.op_plus, c));
                    pos++;
                    continue;
                case '-':
                    lexemes.add(new Lexeme(LexemType.op_minus, c));
                    pos++;
                    continue;
                case '*':
                    lexemes.add(new Lexeme(LexemType.op_mul, c));
                    pos++;
                    continue;
                case '/':
                    lexemes.add(new Lexeme(LexemType.op_div, c));
                    pos++;
                    continue;
                default:
                    if (c <= '9' && c >= '0') {
                        StringBuilder sb = new StringBuilder();
                        do {
                            sb.append(c);
                            pos++;
                            if (pos >= uravn.length()) {
                                break;
                            }
                            c = uravn.charAt(pos);
                        } while (c <= '9' && c >= '0');
                        lexemes.add(new Lexeme(LexemType.number, sb.toString()));
                    } else {
                        if (c != ' ') {
                            throw new RuntimeException("Unexpected character: " + c);
                        }
                        pos++;
                    }
            }
        }
        lexemes.add(new Lexeme(LexemType.EOF, ""));
        return lexemes;
    }

}
