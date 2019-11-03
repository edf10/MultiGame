package padroes;

import componentes.Btn;
import componentes.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import multigame.MultiGameTela;

public class ItemsTela {
    private final ImageIcon imClose = new ImageIcon(getClass().getResource("imagens/btn_close.png"));
    private final ImageIcon imCloseT = new ImageIcon(getClass().getResource("imagens/btn_close_t.png"));
    public Btn btnClose(){
        int closePos[] = {1161,15,19,19}; ImageIcon btn_close[] = {imClose,imCloseT};
        return new Btn(btn_close, closePos, new EventClose());
    }
    private class EventClose implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            System.exit(0);
        }
    }
    
    private final ImageIcon imSom = new ImageIcon(getClass().getResource("imagens/btn_som.png"));
    private final ImageIcon imMute = new ImageIcon(getClass().getResource("imagens/btn_mute.png"));
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
    
    private final ImageIcon imUserIcon = new ImageIcon(getClass().getResource("imagens/btn_user.png"));
    private final ImageIcon imUserIconT = new ImageIcon(getClass().getResource("imagens/btn_user_t.png"));
    private final ImageIcon imSettingIcon = new ImageIcon(getClass().getResource("imagens/btn_setting.png"));
    private final ImageIcon imSettingIconT = new ImageIcon(getClass().getResource("imagens/btn_setting_t.png"));
    private final ImageIcon imReturnIcon = new ImageIcon(getClass().getResource("imagens/btn_return.png"));
    private final ImageIcon imReturnIconT = new ImageIcon(getClass().getResource("imagens/btn_return_t.png"));
    private final ImageIcon imLogoutIcon = new ImageIcon(getClass().getResource("imagens/btn_logout.png"));
    private final ImageIcon imLogoutIconT = new ImageIcon(getClass().getResource("imagens/btn_logout_t.png"));
    private final ImageIcon imHomeIcon = new ImageIcon(getClass().getResource("imagens/btn_home.png"));
    private final ImageIcon imHomeIconT = new ImageIcon(getClass().getResource("imagens/btn_home_t.png"));
    private final ImageIcon imStoreIcon = new ImageIcon(getClass().getResource("imagens/btn_store.png"));
    private final ImageIcon imStoreIconT = new ImageIcon(getClass().getResource("imagens/btn_store_t.png"));
    
    private Btn btnSetting;
    private Btn btnReturn;
    private Btn btnLogout;
    private Btn btnHome;
    private Btn btnStore;
    
    public Btn[] menuOp(Frame telaAtual){
        int userPos[] = {21,20,99,39}; int settingPos[] = {21,81,140,37};
        int returnPos[] = {21,143,125,30}; int logoutPos[] = {25,200,124,37};
        ImageIcon btn_user[] = {imUserIcon,imUserIconT}; ImageIcon btn_setting[] = {imSettingIcon,imSettingIconT};
        ImageIcon btn_return[] = {imReturnIcon,imReturnIconT}; ImageIcon btn_logout[] = {imLogoutIcon,imLogoutIconT};
        btnSetting = new Btn(btn_setting, settingPos, null);
        btnReturn = new Btn(btn_return, returnPos, null);
        btnLogout = new Btn(btn_logout, logoutPos, new EventOps(3, telaAtual));
        btnSetting.setVisible(false);
        btnReturn.setVisible(false);
        btnLogout.setVisible(false);
        Btn btns[] = {
            new Btn(btn_user, userPos, new EventMenuOp(1)),
            btnSetting,
            btnReturn,
            btnLogout
        };
        return btns;
    }
    public Btn[] menuOpGames(Frame telaAtual){
        int userPos[] = {21,20,99,39}; int settingPos[] = {21,81,140,37};
        int returnPos[] = {21,143,125,30}; int logoutPos[] = {25,303,124,37};
        int homePos[] = {21,195,105,33}; int storePos[] = {21,248,117,33};
        ImageIcon btn_user[] = {imUserIcon,imUserIconT}; ImageIcon btn_setting[] = {imSettingIcon,imSettingIconT};
        ImageIcon btn_return[] = {imReturnIcon,imReturnIconT}; ImageIcon btn_logout[] = {imLogoutIcon,imLogoutIconT};
        ImageIcon btn_home[] = {imHomeIcon,imHomeIconT}; ImageIcon btn_store[] = {imStoreIcon,imStoreIconT};
        btnSetting = new Btn(btn_setting, settingPos, null);
        btnReturn = new Btn(btn_return, returnPos, null);
        btnLogout = new Btn(btn_logout, logoutPos, new EventOps(3, telaAtual));
        btnHome = new Btn(btn_home, homePos, new EventOps(2, telaAtual));
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
    
    private boolean descer = false;
    public class EventMenuOp implements ActionListener{
        private int esc;
        public EventMenuOp(int esc){
            this.esc = esc;
        }
        @Override
        public void actionPerformed(ActionEvent e){
            if(descer==false){
                btnSetting.setVisible(true);btnReturn.setVisible(true);btnLogout.setVisible(true);descer = true;
                if(esc==2){btnHome.setVisible(true);btnStore.setVisible(true);}
            }else{
                btnSetting.setVisible(false);btnReturn.setVisible(false);btnLogout.setVisible(false);descer = false;
                if(esc==2){btnHome.setVisible(false);btnStore.setVisible(false);}
            }
        }
    }
    
    public class EventOps implements ActionListener{
        private int esc; private Frame telaAtual;
        public EventOps(int esc, Frame telaAtual){
            this.esc = esc; this.telaAtual = telaAtual;
        }
        @Override
        public void actionPerformed(ActionEvent e){
            switch(esc){
                case 1: break;
                case 2: telaAtual.dispose(); MultiGameTela mg = new MultiGameTela(2);break;
                case 3: telaAtual.dispose(); MultiGameTela mg1 = new MultiGameTela(3);break;
                default: break;
            }
        }
    }
    
}
