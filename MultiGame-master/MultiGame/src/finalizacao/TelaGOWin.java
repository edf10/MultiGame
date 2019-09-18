package finalizacao;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import campominado.TelaCM;
import multigame.MultiGameTela;

public class TelaGOWin extends JFrame{
    
    private ImageIcon imFundo = new ImageIcon(getClass().getResource("gameover.gif"));
    private JLabel lbResultado;
    private JLabel lbTempo;
    private ImageIcon imJogarMesmo = new ImageIcon(getClass().getResource("return.png"));
    private ImageIcon imMenuJogos = new ImageIcon(getClass().getResource("home.png"));
    private ImageIcon imJogarOutro = new ImageIcon(getClass().getResource("arrow.png"));
    private JButton btnMenuJogos = new JButton(imMenuJogos);
    private JButton btnJogarMesmo = new JButton(imJogarMesmo);
    private JButton btnJogarOutro = new JButton(imJogarOutro);
    private JFrame CM;
    
    public TelaGOWin(String tempoCM, JFrame cm, int resultado){
        setSize(400, 300);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        config(tempoCM, resultado);
        getContentPane().setBackground(Color.LIGHT_GRAY);
        CM = cm;
        
        setVisible(true);
    }
    
    public void config(String tempoCM, int resultado){
        
        if(resultado==1){
            lbResultado = new JLabel("Game Over!");
        }else if(resultado==2){
            lbResultado = new JLabel("You Win!");
        }
        
        lbTempo = new JLabel("Tempo: "+tempoCM);
        
        lbResultado.setLayout(null);
        lbTempo.setLayout(null);
        lbResultado.setBounds(77, 40, 230, 50);
        lbTempo.setBounds(100, 110, 200, 30);
        lbResultado.setHorizontalAlignment((int)CENTER_ALIGNMENT);
        lbTempo.setHorizontalAlignment((int)CENTER_ALIGNMENT);
        lbResultado.setOpaque(false);
        Font lbGO = new Font("Arial", Font.PLAIN, 40);
        Font lbT = new Font("Arial", Font.BOLD, 20);
        lbResultado.setFont(lbGO);
        lbTempo.setFont(lbT);
        lbTempo.setForeground(Color.blue);
        
        add(lbResultado);
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
        public Funcao(int n){
            this.n = n;
        }
        @Override
        public void actionPerformed(ActionEvent ae) {
            dispose();
            CM.dispose();
            switch(n){
                case 1:
                    TelaCM tc = new TelaCM();
                    tc.newCM(tc.getN());
                    break;
                case 2:
                    MultiGameTela mgt = new MultiGameTela(2);
                    break;
                case 3:
                    TelaCM tcm = new TelaCM();
                    break;
                default:
                    break;
            }
        }
        
    }
    
}
