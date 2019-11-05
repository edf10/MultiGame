package finalizacao;
import java.awt.Color;
import java.awt.Font;
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
import componentes.Frame;
import jogodavelha.IntroductionJDV;
import jogodavelha.TelaJDV;

public class TelaGOWin extends Frame{
    private final ImageIcon imJogarMesmo = new ImageIcon(getClass().getResource("return.png"));
    private final ImageIcon imMenuJogos = new ImageIcon(getClass().getResource("home.png"));
    private final ImageIcon imJogarOutro = new ImageIcon(getClass().getResource("arrow.png"));
    private TelaCM CM;
    private Campo c;
    
    public TelaGOWin(String tempoCM, TelaCM cm, Campo c, boolean t){
        this.c = c; CM = cm;
        String tempo = "Tempo: "+tempoCM;
        goWinCMJDV(1, tempo, t);
        getContentPane().setBackground(Color.LIGHT_GRAY);
        
        setVisible(true);
    }
    
    private String ganh;
    private TelaJDV jdv;
    public TelaGOWin(String ganh, TelaJDV jdv){
        this.ganh = ganh;
        this.jdv = jdv;
        goWinCMJDV(2, "", true);
        
        setVisible(true);
    }
    
    private JPanel pnGO;
    public void goWinCMJDV(int jogo, String tempoCM, boolean t){
        String goWin = "";
        Font lbT = null;
        Font lbGO = null;
        int lbtitleP[] = {0,0,0,0};
        Funcao e3 = null,e2 = null,e1 = null;
        if(jogo==1){
            lbT = new Font("Arial", Font.BOLD, 20);
            lbGO = new Font("Arial", Font.PLAIN, 40);
            lbtitleP[0] = 87; lbtitleP[1] = 40; lbtitleP[2] = 210; lbtitleP[3] = 50;
            e3 = new Funcao(3,1);e2 = new Funcao(2,1);e1 = new Funcao(1,1);
            goWin = (t)?"You Win!":"GameOver!";
        }else if(jogo==2){
            lbGO = new Font("Arial", Font.PLAIN, 30);
            lbtitleP[0] = 87; lbtitleP[1] = 70; lbtitleP[2] = 210; lbtitleP[3] = 50;
            e3 = new Funcao(3,2);e2 = new Funcao(2,2);e1 = new Funcao(1,2);
            goWin = (!"Velha".equals(ganh))? ganh+"Win":ganh;
        }
        int lbtempoP[] = {87,110,210,30};
        
        
        
        int jogarMesmoP[] = {100,160,55,50}; int jogarOutroP[] = {240,160,55,50}; int menuJogosP[] = {170,160,55,50};
        Component lis[] = {
            new Lb(tempoCM, lbT, lbtempoP, Color.blue, null),
            new Lb(goWin, lbGO, lbtitleP, Color.black, null),
            new Btn(imJogarMesmo, jogarMesmoP, null, false, e1),
            new Btn(imJogarOutro, jogarOutroP, null, false, e3),
            new Btn(imMenuJogos, menuJogosP, null, false, e2)
        };
        int pnGOP[] = {0,0,400,300}; pnGO = new Pn(pnGOP, lis, null);
        add(pnGO);
    }
    
    private class Funcao implements ActionListener{
        private int n;
        private int jogo;
        public Funcao(int n, int jogo){this.n = n;this.jogo = jogo;}
        @Override
        public void actionPerformed(ActionEvent ae) {
            dispose();
            if(jogo==1){
                CM.dispose();
                switch(n){
                    case 1:TelaCM tc = new TelaCM(new Campo(c.getX(), c.getY()));break;
                    case 2:MultiGameTela mgt = new MultiGameTela(); mgt.Jogos(); mgt.show();break;
                    case 3:IntroductionCM i = new IntroductionCM(); i.niveis(); i.show();break;
                    default:break;
                }
            }else if(jogo==2){
                jdv.dispose();
                
                switch(n){
                    case 1:TelaJDV tjdv = new TelaJDV(jdv.getAss(), jdv.getJog1(), jdv.getJog2());break;
                    case 2:MultiGameTela mgt = new MultiGameTela(); mgt.Jogos(); mgt.show();break;
                    case 3:IntroductionJDV i = new IntroductionJDV();break;
                    default:break;
                }
            }
        }
        
    }
    
}
