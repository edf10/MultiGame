package campominado;

import componentes.Btn;
import componentes.Frame;
import componentes.Lb;
import componentes.Pn;
import imagens.Im;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import padroes.Fonts;
import padroes.ItemsTela;
import user.User;
public class Recordes extends Frame{
    private Im im = new Im();
    private ItemsTela it = new ItemsTela();
    private Btn menu[];
    private int nivel;
    private User user = User.getUser();
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
    public Recordes(){
        ScoreCM scm = new ScoreCM();
        it.setTelaAntIntro(1);
        setLayout(null);
    }
    
    public void decVars(){
        switch(nivel){
            case 14: scores = ScoreCM.getRankingEasy(); users = ScoreCM.getUsersEasy(); break;
            case 16: scores = ScoreCM.getRankingMedium(); users = ScoreCM.getUsersMedium(); break;
            case 18: scores = ScoreCM.getRankingHard(); users = ScoreCM.getUsersHard(); break;
            default: break;
        }
    }
    private Pn pnRanking;
    public void escRankingNivel(){
        int backNiveisPos[] = {0,0,1200,700}; int btnEasyPos[] = {496,174,189,71};
        int btnMediumPos[] = {439,311,304,71}; int btnHardPos[] = {502,445,189,79};
        ImageIcon btn_easy[] = {im.addImagem("btn_easy_cm"),im.addImagem("btn_easy_cm_t"),im.addImagem("btn_easy_cm_p")};
        ImageIcon btn_medium[] = {im.addImagem("btn_medium_cm"),im.addImagem("btn_medium_cm_t"),im.addImagem("btn_medium_cm_p")};
        ImageIcon btn_hard[] = {im.addImagem("btn_hard_cm"),im.addImagem("btn_hard_cm_t"),im.addImagem("btn_hard_cm_p")};
        Component cp[] = {
            it.btnClose(),
            it.btnSomOutro(),
            it.returnGames(this),
            new Btn(btn_easy, btnEasyPos, new EventBtnsRank(14)),
            new Btn(btn_medium, btnMediumPos, new EventBtnsRank(16)),
            new Btn(btn_hard, btnHardPos, new EventBtnsRank(18)),
            new Lb(im.addImagem("back_intro_cm"), backNiveisPos)
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
        
        add(it.btnClose()); add(it.returnGames(this)); int backPos[] = {0,0,1200,700}; int barrasPos[] = {96,243,1009,360};
        add(new Lb(im.addImagem("barras_ranking_cm"), barrasPos));
        add(pnPosicoes);add(pnScores);add(pnUsers);
        add(new Lb(im.addImagem("back_ranking_cm"), backPos));
    }
    
    private ArrayList<String> scores = new ArrayList<>();
    private ArrayList<String> users = new ArrayList<>();
    private final String[] lin = {"01","02","03","04","05","06","07","08","09","10"};
    private Pn pnPosicoes;
    private Pn pnScores;
    private Pn pnUsers;
}
