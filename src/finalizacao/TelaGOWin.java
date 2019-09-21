package finalizacao;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import campominado.TelaCM;
import multigame.MultiGameTela;
import javax.swing.JPanel;
import campominado.Campo;
import campominado.IntroductionCM;
import java.awt.Component;
import componentes.Lb;
import componentes.Pn;
import componentes.Btn;

public class TelaGOWin extends JFrame{
    private final ImageIcon imJogarMesmo = new ImageIcon(getClass().getResource("return.png"));
    private final ImageIcon imMenuJogos = new ImageIcon(getClass().getResource("home.png"));
    private final ImageIcon imJogarOutro = new ImageIcon(getClass().getResource("arrow.png"));
    private TelaCM CM;
    private Campo c;
    private IntroductionCM intro;
    
    public TelaGOWin(String tempoCM, TelaCM cm, Campo c, IntroductionCM intro, boolean t){
        setSize(400, 300);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        this.c = c;
        CM = cm;
        this.intro = intro;
        goWinCM(tempoCM, t);
        getContentPane().setBackground(Color.LIGHT_GRAY);
        
        setVisible(true);
    }
    private JPanel pnGO;
    public void goWinCM(String tempoCM, boolean t){
        String goWin = (t)?"You Win!":"GameOver!";
        
        Font lbT = new Font("Arial", Font.BOLD, 20);
        Font lbGO = new Font("Arial", Font.PLAIN, 40);
        int lbtempoP[] = {87,110,210,30}; int lbtitleP[] = {87,40,210,50};
        
        Funcao e3 = new Funcao(3);Funcao e2 = new Funcao(2);Funcao e1 = new Funcao(1);
        
        int jogarMesmoP[] = {100,160,55,50}; int jogarOutroP[] = {240,160,55,50}; int menuJogosP[] = {170,160,55,50};
        Component lis[] = {
            new Lb("Tempo: "+tempoCM, lbT, lbtempoP, Color.blue, null),
            new Lb(goWin, lbGO, lbtitleP, Color.black, null),
            new Btn(imJogarMesmo, jogarMesmoP, null, false, e1),
            new Btn(imJogarOutro, jogarOutroP, null, false, e3),
            new Btn(imMenuJogos, menuJogosP, null, false, e2)
        };
        int pnGOP[] = {0,0,400,300};
        pnGO = new Pn(pnGOP, lis, null);
        add(pnGO);
    }
    
    private class Funcao implements ActionListener{
        private int n;
        public Funcao(int n){this.n = n;}
        @Override
        public void actionPerformed(ActionEvent ae) {
            dispose();CM.dispose();
            switch(n){
                case 1:TelaCM tc = new TelaCM(CM.getN(), c.getX(), c.getY());break;
                case 2:MultiGameTela mgt = new MultiGameTela(2);break;
                case 3:IntroductionCM i = new IntroductionCM(700, 700);break;
                default:break;
            }
        }
        
    }
    
}
