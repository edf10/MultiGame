package jogodavelha;
import java.io.FileNotFoundException; //Erro: não encontrar o arquivo.
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
public class WriteQuestions {
    private PrintWriter pwt;
    private FileOutputStream arquivo;
    private int n;
    private DecimalFormat d = new DecimalFormat("0.0");
    public WriteQuestions(int n){
        this.n = n;
        switch(n){
            case 1: write("multiplicacao", "x");break;
            case 2: write("divisao", "/");break;
            case 3: write("adicao", "+");break;
            case 4: write("subtracao", "-");break;
            default:break;
        }
    }
    public void write(String arq, String operacao){
        try{
            arquivo = new FileOutputStream("questions/"+arq+".txt");
            pwt = new PrintWriter(arquivo);
            for(int i = 1; i<11; i++){
                for(int j = 1; j<11; j++){
                    switch(n){
                        case 1: pwt.println(i+" "+operacao+" "+j+" ="+i*j);break;
                        case 2: pwt.println(i+" "+operacao+" "+j+" ="+d.format((float)i/j));break;
                        case 3: pwt.println(i+" "+operacao+" "+j+" ="+(i+j));break;
                        case 4: pwt.println(i+" "+operacao+" "+j+" ="+(i-j));break;
                        default: break;
                    }
                    
                }
            }
            pwt.close();
            arquivo.close();
        }catch(FileNotFoundException e){}catch(IOException e){}
        
    }
}
