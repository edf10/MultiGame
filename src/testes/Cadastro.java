package testes;
import java.io.FileNotFoundException; //Erro: não encontrar o arquivo.
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import componentes.Frame;
import java.util.Arrays;
import user.Criptografar;
public class Cadastro extends Frame{
    private Criptografar c;
    public Cadastro(){
        super(800,600);
    }
    
    public void gravar(String username, String password){
        try{
            FileOutputStream f = new FileOutputStream("users/"+username+".txt");
            PrintWriter pr = new PrintWriter(f);
            c = new Criptografar("password-user000", password);
            pr.println(Arrays.toString(c.encriptar()));
            System.out.println(Arrays.toString(c.encriptar()));
            pr.close();
            f.close();
        }catch(FileNotFoundException e){
            
        }catch(IOException e){}
    }
    
}
