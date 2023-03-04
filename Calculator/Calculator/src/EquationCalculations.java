
import Calculate.Calcul;
import Calculate.Lexem;

import java.util.List;
import java.util.Scanner;

public class EquationCalculations {
    public static String uravn;

    public EquationCalculations() {
        this.uravn = uravn;
    }
    public void enub(){
        System.out.println("Введите уровнение :");
        Scanner scanner = new Scanner(System.in);
        uravn = scanner.next();
        List<Lexem.Lexeme> lexemes = Lexem.lexAnalyze(EquationCalculations.uravn);
        Lexem.LexemeBuffer lexemeBuffer = new Lexem.LexemeBuffer(lexemes);
        int nub = Calcul.expr(lexemeBuffer);
        System.out.println(uravn + "="+ nub);
    }

}
