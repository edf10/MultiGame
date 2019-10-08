package caçapalavras;
import componentes.Btn;
import componentes.Lb;
import componentes.Pn;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import padroes.IntroductionGame;
public class IntroductionCP extends IntroductionGame{
    public IntroductionCP(){
        super(800,600);
        intro();
        setVisible(true);
    }

    @Override
    public void tutorial() {
    }
    
    private Pn pnIntro;
    private ImageIcon imIntro = new ImageIcon(getClass().getResource(""));
    private ImageIcon imTitle = new ImageIcon(getClass().getResource("imagens/title.png"));
    @Override
    public void intro() {
        int lbFundo[] = {0,0,800,600}; int lbtitle[] = {150,20,500,128};
        int btnStart[] = {300,270,200,80};
        Font f = new Font("Arial", Font.PLAIN, 40);
        Component cp[] = {
            new Lb(imTitle, lbtitle),
            new Lb(imIntro, lbFundo),
            new Btn("START", f, Color.black, Color.white, btnStart, null, true, false, new Start())
        };
        
        int pnIntroP[] = {0,0,800,600};
        
        pnIntro = new Pn(pnIntroP, cp, Color.orange);
        add(pnIntro);
    }
    
    public class Start implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ae) {
            dispose();
            TelaCP tcp = new TelaCP();
        }
    }
    
}
