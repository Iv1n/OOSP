import java.io.*;
import java.util.ArrayList;
public class WorkingWithNotepad {
public ArrayList<String> pastCalculatins = new ArrayList<>();

public void writingToFile(String n){
    File file = new File("text.txt");
    try{
        BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
        writer.write(n + "\n" );
        writer.close();
    } catch (Exception e) {
        throw new RuntimeException(e);
    }
}
public void readFile(){
    try {
        BufferedReader br = null;
        br = new BufferedReader(new FileReader("text.txt"));
        String line;
        while ((line = br.readLine()) !=null){
            pastCalculatins.add(line);
        }

        for(int i =0;i<pastCalculatins.size()/2;i++){
            String tmp  = pastCalculatins.get(i);
            pastCalculatins.set(i, pastCalculatins.get(pastCalculatins.size() - i - 1));
            pastCalculatins.set(pastCalculatins.size()-i-1,tmp);
        }

        for(String l : pastCalculatins){
            System.out.println(l);
        }
        br.close();
    } catch (Exception e) {
        throw new RuntimeException(e);
    }
}
}
