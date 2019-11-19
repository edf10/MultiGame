package campominado;

import componentes.Lb;
import componentes.Pn;
import imagens.Im;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import padroes.Fonts;
import padroes.ItemsTela;
public class Recordes extends Pn{
    private Im im = new Im();
    private ItemsTela it = new ItemsTela();
    public Recordes(){
        ScoreCM scm = new ScoreCM();
        scm.leitura();
        
        switch(ScoreCM.getNivel()){
            case 14: scores = ScoreCM.getRankingEasy(); users = ScoreCM.getUsersEasy(); break;
            case 16: scores = ScoreCM.getRankingMedium(); users = ScoreCM.getUsersMedium(); break;
            case 18: scores = ScoreCM.getRankingHard(); users = ScoreCM.getUsersHard(); break;
            default: break;
        }
        tabela();
        setLayout(null);
        setBounds(0, 0, 1200, 700);
        setVisible(true);
    }
    
    public void tabela(){
        GridLayout col = new GridLayout(10,1);
        int pnPosicoesPos[] = {100,202,331,447}; int pnScoresPos[] = {434,202,330,447}; int pnUsersPos[] = {767,202,334,447};
        
        pnPosicoes = new Pn(pnPosicoesPos, col);
        pnScores = new Pn(pnScoresPos, col);
        pnUsers = new Pn(pnUsersPos, col);
        
        pnPosicoes.setBackground(new Color(59,57,57));
        pnScores.setBackground(new Color(59,57,57));
        pnUsers.setBackground(new Color(59,57,57));
       
        Fonts fs = new Fonts(); Font f = fs.addNewFont("DS-DIGIT", 30);
        for(int i = 0; i<10; i++){
            pnPosicoes.add(new Lb(lin[i],f,Color.white));
            //pnScores.add(new Lb(scores.get(i),f,Color.white));
        }
        add(it.btnClose()); add(it.returnGames(null)); int backPos[] = {0,0,1200,700}; int barrasPos[] = {96,243,1009,360};
        add(new Lb(im.addImagem("barras_ranking_cm"), barrasPos));
        add(pnPosicoes);add(pnScores);add(pnUsers);
        add(new Lb(im.addImagem("back_ranking_cm"), backPos));
    }
    
    private ArrayList<String> scores = new ArrayList<>();
    private ArrayList<String> users = new ArrayList<>();
    private final String[] lin = {"01","02","03","04","05","06","07","08","09","10"};
    private Lb[] colunas = new Lb[3]; private Lb[] posicoes = new Lb[10];
    private Pn pnPosicoes;
    private Pn pnScores;
    private Pn pnUsers;
}
