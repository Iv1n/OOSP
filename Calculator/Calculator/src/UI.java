import java.util.Scanner;
public class UI {

    public void ui(){
        rules();
        menu();
    }
    public void rules(){
        System.out.println("--------------------Правила ввода---------------------");
        System.out.println("-Числа и матеметические операторы вводить через пробел \n" +
                "Пример: ( ( 5 + 2 ) * 2 ) / 1.5\n" +
                "-Дробные числа вводить через .\n" +
                "-Если поставить в самом начале уровнения -, будет ошибка D:\n" +
                "Пример как не надо делать: - 5 + 6");
    }
    public void menu(){
        System.out.println("---------------------Калькулятор----------------------");
        System.out.println("Чтобы открыть прошлые вычисления нажмите 1");
        System.out.println("Чтобы получить решение нажмите 2");
        System.out.println("Чтобы выйти нажмите 3");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (n==1 | n==2 | n==3) {
            if (n == 1) {
                PastCalculatins pastCalculatins = new PastCalculatins();
                pastCalculatins.pastUr();
            }
            if (n == 2) {
                EquationCalculations op = new EquationCalculations();
                op.enub();
            }
            if (n == 3) {
                System.out.println("До Свидания");
                System.exit(0);
            }
        }
        else {
            System.out.println("Вы выбрали не существующие действие");
        }
    }
}
