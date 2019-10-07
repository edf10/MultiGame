package caçapalavras;
import componentes.Btn;
import componentes.Lb;
import componentes.Pn;
import java.awt.Component;
import javax.swing.ImageIcon;
import padroes.IntroductionGame;
public class IntroductionCP extends IntroductionGame{
    public IntroductionCP(){
        super(800,600);
    }

    @Override
    public void tutorial() {
    }
    
    private Pn pnIntro;
    private ImageIcon imIntro = new ImageIcon(getClass().getResource(""));
    @Override
    public void intro() {
        int lbFundo[] = {0,0,800,600};
        int btnStart[] = {300,300,200,200};
        Component cp[] = {
            new Lb(imIntro, lbFundo),
            new Btn()
        };
        
        int pnIntroP[] = {0,0,800,600};
        
        pnIntro = new Pn(pnIntroP, cp);
    }
}
