package wordpuzzle;
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
public class StoreWP extends Store{
    private ItemsTela it = new ItemsTela();
    private Fonts fs = new Fonts();
    private Font font;
    private Color cor;
    
    public StoreWP(){
        setStore(user.getStoreWP());
        setEmUso(user.getEmUsoWP());
    }
    
    public void fontAdd(){
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
            it.btnClose(), it.returnGames(this),
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
        for(int i = 0; i<10; i++){
            pnFonts.add(new Lb(im.addImagem("font_wp_"+ims[i]+"_z"), posBtns[i]));
        }
        addBtnBasic(pnFonts, 0);
        return pnFonts;
    }
    
    private Pn pnCores;
    public Pn addCores(){
        btnCor.setIcon(btnCor.getRolloverIcon());
        pnCores = new Pn(); pnCores.setLayout(null); pnCores.setBounds(0,0,1200,700);
        for(int i = 0; i<10; i++){
            pnCores.add(new Lb(im.addImagem("mostra_cor_wp_"+ims[i]), posBtns[i]));
        }
        addBtnBasic(pnCores, 1);
        return pnCores;
    }
    
    public void loja(Pn pn){
        int backPos[] = {0,0,1200,700};
        Component cp[] = {
            it.btnClose(), it.returnGames(this),
            btnFont, btnCor,
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
            btnFont.setIcon(im.addImagem("btn_fonts_wp"));
            btnCor.setIcon(im.addImagem("btn_cores_wp"));
            if(btn==1){
                loja(addFonts());
            }else{
                loja(addCores());
            }
        }
    }
}
