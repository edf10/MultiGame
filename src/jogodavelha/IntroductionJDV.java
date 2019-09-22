package jogodavelha;
import padroes.IntroductionGame;
import componentes.Btn;
import componentes.Lb;
import componentes.Pn;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.border.Border;
public class IntroductionJDV extends IntroductionGame{

    public IntroductionJDV(int x, int y) {
        super(x, y);
        intro();
        setVisible(true);
    }

    @Override
    public void niveis() {
    }
    @Override
    public void tutorial() {
    }
    
    private Pn pnIntro;
    private final ImageIcon imFundo = new ImageIcon(getClass().getResource("fundo.png"));
    @Override
    public void intro(){
        int btnClassicP[] = {175,200,250,80}; int btnPersoP[] = {175,290,250,80};
        int lbFundoP[] = {0,0,600,551}; int lbtitleP[] = {125,20,350,80};
        Font lb = new Font("Arial", Font.PLAIN, 40);
        Font btn = new Font("Arial", Font.PLAIN, 35);
        Border b = BorderFactory.createLineBorder(Color.black, 3);
        Component cp[] = {
            new Lb("JOGO DA VELHA", lb, lbtitleP, Color.white, b),
            new Btn("Classic", btn, Color.green, Color.black, btnClassicP, b, true, false, null),
            new Btn("Personalizado", btn, Color.green, Color.black, btnPersoP, b, true, false, null),
            new Lb(imFundo, lbFundoP)
        };
        int pnIntroP[] = {0,0,600,600};
        pnIntro = new Pn(pnIntroP, cp, Color.lightGray);
        
        add(pnIntro);
    }
    
}
