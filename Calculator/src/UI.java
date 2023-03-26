import java.util.Scanner;
public class UI {

    public void ui(){
        rules();
        menu();
    }
    private void rules(){
        System.out.println("--------------------Правила ввода---------------------");
        System.out.println("-Числа и матеметические операторы вводить через пробел\n" +
                "Пример: ( ( 5 + 2 ) * 2 ) / 1.5\n" +
                "-Дробные числа вводить через .\n" +
                "-Если поставить в самом начале уровнения -, будет ошибка D:\n" +
                "Пример как не надо делать: - 5 + 6\n" +
                "-Когда возводим числа в стпень и соврешаем какое либо математическую\n" +
                "операцию, то необходимо число возводимое в степень заключить в скобки\n" +
                "Пример: ( 3 ^ 3 ) % 4 = 3.0 , если не поставим то получим 3 ^ 3 % 4 = 27.0\n" +
                "что является неверным.");
    };
    public void menu(){
        System.out.println("---------------------Калькулятор----------------------");
        System.out.println("Чтобы открыть прошлые вычисления нажмите 1");
        System.out.println("Чтобы получить решение нажмите 2");
        System.out.println("Чтобы выйти нажмите 9");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (n==1 | n==2 | n==9) {
            if (n == 1) {
                PastCalculatins pastCalculatins = new PastCalculatins();
                pastCalculatins.pastUr();
            }
            if (n == 2) {
                EquationCalculations op = new EquationCalculations();
                op.enub();
            }
            if (n == 9) {
                System.out.println("До Свидания");
                System.exit(0);
            }
        }
        else {
            System.out.println("Вы выбрали не существующие действие");
        }
    }
}
