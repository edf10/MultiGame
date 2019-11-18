package campominado;

import java.util.ArrayList;

public class Recordes{
    private ArrayList<String> scores = new ArrayList<>();
    private ArrayList<String> users = new ArrayList<>();
    private String[] colunas = {};
    public Recordes(){
        ScoreCM scm = new ScoreCM();
        scm.leitura();
    }
    
}
