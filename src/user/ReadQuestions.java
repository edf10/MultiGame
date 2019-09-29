package user;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
public class ReadQuestions {
    private FileInputStream arquivo;
    private InputStreamReader ist;
    private BufferedReader br;
    private HashMap<Integer,String> perT;
    private HashMap<Integer,String> resT;
    private int n;
    public ReadQuestions(String arquivo){
        esc(arquivo);
    }
    
    public void esc(String arquivo){
        try{
            this.arquivo = new FileInputStream("questions/"+arquivo+".txt");
            ist = new InputStreamReader(this.arquivo);
            br = new BufferedReader(ist);
        }catch(FileNotFoundException e){}
    }
    
    private int linesNumberPer;
    public void read(){
        String line;
        linesNumberPer = 0;
        perT = new HashMap<>();
        resT = new HashMap<>();
        try{
            while((line = br.readLine())!=null){
                String per[] = line.split("=");
                perT.put(linesNumberPer, per[0]+" =");
                resT.put(linesNumberPer, per[1]);
                linesNumberPer++;
            }
            br.close();
            arquivo.close();
            System.out.println(linesNumberPer);
        }catch(IOException e){}
    }
    
    public String getQuestion(int question){
        return perT.get(question);
    }
    public String getAnswer(int question){
        return resT.get(question);
    }
    public int getLengthHash(){
        return linesNumberPer;
    }
}
