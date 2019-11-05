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
    private ItemsTela it = new ItemsTela();
    private Btn menu[] = it.menuOpGames(this);
    private Pn pnNiveis;
    public void niveis() {
        int backNiveisPos[] = {0,0,1200,700}; int btnEasyPos[] = {496,174,189,71};
        int btnMediumPos[] = {439,311,304,71}; int btnHardPos[] = {502,445,189,79};
        ImageIcon btn_easy[] = {im.addImagem("btn_easy_cm"),im.addImagem("btn_easy_cm_t"),im.addImagem("btn_easy_cm_p")};
        ImageIcon btn_medium[] = {im.addImagem("btn_medium_cm"),im.addImagem("btn_medium_cm_t"),im.addImagem("btn_medium_cm_p")};
        ImageIcon btn_hard[] = {im.addImagem("btn_hard_cm"),im.addImagem("btn_hard_cm_t"),im.addImagem("btn_hard_cm_p")};
        Component cp[] = {
            it.btnClose(),
            it.btnSomOutro(),
            menu[0],menu[1],menu[2],menu[3],menu[4],menu[5],
            new Btn(btn_easy, btnEasyPos, new EventBtnsNiveis(1)),
            new Btn(btn_medium, btnMediumPos, new EventBtnsNiveis(2)),
            new Btn(btn_hard, btnHardPos, new EventBtnsNiveis(3)),
            new Lb(im.addImagem("back_intro_cm"), backNiveisPos)
        };
        int pnNiveisPos[] = {0,0,1200,700};
        pnNiveis = new Pn(pnNiveisPos, cp);
        add(pnNiveis);
    }
    public void tutorial(){
    }
    
    private Pn pnIntro;
    public void intro(){
        int backCMPos[] = {0,0,1200,700}; int titlePos[] = {250,52,805,100};
        int btnPlayPos[] = {526,273,185,71}; int btnRankingPos[] = {467,381,304,79};
        int btnTutorialPos[] = {464,497,346,79};
        ImageIcon btn_play_cm[] = {im.addImagem("btn_play_cm"),im.addImagem("btn_play_cm_t"),im.addImagem("btn_play_cm_p")};
        ImageIcon btn_ranking_cm[] = {im.addImagem("btn_ranking_cm"),im.addImagem("btn_ranking_cm_t"),im.addImagem("btn_ranking_cm_p")};
        ImageIcon btn_tutorial_cm[] = {im.addImagem("btn_tutorial_cm"),im.addImagem("btn_tutorial_cm_t"),im.addImagem("btn_tutorial_cm_p")};
        Component cp[] = {
            it.btnClose(),
            it.btnSomOutro(),
            menu[0],menu[1],menu[2],menu[3],menu[4], menu[5],
            new Lb(im.addImagem("title_cm"), titlePos),
            new Btn(btn_play_cm, btnPlayPos, new EventBtnsIntro(1)),
            new Btn(btn_ranking_cm, btnRankingPos, new EventBtnsIntro(2)),
            new Btn(btn_tutorial_cm,btnTutorialPos, new EventBtnsIntro(3)),
            new Lb(im.addImagem("back_intro_cm"), backCMPos),
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
            TelaCM tcm = new TelaCM(new Campo(x,y)); tcm.show();
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
