import java.util.Scanner;
public class UI {

    public void ui(){
        System.out.println("------Калькулятор------");
        System.out.println(" Чтобы открыть прошлые результаты нажмите 1");
        System.out.println(" Чтобы получить решение нажмите 2");
        System.out.println(" Чтобы выйти нажмите 3");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if(n==1){
        }
        if(n==2){
            EquationCalculations op = new EquationCalculations();
            op.enub();
        }
        if(n==3){
        }
    }


}
