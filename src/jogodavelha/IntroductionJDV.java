package jogodavelha;
import componentes.Btn;
import componentes.Lb;
import componentes.Pn;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import componentes.Frame;
import componentes.Pass;
import componentes.Txt;
import java.awt.Font;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import padroes.Fonts;
import padroes.ItemsTela;
import user.Cadastro;
import user.Conta;
import user.User;
public class IntroductionJDV extends Frame{
    private ItemsTela it = new ItemsTela();
    private Btn menu[]; 
    private TelaJDV tjdv = new TelaJDV();
    private User user1 = User.getUser();//user logado na conta do projeto
    private User user2;//user que vai jogar contra pra salvar os dados em ambas as contas
    
    private Pn pnTutorial;
    public void tutorial() {
        pnTutorial = new Pn(); pnTutorial.setLayout(null);pnTutorial.setBounds(0, 0, 1200, 700);
        int backPos[] = {0,0,1200,700}; it.setTelaAntIntro(2);
        add(it.btnClose()); add(it.returnGames());
        pnTutorial.add(new Lb(im.addImagem("tutorial_jdv"),backPos));
        add(pnTutorial);
    }

    private Pn pnIntro;
    public void intro(){
        int backPos[] = {0,0,1200,700}; menu = it.menuOpGamesIntro(this); 
        int titlePos[] = {254,70,752,109}; int multPos[] = {379,267,473,75};
        int tutorialPos[] = {455,372,325,75}; int histPos[] = {465,491,307,75};
        ImageIcon btn_multi[] = {im.addImagem("btn_multiplayer_jdv"),im.addImagem("btn_multiplayer_jdv_t"),im.addImagem("btn_multiplayer_jdv_p")};
        ImageIcon btn_tutorial[] = {im.addImagem("btn_tutorial_jdv"),im.addImagem("btn_tutorial_jdv_t"),im.addImagem("btn_tutorial_jdv_p")};
        ImageIcon btn_hist[] = {im.addImagem("btn_historic_jdv"),im.addImagem("btn_historic_jdv_t"),im.addImagem("btn_historic_jdv_p")};
        Component cp[] = {
            it.btnClose(),
            it.btnSomOutro(),
            menu[0],menu[1],menu[2],menu[3],menu[4],
            new Lb(im.addImagem("title_jdv"), titlePos),
            new Btn(btn_multi, multPos, new EventBtnsIntro(1)),
            new Btn(btn_tutorial, tutorialPos, new EventBtnsIntro(2)),
            new Btn(btn_hist, histPos, new EventBtnsIntro(3)),
            new Lb(im.addImagem("back_intro_jdv"), backPos)
        };
        int pnIntroP[] = {0,0,1200,700};
        pnIntro = new Pn(pnIntroP, cp, Color.black);
        add(pnIntro);
    }
    
    private Pn pnAss;
    public void assunto(){
        int backPos[] = {0,0,1200,700}; int btnAddtionPos[] = {473,190,252,57};
        int btnDivisionPos[] = {482,291,234,57}; int btnSubtractionPos[] = {412,391,374,63};
        int btnMultiplicationPos[] = {371,490,456,57}; menu = it.menuOpGames(this);
        ImageIcon btn_addtion[] = {im.addImagem("btn_addition_jdv"),im.addImagem("btn_addition_jdv_t"),im.addImagem("btn_addition_jdv_p")};
        ImageIcon btn_division[] = {im.addImagem("btn_division_jdv"),im.addImagem("btn_division_jdv_t"),im.addImagem("btn_division_jdv_p")};
        ImageIcon btn_subtraction[] = {im.addImagem("btn_subtraction_jdv"),im.addImagem("btn_subtraction_jdv_t"),im.addImagem("btn_subtraction_jdv_p")};
        ImageIcon btn_multiplication[] = {im.addImagem("btn_multiplication_jdv"),im.addImagem("btn_multiplication_jdv_t"),im.addImagem("btn_multiplication_jdv_p")};
        it.setTelaAntIntro(2);
        Component cp[] = {
            it.btnClose(),
            it.btnSomOutro(),
            menu[0],menu[1],menu[2],menu[3],menu[4],menu[5],
            new Btn(btn_addtion, btnAddtionPos, new EventBtnsAss("Addtion")),
            new Btn(btn_division, btnDivisionPos, new EventBtnsAss("Division")),
            new Btn(btn_subtraction, btnSubtractionPos, new EventBtnsAss("Subtraction")),
            new Btn(btn_multiplication, btnMultiplicationPos, new EventBtnsAss("Multiplication")),
            new Lb(im.addImagem("back_intro_jdv"), backPos),
        };
        int pnAssP[] = {0,0,1200,700};
        pnAss = new Pn(pnAssP, cp);
        add(pnAss);
    }
    public void jogadores(String jogad1, String jogad2){
        tjdv.setJog1(jogad1);
        tjdv.setJog2(jogad2);
    }
    
