package wordpuzzle;
import componentes.Btn;
import componentes.Frame;
import componentes.Lb;
import componentes.Pn;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import padroes.ItemsTela;
public class IntroductionWP extends Frame{
    private ItemsTela it = new ItemsTela();
    private Btn menu[] = it.menuOpGames(this);
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
        
        Component cp[] = {
            new Lb(imTitleWP, titlePos),
            it.btnClose(),
            it.btnSomOutro(),
            menu[0],menu[1],menu[2],menu[3],menu[4],menu[5],
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
    private final ImageIcon imEasy = new ImageIcon(getClass().getResource("imagens/btn_easy_wp.png"));
    private final ImageIcon imEasyT = new ImageIcon(getClass().getResource("imagens/btn_easy_wp_t.png"));
    private final ImageIcon imEasyP = new ImageIcon(getClass().getResource("imagens/btn_easy_wp_p.png"));
    private final ImageIcon imMedium = new ImageIcon(getClass().getResource("imagens/btn_medium_wp.png"));
    private final ImageIcon imMediumT = new ImageIcon(getClass().getResource("imagens/btn_medium_wp_t.png"));
    private final ImageIcon imMediumP = new ImageIcon(getClass().getResource("imagens/btn_medium_wp_p.png"));
    private final ImageIcon imHard = new ImageIcon(getClass().getResource("imagens/btn_hard_wp.png"));
    private final ImageIcon imHardT = new ImageIcon(getClass().getResource("imagens/btn_hard_wp_t.png"));
    private final ImageIcon imHardP = new ImageIcon(getClass().getResource("imagens/btn_hard_wp_p.png"));
    public void niveis(){
        int backPos[] = {0,0,1200,700}; int btnEasyPos[] = {526,172,189,72};
        int btnMediumPos[] = {468,300,304,72}; int btnHardPos[] = {532,430,189,80};
        ImageIcon btn_easy[] = {imEasy,imEasyT,imEasyP};
        ImageIcon btn_medium[] = {imMedium,imMediumT,imMediumP};
        ImageIcon btn_hard[] = {imHard,imHardT,imHardP};
        Component cp[] = {
            it.btnClose(),
            it.btnSomOutro(),
            menu[0],menu[1],menu[2],menu[3],menu[4],menu[5],
            new Btn(btn_easy, btnEasyPos, new EventBtnsNiveis(1)),
            new Btn(btn_medium, btnMediumPos, new EventBtnsNiveis(2)),
            new Btn(btn_hard, btnHardPos, new EventBtnsNiveis(3)),
            new Lb(imBackWP, backPos)
        };
        int pnNiveisPos[] = {0,0,1200,700};
        pnNiveis = new Pn(pnNiveisPos, cp);
        add(pnNiveis);
    }
    
    public class EventBtnsNiveis implements ActionListener{
        private int nivel;
        public EventBtnsNiveis(int n){nivel = n;}
        @Override
        public void actionPerformed(ActionEvent ae) {
            dispose();
            TelaWP tcp = new TelaWP(nivel);
        }
    }
}
