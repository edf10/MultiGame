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
    //Atributos (Construct)
    private JPanel pnIniciar;
    private JLabel lbgif;
    private ImageIcon gifArq;
    private JLabel lbtitulo;
    private JButton btnStart;
    private ImageIcon btnImageArq;
    //Construct
    public MultiGameTela() {
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        pnIniciar = new JPanel();
        gifArq = new ImageIcon(getClass().getResource("01.gif"));
        lbgif = new JLabel(gifArq);
        lbtitulo = new JLabel("MULTIGAME");
        btnImageArq = new ImageIcon(getClass().getResource("btn1.png"));
        btnStart = new JButton(btnImageArq);
        Font titulo = new Font("Arial", Font.PLAIN, 40);
        pnIniciar.setLayout(null);

        //lbtitulo.setOpaque(true);
        //lbtitulo.setBackground(Color.BLACK);
        lbtitulo.setForeground(Color.WHITE);
        lbtitulo.setHorizontalAlignment((int)CENTER_ALIGNMENT);
        lbtitulo.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        lbtitulo.setFont(titulo);

        btnStart.setLayout(null);
        btnStart.setContentAreaFilled(false);
        //btnStart.setOpaque(false);
        //btnStart.setBackground(Color.black);
        btnStart.setBorder(null);


        pnIniciar.setBounds(0, 0, 800, 600);
        lbgif.setBounds(0, 0, 800, 600);
        lbtitulo.setBounds(250, 40, 300, 60);
        btnStart.setBounds(300, 200, 200, 200);

        pnIniciar.add(btnStart);
        pnIniciar.add(lbtitulo);
        pnIniciar.add(lbgif);

        add(pnIniciar);

        BtnStart evento = new BtnStart();
        btnStart.addActionListener(evento);



        setVisible(true);
    }
    //Evento (btnStart)
    private class BtnStart implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            pnIniciar.setVisible(false);
            Jogos();
        }
    }
    //Atributos (Jogos)
    private JPanel pnJogos;
    private JLabel lbCM;
    private JButton btnCM;
    private ImageIcon btnImArq;
    private ImageIcon fundoArq;
    private JLabel lbFundo;
    //Painel de exibição dos jogos
    private void Jogos() {
        pnJogos = new JPanel();
        lbCM = new JLabel("CAMPO MINADO");
        btnImArq = new ImageIcon(getClass().getResource("minesweeper_100815.png"));
        btnCM = new JButton(btnImArq);
        Font jogos = new Font("Tahoma", Font.PLAIN, 24);
        fundoArq = new ImageIcon(getClass().getResource("1fa3cfe7aba3549af9fff427ad6a7a32.gif"));
        lbFundo = new JLabel(fundoArq);

        pnJogos.setBackground(Color.white);
        pnJogos.setLayout(null);

        btnCM.setLayout(null);
        btnCM.setHorizontalAlignment((int)CENTER_ALIGNMENT);
        btnCM.setContentAreaFilled(false);
        btnCM.setBorder(null);

        lbCM.setForeground(Color.black);
        lbCM.setFont(jogos);
        lbCM.setHorizontalAlignment((int)CENTER_ALIGNMENT);

        lbFundo.setBounds(0, 0, 800, 600);
        pnJogos.setBounds(0, 0, 800, 600);
        btnCM.setBounds(20, 20, 200, 200);
        lbCM.setBounds(20, 230, 200, 20);

        BtnJogo event = new BtnJogo();
        btnCM.addActionListener(event);


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
