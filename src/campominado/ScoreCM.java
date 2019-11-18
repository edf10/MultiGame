package campominado;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import user.User;
public class ScoreCM {
    private int minasNivel;
    private int posOpen; //campos diferentes de minas que estejam abertos
    private int tempoSegundos;
    private User user = new User();
    private static ArrayList<String> rankingEasy = new ArrayList<>();
    private static ArrayList<String> rankingMedium = new ArrayList<>();
    private static ArrayList<String> rankingHard = new ArrayList<>();
    private static ArrayList<String> usersEasy = new ArrayList<>();
    private static ArrayList<String> usersMedium = new ArrayList<>();
    private static ArrayList<String> usersHard = new ArrayList<>();
    private int nivel;
    
    public static ArrayList<String> getRankingEasy() {
        return rankingEasy;
    }
    public static ArrayList<String> getUsersEasy() {
        return usersEasy;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
    public ScoreCM(){}
    public ScoreCM(int posOpen, int tempoSegundos, int minasNivel){
        this.posOpen = posOpen;
        this.tempoSegundos = tempoSegundos;
        this.minasNivel = minasNivel;
        leitura();
    }
    public int scoreRankingCM(){
        int score = 30*posOpen+30*minasNivel-40*tempoSegundos;
        if(score>0){
            switch (nivel) {
                case 14:rankingEasy.add(""+score);usersEasy.add(user.getUsername());break;
                case 16:rankingMedium.add(""+score);usersMedium.add(user.getUsername());break;
                default:rankingHard.add(""+score);usersHard.add(user.getUsername());break;
            }
            return score;
        }else{
            return 0;
        }
    }
    public int scoreMoedaCM(){
        int moedas = 3*posOpen+3*minasNivel-4*tempoSegundos;
        if(moedas>0){
            return moedas;
        }else{
            return 0;
        }
    }
    
    public void sequenciar(ArrayList<String> ranking, ArrayList<String> users){
        String[] usersAux = new String[users.size()];
        int[] scoresAux = new int[ranking.size()];
        ArrayList<Integer> rankingAux = new ArrayList<>();
        for(int i = 0; i<users.size(); i++){
            usersAux[i] = users.get(i);
            scoresAux[i] = Integer.parseInt(ranking.get(i));
            rankingAux.add(Integer.parseInt(ranking.get(i)));
        }
        Collections.sort(rankingAux);
        Collections.reverse(rankingAux);
        for(int i = 0; i<ranking.size(); i++){
            for(int j = 0; j<users.size(); j++){
                if(rankingAux.get(i)==scoresAux[j]&&users.get(i).equals(usersAux[j])){
                    users.set(i, usersAux[j]);
                }
            }
        }
        ranking.clear();
        for(int i = 0; i<rankingAux.size(); i++){
            ranking.add(String.valueOf(rankingAux.get(i)));
        }
        if(ranking.size()>10){
            for(int i = 9; i<ranking.size(); i++){
                ranking.remove(i);
                users.remove(i);
            }
        }
    }
    
    public void leitura(){
        JSONObject objectArquivo;
        JSONParser parser = new JSONParser();
        try{
            objectArquivo = (JSONObject) parser.parse(new FileReader("rankings/cm.json"));
            rankingEasy = (ArrayList<String>) objectArquivo.get("ranking_easy");
            usersEasy = (ArrayList<String>) objectArquivo.get("users_easy");
            rankingMedium = (ArrayList<String>) objectArquivo.get("ranking_medium");
            usersMedium = (ArrayList<String>) objectArquivo.get("users_medium");
            rankingHard = (ArrayList<String>) objectArquivo.get("ranking_hard");
            usersHard = (ArrayList<String>) objectArquivo.get("users_hard");
            sequenciar(rankingEasy, usersEasy);sequenciar(rankingMedium, usersMedium);sequenciar(rankingHard, usersHard);
        }catch(FileNotFoundException e){}catch(IOException e){} catch (ParseException ex) {}
    }
    
    public void gravar(){
        JSONObject objectArquivo = new JSONObject();
        objectArquivo.put("ranking_easy", rankingEasy);
        objectArquivo.put("ranking_medium", rankingMedium);
        objectArquivo.put("ranking_hard", rankingHard);
        objectArquivo.put("users_easy", usersEasy);
        objectArquivo.put("users_medium", usersMedium);
        objectArquivo.put("users_hard", usersHard);
        try{
            FileWriter arquivo = new FileWriter("rankings/cm.json");
            arquivo.write(objectArquivo.toJSONString());
            arquivo.close();
        }catch(FileNotFoundException e){}catch(IOException e){}
    }
    
}
