package jogodavelha;
import java.io.FileNotFoundException; //Erro: não encontrar o arquivo.
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
public class WriteQuestions {
    private PrintWriter pwt;
    private FileOutputStream tabuada;
    public WriteQuestions(int n){
        try{
            tabuada = new FileOutputStream("tabuada.txt");
            pwt = new PrintWriter(tabuada);
        }catch(FileNotFoundException e){}
        
        //try{FileOutputStream equacao1 = new FileOutputStream("equacao1.txt");}catch(FileNotFoundException e){}
        //try{FileOutputStream equacao2 = new FileOutputStream("equacao2.txt");}catch(FileNotFoundException e){}
        
        if(n==1){
            writeTabuada();
        }
    }
    public void writeTabuada(){
        for(int i = 1; i<11; i++){
            for(int j = 1; j<11; j++){
                pwt.println(i+" x "+j+" ="+i*j);
            }
        }
        pwt.close();
        try{tabuada.close();}catch(IOException e){}
    }
}
