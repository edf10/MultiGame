package campominado;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import user.User;

public class ScoreCM {
    private int minasNivel;
    private int posOpen; //campos diferentes de minas que estejam abertos
    private int tempoSegundos;
    private User user = new User();
    private static ArrayList<String> ranking = new ArrayList<>();
    private static ArrayList<String> users = new ArrayList<>();
    
    public static ArrayList<String> getRanking() {
        return ranking;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public ScoreCM(int posOpen, int tempoSegundos, int minasNivel){
        this.posOpen = posOpen;
        this.tempoSegundos = tempoSegundos;
        this.minasNivel = minasNivel;
        leitura();
    }
    public int scoreRankingCM(){
        int score = 30*posOpen+30*minasNivel-40*tempoSegundos;
        if(score>0){
            ranking.add(""+score);
            users.add(user.getUsername());
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
    
    public void sequenciar(){
        String[] usersAux = new String[users.size()];
        int[] scoresAux = new int[ranking.size()];
        for(int i = 0; i<users.size(); i++){
            usersAux[i] = users.get(i);
            scoresAux[i] = Integer.parseInt(ranking.get(i));
        }
        ArrayList<Integer> rankingAux = new ArrayList<>();
        for(int i = 0; i<ranking.size(); i++){
            rankingAux.add(Integer.parseInt(ranking.get(i)));
        }
        Collections.sort(rankingAux);
        Collections.reverse(rankingAux);
        for(int i = 0; i<ranking.size(); i++){
            for(int j = 0; j<users.size(); j++){
                if(rankingAux.get(i)==scoresAux[j]){
                    users.set(i, usersAux[j]);
                }
            }
        }
        ranking.clear();
        for(int i = 0; i<rankingAux.size(); i++){
            ranking.add(String.valueOf(rankingAux.get(i)));
        }
        
        System.out.println(ranking);
    }
    
    public void leitura(){
        JSONObject objectArquivo;
        JSONParser parser = new JSONParser();
        try{
            objectArquivo = (JSONObject) parser.parse(new FileReader("rankings/cm.json"));
            ranking = (ArrayList<String>) objectArquivo.get("ranking");
            users = (ArrayList<String>) objectArquivo.get("users");sequenciar();
        }catch(FileNotFoundException e){}catch(IOException e){} catch (ParseException ex) {}
    }
    
    public void gravar(){
        JSONObject objectArquivo = new JSONObject();
        objectArquivo.put("ranking", ranking);
        objectArquivo.put("users", users);
        try{
            FileWriter arquivo = new FileWriter("rankings/cm.json");
            arquivo.write(objectArquivo.toJSONString());
            arquivo.close();
        }catch(FileNotFoundException e){}catch(IOException e){}
    }
    
}
