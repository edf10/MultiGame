package multigame;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import campominado.TelaCM;
import componentes.Lb;
import componentes.Btn;
import java.awt.Component;
import componentes.Pn;
import campominado.IntroductionCM;

public class MultiGameTela extends JFrame{
    //Painel
    private Pn pnIniciar;
    //ImageIcons
    private final ImageIcon gifArq = new ImageIcon(getClass().getResource("01.gif"));
    private final ImageIcon btnImageArq = new ImageIcon(getClass().getResource("btn1.png"));
    public MultiGameTela(int i) {
        /* Configurações padrão da tela */
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        /* ---------------------------- */
        if(i==1){
            /* Configurando lbs - PainelInicial */
            Font titulo = new Font("Arial", Font.PLAIN, 40);//Fonte
            int lbtituloP[] = {250,40,300,60};
            int lbgifP[] = {0,0,800,600};
            /* -------------------------------- */
            /* Configurando BtnStart */
            int btnStartP[] = {300,200,200,200};
            BtnStart evento = new BtnStart();
            /* --------------------- */
            /* Painel Iniciar */
            Component cp[] = {
                new Btn(btnImageArq, null, null, btnStartP, null, false, evento),
                new Lb("MULTIGAME", titulo, lbtituloP, Color.WHITE, BorderFactory.createLineBorder(Color.WHITE)),
                new Lb(gifArq, lbgifP)
            };
            int pnIniciarP[] = {0,0,800,600};
            pnIniciar = new Pn(pnIniciarP, cp);
            add(pnIniciar);
            /* -------------- */
        }else{
            Jogos();
        }
        setVisible(true);
    }
    private class BtnStart implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            pnIniciar.setVisible(false);
            Jogos();
        }
    }
    //Painel
    private Pn pnJogos;
    //ImageIcons
    private final ImageIcon imCM = new ImageIcon(getClass().getResource("campominado.png"));
    private final ImageIcon imJDV = new ImageIcon(getClass().getResource("jogodavelha.png"));
    private final ImageIcon fundoArq = new ImageIcon(getClass().getResource("02.gif"));
    private void Jogos() { //Painel de exibição dos jogos
        /* Configurando lbs - PainelJogos */
        Font jogos = new Font("Tahoma", Font.PLAIN, 24);
        int lbCMP[] = {20,230,200,20};
        int lbFundoP[] = {0,0,800,600};
        int lbJDVP[] = {230,230,200,20};
        /* ------------------------------ */
        /* Configurando btns */
        BtnJogo cm = new BtnJogo(1);
        BtnJogo jdv = new BtnJogo(2);
        int btnCMP[] = {20,20,200,200};
        int btnJDVP[] = {230,20,200,200};
        /* ----------------- */
        /* Painel Jogos */
        Component cp[] = {
            new Lb("CAMPO MINADO", jogos, lbCMP, Color.black, null),
            new Lb("JOGO DA VELHA", jogos, lbJDVP, Color.black, null),
            new Btn(imCM, null, null, btnCMP, null, false, cm),
            new Btn(imJDV, null, null, btnJDVP, null, false, jdv),
            new Lb(fundoArq, lbFundoP)
        };
        int pnJogosP[] = {0,0,800,600};
        pnJogos = new Pn(pnJogosP, cp);
        add(pnJogos);
        /* ----------- */
    }
    private class BtnJogo implements ActionListener{ //Evento dos btns de jogo
        private int n;
        public BtnJogo(int n){
            this.n = n;
        }
        public void actionPerformed(ActionEvent e) {
            dispose();
            if(n==1){
                IntroductionCM i = new IntroductionCM(700, 700);
            }else if(n==2){
            }
        }
    }
}
