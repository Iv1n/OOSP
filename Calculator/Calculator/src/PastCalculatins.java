import java.util.ArrayList;
public class PastCalculatins {

    public static ArrayList<String> uravneny = new ArrayList<>();
    public void uravneny(String n) {
        uravneny.add(n);
    }
    public void pastUr(){
        System.out.println("----------------Прошлые вычисления----------------");
        for(String l : uravneny){
            System.out.println(l);
        }
        UI ui = new UI();
        ui.ui();
    }
}

