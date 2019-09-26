package jogodavelha;
import padroes.IntroductionGame;
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
public class IntroductionJDV extends IntroductionGame{

    public IntroductionJDV() {
        super(600,600);
        intro();
        setVisible(true);
    }
    @Override
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
    private final ImageIcon imFundo = new ImageIcon(getClass().getResource("imagens/intro.png"));
    @Override
    public void intro(){
        int btnClassicP[] = {175,200,250,60}; int btnPersoP[] = {175,270,250,60}; int btnTutP[] = {175,340,250,60};
        int lbFundoP[] = {0,-30,600,600}; int lbtitleP[] = {125,30,350,80};
        Font lb = new Font("Arial", Font.PLAIN, 40);
        Font btn = new Font("Arial", Font.PLAIN, 35);
        Border b = BorderFactory.createLineBorder(Color.black, 3);
        Border a = BorderFactory.createLineBorder(Color.white, 3);
        Btns b1 = new Btns(1); Btns b2 = new Btns(2); Btns b3 = new Btns(3);
        Component cp[] = {
            new Lb("JOGO DA VELHA", lb, lbtitleP, Color.white, a),
            new Btn("Classic", btn, Color.white, Color.black, btnClassicP, b, true, false, b1),
            new Btn("Personalizado", btn, Color.white, Color.black, btnPersoP, b, true, false, b2),
            new Btn("Tutorial", btn, Color.white, Color.black, btnTutP, b, true, false, b3),
            new Lb(imFundo, lbFundoP)
        };
        int pnIntroP[] = {0,0,600,600};
        pnIntro = new Pn(pnIntroP, cp, Color.black);
        add(pnIntro);
    }
    
    private Pn pnAss;
    private final ImageIcon imBack = new ImageIcon(getClass().getResource("imagens/assuntos.jpg"));
    public void assunto(){
        pnIntro.setVisible(false);
        int lbFundo[] = {0,0,600,600}; int btn1[] = {175,180,250,50}; int btn4[] = {175,370,250,50};
        int btn2[] = {175,250,250,50}; int btn3[] = {175,310,250,50}; int lbtitle[] = {125,20,350,80};
        Font f = new Font("Arial", Font.PLAIN, 30);
        Border b = BorderFactory.createLineBorder(Color.white, 1);
        Border a = BorderFactory.createLineBorder(Color.black, 3);
        Font d = new Font("Arial", Font.PLAIN, 40);
        Component cp[] = {
            new Lb("Assuntos", d, lbtitle, Color.black, a),
            new Btn("Multiplicação", f, null, Color.white, btn1, b, false, false, new Esc("multiplicacao")),
            new Btn("Divisão", f, null, Color.white, btn2, b, false, false, new Esc("divisao")),
            new Btn("Soma", f, null, Color.white, btn3, b, false, false, new Esc("adicao")),
            new Btn("Subtração", f, null, Color.white, btn4, b, false, false, new Esc("subtracao")),
            new Lb(imBack, lbFundo)
        };
        int pnAssP[] = {0,0,600,600};
        pnAss = new Pn(pnAssP, cp);
        add(pnAss);
    }
    
    private class Btns implements ActionListener{
        private int n;
        public Btns(int n) {this.n = n;}
        @Override
        public void actionPerformed(ActionEvent ae) {
            switch (n) {
                case 1:assunto();break;
                case 2:assunto();break;
                case 3:tutorial();break;
                default:break;
            }
        }
    }
    private class Esc implements ActionListener{
        private String ass;
        public Esc(String ass){
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
