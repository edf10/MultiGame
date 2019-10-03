package damas;
import componentes.Lb;
import componentes.Pn;
import java.awt.Color;
import java.awt.Component;
import javax.swing.ImageIcon;
import padroes.IntroductionGame;
public class IntroductionDama extends IntroductionGame{
    
    public IntroductionDama(){
        super(800,700);
        intro();
        setVisible(true);
    }
    
    @Override
    public void tutorial() {
    }

    private Pn pnIntro;
    private ImageIcon imTabuleiro = new ImageIcon(getClass().getResource("imagens/tabuleiro.png"));
    @Override
    public void intro() {
        int pnintroP[] = {0,0,800,700}; int lbTabP[] = {55,35,680,600};
        Component cp[] = {
            new Lb(imTabuleiro, lbTabP)
        };
        
        pnIntro = new Pn(pnintroP, cp);
        add(pnIntro);
    }
    
}
