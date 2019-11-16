package jogodavelha;
import componentes.Btn;
import componentes.Lb;
import componentes.Pn;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import componentes.Frame;
import java.util.Random;
import padroes.ItemsTela;
import user.User;
public class IntroductionJDV extends Frame{
    private ItemsTela it = new ItemsTela();
    private Btn menu[] = it.menuOpGames(this);
    private TelaJDV tjdv = new TelaJDV();
    private User user;
    
    public IntroductionJDV(User user){
        this.user = user;
    }
    
    public void tutorial() {
    }

    private Pn pnIntro;
    public void intro(){//262,351,440,526
        int backPos[] = {0,0,1200,700}; 
        int titlePos[] = {254,70,752,109}; int multPos[] = {435,262,386,62};
        int tutorialPos[] = {496,351,266,63}; int histPos[] = {503,440,252,62};
        ImageIcon btn_multi[] = {im.addImagem("btn_multiplayer_jdv"),im.addImagem("btn_multiplayer_jdv_t"),im.addImagem("btn_multiplayer_jdv_p")};
        ImageIcon btn_tutorial[] = {im.addImagem("btn_tutorial_jdv"),im.addImagem("btn_tutorial_jdv_t"),im.addImagem("btn_tutorial_jdv_p")};
        ImageIcon btn_hist[] = {im.addImagem("btn_historic_jdv"),im.addImagem("btn_historic_jdv_t"),im.addImagem("btn_historic_jdv_p")};
        Component cp[] = {
            it.btnClose(),
            it.btnSomOutro(),
            menu[0],menu[1],menu[2],menu[3],menu[4],menu[5],
            new Lb(im.addImagem("title_jdv"), titlePos),
            new Btn(btn_multi, multPos, new EventBtnsIntro(1)),
            new Btn(btn_tutorial, tutorialPos, new EventBtnsIntro(2)),
            new Btn(btn_hist, histPos, new EventBtnsIntro(3)),
            new Lb(im.addImagem("back_intro_jdv"), backPos)
        };
        int pnIntroP[] = {0,0,1200,700};
        pnIntro = new Pn(pnIntroP, cp, Color.black);
        add(pnIntro);
    }
    
    private Pn pnAss;
    public void assunto(){
        int backPos[] = {0,0,1200,700}; int btnAddtionPos[] = {473,190,252,57};
        int btnDivisionPos[] = {482,291,234,57}; int btnSubtractionPos[] = {412,391,374,63};
        int btnMultiplicationPos[] = {371,490,456,57};
        ImageIcon btn_addtion[] = {im.addImagem("btn_addition_jdv"),im.addImagem("btn_addition_jdv_t"),im.addImagem("btn_addition_jdv_p")};
        ImageIcon btn_division[] = {im.addImagem("btn_division_jdv"),im.addImagem("btn_division_jdv_t"),im.addImagem("btn_division_jdv_p")};
        ImageIcon btn_subtraction[] = {im.addImagem("btn_subtraction_jdv"),im.addImagem("btn_subtraction_jdv_t"),im.addImagem("btn_subtraction_jdv_p")};
        ImageIcon btn_multiplication[] = {im.addImagem("btn_multiplication_jdv"),im.addImagem("btn_multiplication_jdv_t"),im.addImagem("btn_multiplication_jdv_p")};
        Component cp[] = {
            it.btnClose(),
            it.btnSomOutro(),
            menu[0],menu[1],menu[2],menu[3],menu[4],menu[5],
            new Btn(btn_addtion, btnAddtionPos, new EventBtnsAss(1)),
            new Btn(btn_division, btnDivisionPos, new EventBtnsAss(2)),
            new Btn(btn_subtraction, btnSubtractionPos, new EventBtnsAss(3)),
            new Btn(btn_multiplication, btnMultiplicationPos, new EventBtnsAss(4)),
            new Lb(im.addImagem("back_intro_jdv"), backPos),
        };
        int pnAssP[] = {0,0,1200,700};
        pnAss = new Pn(pnAssP, cp);
        add(pnAss);
    }
    
    public void jogadores(String jogador01, String jogador02){
        Random sortear = new Random();
        int jog1 = sortear.nextInt(2); int jog2 = (jog1==1) ? 0:1;
        String names[] = {jogador01,jogador02};
        tjdv.setJog1(names[jog1]);
        tjdv.setJog2(names[jog2]);
    }
    
    private class EventBtnsIntro implements ActionListener{
        private int n;
        public EventBtnsIntro(int n) {this.n = n;}
        @Override
        public void actionPerformed(ActionEvent ae) {
            pnIntro.setVisible(false);
            switch (n) {
                case 1:assunto();jogadores(user.getUsername(), "Computer");break;
                case 2:tutorial();break;
                case 3:tutorial();break;
                default:break;
            }
        }
    }
    private class EventBtnsAss implements ActionListener{
        private int assunto;
        public EventBtnsAss(int assunto){
            this.assunto = assunto;
        }
        @Override
        public void actionPerformed(ActionEvent ae) {
            pnAss.setVisible(false);
            dispose();
            tjdv.setAss(assunto);
            tjdv.start();
            tjdv.show();
        }
    }
}
