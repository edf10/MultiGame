package testes;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import multigame.MultiGameTela;
import user.Criptografar;

public class Login {
    
    public Login(String username, String password){
        try{
            FileInputStream f = new FileInputStream("users/"+username+".txt");
            InputStreamReader i = new InputStreamReader(f);
            BufferedReader b = new BufferedReader(i);
            Criptografar c = new Criptografar("password-user000", password);
            System.out.println(Arrays.toString(c.descriptar()));
            if(b.readLine().equals(Arrays.toString(c.descriptar()))){
                System.out.println("Logado");
                MultiGameTela m = new MultiGameTela(2);
            }
            b.close();
            f.close();
        }catch(FileNotFoundException e){
            
        }catch(IOException e){
            
        }
    }
}
