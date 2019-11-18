package campominado;
import componentes.Pn;
import java.util.ArrayList;
public class Recordes extends Pn{
    
    public Recordes(){
        ScoreCM scm = new ScoreCM();
        scm.leitura();
        
        switch(ScoreCM.getNivel()){
            case 14: scores = ScoreCM.getRankingEasy(); users = ScoreCM.getUsersEasy(); break;
            case 16: scores = ScoreCM.getRankingMedium(); users = ScoreCM.getUsersMedium(); break;
            case 18: scores = ScoreCM.getRankingHard(); users = ScoreCM.getUsersHard(); break;
            default: break;
        }
        
        
        setLayout(null);
        setBounds(20, 20, 1120, 620);
        setVisible(true);
    }
    
    public void tabela(){
    }
    
    private ArrayList<String> scores = new ArrayList<>();
    private ArrayList<String> users = new ArrayList<>();
    private final String[] linhas = {"01","02","03","04","05","06","07","08","09","10"};
}
