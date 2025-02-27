package jogodavelha;
import componentes.Btn;
import componentes.Lb;
import componentes.Pn;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import padroes.ItemsTela;
import padroes.Store;
import user.Conta;
import user.User;
public class StoreJDV extends Store{
    private ItemsTela it = new ItemsTela();
    
    private ImageIcon btn_x = new ImageIcon();
    private ImageIcon btn_o = new ImageIcon();
    private ArrayList<ImageIcon> btn_button = new ArrayList<>();
    
    public StoreJDV(){
        setStore(user.getStoreJDV());
        setEmUso(user.getEmUsoJDV());
        btnX(ims[user.getEmUsoJDV().get(0).indexOf("1")]);
        btnO(ims[user.getEmUsoJDV().get(1).indexOf("1")]);
        btnButtons(ims[user.getEmUsoJDV().get(2).indexOf("1")]);
    }
    
    public void btnX(String esc){
        btn_x = im.addImagem("x_jdv_"+esc);
    }
    public void btnO(String esc){
        btn_o = im.addImagem("o_jdv_"+esc);
    }
    public void btnButtons(String esc){
        btn_button.clear();
        btn_button.add(im.addImagem("btn_jdv_game_"+esc));btn_button.add(im.addImagem("btn_jdv_game_t_"+esc));btn_button.add(im.addImagem("btn_jdv_game_p_"+esc));
    }
    public ImageIcon getBtn_x() {
        return btn_x;
    }
    public ImageIcon getBtn_o() {
        return btn_o;
    }
    public ArrayList<ImageIcon> getBtn_button() {
        return btn_button;
    }
    
    private Pn pnIntro;
    private Btn btnButtons;
    private Btn btnXs;
    private Btn btnOs;
    @Override
    public void intro(){
        int backPos[] = {0,0,1200,700}; int btnXPos[] = {150,38,255,72}; int btnButtonPos[] = {834,38,255,72};
        int btnOPos[] = {487,38,255,72};
        ImageIcon btn_xs[] = {im.addImagem("btn_x_jdv"),im.addImagem("btn_x_jdv_t"),im.addImagem("btn_x_jdv_p")};
        ImageIcon btn_os[] = {im.addImagem("btn_o_jdv"),im.addImagem("btn_o_jdv_t"),im.addImagem("btn_o_jdv_p")};
        ImageIcon btn_buttons[] = {im.addImagem("btn_buttons_jdv"),im.addImagem("btn_buttons_jdv_t"),im.addImagem("btn_buttons_jdv_p")};
        if(it.getTelaAntIntro()==0){it.setTelaAntIntro(2);}else{it.setTelaAntIntro(5);}
        btnButtons = new Btn(btn_buttons, btnButtonPos, new EventBtnsIntro(3));
        btnXs = new Btn(btn_xs, btnXPos, new EventBtnsIntro(1));
        btnOs = new Btn(btn_os, btnOPos, new EventBtnsIntro(2));
        Component cp[] = {
            it.btnClose(), it.btnSomOutro(), it.returnGames(this),
            btnButtons, btnXs, btnOs,
            new Lb(im.addImagem("back_store"), backPos)
        };
        pnIntro = new Pn(backPos, cp);
        add(pnIntro);
    }
    public void loja(Pn pn){
        int backPos[] = {0,0,1200,700};
        Component cp[] = {
            it.btnClose(), it.btnSomOutro(), it.returnGames(this),
            btnButtons, btnXs, btnOs,
            pn
        };
        pnIntro = new Pn(backPos, cp);
        add(pnIntro);
    }
    
    public class EventBtnsIntro implements ActionListener{
        private int btn;
        public EventBtnsIntro(int btn){
            this.btn = btn;
        }
        @Override
        public void actionPerformed(ActionEvent ae) {
            pnIntro.setVisible(false);
            btnButtons.setIcon(im.addImagem("btn_buttons_jdv"));
            btnOs.setIcon(im.addImagem("btn_o_jdv"));
            btnXs.setIcon(im.addImagem("btn_x_jdv"));
            if(btn==1){
                loja(addXs());
            }else if(btn==2){
                loja(addOs());
            }else{
                loja(addButtons());
            }
        }
    }
    
