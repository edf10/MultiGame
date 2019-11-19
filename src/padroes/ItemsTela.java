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
    
    private Btn btnSetting;
    private Btn btnReturn;
    private Btn btnLogout;
    private Btn btnHome;
    private Btn btnStore;
    
    private final ImageIcon btn_user[] = {im.addImagem("btn_user"),im.addImagem("btn_user_t")}; 
    private final ImageIcon btn_setting[] = {im.addImagem("btn_setting"),im.addImagem("btn_setting_t")};
    private final ImageIcon btn_return[] = {im.addImagem("btn_return"),im.addImagem("btn_return_t")}; 
    private final ImageIcon btn_logout[] = {im.addImagem("btn_logout"),im.addImagem("btn_logout_t")};
    private final ImageIcon btn_home[] = {im.addImagem("btn_home"),im.addImagem("btn_home_t")}; 
    private final ImageIcon btn_store[] = {im.addImagem("btn_store"),im.addImagem("btn_store_t")};
    public Btn[] menuOp(Frame telaAtual){
        this.telaAtual = telaAtual;
        int userPos[] = {21,20,99,39}; int settingPos[] = {21,81,140,37};
        int logoutPos[] = {25,143,124,37};
        btnSetting = new Btn(btn_setting, settingPos, null);
        btnLogout = new Btn(btn_logout, logoutPos, new EventOps(3));
        btnSetting.setVisible(false);
        btnLogout.setVisible(false);
        Btn btns[] = {
            new Btn(btn_user, userPos, new EventMenuOp(1)),
            btnSetting,
            btnLogout
        };
        return btns;
    }
    
    public Btn[] menuOpGames(Frame telaAtual){
        this.telaAtual = telaAtual;
        int userPos[] = {21,20,99,39}; int settingPos[] = {21,81,140,37};
        int returnPos[] = {21,143,125,30}; int logoutPos[] = {25,303,124,37};
        int homePos[] = {21,195,105,33}; int storePos[] = {21,248,117,33};
        btnSetting = new Btn(btn_setting, settingPos, null);
        btnReturn = new Btn(btn_return, returnPos, new EventBtnReturn());
        btnLogout = new Btn(btn_logout, logoutPos, new EventOps(3));
        btnHome = new Btn(btn_home, homePos, new EventOps(2));
        btnStore = new Btn(btn_store, storePos, null);
        btnSetting.setVisible(false);
        btnReturn.setVisible(false);
        btnLogout.setVisible(false);
        btnHome.setVisible(false);
        btnStore.setVisible(false);
        Btn btns[] = {
            new Btn(btn_user, userPos, new EventMenuOp(2)),
            btnSetting,
            btnReturn,
            btnHome,
            btnStore,
            btnLogout
        };
        return btns;
    }
    
    public Btn[] menuOpGamesIntro(Frame telaAtual){
        this.telaAtual = telaAtual;//20,81,143,195,248,303
        int userPos[] = {21,20,99,39}; int settingPos[] = {21,81,140,37};
        int logoutPos[] = {25,248,124,37};
        int homePos[] = {21,143,105,33}; int storePos[] = {21,195,117,33};
        btnSetting = new Btn(btn_setting, settingPos, null);
        btnLogout = new Btn(btn_logout, logoutPos, new EventOps(3));
        btnHome = new Btn(btn_home, homePos, new EventOps(2));
        btnStore = new Btn(btn_store, storePos, null);
        btnSetting.setVisible(false);
        btnLogout.setVisible(false);
        btnHome.setVisible(false);
        btnStore.setVisible(false);
        Btn btns[] = {
            new Btn(btn_user, userPos, new EventMenuOp(3)),
            btnSetting,
            btnHome,
            btnStore,
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
                btnSetting.setVisible(true);btnLogout.setVisible(true);descer = true;
                if(esc==2){btnHome.setVisible(true);btnStore.setVisible(true);btnReturn.setVisible(true);}
                if(esc==3){btnHome.setVisible(true);btnStore.setVisible(true);}
            }else{
                btnSetting.setVisible(false);btnLogout.setVisible(false);descer = false;
                if(esc==2){btnHome.setVisible(false);btnStore.setVisible(false);btnReturn.setVisible(false);}
                if(esc==3){btnHome.setVisible(false);btnStore.setVisible(false);}
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