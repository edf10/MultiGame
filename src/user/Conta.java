package user;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Conta {
    private User user;
    public Conta(User user){
        this.user = user;
    }
    private boolean logado = false;
    public boolean isLogado() {return logado;}
    public void setLogado(boolean logado) {this.logado = logado;}
   
    public User login(){
        JSONObject objectArquivo;
        JSONParser parser = new JSONParser();
        try{
            objectArquivo = (JSONObject) parser.parse(new FileReader("users/"+user.getUsername()+".json"));
            if(objectArquivo.get("password").equals(user.getPassword())&&logado==false){
                if(user.getUsername().length()>0&&user.getPassword().length()>0){
                    logado = true;
                    user.setUsername(objectArquivo.get("username").toString());
                    user.setPassword(objectArquivo.get("password").toString());
                    user.setDataRegistro(objectArquivo.get("data_register").toString());
                    user.setHistoricJDV((ArrayList<ArrayList<String>>) objectArquivo.get("historicJDV"));
                    user.setMoedas(Integer.parseInt(objectArquivo.get("moedas").toString()));
                    user.setStoreCM((ArrayList<ArrayList<String>>) objectArquivo.get("storeCM"));
                    user.setEmUsoCM((ArrayList<ArrayList<String>>) objectArquivo.get("emUsoCM"));
                    user.setStoreJDV((ArrayList<ArrayList<String>>) objectArquivo.get("storeJDV"));
                    user.setEmUsoJDV((ArrayList<ArrayList<String>>) objectArquivo.get("emUsoJDV"));
                    return user;
                }
                
            }
        }catch(FileNotFoundException e){}catch(IOException e){} catch (ParseException ex) {}
        return null;
    }
    public void gravar(){
        JSONObject objectArquivo = new JSONObject();
        if(user.getUsername().length()>0&&user.getPassword().length()>0){
            objectArquivo.put("username", user.getUsername());
            objectArquivo.put("password", user.getPassword());
            objectArquivo.put("data_register", user.getDataRegistro());
            objectArquivo.put("historicJDV", user.getHistoricJDV());
            objectArquivo.put("moedas", user.getMoedas());
            objectArquivo.put("storeCM", user.getStoreCM());
            objectArquivo.put("emUsoCM", user.getEmUsoCM());
            objectArquivo.put("storeJDV", user.getStoreJDV());
            objectArquivo.put("emUsoJDV", user.getEmUsoJDV());
        }
        try{
            FileWriter arquivo = new FileWriter("users/"+user.getUsername()+".json");
            arquivo.write(objectArquivo.toJSONString());
            arquivo.close();
        }catch(FileNotFoundException e){}catch(IOException e){}
    }
    
}