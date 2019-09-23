package campominado;
import componentes.Btn;
import componentes.Pn;
import java.awt.Color;
import padroes.IntroductionGame;
import java.awt.Component;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import componentes.Lb;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
public class IntroductionCM extends IntroductionGame{
    private TelaCM tcm;
    public IntroductionCM() {
        super(700,700);
        //niveis();
        intro();
        setVisible(true);
    }
    
    private Pn pnNiveis;
    private final ImageIcon imFundo = new ImageIcon(getClass().getResource("fundoNiveis.jpg"));
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
    @Override
    public void tutorial(){
    }
    
    private Pn pnIntro;
    private final ImageIcon imIntro = new ImageIcon(getClass().getResource("introCM.jpg"));
    @Override
    public void intro(){
        int lbIntroP[] = {0,0,700,700}; int pnIntroP[] = {0,0,684,700};
        int btnJogarP[] = {200,220,300,80}; int lbtitle[] = {125,20,450,100};
        int btnTurorialP[] = {200,310,300,80}; int btnRecordesP[] = {200,400,300,80};
        Font btn = new Font("Arial", Font.PLAIN, 55);
        Font title = new Font("Arial", Font.PLAIN, 50);
        Border b = BorderFactory.createLineBorder(Color.black, 3);
        Border t = BorderFactory.createLineBorder(Color.black, 3);
        Btns b1 = new Btns(1); Btns b2 = new Btns(2); Btns b3 = new Btns(3);
        Component cp[] = {
            new Btn("Jogar", btn, Color.white, Color.black, btnJogarP, b, true, false, b1),
            new Btn("Tutorial", btn, Color.white, Color.black, btnTurorialP, b, true, false, b2),
            new Btn("Recordes", btn, Color.white, Color.black, btnRecordesP, b, true, false, b3),
            new Lb("CAMPO MINADO", title, lbtitle, Color.yellow, t),
            new Lb(imIntro, lbIntroP),
        };
        pnIntro = new Pn(pnIntroP, cp);
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
    private class Btns implements ActionListener{
        private int n;
        public Btns(int n) {this.n = n;}
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
