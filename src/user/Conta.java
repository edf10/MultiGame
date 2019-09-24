package user;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import multigame.MultiGameTela;

public class Conta {
    private SecretKey key;
    private final String chave = "password-user000";
    private Criptografar c;
    private String username;
    private String password;
    public Conta(String username, String password){
        this.username = username;
        this.password = password;
        key = new SecretKeySpec(chave.getBytes(), "AES");
        c = new Criptografar(chave, password);
    }
    private boolean logado = false;

    public boolean isLogado() {return logado;}
    public void setLogado(boolean logado) {this.logado = logado;}
   
    public void login(){
        try{
            FileInputStream f = new FileInputStream("users/"+username+".txt");
            InputStreamReader i = new InputStreamReader(f);
            BufferedReader b = new BufferedReader(i);
            if(b.readLine().equals(Arrays.toString(c.encriptar()))&&!logado){
                if(username!=null&&password!=null){
                    MultiGameTela m = new MultiGameTela(2);
                    System.out.println("Logado");
                    logado = true;
                }
            }
            b.close();
            f.close();
        }catch(FileNotFoundException e){
            
        }catch(IOException e){
            
        }
    }
    
    public void gravar(){
        try{
            if(username!=null&&password!=null){
                FileOutputStream f = new FileOutputStream("users/"+username+".txt");
                PrintWriter pr = new PrintWriter(f);
                pr.println(Arrays.toString(c.encriptar()));
                pr.close();
                f.close();
            }
        }catch(FileNotFoundException e){
            
        }catch(IOException e){}
    }
    
    
}
