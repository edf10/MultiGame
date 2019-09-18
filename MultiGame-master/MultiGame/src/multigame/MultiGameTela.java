package multigame;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import campominado.TelaCM;

public class MultiGameTela extends JFrame{
    //Painel
    private JPanel pnIniciar;
    
    //Labels
    private JLabel lbgif;
    private JLabel lbtitulo;
    
    //ImageIcons
    private ImageIcon gifArq;
    private ImageIcon btnImageArq;
    
    //Buttons
    private JButton btnStart;
    
    //Construct
    public MultiGameTela(int i) {
        /* Configurações padrão da tela */
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        /* ---------------------------- */
        if(i==1){
            /* Painel Inicial */
            pnIniciar = new JPanel();
            pnIniciar.setLayout(null);
            pnIniciar.setBounds(0, 0, 800, 600);
            /* -------------- */

            /* Configurando ImageIcons */
            gifArq = new ImageIcon(getClass().getResource("01.gif"));
            btnImageArq = new ImageIcon(getClass().getResource("btn1.png"));
            /* ----------------------- */

            /* Configurando lbs - PainelInicial */
            Font titulo = new Font("Arial", Font.PLAIN, 40);//Fonte

            lbgif = new JLabel(gifArq);
            lbtitulo = new JLabel("MULTIGAME");

            lbtitulo.setForeground(Color.WHITE);

            lbtitulo.setHorizontalAlignment((int)CENTER_ALIGNMENT);

            lbtitulo.setBorder(BorderFactory.createLineBorder(Color.WHITE));

            lbtitulo.setFont(titulo);

            lbgif.setBounds(0, 0, 800, 600);
            lbtitulo.setBounds(250, 40, 300, 60);
            /* -------------------------------- */

            /* Configurando BtnStart */
            btnStart = new JButton(btnImageArq);
            btnStart.setLayout(null);
            btnStart.setContentAreaFilled(false);
            btnStart.setBorder(null);
            btnStart.setBounds(300, 200, 200, 200);   
            BtnStart evento = new BtnStart();
            btnStart.addActionListener(evento);
            /* --------------------- */

            //Adicionando
            pnIniciar.add(btnStart);
            pnIniciar.add(lbtitulo);
            pnIniciar.add(lbgif);

            add(pnIniciar);
        }else{
            Jogos();
        }

        setVisible(true);
    }
    //Evento (btnStart)
    private class BtnStart implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            pnIniciar.setVisible(false);
            Jogos();
        }
    }
    
    //Painel
    private JPanel pnJogos;
    
    //Labels
    private JLabel lbCM;
    private JLabel lbJDV;
    private JLabel lbFundo;
    
    //Buttons
    private JButton btnCM;
    private JButton btnJDV;
    
    //ImageIcons
    private ImageIcon imCM;
    private ImageIcon imJDV;
    private ImageIcon fundoArq;
    
    //Painel de exibição dos jogos
    private void Jogos() {
        
        /* Painel Jogos */
        pnJogos = new JPanel();
        pnJogos.setBackground(Color.white);
        pnJogos.setLayout(null);
        pnJogos.setBounds(0, 0, 800, 600);
        /* ----------- */
        
        /* Configurando ImageIcons */
        imCM = new ImageIcon(getClass().getResource("campominado.png"));
        imJDV = new ImageIcon(getClass().getResource("jogodavelha.png"));
        fundoArq = new ImageIcon(getClass().getResource("02.gif"));
        /* ----------------------- */
        
        /* Configurando lbs - PainelJogos */
        Font jogos = new Font("Tahoma", Font.PLAIN, 24);
        
        lbCM = new JLabel("CAMPO MINADO");
        lbFundo = new JLabel(fundoArq);
        lbJDV = new JLabel("JOGO DA VELHA");
        
        lbCM.setForeground(Color.black);
        lbJDV.setForeground(Color.black);
        
        lbCM.setFont(jogos);
        lbJDV.setFont(jogos);
        
        lbCM.setHorizontalAlignment((int)CENTER_ALIGNMENT);
        lbJDV.setHorizontalAlignment((int)CENTER_ALIGNMENT);
        
        lbFundo.setBounds(0, 0, 800, 600);
        lbCM.setBounds(20, 230, 200, 20);
        lbJDV.setBounds(230, 230, 200, 20);
        /* ------------------------------ */
        
        /* Configurando btns */
        btnCM = new JButton(imCM);
        btnJDV = new JButton(imJDV);
        
        btnCM.setLayout(null);
        btnJDV.setLayout(null);
        
        btnCM.setHorizontalAlignment((int)CENTER_ALIGNMENT);
        btnJDV.setHorizontalAlignment((int)CENTER_ALIGNMENT);
        
        btnCM.setContentAreaFilled(false);
        btnJDV.setContentAreaFilled(false);
        
        btnCM.setBorder(null);
        btnJDV.setBorder(null);
        
        btnCM.setBounds(20, 20, 200, 200);
        btnJDV.setBounds(230, 20, 200, 200);
        
        BtnJogo cm = new BtnJogo(1);
        btnCM.addActionListener(cm);
        BtnJogo jdv = new BtnJogo(2);
        btnJDV.addActionListener(jdv);
        /* ----------------- */
        
        //Adicionando
        pnJogos.add(lbCM);
        pnJogos.add(lbJDV);
        pnJogos.add(btnCM);
        pnJogos.add(btnJDV);
        pnJogos.add(lbFundo);

        add(pnJogos);
    }
    //Evento (Botões de cada Jogo)
    private class BtnJogo implements ActionListener{
        private int n;
        public BtnJogo(int n){
            this.n = n;
        }
        public void actionPerformed(ActionEvent e) {
            dispose();
            if(n==1){
                TelaCM ticm = new TelaCM();
            }else if(n==2){
                
            }
        }
    }
}
