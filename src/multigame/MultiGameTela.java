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
import wordpuzzle.IntroductionWP;
import componentes.Pass;
import componentes.Txt;
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
    private final ImageIcon imPlayT = new ImageIcon(getClass().getResource("imagens/btn_play_t.png"));
    private final ImageIcon imPlayP = new ImageIcon(getClass().getResource("imagens/btn_play_p.png"));
    private final ItemsTela it = new ItemsTela();
    public MultiGameTela(int i) {
        if(i==1){
            ImageIcon btn_play[] = {imPlay, imPlayT, imPlayP};
            int titlePos[] = {280,40,639,155}; int backPos[] = {0,0,1200,700};
            int playPos[] = {488,290,224,224};
            Component cp[] = {
                new Btn(btn_play, playPos, new EventBtnPlay()),
                new Lb(imLogo, titlePos),
                it.btnSom(),
                it.btnClose(),
                new Lb(imBack, backPos)
            };
            int pnInitialPos[] = {0,0,1200,700}; pnIniciar = new Pn(pnInitialPos, cp);
            add(pnIniciar);
        }else if(i==2){Jogos();}else{login_user();}
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
    private final ImageIcon imBackGames = new ImageIcon(getClass().getResource("imagens/back_games.png"));
    private final ImageIcon imTitleGames = new ImageIcon(getClass().getResource("imagens/title_games.png"));
    private final ImageIcon imCapaCM = new ImageIcon(getClass().getResource("imagens/back_capa_cm.png"));
    private final ImageIcon imCapaJDV = new ImageIcon(getClass().getResource("imagens/back_capa_jdv.png"));
    private final ImageIcon imCapaCP = new ImageIcon(getClass().getResource("imagens/back_capa_cp.png"));
    private final ImageIcon imCM = new ImageIcon(getClass().getResource("imagens/btn_cm.png"));
    private final ImageIcon imCMT = new ImageIcon(getClass().getResource("imagens/btn_cm_t.png"));
    private final ImageIcon imCMP = new ImageIcon(getClass().getResource("imagens/btn_cm_p.png"));
    private final ImageIcon imJDV = new ImageIcon(getClass().getResource("imagens/btn_jdv.png"));
    private final ImageIcon imJDVT = new ImageIcon(getClass().getResource("imagens/btn_jdv_t.png"));
    private final ImageIcon imJDVP = new ImageIcon(getClass().getResource("imagens/btn_jdv_p.png"));
    private final ImageIcon imCP = new ImageIcon(getClass().getResource("imagens/btn_cp.png"));
    private final ImageIcon imCPT = new ImageIcon(getClass().getResource("imagens/btn_cp_t.png"));
    private final ImageIcon imCPP = new ImageIcon(getClass().getResource("imagens/btn_cp_p.png"));
    private void Jogos() { 
        int backPos[] = {0,0,1200,700}; int titlePos[] = {381,75,453,134};
        int capaCMPos[] = {100,303,222,247}; int capaJDVPos[] = {343,303,222,247};
        int capaCPPos[] = {605,303,222,247}; int btnCMPos[] = {132,375,167,156};
        int btnJDVPos[] = {376,375,167,156}; int btnCPPos[] = {636,375,167,156};
        ImageIcon btn_cm[] = {imCM,imCMT,imCMP}; ImageIcon btn_jdv[] = {imJDV,imJDVT,imJDVP};
        ImageIcon btn_cp[] = {imCP,imCPT,imCPP}; Btn menu[] = it.menuOp(this);
        Component cp[] = {
            new Lb(imTitleGames,titlePos),
            new Btn(btn_cm, btnCMPos, new EventInitialGame(1)),
            new Btn(btn_jdv, btnJDVPos, new EventInitialGame(2)),
            new Btn(btn_cp, btnCPPos, new EventInitialGame(3)),
            menu[0],
            menu[1],
            menu[2],
            menu[3],
            new Lb(imCapaCM,capaCMPos),
            new Lb(imCapaJDV, capaJDVPos),
            new Lb(imCapaCP, capaCPPos),
            it.btnClose(),
            it.btnSomOutro(),
            new Lb(imBackGames, backPos)
        };
        int pnJogosP[] = {0,0,1200,700}; pnJogos = new Pn(pnJogosP, cp);
        add(pnJogos);
    }
    private class EventInitialGame implements ActionListener{ //Evento dos btns de jogo
        private int n;
        public EventInitialGame(int n){this.n = n;}
        public void actionPerformed(ActionEvent e) {
            dispose();
            if(n==1){IntroductionCM j1 = new IntroductionCM();
            }else if(n==2){IntroductionJDV j2 = new IntroductionJDV();
            }else if(n==3){IntroductionWP j3 = new IntroductionWP();}
            
        }
    }
    
    private Pn pnLogin;
    private Txt txtUserName;
    private Pass txtPassword;
    private final ImageIcon imTitleLog = new ImageIcon(getClass().getResource("imagens/title_login.png"));
    private final ImageIcon imQuadro = new ImageIcon(getClass().getResource("imagens/left_quadro.gif"));
    private final ImageIcon imBarra = new ImageIcon(getClass().getResource("imagens/barra.png"));
    private final ImageIcon imUserIcon = new ImageIcon(getClass().getResource("imagens/user_icon.png"));
    private final ImageIcon imPassIcon = new ImageIcon(getClass().getResource("imagens/password_icon.png"));
    private final ImageIcon imLogar = new ImageIcon(getClass().getResource("imagens/btn_logar.png"));
    private final ImageIcon imLogarT = new ImageIcon(getClass().getResource("imagens/btn_logar_t.png"));
    private final ImageIcon imLogarP = new ImageIcon(getClass().getResource("imagens/btn_logar_p.png"));
    private final ImageIcon imCadastro = new ImageIcon(getClass().getResource("imagens/btn_cadastro.png"));
    private final ImageIcon imCadastroT = new ImageIcon(getClass().getResource("imagens/btn_cadastro_t.png"));
    public void login_user(){
        pnIniciar.setVisible(false);
        int txtUser[] = {733,250,369,68}; int txtpass[] = {733,350,369,68}; 
        int titlePos[] = {692,66,420,83}; int quadroPos[] = {0,0,588,700};
        int barraPos[] = {589,0,5,700}; int userIconPos[] = {676,265,40,46};
        int passIconPos[] = {676,358,38,44}; int logarPos[] = {822,457,190,62};
        int cadastroPos[] = {748,569,328,42};
        Font f = new Font("Arial", Font.PLAIN, 20);
        
        Border b = BorderFactory.createLineBorder(new Color(52,103,77), 3);
        txtUserName = new Txt(txtUser, f, Color.black, b);
        txtPassword = new Pass(txtpass, f, Color.black, b);
        ImageIcon btn_logar[] = {imLogar, imLogarT, imLogarP};
        ImageIcon btn_cadastro[] = {imCadastro, imCadastroT};
        Component cp[] = {
            new Lb(imTitleLog, titlePos),
            txtUserName,
            txtPassword,
            new Lb(imQuadro, quadroPos),
            new Lb(imBarra, barraPos),
            new Lb(imUserIcon, userIconPos),
            new Lb(imPassIcon, passIconPos),
            new Btn(btn_logar, logarPos, new Logar()),
            new Btn(btn_cadastro, cadastroPos, new Register()),
            it.btnClose(),
            it.btnSomOutro()
        };
        int pnLoginP[] = {0,0,1200,700};
        pnLogin = new Pn(pnLoginP, cp, Color.black);
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