package Calculate;

public class Calcul {

    public static int expr(Lexem.LexemeBuffer lexemes) {
        Lexem.Lexeme lexeme = lexemes.next();
        if (lexeme.type == Lexem.LexemType.EOF) {
            return 0;
        } else {
            lexemes.back();
            return plusminus(lexemes);
        }
    }

    public static int plusminus(Lexem.LexemeBuffer lexemes) {
        int value = multdiv(lexemes);
        while (true) {
            Lexem.Lexeme lexeme = lexemes.next();
            switch (lexeme.type) {
                case op_plus:
                    value += multdiv(lexemes);
                    break;
                case op_minus:
                    value -= multdiv(lexemes);
                    break;
                case EOF:
                case rigth_bracket:
                    lexemes.back();
                    return value;
            }
        }
    }

    public static int multdiv(Lexem.LexemeBuffer lexemes) {
        int value = factor(lexemes);
        while (true) {
            Lexem.Lexeme lexeme = lexemes.next();
            switch (lexeme.type) {
                case op_mul:
                    value *= factor(lexemes);
                    break;
                case op_div:
                    value /= factor(lexemes);
                    break;
                case EOF:
                case rigth_bracket:
                case op_plus:
                case op_minus:
                    lexemes.back();
                    return value;
            }

        }
    }

    public static int factor(Lexem.LexemeBuffer lexemes) {
        Lexem.Lexeme lexeme = lexemes.next();
        switch (lexeme.type) {
            case number:
                return Integer.parseInt(lexeme.value);
            case left_bracket:
                int value = plusminus(lexemes);
                lexeme = lexemes.next();
                if (lexeme.type != Lexem.LexemType.rigth_bracket) {
                    throw new RuntimeException("Unexpected token: " + lexeme.value
                            + " at position: " + lexemes.getPos());
                }
                return value;
            default:
                throw new RuntimeException("Unexpected token: " + lexeme.value
                        + " at position: " + lexemes.getPos());
        }

    }
}
