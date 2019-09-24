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
    private String chave;
    private Criptografar c;
    private String username;
    public Conta(String chave, String username, String password){
        this.chave = chave;
        this.username = username;
        key = new SecretKeySpec(chave.getBytes(), "AES");
        c = new Criptografar(chave, password);
    }
    
    public void Login(){
        try{
            FileInputStream f = new FileInputStream("users/"+username+".txt");
            InputStreamReader i = new InputStreamReader(f);
            BufferedReader b = new BufferedReader(i);
            if(b.readLine().equals(Arrays.toString(c.encriptar()))){
                System.out.println("Logado");
                MultiGameTela m = new MultiGameTela(2);
            }
            b.close();
            f.close();
        }catch(FileNotFoundException e){
            
        }catch(IOException e){
            
        }
    }
    
    public void gravar(){
        try{
            FileOutputStream f = new FileOutputStream("users/"+username+".txt");
            PrintWriter pr = new PrintWriter(f);
            pr.println(Arrays.toString(c.encriptar()));
            System.out.println(Arrays.toString(c.encriptar()));
            pr.close();
            f.close();
        }catch(FileNotFoundException e){
            
        }catch(IOException e){}
    }
    
}
