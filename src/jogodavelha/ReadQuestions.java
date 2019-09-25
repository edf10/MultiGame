package jogodavelha;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
public class ReadQuestions {
    private FileInputStream tabuada;
    private InputStreamReader ist;
    private BufferedReader br;
    private HashMap<Integer,String> perT;
    private HashMap<Integer,String> resT;
    public ReadQuestions(){
        try{
            tabuada = new FileInputStream("questions/multiplicacao.txt");
            ist = new InputStreamReader(tabuada);
            br = new BufferedReader(ist);
        }catch(FileNotFoundException e){}
    }
    private int linesNumberPerTabuada;
    public void readTabuada(){
        String line;
        linesNumberPerTabuada = 0;
        perT = new HashMap<>();
        resT = new HashMap<>();
        try{
            while((line = br.readLine())!=null){
                String per[] = line.split("=");
                perT.put(linesNumberPerTabuada, per[0]+" =");
                resT.put(linesNumberPerTabuada, per[1]);
                linesNumberPerTabuada++;
            }
            br.close();
            tabuada.close();
            System.out.println(linesNumberPerTabuada);
        }catch(IOException e){}
    }
    
    public String getQuestionTabuada(int question){
        return perT.get(question);
    }
    public String getAnswerTabuada(int question){
        return resT.get(question);
    }
    public int getLengthHashTabuada(){
        return linesNumberPerTabuada;
    }
}
