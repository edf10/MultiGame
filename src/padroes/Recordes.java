package padroes;

import componentes.Btn;
import componentes.Frame;
import componentes.Lb;
import componentes.Pn;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;

public abstract class Recordes extends Frame{
    private ArrayList<String> scores = new ArrayList<>();
    private ArrayList<String> users = new ArrayList<>();
    private final String[] lin = {"01","02","03","04","05","06","07","08","09","10"};
    private Pn pnPosicoes;
    private Pn pnScores;
    private Pn pnUsers;
    public ItemsTela it = new ItemsTela();
    protected Score s;
    protected int nivel;
    public Recordes(){}
    public Recordes(int nivel){
        this.nivel = nivel;
    }
    public void decVars(){
        switch(nivel){
            case 14: scores = s.getRankingEasy(); users = s.getUsersEasy(); break;
            case 16: scores = s.getRankingMedium(); users = s.getUsersMedium(); break;
            case 18: scores = s.getRankingHard(); users = s.getUsersHard(); break;
            default: break;
        }
    }
    
    private ImageIcon[][] ims;
    public void setIms(ImageIcon[][] ims) {
        this.ims = ims;
    }
    private Pn pnRanking;
    public void escRankingNivel(){
        int backNiveisPos[] = {0,0,1200,700}; int btnEasyPos[] = {496,174,189,71};
        int btnMediumPos[] = {439,311,304,71}; int btnHardPos[] = {502,445,189,79};
        ImageIcon btn_easy[] = ims[0];ImageIcon btn_medium[] = ims[1];ImageIcon btn_hard[] = ims[2];
        Component cp[] = {
            it.btnClose(),
            it.btnSomOutro(),
            it.returnGames(this),
            new Btn(btn_easy, btnEasyPos, new EventBtnsRank(14)),
            new Btn(btn_medium, btnMediumPos, new EventBtnsRank(16)),
            new Btn(btn_hard, btnHardPos, new EventBtnsRank(18)),
            new Lb(ims[3][0], backNiveisPos)
        };
        int pnNiveisPos[] = {0,0,1200,700};
        pnRanking = new Pn(pnNiveisPos, cp);
        add(pnRanking);
    }
    
    public class EventBtnsRank implements ActionListener{
        private int n;
        public EventBtnsRank(int n){this.n = n;}
        @Override
        public void actionPerformed(ActionEvent ae) {
            pnRanking.setVisible(false);
            nivel = n; decVars(); tabela();
        }
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
        for(int i = 0; i<scores.size(); i++){
            pnPosicoes.add(new Lb(lin[i],f,Color.white));
            pnScores.add(new Lb(scores.get(i),f,Color.white));
            pnUsers.add(new Lb(users.get(i),f,Color.white));
        }
        for(int i = scores.size(); i<10; i++){
            pnPosicoes.add(new Lb(lin[i],f,Color.white));
            pnScores.add(new Lb("-",f,Color.white));
            pnUsers.add(new Lb("-",f,Color.white));
        }
        
        add(it.btnClose()); add(it.returnGames(this)); int backPos[] = {0,0,1200,700}; int barrasPos[] = {94,243,1009,360};
        add(new Lb(ims[4][0], barrasPos));
        add(pnPosicoes);add(pnScores);add(pnUsers);
        add(new Lb(ims[5][0], backPos));
    }
    
    
    
}
