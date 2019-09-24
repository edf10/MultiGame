package user;
import java.io.FileNotFoundException; //Erro: não encontrar o arquivo.
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import componentes.Frame;
public class Cadastro extends Frame{
    
    public Cadastro(){
        super(800,600);
    }
    
    public void gravar(String username, String password){
        try{
            FileOutputStream f = new FileOutputStream("users/"+username+".txt");
            PrintWriter pr = new PrintWriter(f);
            
        }catch(FileNotFoundException e){
            
        }
    }
    
}
