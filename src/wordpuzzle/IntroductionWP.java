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

    public void tutorial() {
    }
    
    private Pn pnIntro;
    public void intro() {
        int backPos[] = {0,0,1200,700}; int titlePos[] = {252,73,700,107};
        int classicPos[] = {478,249,227,52}; int customPos[] = {477,342,231,59};
        int rankPos[] = {484,440,231,58}; int tutoPos[] = {475,530,262,58};
        ImageIcon btn_classic[] = {im.addImagem("btn_classic_wp"),im.addImagem("btn_classic_wp_t"),im.addImagem("btn_classic_wp_p")};
        ImageIcon btn_custom[] = {im.addImagem("btn_custom_wp"),im.addImagem("btn_custom_wp_t"),im.addImagem("btn_custom_wp_p")};
        ImageIcon btn_rank[] = {im.addImagem("btn_ranking_wp"),im.addImagem("btn_ranking_wp_t"),im.addImagem("btn_ranking_wp_p")};
        ImageIcon btn_tuto[] = {im.addImagem("btn_tutorial_wp"),im.addImagem("btn_tutorial_wp_t"),im.addImagem("btn_tutorial_wp_p")};
        
        Component cp[] = {
            new Lb(im.addImagem("title_wp"), titlePos),
            it.btnClose(),
            it.btnSomOutro(),
            menu[0],menu[1],menu[2],menu[3],menu[4],menu[5],
            new Btn(btn_classic, classicPos, new EventBtnsIntro()),
            new Btn(btn_custom, customPos, null),
            new Btn(btn_rank, rankPos, null),
            new Btn(btn_tuto, tutoPos, null),
            new Lb(im.addImagem("back_intro_wp"), backPos)
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
    public void niveis(){
        int backPos[] = {0,0,1200,700}; int btnEasyPos[] = {526,172,189,72};
        int btnMediumPos[] = {468,300,304,72}; int btnHardPos[] = {532,430,189,80};
        ImageIcon btn_easy[] = {im.addImagem("btn_easy_wp"),im.addImagem("btn_easy_wp_t"),im.addImagem("btn_easy_wp_p")};
        ImageIcon btn_medium[] = {im.addImagem("btn_medium_wp"),im.addImagem("btn_medium_wp_t"),im.addImagem("btn_medium_wp_p")};
        ImageIcon btn_hard[] = {im.addImagem("btn_hard_wp"),im.addImagem("btn_hard_wp_t"),im.addImagem("btn_hard_wp_p")};
        Component cp[] = {
            it.btnClose(),
            it.btnSomOutro(),
            menu[0],menu[1],menu[2],menu[3],menu[4],menu[5],
            new Btn(btn_easy, btnEasyPos, new EventBtnsNiveis(1)),
            new Btn(btn_medium, btnMediumPos, new EventBtnsNiveis(2)),
            new Btn(btn_hard, btnHardPos, new EventBtnsNiveis(3)),
            new Lb(im.addImagem("back_intro_wp"), backPos)
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
            TelaWP tcp = new TelaWP(nivel); tcp.show();
        }
    }
}