    private Txt txtUsername;
    private Pass txtPassword;
    public class TelaOutroUser extends Frame{
        public TelaOutroUser(){
            setSize(600,500); setLocationRelativeTo(null); setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            int titlePos[] = {70,59,482,66}; int backPos[] = {0,0,600,500};
            int txtUser[] = {162,180,340,64}; int txtpass[] = {162,262,340,64};
            int userPos[] = {112,189,36,47}; int passPos[] = {110,271,37,48};
            int btnLoginPos[] = {332,382,190,62}; int btnRegisterPos[] = {88,382,192,62};
            Border d = BorderFactory.createLineBorder(new Color(52,103,77), 3);
            Fonts fs = new Fonts(); Font f = fs.addNewFont("DS-DIGIT", 40);
            txtUsername = new Txt(txtUser, f, Color.black, d);
            txtPassword = new Pass(txtpass, f, Color.black, d);
            ImageIcon btn_login[] = {im.addImagem("btn_logar"),im.addImagem("btn_logar_t"),im.addImagem("btn_logar_p")};
            ImageIcon btn_register[] = {im.addImagem("btn_register"),im.addImagem("btn_register_t"),im.addImagem("btn_register_p")};
            Component cp[] = {
                new Lb(im.addImagem("title_outro_user_jdv"), titlePos),
                txtUsername,txtPassword,
                new Lb(im.addImagem("avatar_jdv_outro_user"), userPos),
                new Lb(im.addImagem("pass_jdv_outro_user"), passPos),
                new Btn(btn_login, btnLoginPos, new EventLogar(this)),
                new Btn(btn_register, btnRegisterPos, new EventRegister(TelaOutroUser.this)),
                btnClose(this)
            };
            Pn pnLogin = new Pn(backPos, cp);
            pnLogin.setBackground(Color.black);
            Border b = BorderFactory.createLineBorder(Color.white, 3);
            pnLogin.setBorder(b);
            add(pnLogin);
            show();
        }
    }
    private class EventRegister implements ActionListener{
        private Frame f;
        public EventRegister(Frame f){
            this.f = f;
        }
        @Override
        public void actionPerformed(ActionEvent e){
            f.dispose();
            dispose();
            Cadastro c = new Cadastro(user1); c.telaRegister();
        }
    }
    private class EventLogar implements ActionListener{
        private Frame f;
        public EventLogar(Frame f){this.f = f;}
        @Override
        public void actionPerformed(ActionEvent e){
            user2 = new User(txtUsername.getText(), txtPassword.getText());
            Conta c = new Conta(user2);
            user2 = c.login();
            if(c.isLogado()&&user2.getUsername().equals(user1.getUsername())==false){
                f.dispose(); pnIntro.setVisible(false); assunto();
            }else{
                txtUsername.setText("");
                txtPassword.setText("");
            }
        }
    }
    public Btn btnClose(Frame f){
        int closePos[] = {551,15,19,19}; ImageIcon btn_close[] = {im.addImagem("btn_close"),im.addImagem("btn_close_t")};
        return new Btn(btn_close, closePos, new EventClose(f));
    }
    private class EventClose implements ActionListener{
        private Frame f;
        public EventClose(Frame f){this.f = f;}
        @Override
        public void actionPerformed(ActionEvent e){
            f.dispose();
        }
    }
    
    private class EventBtnsIntro implements ActionListener{
        private int n;
        public EventBtnsIntro(int n) {this.n = n;}
        @Override
        public void actionPerformed(ActionEvent ae) {
            pnIntro.setVisible(false);
            switch (n) {
                case 1:pnIntro.setVisible(true);new TelaOutroUser();break;
                case 2:tutorial();break;
                case 3:dispose();new HistoricJDV();break;
                default:break;
            }
        }
    }
    private class EventBtnsAss implements ActionListener{
        private String assunto;
        public EventBtnsAss(String assunto){
            this.assunto = assunto;
        }
        @Override
        public void actionPerformed(ActionEvent ae) {
            pnAss.setVisible(false);
            dispose();
            tjdv.setUser1(user1); tjdv.setUser2(user2);
            jogadores(user1.getUsername(), user2.getUsername());
            tjdv.setAss(assunto);
            tjdv.start();
            tjdv.show();
        }
    }
}
