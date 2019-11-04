package campominado;
import componentes.Btn;
import componentes.Pn;
import java.awt.Component;
import componentes.Lb;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import componentes.Frame;
import padroes.ItemsTela;
public class IntroductionCM extends Frame{
    private TelaCM tcm;
    private ItemsTela it = new ItemsTela();
    private Btn menu[] = it.menuOpGames(this);
    public IntroductionCM(int esc) {
        if(esc==1){intro();}else{niveis();}
        show();
    }
    
    private Pn pnNiveis;
    private final ImageIcon imEasy = new ImageIcon(getClass().getResource("imagens/btn_easy_cm.png"));
    private final ImageIcon imEasyT = new ImageIcon(getClass().getResource("imagens/btn_easy_cm_t.png"));
    private final ImageIcon imEasyP = new ImageIcon(getClass().getResource("imagens/btn_easy_cm_p.png"));
    private final ImageIcon imMedium = new ImageIcon(getClass().getResource("imagens/btn_medium_cm.png"));
    private final ImageIcon imMediumT = new ImageIcon(getClass().getResource("imagens/btn_medium_cm_t.png"));
    private final ImageIcon imMediumP = new ImageIcon(getClass().getResource("imagens/btn_medium_cm_p.png"));
    private final ImageIcon imHard = new ImageIcon(getClass().getResource("imagens/btn_hard_cm.png"));
    private final ImageIcon imHardT = new ImageIcon(getClass().getResource("imagens/btn_hard_cm_t.png"));
    private final ImageIcon imHardP = new ImageIcon(getClass().getResource("imagens/btn_hard_cm_p.png"));
    public void niveis() {
        int backNiveisPos[] = {0,0,1200,700}; int btnEasyPos[] = {496,174,189,71};
        int btnMediumPos[] = {439,311,304,71}; int btnHardPos[] = {502,445,189,79};
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
            new Lb(imBackIntro, backNiveisPos)
        };
        int pnNiveisPos[] = {0,0,1200,700};
        pnNiveis = new Pn(pnNiveisPos, cp);
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
    private class EventBtnsNiveis implements ActionListener{
        private int nil; private int x; private int y;
        private EventBtnsNiveis(int nil){this.nil = nil;}
        @Override
        public void actionPerformed(ActionEvent e){
            pnNiveis.setVisible(false);
            switch(nil){
                case 1:x = y = 14;break;
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
            pnIntro.setVisible(false);
            switch (n) {
                case 1:niveis();break;
                case 2:tutorial();break;
                default:break;
            }
        }
        
    }
}
