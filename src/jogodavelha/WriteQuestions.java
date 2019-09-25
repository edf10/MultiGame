package jogodavelha;
import java.io.FileNotFoundException; //Erro: não encontrar o arquivo.
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;

public class WriteQuestions {
    private PrintWriter pwt;
    private FileOutputStream arquivo;
    private DecimalFormat d = new DecimalFormat("0.0");
    public WriteQuestions(int n){
        
        
        //try{FileOutputStream equacao1 = new FileOutputStream("equacao1.txt");}catch(FileNotFoundException e){}
        //try{FileOutputStream equacao2 = new FileOutputStream("equacao2.txt");}catch(FileNotFoundException e){}
        
        if(n==1){
            writeMult();
        }else if(n==2){
            writeDiv();
        }
    }
    public void writeMult(){
        try{
            arquivo = new FileOutputStream("questions/multiplicacao.txt");
            pwt = new PrintWriter(arquivo);
            for(int i = 1; i<11; i++){
                for(int j = 1; j<11; j++){
                    pwt.println(i+" x "+j+" ="+i*j);
                }
            }
            pwt.close();
            arquivo.close();
        }catch(FileNotFoundException e){}catch(IOException e){}
    }
    public void writeDiv(){
        try{
            arquivo = new FileOutputStream("questions/divisao.txt");
            pwt = new PrintWriter(arquivo);
            for(int i = 1; i<11; i++){
                for(int j = 1; j<11; j++){
                    pwt.println(i+" / "+j+" ="+d.format((float)i/j));
                }
            }
            pwt.close();
            arquivo.close();
        }catch(FileNotFoundException e){}catch(IOException e){}
    }
}