    public void definirTelaVoltar(int x){
        it.setTelaAntIntro(x);
    }
    
    private Pn pnItemsButtons;
    public Pn addButtons(){
        btnButtons.setIcon(btnButtons.getRolloverIcon());
        pnItemsButtons = new Pn(); pnItemsButtons.setLayout(null); pnItemsButtons.setBounds(0, 0, 1200, 700);
        addBtnsUso(pnItemsButtons, 2);
        for(int i = 0; i<10; i++){
            pnItemsButtons.add(new Lb(im.addImagem("btn_jdv_game_"+ims[i]+"_z"), posBtns[i]));
            pnItemsButtons.add(btnsUso[2][i]);
        }
        addBtnBasic(pnItemsButtons, 2);
        return pnItemsButtons;
    }
    private Pn pnItemsOs;
    public Pn addOs(){
        btnOs.setIcon(btnOs.getRolloverIcon());
        pnItemsOs = new Pn(); pnItemsOs.setLayout(null); pnItemsOs.setBounds(0, 0, 1200, 700);
        addBtnsUso(pnItemsOs, 1);
        for(int i = 0; i<10; i++){
            pnItemsOs.add(new Lb(im.addImagem("o_jdv_"+ims[i]+"_z"), posBtns[i]));
            pnItemsOs.add(btnsUso[1][i]);
        }
        addBtnBasic(pnItemsOs, 1);
        return pnItemsOs;
    }
    private Pn pnItemsXs;
    public Pn addXs(){
        btnXs.setIcon(btnXs.getRolloverIcon());
        pnItemsXs = new Pn(); pnItemsXs.setLayout(null); pnItemsXs.setBounds(0, 0, 1200, 700);
        addBtnsUso(pnItemsXs, 0);
        for(int i = 0; i<10; i++){
            pnItemsXs.add(new Lb(im.addImagem("x_jdv_"+ims[i]+"_z"), posBtns[i]));
            pnItemsXs.add(btnsUso[0][i]);
        }
        addBtnBasic(pnItemsXs, 0);
        return pnItemsXs;
    }
    
    public void addItems(){
        user.setStoreJDV(getStore());
        user.setEmUsoJDV(getEmUso());
        btnX(ims[botao]);
        btnO(ims[botao]);
        btnButtons(ims[botao]);
        Conta c = new Conta(user); c.gravar(); User.setUser(user);
    }
    
    private Btn btnsUso[][] = new Btn[3][10];
    public void addBtnsUso(Pn pn, int tipo){
        for(int i = 0; i<10; i++){
            if(getEmUso().get(tipo).get(i).equals("1")){
                btnsUso[tipo][i] = new Btn(im.addImagem("btn_uso_store"), posBtnsUso[i], new EventUso(i, tipo));
            }else{
                btnsUso[tipo][i] = new Btn(im.addImagem("sem_uso_btn_cm_store"), posBtnsUso[i], new EventUso(i, tipo));
            }
        }
    }
    
    private int botao;
    public class EventUso implements ActionListener{
        private int btn;private int tipo;
        public EventUso(int auxBtn, int auxTipo){
            btn = auxBtn; tipo = auxTipo;
        }
        @Override
        public void actionPerformed(ActionEvent ae) {
            if(getEmUso().get(tipo).get(btn).equals("0")&&getStore().get(tipo).get(btn).equals("1")){
                btnsUso[tipo][getEmUso().get(tipo).indexOf("1")].setIcon(im.addImagem("sem_uso_btn_cm_store"));
                getEmUso().get(tipo).set(getEmUso().get(tipo).indexOf("1"), "0");
                getEmUso().get(tipo).set(btn, "1");
                System.out.println(getEmUso().toString());
                btnsUso[tipo][btn].setIcon(im.addImagem("btn_uso_store"));
                botao = btn;
                addItems();
            }
        }
    }
    
}
