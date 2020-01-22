package wordpuzzle;
import campominado.StoreCM;
import componentes.Btn;
import componentes.Lb;
import componentes.Pn;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import padroes.Fonts;
import padroes.ItemsTela;
import padroes.Store;
import user.Conta;
import user.User;
public class StoreWP extends Store{
    private ItemsTela it = new ItemsTela();
    private Fonts fs = new Fonts();
    private Font font;
    private Color cor;
    private Color cores[] = {new Color(91,191,150),new Color(191,91,129),new Color(82,119,188),new Color(139,82,188),new Color(188,107,82),
                             new Color(145,46,46),new Color(196,200,93),new Color(143,80,30),new Color(69,111,135),new Color(65,130,65)};
    
    public StoreWP(){
        setStore(user.getStoreWP());
        setEmUso(user.getEmUsoWP());
        fontAdd(ims[user.getEmUsoWP().get(0).indexOf("1")]);
        corAdd(Integer.parseInt(ims[user.getEmUsoWP().get(1).indexOf("1")])-1);
    }
    
    public void fontAdd(String esc){
        if(esc.equals("01")||esc.equals("07")||esc.equals("09")||esc.equals("10")){
            font = fs.addNewFontOutro("font_"+esc, 18); 
        }else{
            font = fs.addNewFont("font_"+esc, 18);
        }
    }
    public void corAdd(int esc){
        cor = cores[esc];
    }
    public Font getFont() {
        return font;
    }
    public Color getCor() {
        return cor;
    }
    private Pn pnIntro;
    private Btn btnFont;
    private Btn btnCor;
    @Override
    public void intro(){
        int backPos[] = {0,0,1200,700}; int btnFontPos[] = {298,37,255,72}; int btnCorPos[] = {641,37,255,72};
        ImageIcon btn_font[] = {im.addImagem("btn_fonts_wp"),im.addImagem("btn_fonts_wp_t"),im.addImagem("btn_fonts_wp_p")};
        ImageIcon btn_cor[] = {im.addImagem("btn_cores_wp"),im.addImagem("btn_cores_wp_t"),im.addImagem("btn_cores_wp_p")};
        if(it.getTelaAntIntro()==0){it.setTelaAntIntro(3);}else{it.setTelaAntIntro(5);}
        btnFont = new Btn(btn_font, btnFontPos, new EventBtnsIntro(1));
        btnCor = new Btn(btn_cor, btnCorPos, new EventBtnsIntro(2));
        Component cp[] = {
            it.btnClose(), it.btnSomOutro(), it.returnGames(this),
            btnFont, btnCor,
            new Lb(im.addImagem("back_store"), backPos)
        };
        pnIntro = new Pn(backPos, cp);
        add(pnIntro);
    }
    
    private Pn pnFonts;
    public Pn addFonts(){
        btnFont.setIcon(btnFont.getRolloverIcon());
        pnFonts = new Pn(); pnFonts.setLayout(null); pnFonts.setBounds(0, 0, 1200, 700);
        addBtnsUso(pnFonts, 0);
        for(int i = 0; i<10; i++){
            pnFonts.add(new Lb(im.addImagem("font_wp_"+ims[i]+"_z"), posBtns[i]));
            pnFonts.add(btnsUso[0][i]);
        }
        addBtnBasic(pnFonts, 0);
        return pnFonts;
    }
    
    private Pn pnCores;
    public Pn addCores(){
        btnCor.setIcon(btnCor.getRolloverIcon());
        pnCores = new Pn(); pnCores.setLayout(null); pnCores.setBounds(0,0,1200,700);
        addBtnsUso(pnCores, 1);
        for(int i = 0; i<10; i++){
            pnCores.add(new Lb(im.addImagem("mostra_cor_wp_"+ims[i]), posBtns[i]));
            pnCores.add(btnsUso[1][i]);
        }
        addBtnBasic(pnCores, 1);
        return pnCores;
    }
    
    public void loja(Pn pn){
        int backPos[] = {0,0,1200,700};
        Component cp[] = {
            it.btnClose(), it.btnSomOutro(), it.returnGames(this),
            btnFont, btnCor,
            pn
        };
        pnIntro = new Pn(backPos, cp);
        add(pnIntro);
    }
    
    public void definirTelaVoltar(int x){
        it.setTelaAntIntro(x);
    }
    
    public class EventBtnsIntro implements ActionListener{
        private int btn;
        public EventBtnsIntro(int btn){
            this.btn = btn;
        }
        @Override
        public void actionPerformed(ActionEvent ae) {
            pnIntro.setVisible(false);
            btnFont.setIcon(im.addImagem("btn_fonts_wp"));
            btnCor.setIcon(im.addImagem("btn_cores_wp"));
            if(btn==1){
                loja(addFonts());
            }else{
                loja(addCores());
            }
        }
    }
    
    public void addItems(){
        user.setStoreWP(getStore());
        user.setEmUsoWP(getEmUso());
        fontAdd(ims[botao]);
        corAdd(Integer.parseInt(ims[botao])-1);
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
                btnsUso[tipo][btn].setIcon(im.addImagem("btn_uso_store"));
                botao = btn;
                addItems();
            }
        }
    }
    
}
