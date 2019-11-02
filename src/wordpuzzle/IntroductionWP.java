package wordpuzzle;
import componentes.Btn;
import componentes.Frame;
import componentes.Lb;
import componentes.Pn;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import padroes.ItemsTela;
public class IntroductionWP extends Frame{
    private ItemsTela it = new ItemsTela();
    public IntroductionWP(){
        intro();
        show();
    }

    public void tutorial() {
    }
    
    private Pn pnIntro;
    private final ImageIcon imBackWP = new ImageIcon(getClass().getResource("imagens/back_intro_wp.png"));
    private final ImageIcon imTitleWP = new ImageIcon(getClass().getResource("imagens/title_wp.png"));
    private final ImageIcon imClassicWP = new ImageIcon(getClass().getResource("imagens/btn_classic_wp.png"));
    private final ImageIcon imClassicWPT = new ImageIcon(getClass().getResource("imagens/btn_classic_wp_t.png"));
    private final ImageIcon imClassicWPP = new ImageIcon(getClass().getResource("imagens/btn_classic_wp_p.png"));
    private final ImageIcon imCustomWP = new ImageIcon(getClass().getResource("imagens/btn_custom_wp.png"));
    private final ImageIcon imCustomWPT = new ImageIcon(getClass().getResource("imagens/btn_custom_wp_t.png"));
    private final ImageIcon imCustomWPP = new ImageIcon(getClass().getResource("imagens/btn_custom_wp_p.png"));
    private final ImageIcon imRankingWP = new ImageIcon(getClass().getResource("imagens/btn_ranking_wp.png"));
    private final ImageIcon imRankingWPT = new ImageIcon(getClass().getResource("imagens/btn_ranking_wp_t.png"));
    private final ImageIcon imRankingWPP = new ImageIcon(getClass().getResource("imagens/btn_ranking_wp_p.png"));
    private final ImageIcon imTutorialWP = new ImageIcon(getClass().getResource("imagens/btn_tutorial_wp.png"));
    private final ImageIcon imTutorialWPT = new ImageIcon(getClass().getResource("imagens/btn_tutorial_wp_t.png"));
    private final ImageIcon imTutorialWPP = new ImageIcon(getClass().getResource("imagens/btn_tutorial_wp_p.png"));
    public void intro() {
        int backPos[] = {0,0,1200,700}; int titlePos[] = {252,73,700,107};
        int classicPos[] = {478,249,227,52}; int customPos[] = {477,342,231,59};
        int rankPos[] = {484,440,231,58}; int tutoPos[] = {475,530,262,58};
        ImageIcon btn_classic[] = {imClassicWP,imClassicWPT,imClassicWPP};
        ImageIcon btn_custom[] = {imCustomWP,imCustomWPT,imCustomWPP};
        ImageIcon btn_rank[] = {imRankingWP,imRankingWPT,imRankingWPP};
        ImageIcon btn_tuto[] = {imTutorialWP,imTutorialWPT,imTutorialWPP};
        Btn menu[] = it.menuOp(this);
        Component cp[] = {
            new Lb(imTitleWP, titlePos),
            it.btnClose(),
            it.btnSomOutro(),
            menu[0],menu[1],menu[2],menu[3],
            new Btn(btn_classic, classicPos, new EventBtnsIntro()),
            new Btn(btn_custom, customPos, null),
            new Btn(btn_rank, rankPos, null),
            new Btn(btn_tuto, tutoPos, null),
            new Lb(imBackWP, backPos)
        };
        
        int pnIntroP[] = {0,0,1200,700};
        
        pnIntro = new Pn(pnIntroP, cp, Color.orange);
        add(pnIntro);
    }
    
    public class EventBtnsIntro implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ae) {
            pnIntro.setVisible(false);
            niveis();
        }
    }
    
    private Pn pnNiveis;
    private final ImageIcon imF = new ImageIcon("");
    public void niveis(){
        int pnNiveisP[] = {0,0,800,600}; int lbfundoP[] = {0,0,800,600};
        int btnFP[] = {300,100,200,100}; int btnMP[] = {300,210,200,100}; int btnDP[] = {300,320,200,100};
        Font f = new Font("Arial", Font.PLAIN, 40);
        Component cp[] = {
            new Btn("Fácil", f, Color.darkGray, Color.BLACK, btnFP, null, true, false, new Niveis(1)),
            new Btn("Médio", f, Color.darkGray, Color.BLACK, btnMP, null, true, false, new Niveis(2)),
            new Btn("Difícil", f, Color.darkGray, Color.BLACK, btnDP, null, true, false, new Niveis(3)),
            new Lb(imF, lbfundoP)
        };
        
        pnNiveis = new Pn(pnNiveisP, cp);
        add(pnNiveis);
    }
    
    public class Niveis implements ActionListener{
        private int nivel;
        public Niveis(int n){nivel = n;}
        @Override
        public void actionPerformed(ActionEvent ae) {
            dispose();
            TelaWP tcp = new TelaWP(nivel);
        }
    }
}
