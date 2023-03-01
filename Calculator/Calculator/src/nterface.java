import java.util.Scanner;

public class nterface {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();

    public void gnterface(){
        System.out.println("Чтоб провести вычисления нажмите 1");
        System
        if(n==1){
            System.out.println("Прошлые вычисления");
        }
        if(n==2){
            System.out.println("Ввести уравнения");
            EquationCalculations op = new EquationCalculations();
            op.enub();
        }
        if(n==3){
            System.out.println("Выход");
        }
    }

    public nterface() {
        this.scanner = scanner;
        this.n = n;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }
}
