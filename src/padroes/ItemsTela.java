package padroes;

import campominado.IntroductionCM;
import componentes.Btn;
import componentes.Frame;
import imagens.Im;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import jogodavelha.IntroductionJDV;
import multigame.MultiGameTela;
import user.User;
import wordpuzzle.IntroductionWP;

public class ItemsTela {
    private Im im = new Im();
    public Btn btnClose(){
        int closePos[] = {1161,15,19,19}; ImageIcon btn_close[] = {im.addImagem("btn_close"),im.addImagem("btn_close_t")};
        return new Btn(btn_close, closePos, new EventClose());
    }
    private class EventClose implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            System.exit(0);
        }
    }
    
    private final ImageIcon imSom = im.addImagem("btn_som");
    private final ImageIcon imMute = im.addImagem("btn_mute");
    private Btn som;
    public Btn btnSom(){
        int somPos[] = {20,20,42,35};
        ImageIcon imDaVez = (vez==1) ? imSom:imMute;
        som = new Btn(imDaVez, somPos, new EventSom());
        return som;
    }
    public Btn btnSomOutro(){
        int somPos[] = {1129,642,42,35};
        ImageIcon imDaVez = (vez==1) ? imSom:imMute;
        som = new Btn(imDaVez, somPos, new EventSom());
        return som;
    }
    private static int vez = 1;
    public class EventSom implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            if(vez==1){som.setIcon(imMute);vez = 2;}else{som.setIcon(imSom);vez = 1;}
        }
    }
    
    private Btn btnReturn;
    private Btn btnLogout;
    private Btn btnHome;
    
    private final ImageIcon btn_user[] = {im.addImagem("btn_user"),im.addImagem("btn_user_t")}; 
    private final ImageIcon btn_return[] = {im.addImagem("btn_return"),im.addImagem("btn_return_t")}; 
    private final ImageIcon btn_logout[] = {im.addImagem("btn_logout"),im.addImagem("btn_logout_t")};
    private final ImageIcon btn_home[] = {im.addImagem("btn_home"),im.addImagem("btn_home_t")}; 
    public Btn[] menuOp(Frame telaAtual){
        this.telaAtual = telaAtual;
        int userPos[] = {21,20,99,39}; int logoutPos[] = {25,81,124,37};
        btnLogout = new Btn(btn_logout, logoutPos, new EventOps(3));
        btnLogout.setVisible(false);
        Btn btns[] = {
            new Btn(btn_user, userPos, new EventMenuOp(1)),
            btnLogout
        };
        return btns;
    }
    
    public Btn[] menuOpGames(Frame telaAtual){
        this.telaAtual = telaAtual;
        int userPos[] = {21,20,99,39}; int homePos[] = {21,137,105,33};
        int returnPos[] = {21,81,125,30}; int logoutPos[] = {25,195,124,37};
        btnReturn = new Btn(btn_return, returnPos, new EventBtnReturn());
        btnLogout = new Btn(btn_logout, logoutPos, new EventOps(3));
        btnHome = new Btn(btn_home, homePos, new EventOps(2));
        btnReturn.setVisible(false);
        btnLogout.setVisible(false);
        btnHome.setVisible(false);
        Btn btns[] = {
            new Btn(btn_user, userPos, new EventMenuOp(2)),
            btnReturn,
            btnHome,
            btnLogout
        };
        return btns;
    }
    
    public Btn[] menuOpGamesIntro(Frame telaAtual){
        this.telaAtual = telaAtual;//20,81,143,195,248,303
        int userPos[] = {21,20,99,39};int logoutPos[] = {25,143,124,37};int homePos[] = {21,81,105,33};
        btnLogout = new Btn(btn_logout, logoutPos, new EventOps(3));
        btnHome = new Btn(btn_home, homePos, new EventOps(2));
        btnLogout.setVisible(false);
        btnHome.setVisible(false);
        Btn btns[] = {
            new Btn(btn_user, userPos, new EventMenuOp(3)),
            btnHome,
            btnLogout
        };
        return btns;
    }
    
    private boolean descer = false;
    public class EventMenuOp implements ActionListener{
        private int esc;
        public EventMenuOp(int esc){
            this.esc = esc;
        }
        @Override
        public void actionPerformed(ActionEvent e){
            if(descer==false){
                btnLogout.setVisible(true);descer = true;
                if(esc==2){btnHome.setVisible(true);btnReturn.setVisible(true);}
                if(esc==3){btnHome.setVisible(true);}
            }else{
                btnLogout.setVisible(false);descer = false;
                if(esc==2){btnHome.setVisible(false);btnReturn.setVisible(false);}
                if(esc==3){btnHome.setVisible(false);}
            }
        }
    }
    
    public class EventOps implements ActionListener{
        private int esc;
        public EventOps(int esc){
            this.esc = esc;
        }
        @Override
        public void actionPerformed(ActionEvent e){
            switch(esc){
                case 1: break;
                case 2: telaAtual.dispose(); MultiGameTela mg = new MultiGameTela(); mg.setUser(user); mg.Jogos(); mg.show();break;
                case 3: telaAtual.dispose(); MultiGameTela mg1 = new MultiGameTela(); mg1.login_user(); mg1.show();break;
                default: break;
            }
        }
    }
    public Btn returnGames(){
        int returnPos[] = {21,20,125,30};
        return new Btn(btn_return, returnPos, new EventBtnReturn());
    }
    public Btn returnGames(Frame telaAtual){
        this.telaAtual = telaAtual;
        int returnPos[] = {21,20,125,30};
        return new Btn(btn_return, returnPos, new EventBtnReturn());
    }
    private int telaAntIntro;
    private Frame telaAtual;
    private User user = User.getUser();

    public void setTelaAntIntro(int telaAntIntro) {
        this.telaAntIntro = telaAntIntro;
    }
    
    public class EventBtnReturn implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            telaAtual.dispose();
            if(telaAntIntro==1){
                IntroductionCM icm = new IntroductionCM();icm.intro();icm.show();
            }else if(telaAntIntro==2){
                IntroductionJDV ijdv = new IntroductionJDV();ijdv.intro();ijdv.show();
            }else if(telaAntIntro==3){
                IntroductionWP iwp = new IntroductionWP();iwp.intro();iwp.show();
            }else if(telaAntIntro==4){
                
            }
        }
    }
    
}