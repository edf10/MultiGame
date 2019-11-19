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
import padroes.Fonts;
import padroes.ItemsTela;
import user.Cadastro;
import user.Conta;
import user.User;

public class MultiGameTela extends Frame{
    private Pn pnIniciar;
    private final ItemsTela it = new ItemsTela();
    private User user = User.getUser();
    public void setUser(User user) {
        this.user = user;
    }
    public MultiGameTela(){}
    public void intro(){
        ImageIcon btn_play[] = {im.addImagem("btn_play"), im.addImagem("btn_play_t"), im.addImagem("btn_play_p")};
        int titlePos[] = {280,40,639,155}; int backPos[] = {0,0,1200,700};
        int playPos[] = {488,290,224,224};
        Component cp[] = {
            new Btn(btn_play, playPos, new EventBtnPlay()),
            new Lb(im.addImagem("title_multigame"), titlePos),
            it.btnSom(),
            it.btnClose(),
            new Lb(im.addImagem("back_initial_multigame"), backPos)
        };
        int pnInitialPos[] = {0,0,1200,700}; pnIniciar = new Pn(pnInitialPos, cp);
        add(pnIniciar);
    }
    private class EventBtnPlay implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            pnIniciar.setVisible(false);
            login_user();
        }
    }
    private Pn pnJogos; 
    public void Jogos() { 
        int backPos[] = {0,0,1200,700}; int titlePos[] = {381,75,453,134};
        int capaCMPos[] = {100,303,222,247}; int capaJDVPos[] = {343,303,222,247};
        int capaCPPos[] = {605,303,222,247}; int btnCMPos[] = {132,375,167,156};
        int btnJDVPos[] = {376,375,167,156}; int btnCPPos[] = {636,375,167,156};
        ImageIcon btn_cm[] = {im.addImagem("btn_cm"),im.addImagem("btn_cm_t"),im.addImagem("btn_cm_p")};
        ImageIcon btn_jdv[] = {im.addImagem("btn_jdv"),im.addImagem("btn_jdv_t"),im.addImagem("btn_jdv_p")};
        ImageIcon btn_wp[] = {im.addImagem("btn_wp"),im.addImagem("btn_wp_t"),im.addImagem("btn_wp_p")}; 
        Btn menu[] = it.menuOp(this); int lbCoinsPos[] = {150,27,33,29}; int lbMoedasPos[] = {191,29,120,29};
        Fonts fs = new Fonts(); Font f = fs.addNewFont("DS-DIGIT", 30);
        Component cp[] = {
            new Lb(im.addImagem("title_games"),titlePos),
            new Btn(btn_cm, btnCMPos, new EventInitialGame(1)),
            new Btn(btn_jdv, btnJDVPos, new EventInitialGame(2)),
            new Btn(btn_wp, btnCPPos, new EventInitialGame(3)),
            menu[0],
            menu[1],
            menu[2],
            new Lb(im.addImagem("moedas"), lbCoinsPos),
            new Lb(user.getMoedasString(), f, lbMoedasPos, Color.white),
            new Lb(im.addImagem("back_capa_cm"),capaCMPos),
            new Lb(im.addImagem("back_capa_jdv"), capaJDVPos),
            new Lb(im.addImagem("back_capa_wp"), capaCPPos),
            it.btnClose(),
            it.btnSomOutro(),
            new Lb(im.addImagem("back_games"), backPos)
        };
        int pnJogosP[] = {0,0,1200,700}; pnJogos = new Pn(pnJogosP, cp);
        add(pnJogos);
    }
    private class EventInitialGame implements ActionListener{ //Evento dos btns de jogo
        private int n;
        public EventInitialGame(int n){this.n = n;}
        public void actionPerformed(ActionEvent e) {
            dispose();
            switch (n) {
                case 1:IntroductionCM cm = new IntroductionCM(); cm.intro(); cm.show();break;
                case 2:IntroductionJDV jdv = new IntroductionJDV(); jdv.intro(); jdv.show();break;
                case 3:IntroductionWP wp = new IntroductionWP(); wp.intro(); wp.show(); break;
                default:break;
            }
            
        }
    }
    
    private Pn pnLogin;
    private Txt txtUserName;
    private Pass txtPassword;
    public void login_user(){
        int txtUser[] = {733,250,369,68}; int txtpass[] = {733,350,369,68}; 
        int titlePos[] = {692,66,420,83}; int quadroPos[] = {0,0,588,700};
        int barraPos[] = {589,0,5,700}; int userIconPos[] = {676,265,40,46};
        int passIconPos[] = {676,358,38,44}; int logarPos[] = {822,457,190,62};
        int cadastroPos[] = {748,569,328,42};
        Fonts fonte = new Fonts(); 
        Font f = fonte.addNewFont("DS-DIGIT", 40);
        Border b = BorderFactory.createLineBorder(new Color(52,103,77), 3);
        txtUserName = new Txt(txtUser, f, Color.black, b);
        txtPassword = new Pass(txtpass, f, Color.black, b);
        ImageIcon btn_logar[] = {im.addImagem("btn_logar"), im.addImagem("btn_logar_t"), im.addImagem("btn_logar_p")};
        ImageIcon btn_cadastro[] = {im.addImagem("btn_cadastro"), im.addImagem("btn_cadastro_t")};
        Component cp[] = {
            new Lb(im.addImagem("title_login"), titlePos),
            txtUserName,
            txtPassword,
            new Lb(im.addGif("left_quadro"), quadroPos),
            new Lb(im.addImagem("barra"), barraPos),
            new Lb(im.addImagem("user_icon"), userIconPos),
            new Lb(im.addImagem("password_icon"), passIconPos),
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
            user = new User(txtUserName.getText(),txtPassword.getText());
            Conta c = new Conta(user);
            user = c.login();
            User.setUser(user);
            pnLogin.setVisible(false);
            if(c.isLogado()){
                Jogos();
                c.setLogado(true);
            }else{
                dispose();
                MultiGameTela mg = new MultiGameTela(); mg.intro(); mg.show();
            }
        }
    }
    public class Register implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ae) {
            dispose();
            Cadastro c = new Cadastro(); c.setRedirecionamento(1);c.telaRegister();
        }
    }
}