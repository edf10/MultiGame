package wordpuzzle;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Perguntas {
    private ArrayList<String> questsGeometria = new ArrayList<>();
    private ArrayList<String> respGeometria = new ArrayList<>();
    private ArrayList<String> questsEquacoes = new ArrayList<>();
    private ArrayList<String> respEquacoes = new ArrayList<>();
    
    public void ler(String arq){
        JSONObject objectArquivo;
        JSONParser parser = new JSONParser();
        try{
            objectArquivo = (JSONObject) parser.parse(new FileReader("questions/wordpuzzle/"+arq+".json"));
            questsGeometria = (ArrayList<String>) objectArquivo.get("quests_geometria");
            respGeometria = (ArrayList<String>) objectArquivo.get("resp_geometria");
            questsEquacoes = (ArrayList<String>) objectArquivo.get("quests_equacoes");
            respEquacoes = (ArrayList<String>) objectArquivo.get("resp_equacoes");
        }catch(FileNotFoundException e){}catch(IOException e){} catch (ParseException ex) {}
    }
    
    public void gravar(String arq){
        JSONObject objectArquivo = new JSONObject();
        objectArquivo.put("quests_geometria", questsGeometria);
        objectArquivo.put("resp_geometria", respGeometria);
        objectArquivo.put("quests_equacoes", questsEquacoes);
        objectArquivo.put("resp_equacoes", respEquacoes);
        try{
            FileWriter arquivo = new FileWriter("questions/wordpuzzle/"+arq+".json");
            arquivo.write(objectArquivo.toJSONString());
            arquivo.close();
        }catch(FileNotFoundException e){}catch(IOException e){}
    }
    
    
}
