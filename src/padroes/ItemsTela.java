package padroes;

import arduino.ArduinoSerial;
import campominado.IntroductionCM;
import campominado.StoreCM;
import componentes.Btn;
import componentes.Frame;
import imagens.Im;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import jogodavelha.IntroductionJDV;
import jogodavelha.StoreJDV;
import multigame.MultiGameTela;
import wordpuzzle.IntroductionWP;
import wordpuzzle.StoreWP;

public class ItemsTela {
    private Im im = new Im();
    private ArduinoSerial arduino = new ArduinoSerial("COM4");
    public ItemsTela(){
        arduino.initialize();
    }
    public Btn btnClose(){
        int closePos[] = {1161,15,19,19}; ImageIcon btn_close[] = {im.addImagem("btn_close"),im.addImagem("btn_close_t")};
        VerificarPressExit sair = new VerificarPressExit(); sair.start();
        return new Btn(btn_close, closePos, new EventClose());
    }
    private class EventClose implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            System.exit(0);
        }
    }
    public class VerificarPressExit extends Thread{
        private String lido;
        @Override
        public void run(){
            while(true){
                //System.out.println(lido);
                try{Thread.sleep(100);}catch(Exception e){}
                if((lido = (arduino.read()!=null)?arduino.read():"0").equals("A")){
                    System.out.println("e");
                    System.exit(0);
                    stop();
                    break;
                }
            }
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
    private Btn btnStore;
    
    private final ImageIcon btn_user[] = {im.addImagem("btn_user"),im.addImagem("btn_user_t")}; 
    private final ImageIcon btn_return[] = {im.addImagem("btn_return"),im.addImagem("btn_return_t")}; 
    private final ImageIcon btn_logout[] = {im.addImagem("btn_logout"),im.addImagem("btn_logout_t")};
    private final ImageIcon btn_home[] = {im.addImagem("btn_home"),im.addImagem("btn_home_t")}; 
    private final ImageIcon btn_store[] = {im.addImagem("btn_store"),im.addImagem("btn_store_t")};
    public Btn[] menuOp(Frame telaAtual){
        this.telaAtual = telaAtual;
        int userPos[] = {21,20,99,39}; int logoutPos[] = {25,143,124,37}; int storePos[] = {21,86,117,33};
        btnLogout = new Btn(btn_logout, logoutPos, new EventOps(2));
        btnStore = new Btn(btn_store, storePos, new EventOps(3));
        btnLogout.setVisible(false);
        btnStore.setVisible(false);
        Btn btns[] = {
            new Btn(btn_user, userPos, new EventMenuOp(1)),
            btnLogout,
            btnStore
        };
        return btns;
    }
    public Btn[] menuOpGames(Frame telaAtual){
        this.telaAtual = telaAtual;
        int userPos[] = {21,20,99,39}; int homePos[] = {21,137,105,33};
        int returnPos[] = {21,81,125,30}; int logoutPos[] = {25,195,124,37};
        btnReturn = new Btn(btn_return, returnPos, new EventBtnReturn());
        btnLogout = new Btn(btn_logout, logoutPos, new EventOps(2));
        btnHome = new Btn(btn_home, homePos, new EventOps(1));
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
    
    public Btn[] menuOpGamesIntro(Frame telaAtual, int store){
        this.telaAtual = telaAtual;//20,81,143,195,248,303
        int userPos[] = {21,20,99,39};int logoutPos[] = {25,195,124,37};int homePos[] = {21,81,105,33}; int storePos[] = {19,139,117,33};
        btnLogout = new Btn(btn_logout, logoutPos, new EventOps(2));
        btnHome = new Btn(btn_home, homePos, new EventOps(1));
        btnStore = new Btn(btn_store, storePos, new EventOps(store));
        btnLogout.setVisible(false);
        btnHome.setVisible(false);
        btnStore.setVisible(false);
        Btn btns[] = {
            new Btn(btn_user, userPos, new EventMenuOp(3)),
            btnHome,
            btnLogout,
            btnStore
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
                if(esc==1||esc==3){btnStore.setVisible(true);}
                if(esc==2){btnHome.setVisible(true);btnReturn.setVisible(true);}
                if(esc==3){btnHome.setVisible(true);btnStore.setVisible(true);}
            }else{
                btnLogout.setVisible(false);descer = false;
                if(esc==1||esc==3){btnStore.setVisible(false);}
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
                case 1: telaAtual.dispose(); MultiGameTela mg = new MultiGameTela();mg.Jogos(); mg.show();break;
                case 2: telaAtual.dispose(); MultiGameTela mg1 = new MultiGameTela(); mg1.login_user(); mg1.show();break;
                case 3: telaAtual.dispose(); Store s = new Store(); s.intro(); s.show(); break;
                case 4: telaAtual.dispose(); StoreCM scm = new StoreCM(); scm.intro(); scm.show(); break;
                case 5: telaAtual.dispose(); StoreJDV sjdv = new StoreJDV(); sjdv.intro(); sjdv.show(); break;
                case 6: telaAtual.dispose(); StoreWP swp = new StoreWP(); swp.intro(); swp.show(); break;
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
    public void setTelaAntIntro(int telaAntIntro) {
        this.telaAntIntro = telaAntIntro;
    }
    public int getTelaAntIntro() {
        return telaAntIntro;
    }
    public void setTelaAtual(Frame telaAtual) {
        this.telaAtual = telaAtual;
    }
    public class EventBtnReturn implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            telaAtual.dispose();
            switch (telaAntIntro) {
                case 1:IntroductionCM icm = new IntroductionCM();icm.intro();icm.show();break;
                case 2:IntroductionJDV ijdv = new IntroductionJDV();ijdv.intro();ijdv.show();break;
                case 3:IntroductionWP iwp = new IntroductionWP();iwp.intro();iwp.show();break;
                case 4:MultiGameTela mg = new MultiGameTela();mg.Jogos(); mg.show();break;
                case 5:Store s = new Store(); s.intro(); s.show();
                default:break;
            }
        }
    }
    
}