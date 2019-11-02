package campominado;
import componentes.Btn;
import componentes.Pn;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import componentes.Lb;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import componentes.Frame;
import padroes.ItemsTela;
public class IntroductionCM extends Frame{
    private TelaCM tcm;
    private ItemsTela it = new ItemsTela();
    public IntroductionCM() {
        intro();
        show();
    }
    
    private Pn pnNiveis;
    private final ImageIcon imFundo = new ImageIcon(getClass().getResource("imagens/fundoNiveis.jpg"));
    public void niveis() {
        pnIntro.setVisible(false);
        Font nivel = new Font("Arial", Font.PLAIN, 30);
        Color c = new Color(231, 218, 87);
        Nivel e1 = new Nivel(1); Nivel e2 = new Nivel(2); Nivel e3 = new Nivel(3);
        int posF[] = {240,270,220,50}; int posM[] = {240,340,220,50}; int posD[] = {240,410,220,50};
        int lbFundoP[] = {0,0,700,700}; int pnNiveisP[] = {0,0,700,700};
        Border b = BorderFactory.createLineBorder(Color.black, 3);
        Component cp[] = {
            new Btn("FÁCIL", nivel, c, Color.black, posF, b, false, false, e1),
            new Btn("MÉDIO", nivel, c, Color.black, posM, b, false, false, e2),
            new Btn("DIFÍCIL", nivel, c, Color.black, posD, b, false, false, e3),
            new Lb(imFundo, lbFundoP)
        };
        pnNiveis = new Pn(pnNiveisP, cp);
        add(pnNiveis);
    }
    public void tutorial(){
    }
    
    private Pn pnIntro;
    private final ImageIcon imBackIntro = new ImageIcon(getClass().getResource("imagens/back_intro_cm.png"));
    private final ImageIcon imTitleCM = new ImageIcon(getClass().getResource("imagens/title_cm.png"));
    private final ImageIcon imPlayCM = new ImageIcon(getClass().getResource("imagens/btn_play_cm.png"));
    private final ImageIcon imPlayCMT = new ImageIcon(getClass().getResource("imagens/btn_play_cm_t.png"));
    private final ImageIcon imPlayCMP = new ImageIcon(getClass().getResource("imagens/btn_play_cm_p.png"));
    private final ImageIcon imRankingCM = new ImageIcon(getClass().getResource("imagens/btn_ranking_cm.png"));
    private final ImageIcon imRankingCMT = new ImageIcon(getClass().getResource("imagens/btn_ranking_cm_t.png"));
    private final ImageIcon imRankingCMP = new ImageIcon(getClass().getResource("imagens/btn_ranking_cm_p.png"));
    private final ImageIcon imTutorialCM = new ImageIcon(getClass().getResource("imagens/btn_tutorial_cm.png"));
    private final ImageIcon imTutorialCMT = new ImageIcon(getClass().getResource("imagens/btn_tutorial_cm_t.png"));
    private final ImageIcon imTutorialCMP = new ImageIcon(getClass().getResource("imagens/btn_tutorial_cm_p.png"));
    
    public void intro(){
        int backCMPos[] = {0,0,1200,700}; int titlePos[] = {250,52,805,100};
        int btnPlayPos[] = {526,273,185,71}; int btnRankingPos[] = {467,381,304,79};
        int btnTutorialPos[] = {464,497,346,79};
        ImageIcon btn_play_cm[] = {imPlayCM,imPlayCMP,imPlayCMT};
        ImageIcon btn_ranking_cm[] = {imRankingCM,imRankingCMP,imRankingCMT};
        ImageIcon btn_tutorial_cm[] = {imTutorialCM,imTutorialCMP,imTutorialCMT};
        Btn menu[] = it.menuOpGames(this);
        Component cp[] = {
            it.btnClose(),
            it.btnSomOutro(),
            menu[0],menu[1],menu[2],menu[3],menu[4], menu[5],
            new Lb(imTitleCM, titlePos),
            new Btn(btn_play_cm, btnPlayPos, new EventBtnsIntro(1)),
            new Btn(btn_ranking_cm, btnRankingPos, new EventBtnsIntro(2)),
            new Btn(btn_tutorial_cm,btnTutorialPos, new EventBtnsIntro(3)),
            new Lb(imBackIntro, backCMPos),
        };
        int pnIntroPos[] = {0,0,1200,700};
        pnIntro = new Pn(pnIntroPos, cp);
        add(pnIntro);
    }
    public void recordes(){
        
    }
    private class Nivel implements ActionListener{
        private int nil; private int x; private int y;
        private Nivel(int nil){this.nil = nil;}
        @Override
        public void actionPerformed(ActionEvent e){
            pnNiveis.setVisible(false);
            switch(nil){
                case 1:x = y = 12;break;
                case 2:x = y = 16;break;
                case 3:x = y = 18;break;
                default:break;
            }
            dispose();
            tcm = new TelaCM(nil, x, y);
        }
    }
    private class EventBtnsIntro implements ActionListener{
        private int n;
        public EventBtnsIntro(int n) {this.n = n;}
        @Override
        public void actionPerformed(ActionEvent ae) {
            switch (n) {
                case 1:niveis();break;
                case 2:tutorial();break;
                default:recordes();break;
            }
        }
        
    }
    
}
