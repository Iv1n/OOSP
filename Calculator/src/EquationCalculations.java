import java.util.Scanner;

public class EquationCalculations {
    public static String uravn;

    public void enub(){
        System.out.println("Введите уровнение :");
        Scanner scanner = new Scanner(System.in);
        uravn = scanner.nextLine();

        Calculations calculations = new Calculations();
        calculations.analiz(uravn);

        String nub = String.valueOf(calculations.calculate());
        System.out.println(uravn + " = "+ nub);
        String n = uravn + " = " + nub;

        PastCalculatins past = new PastCalculatins();
        past.uravneny(n);

        WorkingWithNotepad notePad = new WorkingWithNotepad();
        notePad.writingToFile(n);

        UI ui = new UI();
        ui.menu();

    }



}
