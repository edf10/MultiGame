package finalizacao;
import campominado.IntroductionCM;
import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import campominado.TelaCM;
import multigame.MultiGameTela;
import javax.swing.JPanel;
import campominado.Campo;
import campominado.IntroductionCM;

public class TelaGameOver extends JFrame{
    
    private ImageIcon imFundo = new ImageIcon(getClass().getResource("gameover.gif"));
    private JLabel lbFundo = new JLabel("GameOver");
    private JLabel lbTempo;
    private ImageIcon imJogarMesmo = new ImageIcon(getClass().getResource("return.png"));
    private ImageIcon imMenuJogos = new ImageIcon(getClass().getResource("home.png"));
    private ImageIcon imJogarOutro = new ImageIcon(getClass().getResource("arrow.png"));
    private JButton btnMenuJogos = new JButton(imMenuJogos);
    private JButton btnJogarMesmo = new JButton(imJogarMesmo);
    private JButton btnJogarOutro = new JButton(imJogarOutro);
    private TelaCM CM;
    private Campo c;
    private IntroductionCM intro;
    
    public TelaGameOver(String tempoCM, TelaCM cm, Campo c, IntroductionCM intro){
        setSize(400, 300);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        this.c = c;
        CM = cm;
        this.intro = intro;
        gameOverCM(tempoCM);
        getContentPane().setBackground(Color.LIGHT_GRAY);
        
        
        setVisible(true);
    }
    
    public void gameOverCM(String tempoCM){
        lbTempo = new JLabel("Tempo: "+tempoCM);
        
        lbFundo.setLayout(null);
        lbTempo.setLayout(null);
        lbFundo.setBounds(100, 40, 200, 50);
        lbTempo.setBounds(100, 110, 200, 30);
        lbFundo.setHorizontalAlignment((int)CENTER_ALIGNMENT);
        lbTempo.setHorizontalAlignment((int)CENTER_ALIGNMENT);
        lbFundo.setOpaque(false);
        Font lbGO = new Font("Arial", Font.PLAIN, 40);
        Font lbT = new Font("Arial", Font.BOLD, 20);
        lbFundo.setFont(lbGO);
        lbTempo.setFont(lbT);
        lbTempo.setForeground(Color.blue);
        
        add(lbFundo);
        add(lbTempo);
        
        btnJogarMesmo.setLayout(null);
        btnJogarMesmo.setBounds(100, 160, 55, 50);
        btnJogarMesmo.setBackground(null);
        btnJogarMesmo.setFocusPainted(false);
        btnJogarMesmo.setBorder(null);
        
        btnMenuJogos.setLayout(null);
        btnMenuJogos.setBounds(170, 160, 55, 50);
        btnMenuJogos.setBackground(null);
        btnMenuJogos.setFocusPainted(false);
        btnMenuJogos.setBorder(null);
        
        btnJogarOutro.setLayout(null);
        btnJogarOutro.setBounds(240, 160, 55, 50);
        btnJogarOutro.setBackground(null);
        btnJogarOutro.setFocusPainted(false);
        btnJogarOutro.setBorder(null);
        
        add(btnJogarMesmo);
        add(btnMenuJogos);
        add(btnJogarOutro);
        
        Funcao e3 = new Funcao(3);
        btnJogarOutro.addActionListener(e3);
        
        Funcao e2 = new Funcao(2);
        btnMenuJogos.addActionListener(e2);
        
        Funcao e1 = new Funcao(1);
        btnJogarMesmo.addActionListener(e1);
    }
    
    private class Funcao implements ActionListener{
        private int n;
        private int x;
        private int y;
        public Funcao(int n){
            this.n = n;
        }
        @Override
        public void actionPerformed(ActionEvent ae) {
            dispose();
            CM.dispose();
            intro.dispose();
            switch(n){
                case 1:
                    System.out.println(c.getX()+" "+c.getY());
                    TelaCM tc = new TelaCM(CM.getN(), c.getX(), c.getY(), intro);
                    break;
                case 2:
                    MultiGameTela mgt = new MultiGameTela(2);
                    break;
                case 3:
                    IntroductionCM i = new IntroductionCM(700, 700);
                    //TelaCM tcm = new TelaCM();
                    break;
                default:
                    break;
            }
        }
        
    }
    
}
