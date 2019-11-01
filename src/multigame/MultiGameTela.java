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
import caçapalavras.IntroductionCP;
import componentes.Pass;
import componentes.Txt;
import java.awt.Dimension;
import javax.swing.border.Border;
import jogodavelha.IntroductionJDV;
import padroes.ItemsTela;
import user.Cadastro;
import user.Conta;

public class MultiGameTela extends Frame{
    private Pn pnIniciar;
    private final ImageIcon imLogo = new ImageIcon(getClass().getResource("imagens/title_multigame.png"));
    private final ImageIcon imBack = new ImageIcon(getClass().getResource("imagens/back_initial_multigame.jpg"));
    private final ImageIcon imPlay = new ImageIcon(getClass().getResource("imagens/btn_play.png"));
    private final ItemsTela it = new ItemsTela();
    private Dimension tamTela;
    public MultiGameTela(int i) {
        if(i==1){
            Font titulo = new Font("Arial", Font.PLAIN, 40);//Fonte
            int titlePos[] = {280,40,639,155}; int backPos[] = {0,0,1200,700};
            int playPos[] = {488,290,224,224};
            Component cp[] = {
                new Btn(imPlay, playPos, new EventBtnPlay()),
                new Lb(imLogo, titlePos),
                it.btnSom(),
                it.btnClose(),
                new Lb(imBack, backPos)
            };
            int pnInitialPos[] = {0,0,1200,700}; pnIniciar = new Pn(pnInitialPos, cp);
            add(pnIniciar);
        }else{Jogos();}
        show();
    }
    private class EventBtnPlay implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            pnIniciar.setVisible(false);
            login_user();
        }
    }
    private Pn pnJogos; 
    private final ImageIcon imCM = new ImageIcon(getClass().getResource("imagens/campominado.png"));
    private final ImageIcon imJDV = new ImageIcon(getClass().getResource("imagens/jogodavelha.png"));
    private final ImageIcon fundoArq = new ImageIcon(getClass().getResource("imagens/02.gif"));
    private final ImageIcon imCP = new ImageIcon(getClass().getResource("imagens/caçalogo.png"));
    private void Jogos() { //Painel de exibição dos jogos
        /* Configurando lbs - PainelJogos */
        Font jogos = new Font("Tahoma", Font.PLAIN, 24);
        int lbCMP[] = {20,230,200,20}; int lbFundoP[] = {0,0,800,600};int lbJDVP[] = {230,230,200,20}; int lbCPP[] = {440,230,200,20};
        /* Configurando btns */
        BtnJogo cm = new BtnJogo(1);BtnJogo jdv = new BtnJogo(2); BtnJogo caça = new BtnJogo(3);
        int btnCMP[] = {20,20,200,200}; int btnJDVP[] = {230,20,200,200}; int btnSolP[] = {440,20,200,200};
        
        /* Painel Jogos */
        Component cp[] = {
            new Lb("CAMPO MINADO", jogos, lbCMP, Color.black, null),
            new Lb("JOGO DA VELHA", jogos, lbJDVP, Color.black, null),
            new Lb("CAÇA-PALAVRAS", jogos, lbCPP, Color.black, null),
            new Btn(imCM, null, null, btnCMP, null, false, cm),
            new Btn(imJDV, null, null, btnJDVP, null, false, jdv),
            new Btn(imCP, null, null, btnSolP, null, false, caça),
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
            }else if(n==3){IntroductionCP j3 = new IntroductionCP();}
            
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