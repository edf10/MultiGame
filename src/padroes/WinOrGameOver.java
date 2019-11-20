package padroes;

import campominado.IntroductionCM;
import campominado.RecordesCM;
import componentes.Btn;
import componentes.Frame;
import componentes.Lb;
import componentes.Pn;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.border.Border;
import jogodavelha.HistoricJDV;
import jogodavelha.IntroductionJDV;
import wordpuzzle.IntroductionWP;
import wordpuzzle.RecordesWP;

public class WinOrGameOver extends Frame{
    private int nivel;
    private ImageIcon btn_home[] = {im.addImagem("btn_home_wg"),im.addImagem("btn_home_wg_t"),im.addImagem("btn_home_wg_p")};
    private ImageIcon btn_ranking[] = {im.addImagem("btn_ranking_wg"),im.addImagem("btn_ranking_wg_t"),im.addImagem("btn_ranking_wg_p")};
    private ImageIcon btn_historic[] = {im.addImagem("btn_historic_wg"),im.addImagem("btn_historic_wg_t"),im.addImagem("btn_historic_wg_p")};
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
    private Frame game;
    public WinOrGameOver(Frame game){
        setSize(486,294);
        setLocationRelativeTo(null);
        this.game = game;
    }
    
    private Pn pnGO;
    public void addGameOver(int jogo){
        int backPos[] = {2,2,480,288}; int rectPos[] = {100,143,325,90};
        int btnHome[] = {84,170,142,53}; int btnRanking[] = {271,170,142,53};
        Component[] cp = new Component[4];
        cp[0] = new Btn(btn_home, btnHome, new EventBtns(jogo));
        cp[2] = new Lb(im.addImagem("rect_black"),rectPos);
        cp[3] = new Lb(im.addGif("back_gameover"), backPos);
        if(jogo!=6){
            cp[1] = new Btn(btn_ranking, btnRanking, new EventBtns(jogo-1));
        }else{
            cp[1] = new Btn(btn_historic, btnRanking, new EventBtns(jogo-1));
        }
        pnGO = new Pn(backPos, cp);
        Border b = BorderFactory.createLineBorder(Color.white, 4);
        pnGO.setBorder(b);
        add(pnGO);
    }
    
    public class EventBtns implements ActionListener{
        private int esc;
        public EventBtns(int esc){this.esc = esc;}
        @Override
        public void actionPerformed(ActionEvent ae) {
            game.dispose();dispose();
            if(esc==2){ //
                IntroductionCM cm = new IntroductionCM(); cm.intro(); cm.show();
            }else if(esc==1){
                RecordesCM r = new RecordesCM(nivel);
                r.tabela();r.show();
            }else if(esc==4){
                IntroductionWP wp = new IntroductionWP(); wp.intro(); wp.show();
            }else if(esc==3){
                RecordesWP r = new RecordesWP(nivel);
                r.tabela();r.show();
            }else if(esc==6){
                IntroductionJDV jdv = new IntroductionJDV(); jdv.intro(); jdv.show();
            }else{
                HistoricJDV h = new HistoricJDV();
            }
        }
    }
    
    private Pn pnWin;
    public void addWin(int jogo){
        setSize(484, 274);
        int backPos[] = {2,2,480,270}; int titlePos[] = {146,49,216,52};
        int btnHome[] = {90,161,142,53}; int btnRanking[] = {290,161,142,53};
        Component[] cp = new Component[4];
        cp[0] = new Btn(btn_home, btnHome, new EventBtns(jogo));
        cp[2] = new Lb(im.addImagem("title_win_cm_wp"), titlePos);
        cp[3] = new Lb(im.addGif("back_win"), backPos);
        if(jogo!=6){
            cp[1] = new Btn(btn_ranking, btnRanking, new EventBtns(jogo-1));
        }else{
            cp[1] = new Btn(btn_historic, btnRanking, new EventBtns(jogo-1));
        }
        pnWin = new Pn(backPos, cp);
        Border b = BorderFactory.createLineBorder(Color.white, 4);
        pnWin.setBorder(b);
        pnWin.setBackground(Color.black);
        add(pnWin);
    }
    
    private Pn pnEmp;
    public void addEmpateJDV(){
        setSize(484, 274);
        int backPos[] = {2,2,480,270}; int titlePos[] = {146,49,216,52};
        int btnHome[] = {90,161,142,53}; int btnHistoric[] = {290,161,142,53};
        Component cp[] = {
            new Btn(btn_home, btnHome, new EventBtns(6)),
            new Btn(btn_historic, btnHistoric, new EventBtns(5)),
            new Lb(im.addImagem("title_empate_jdv"), titlePos),
            new Lb(im.addGif("back_empate"), backPos)
        };
        pnEmp = new Pn(backPos, cp);
        Border b = BorderFactory.createLineBorder(Color.white, 4);
        pnEmp.setBorder(b);
        pnEmp.setBackground(Color.black);
        add(pnEmp);
    }
    
}
