package jogodavelha;
import componentes.Btn;
import componentes.Lb;
import componentes.Pn;
import componentes.Txt;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.border.Border;
import componentes.Frame;
import padroes.ItemsTela;
public class IntroductionJDV extends Frame{
    private ItemsTela it = new ItemsTela();
    private Btn menu[] = it.menuOpGames(this);
    public IntroductionJDV() {
        intro();
        show();
    }
    public void tutorial() {
    }

    private Pn pnEsc;
    private Txt jog1;
    private Txt jog2;
    private ImageIcon imBtn = new ImageIcon(getClass().getResource("imagens/start.png"));
    public void escJog(String ass){
        pnAss.setVisible(false);
        Font txt = new Font("Arial", Font.PLAIN, 20);
        Border b = BorderFactory.createLineBorder(Color.black, 3);
        int txtjog1[] = {50,260,200,40}; int txtjog2[] = {330,260,200,40};
        jog1 = new Txt(txtjog1, txt, Color.cyan, b); jog2 = new Txt(txtjog2, txt, Color.cyan, b);
        jog1.setText("Jogador01"); jog2.setText("Jogador02");
        int lbjog1[] = {30,70,250,100}; int lbjog2[] = {310,70,250,100};
        int lbn1[] = {50,210,200,40}; int lbn2[] = {330,210,200,40};
        int lbx[] = {96,330,100,100}; int lby[] = {376,330,100,100}; int btnP[] = {460,450,100,100};
        Font jog = new Font("Arial", Font.PLAIN, 30);
        Font lb = new Font("Arial", Font.PLAIN, 20);
        Font xo = new Font("Arial", Font.PLAIN, 70);
        Start b1 = new Start(ass);
        Component cp[] = {
            new Lb("NOME", lb, lbn1, Color.black, null),
            new Lb("NOME", lb, lbn2, Color.black, null),
            new Lb("X", xo, lbx, Color.white, b),
            new Lb("O", xo, lby, Color.white, b),
            new Lb("Jogador 01", jog, lbjog1, Color.black, b),
            new Lb("Jogador 02", jog, lbjog2, Color.black, b),
            new Btn(imBtn, btnP, null, false, b1),
            jog1, jog2
        };
        int pnEscP[] = {0,0,600,600};
        pnEsc = new Pn(pnEscP, cp);
        pnEsc.setBackground(Color.darkGray);
        add(pnEsc);
    }
    
    private Pn pnIntro;
    public void intro(){
        int backPos[] = {0,0,1200,700}; int vsCompPos[] = {430,262,398,63};
        int titlePos[] = {254,70,752,109}; int multPos[] = {435,351,386,62};
        int tutorialPos[] = {496,440,266,63}; int histPos[] = {503,526,252,62};
        ImageIcon btn_vscomputer[] = {im.addImagem("btn_vscomputer_jdv"),im.addImagem("btn_vscomputer_jdv_t"),im.addImagem("btn_vscomputer_jdv_p")};
        ImageIcon btn_multi[] = {im.addImagem("btn_multiplayer_jdv"),im.addImagem("btn_multiplayer_jdv_t"),im.addImagem("btn_multiplayer_jdv_p")};
        ImageIcon btn_tutorial[] = {im.addImagem("btn_tutorial_jdv"),im.addImagem("btn_tutorial_jdv_t"),im.addImagem("btn_tutorial_jdv_p")};
        ImageIcon btn_hist[] = {im.addImagem("btn_historic_jdv"),im.addImagem("btn_historic_jdv_t"),im.addImagem("btn_historic_jdv_p")};
        Component cp[] = {
            it.btnClose(),
            it.btnSomOutro(),
            menu[0],menu[1],menu[2],menu[3],menu[4],menu[5],
            new Lb(im.addImagem("title_jdv"), titlePos),
            new Btn(btn_vscomputer, vsCompPos, new EventBtnsIntro(1)),
            new Btn(btn_multi, multPos, new EventBtnsIntro(2)),
            new Btn(btn_tutorial, tutorialPos, new EventBtnsIntro(3)),
            new Btn(btn_hist, histPos, new EventBtnsIntro(4)),
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
            new Btn(btn_addtion, btnAddtionPos, new EventBtnsAss("adicao")),
            new Btn(btn_division, btnDivisionPos, new EventBtnsAss("divisao")),
            new Btn(btn_subtraction, btnSubtractionPos, new EventBtnsAss("subtracao")),
            new Btn(btn_multiplication, btnMultiplicationPos, new EventBtnsAss("multiplicacao")),
            new Lb(im.addImagem("back_intro_jdv"), backPos),
        };
        int pnAssP[] = {0,0,1200,700};
        pnAss = new Pn(pnAssP, cp);
        add(pnAss);
    }
    
    private class EventBtnsIntro implements ActionListener{
        private int n;
        public EventBtnsIntro(int n) {this.n = n;}
        @Override
        public void actionPerformed(ActionEvent ae) {
            pnIntro.setVisible(false);
            switch (n) {
                case 1:assunto();break;
                case 2:assunto();break;
                case 3:tutorial();break;
                case 4:tutorial();break;
                default:break;
            }
        }
    }
    private class EventBtnsAss implements ActionListener{
        private String ass;
        public EventBtnsAss(String ass){
            this.ass = ass;
        }
        @Override
        public void actionPerformed(ActionEvent ae) {
            escJog(ass);
        }
    }
        
    private class Start implements ActionListener{
        private String ass;
        public Start(String ass){this.ass = ass;}
        @Override
        public void actionPerformed(ActionEvent ae) {
            dispose();
            TelaJDV tjdv = new TelaJDV(ass, jog1.getText(), jog2.getText());
        }
    }
}
