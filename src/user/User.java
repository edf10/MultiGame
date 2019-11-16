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
    private HashMap<Integer,String> historicCM = new HashMap<>();
    private ArrayList<ArrayList> historicJDV = new ArrayList<>();
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
    
    public void addScoreCM(int sc, String nivel){
        historicCM.put(sc, nivel);
    }
    
    public void addPartidaJDV(String wOrgo, String oponente){
        ArrayList<String> partida = new ArrayList<String>();
        partida.add(wOrgo);
        partida.add(oponente);
        historicJDV.add(partida);
    }
    
    public HashMap<Integer,String> getHistoricCM() {
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
    public void setHistoricCM(HashMap<Integer,String> historicCM) {
        this.historicCM = historicCM;
    }
    public int getMoedas() {
        return moedas;
    }
    public void setMoedas(int moedas) {
        this.moedas += moedas;
    }
    public ArrayList<ArrayList> getHistoricJDV() {
        return historicJDV;
    }
    public void setHistoricJDV(ArrayList<ArrayList> historicJDV) {
        this.historicJDV = historicJDV;
    }
    
}