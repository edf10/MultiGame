package multigame;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import componentes.Lb;
import componentes.Btn;
import java.awt.Component;
import componentes.Pn;
import componentes.Frame;
import campominado.IntroductionCM;
import componentes.Pass;
import componentes.Txt;
import damas.IntroductionDama;
import javax.swing.border.Border;
import jogodavelha.IntroductionJDV;
import user.Cadastro;
import user.Conta;

public class MultiGameTela extends Frame{
    private Pn pnIniciar;
    private final ImageIcon gifArq = new ImageIcon(getClass().getResource("imagens/01.gif"));
    private final ImageIcon btnImageArq = new ImageIcon(getClass().getResource("imagens/btn1.png"));
    public MultiGameTela(int i) {
        super(800, 600);
        if(i==1){
            /* Configurando lbs - PainelInicial */
            Font titulo = new Font("Arial", Font.PLAIN, 40);//Fonte
            int lbtituloP[] = {250,40,300,60}; int lbgifP[] = {0,0,800,600};
            /* Configurando BtnStart */
            int btnStartP[] = {300,200,200,200}; BtnStart evento = new BtnStart();
            /* Painel Iniciar */
            Component cp[] = {
                new Btn(btnImageArq, null, null, btnStartP, null, false, evento),
                new Lb("MULTIGAME", titulo, lbtituloP, Color.WHITE, BorderFactory.createLineBorder(Color.WHITE)),
                new Lb(gifArq, lbgifP)
            };
            int pnIniciarP[] = {0,0,800,600}; pnIniciar = new Pn(pnIniciarP, cp);
            add(pnIniciar);
            /* -------------- */
        }else{Jogos();}
        setVisible(true);
    }
    private class BtnStart implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            pnIniciar.setVisible(false);
            login_user();
            //Jogos();
        }
    }
    private Pn pnJogos; //Painel
    //ImageIcons
    private final ImageIcon imCM = new ImageIcon(getClass().getResource("imagens/campominado.png"));
    private final ImageIcon imJDV = new ImageIcon(getClass().getResource("imagens/jogodavelha.png"));
    private final ImageIcon fundoArq = new ImageIcon(getClass().getResource("imagens/02.gif"));
    private final ImageIcon imDama = new ImageIcon(getClass().getResource("imagens/dama.png"));
    private void Jogos() { //Painel de exibição dos jogos
        /* Configurando lbs - PainelJogos */
        Font jogos = new Font("Tahoma", Font.PLAIN, 24);
        int lbCMP[] = {20,230,200,20}; int lbFundoP[] = {0,0,800,600};int lbJDVP[] = {230,230,200,20};
        int lbDP[] = {440,230,200,20};
        /* Configurando btns */
        BtnJogo cm = new BtnJogo(1);BtnJogo jdv = new BtnJogo(2); BtnJogo dama = new BtnJogo(3);
        int btnCMP[] = {20,20,200,200}; int btnJDVP[] = {230,20,200,200}; int btnDP[] = {440,20,200,200};
        
        /* Painel Jogos */
        Component cp[] = {
            new Lb("CAMPO MINADO", jogos, lbCMP, Color.black, null),
            new Lb("JOGO DA VELHA", jogos, lbJDVP, Color.black, null),
            new Lb("DAMAS", jogos, lbDP, Color.black, null),
            new Btn(imCM, null, null, btnCMP, null, false, cm),
            new Btn(imJDV, null, null, btnJDVP, null, false, jdv),
            new Btn(imDama, null, null, btnDP, null, false, dama),
            new Lb(fundoArq, lbFundoP)
        };
        int pnJogosP[] = {0,0,800,600}; pnJogos = new Pn(pnJogosP, cp);
        add(pnJogos);
        /* ----------- */
    }
    private class BtnJogo implements ActionListener{ //Evento dos btns de jogo
        private int n;
        public BtnJogo(int n){this.n = n;}
        public void actionPerformed(ActionEvent e) {
            dispose();
            if(n==1){IntroductionCM j1 = new IntroductionCM();
            }else if(n==2){IntroductionJDV j2 = new IntroductionJDV();
            }else if(n==3){IntroductionDama j3 = new IntroductionDama();}
        }
    }
    
    private Pn pnLogin;
    private Txt txtUserName;
    private Pass txtPassword;
    private final ImageIcon imLog = new ImageIcon(getClass().getResource("imagens/login.jpg"));
    private final ImageIcon imUser = new ImageIcon(getClass().getResource("imagens/user.png"));
    private final ImageIcon imPass = new ImageIcon(getClass().getResource("imagens/pass.png"));
    public void login_user(){
        pnIniciar.setVisible(false);
        Color fundo = new Color(0,255,85);
        getContentPane().setBackground(fundo);
        int txtUser[] = {90,205,270,40}; int txtpass[] = {90,275,270,40}; 
        int btnLogar[] = {85,380,250,50}; int lblogar[] = {55,90,300,60};
        int btnRes[] = {55,440,300,50}; int lbIm[] = {0,0,400,600};
        int lbUser[] = {35,200,50,50}; int lbPass[] = {35,270,50,50};
        
        Font f = new Font("Arial", Font.PLAIN, 20);
        Font d = new Font("Arial", Font.PLAIN, 30);
        Font t = new Font("Arial", Font.PLAIN, 15);
        Border b = BorderFactory.createLineBorder(Color.black, 3);
        txtUserName = new Txt(txtUser, f, Color.black, b);
        txtPassword = new Pass(txtpass, f, Color.black, b);
        Component cp[] = {
            new Lb("Logar Usuário", d, lblogar, Color.green, b),
            txtUserName,
            txtPassword,
            new Lb(imUser, lbUser),
            new Lb(imPass, lbPass),
            new Btn("Login", d, Color.black, Color.green, btnLogar, b, true, false, new Logar()),
            new Btn("Não tem conta? Registre-se", t, null, Color.blue,btnRes, null, false, false, new Register()),
            new Lb(imLog, lbIm)
        };
        int pnLoginP[] = {200,0,400,600};
        pnLogin = new Pn(pnLoginP, cp);
        add(pnLogin);
    }
    
    public class Logar implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ae) {
            Conta c = new Conta(txtUserName.getText(), txtPassword.getText());
            c.login();
            pnLogin.setVisible(false);
            if(c.isLogado()){
                Jogos();
                c.setLogado(true);
            }else{
                pnIniciar.setVisible(true);
            }
        }
    }
    public class Register implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ae) {
            dispose();
            Cadastro c = new Cadastro();
        }
    }
}
