package user;
import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
public class User {
    private final String username;
    private final String password;
    private final String dataRegistro;
    private HashMap<Integer,String> historicCM;
    private HashMap<Integer,String> historicJDV;
    private HashMap<Integer,String> historicWP;
    
    public User(String username, String password){
        this.username = username;
        this.password = password;
        Date d = new Date();
        dataRegistro = java.text.DateFormat.getDateInstance(DateFormat.MEDIUM).format(d);
    }

    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    
}