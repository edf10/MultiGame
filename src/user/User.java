package user;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
public class User {
    private String username;
    private String password;
    private String dataRegistro;
    private int moedas;
    private ArrayList<ArrayList<String>> historicJDV = new ArrayList<>();
    private static User user;
    public static User getUser() {
        return user;
    }
    public static void setUser(User user) {
        User.user = user;
    }
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
    public void addPartidaJDV(String wOrgo, String oponente, String assunto){
        ArrayList<String> partida = new ArrayList<String>();
        partida.add(wOrgo);
        partida.add(oponente);
        partida.add(assunto);
        historicJDV.add(partida);
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
    public String getMoedasString() {
        DecimalFormat dc = new DecimalFormat("00.00");
        return dc.format(moedas);
    }
    public int getMoedas(){
        return moedas;
    }
    public void setMoedas(int moedas) {
        this.moedas += moedas;
    }
    public ArrayList<ArrayList<String>> getHistoricJDV() {
        return historicJDV;
    }
    public void setHistoricJDV(ArrayList<ArrayList<String>> historicJDV) {
        this.historicJDV = historicJDV;
    }
    
}