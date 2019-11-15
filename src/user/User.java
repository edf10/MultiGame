package user;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
public class User {
    private String username;
    private String password;
    private String dataRegistro;
    private int moedas;
    private ArrayList<Integer> historicCM = new ArrayList<Integer>();
    private HashMap<Integer,String> historicJDV;
    private HashMap<Integer,String> historicWP;
    
    public User(){}
    
    public User(String username, String password){
        this.username = username;
        this.password = password;
        moedas = 0;
    }
    
    public void addDataRegister(){
        Date d = new Date();
        dataRegistro = java.text.DateFormat.getDateInstance(DateFormat.MEDIUM).format(d);
        String[] numerosData = dataRegistro.split("/");
        dataRegistro = numerosData[0]+" "+numerosData[1]+" "+numerosData[2];
    }
    
    public void addScoreCM(int sc){
        historicCM.add(sc);
    }
    public ArrayList<Integer> getHistoricCM() {
        return historicCM;
    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public String getDataRegistro() {
        return dataRegistro;
    }
    public void setDataRegistro(String dataRegistro){
        this.dataRegistro = dataRegistro;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setHistoricCM(ArrayList<Integer> historicCM) {
        this.historicCM = historicCM;
    }
    public int getMoedas() {
        return moedas;
    }
    public void setMoedas(int moedas) {
        this.moedas += moedas;
    }
    
}