import java.util.Scanner;

public class EquationCalculations {
    String uravn;

    public EquationCalculations() {
        this.uravn = uravn;
    }
    public void enub(){
        System.out.println("Введите уровнение");
        Scanner scanner = new Scanner(System.in);
        uravn = scanner.next();
        System.out.println(uravn);
    }
}
