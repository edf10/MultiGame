package padroes;

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

public abstract class Score {
    protected User user = User.getUser();
    protected ArrayList<String> rankingEasy = new ArrayList<>();
    protected ArrayList<String> rankingMedium = new ArrayList<>();
    protected ArrayList<String> rankingHard = new ArrayList<>();
    protected ArrayList<String> usersEasy = new ArrayList<>();
    protected ArrayList<String> usersMedium = new ArrayList<>();
    protected ArrayList<String> usersHard = new ArrayList<>();
    protected int nivel;
    private String arq;
    public void setArq(String arq) {
        this.arq = arq;
    }
    public int getNivel() {
        return nivel;
    }
    public ArrayList<String> getRankingEasy() {
        return rankingEasy;
    }
    public ArrayList<String> getUsersEasy() {
        return usersEasy;
    }
    public ArrayList<String> getRankingMedium() {
        return rankingMedium;
    }
    public ArrayList<String> getRankingHard() {
        return rankingHard;
    }
    public ArrayList<String> getUsersMedium() {
        return usersMedium;
    }
    public ArrayList<String> getUsersHard() {
        return usersHard;
    }
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
    
    public void sequenciar(ArrayList<String> ranking, ArrayList<String> users){
        String usersAux[] = new String[users.size()];
        int scoresAux[] = new int[ranking.size()];
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
            objectArquivo = (JSONObject) parser.parse(new FileReader("rankings/"+arq+".json"));
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
            FileWriter arquivo = new FileWriter("rankings/"+arq+".json");
            arquivo.write(objectArquivo.toJSONString());
            arquivo.close();
        }catch(FileNotFoundException e){}catch(IOException e){}
    }
    
    public void limpar(){
        JSONObject objectArquivo = new JSONObject();
        objectArquivo.clear();
        try{
            FileWriter arquivo = new FileWriter("rankings/"+arq+".json");
            arquivo.write(objectArquivo.toJSONString());
            arquivo.close();
        }catch(FileNotFoundException e){}catch(IOException e){}
        gravar();
    }
    
}
