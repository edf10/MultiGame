package user;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Conta {
    private SecretKey key;
    private final String chave = "password-user000";
    private Criptografar c;
    private String username;
    private String password;
    public Conta(User user){
        key = new SecretKeySpec(chave.getBytes(), "AES");
        c = new Criptografar(chave, password);
        username = user.getUsername();
        password = user.getPassword();
    }
    private boolean logado = false;

    public boolean isLogado() {return logado;}
    public void setLogado(boolean logado) {this.logado = logado;}
   
    public void login(){
        
        JSONObject objectArquivo;
        JSONParser parser = new JSONParser();
        
        try{
            objectArquivo = (JSONObject) parser.parse(new FileReader("users/"+username+".json"));
            if(objectArquivo.get("password").equals(Arrays.toString(c.encriptar()))&&!logado){
                if(username!=null&&password!=null){
                    logado = true;
                }
            }
        }catch(FileNotFoundException e){}catch(IOException e){} catch (ParseException ex) {}
    }
    public void gravar(){
        JSONObject objectArquivo = new JSONObject();
        if(username.length()>0&&password.length()>0){
            objectArquivo.put("username", username);
            objectArquivo.put("password", Arrays.toString(c.encriptar()));
        }
        try{
            FileWriter arquivo = new FileWriter("users/"+username+".json");
            arquivo.write(objectArquivo.toJSONString());
            arquivo.close();
        }catch(FileNotFoundException e){}catch(IOException e){}
    }
}