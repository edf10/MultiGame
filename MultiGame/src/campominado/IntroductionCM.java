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
    public IntroductionCM(int x, int y) {
        super(x, y);
        niveis();
        
        setVisible(true);
    }
    
    private Pn pnNiveis;
    private final ImageIcon imFundo = new ImageIcon(getClass().getResource("fundoNiveis.jpg"));
    @Override
    public void niveis() {
        Font nivel = new Font("Arial", Font.PLAIN, 30);
        Color c = new Color(231, 218, 87);
        Nivel e1 = new Nivel(1);
        Nivel e2 = new Nivel(2);
        Nivel e3 = new Nivel(3);
        int posF[] = {240,270,220,50};
        int posM[] = {240,340,220,50};
        int posD[] = {240,410,220,50};
        int lbFundoP[] = {0,0,700,700};
        Border b = BorderFactory.createLineBorder(Color.black, 3);
        Component cp[] = {
            new Btn("FÁCIL", nivel, c, posF, b, false, false, e1),
            new Btn("MÉDIO", nivel, c, posM, b, false, false, e2),
            new Btn("DIFÍCIL", nivel, c, posD, b, false, false, e3),
            new Lb(imFundo, lbFundoP)
        };
        int pnNiveisP[] = {0,0,700,700};
        pnNiveis = new Pn(pnNiveisP, cp);
        add(pnNiveis);
    }
    @Override
    public void tutorial(){
    }
    @Override
    public void intro(){
    }
    private static int nivel;
    private class Nivel implements ActionListener{
        private int nil;
        private int x;
        private int y;
        private Nivel(int nil){
            this.nil = nil;
        }
        @Override
        public void actionPerformed(ActionEvent e){
            pnNiveis.setVisible(false);
            switch(nil){
                case 1:x = y = 12;break;
                case 2:x = y = 16;break;
                case 3:x = y = 18;break;
                default:break;
            }
            tcm = new TelaCM(nil, x, y);
        }
    }
    
}
