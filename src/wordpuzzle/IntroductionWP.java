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
    private final ItemsTela it = new ItemsTela();
    private Btn menu[];
    private Pn pnTutorial;
    public void tutorial() {
        pnTutorial = new Pn(); pnTutorial.setLayout(null);pnTutorial.setBounds(0, 0, 1200, 700);
        int backPos[] = {0,0,1200,700}; it.setTelaAntIntro(3);
        add(it.btnClose()); add(it.returnGames()); add(it.btnSomOutro());
        pnTutorial.add(new Lb(im.addImagem("tutorial_wp"),backPos));
        add(pnTutorial);
    }
    public void ranking(){
        dispose();
        RecordesWP r = new RecordesWP(); r.initial();
    }
    private Pn pnIntro;
    public void intro() {
        int backPos[] = {0,0,1200,700}; int titlePos[] = {252,73,700,107};
        int classicPos[] = {478,254,227,52}; int rankPos[] = {484,347,231,58}; int tutoPos[] = {475,445,262,58};
        ImageIcon btn_classic[] = {im.addImagem("btn_classic_wp"),im.addImagem("btn_classic_wp_t"),im.addImagem("btn_classic_wp_p")};
        ImageIcon btn_rank[] = {im.addImagem("btn_ranking_wp"),im.addImagem("btn_ranking_wp_t"),im.addImagem("btn_ranking_wp_p")};
        ImageIcon btn_tuto[] = {im.addImagem("btn_tutorial_wp"),im.addImagem("btn_tutorial_wp_t"),im.addImagem("btn_tutorial_wp_p")};
        menu = it.menuOpGamesIntro(this);
        Component cp[] = {
            new Lb(im.addImagem("title_wp"), titlePos),
            it.btnClose(), it.btnSomOutro(),
            menu[0],menu[1],menu[2],menu[3],
            new Btn(btn_classic, classicPos, new EventBtnsIntro(1)),
            new Btn(btn_rank, rankPos, new EventBtnsIntro(2)),
            new Btn(btn_tuto, tutoPos, new EventBtnsIntro(3)),
            new Lb(im.addImagem("back_intro_wp"), backPos)
        };
        
        int pnIntroP[] = {0,0,1200,700};
        
        pnIntro = new Pn(pnIntroP, cp, Color.orange);
        add(pnIntro);
    }
    
    public class EventBtnsIntro implements ActionListener{
        private final int esc;
        public EventBtnsIntro(int esc){this.esc = esc;}
        @Override
        public void actionPerformed(ActionEvent ae) {
            pnIntro.setVisible(false);
            switch(esc){
                case 1: niveis();break;
                case 2: ranking();break;
                default: tutorial();break;
            }
        }
    }
    
    private Pn pnNiveis;
    public void niveis(){
        int backPos[] = {0,0,1200,700}; int btnEasyPos[] = {526,172,189,72}; menu = it.menuOpGames(this);
        int btnMediumPos[] = {468,300,304,72}; int btnHardPos[] = {532,430,189,80};
        ImageIcon btn_easy[] = {im.addImagem("btn_easy_wp"),im.addImagem("btn_easy_wp_t"),im.addImagem("btn_easy_wp_p")};
        ImageIcon btn_medium[] = {im.addImagem("btn_medium_wp"),im.addImagem("btn_medium_wp_t"),im.addImagem("btn_medium_wp_p")};
        ImageIcon btn_hard[] = {im.addImagem("btn_hard_wp"),im.addImagem("btn_hard_wp_t"),im.addImagem("btn_hard_wp_p")};
        it.setTelaAntIntro(3);
        Component cp[] = {
            it.btnClose(), it.btnSomOutro(),
            menu[0],menu[1],menu[2],menu[3],
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
        private final int nivel;
        public EventBtnsNiveis(int n){nivel = n;}
        @Override
        public void actionPerformed(ActionEvent ae) {
            dispose();
            TelaWP tcp = new TelaWP(); tcp.setNivel(nivel); tcp.configuracoes(); tcp.show();
        }
    }
}
