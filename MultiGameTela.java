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
    private JLabel lbFundo;
    
    //Buttons
    private JButton btnCM;
    
    //ImageIcons
    private ImageIcon btnImArq;
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
        btnImArq = new ImageIcon(getClass().getResource("minesweeper_100815.png"));
        fundoArq = new ImageIcon(getClass().getResource("1fa3cfe7aba3549af9fff427ad6a7a32.gif"));
        /* ----------------------- */
        
        /* Configurando lbs - PainelJogos */
        Font jogos = new Font("Tahoma", Font.PLAIN, 24);
        
        lbCM = new JLabel("CAMPO MINADO");
        lbFundo = new JLabel(fundoArq);
        
        lbCM.setForeground(Color.black);
        
        lbCM.setFont(jogos);
        
        lbCM.setHorizontalAlignment((int)CENTER_ALIGNMENT);
        
        lbFundo.setBounds(0, 0, 800, 600);
        lbCM.setBounds(20, 230, 200, 20);
        /* ------------------------------ */
        
        /* Configurando btns */
        btnCM = new JButton(btnImArq);
        btnCM.setLayout(null);
        btnCM.setHorizontalAlignment((int)CENTER_ALIGNMENT);
        btnCM.setContentAreaFilled(false);
        btnCM.setBorder(null);
        btnCM.setBounds(20, 20, 200, 200);
        BtnJogo event = new BtnJogo();
        btnCM.addActionListener(event);
        /* ----------------- */
        
        //Adicionando
        pnJogos.add(lbCM);
        pnJogos.add(btnCM);
        pnJogos.add(lbFundo);

        add(pnJogos);
    }
    //Evento (Botões de cada Jogo)
    private class BtnJogo implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            dispose();
            TelaCM ticm = new TelaCM();
        }
    }
}
