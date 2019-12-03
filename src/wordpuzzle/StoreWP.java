package wordpuzzle;
import componentes.Btn;
import componentes.Lb;
import componentes.Pn;
import java.awt.Component;
import javax.swing.ImageIcon;
import padroes.ItemsTela;
import padroes.Store;
public class StoreWP extends Store{
    private ItemsTela it = new ItemsTela();
    private Pn pnIntro;
    private Btn btnFont;
    private Btn btnCor;
    @Override
    public void intro(){
        int backPos[] = {0,0,1200,700}; int btnFontPos[] = {298,37,255,72}; int btnCorPos[] = {641,37,255,72};
        ImageIcon btn_font[] = {im.addImagem("btn_fonts_wp"),im.addImagem("btn_fonts_wp_t"),im.addImagem("btn_fonts_wp_p")};
        ImageIcon btn_cor[] = {im.addImagem("btn_cores_wp"),im.addImagem("btn_cores_wp_t"),im.addImagem("btn_cores_wp_p")};
        if(it.getTelaAntIntro()==0){it.setTelaAntIntro(1);}else{it.setTelaAntIntro(5);}
        btnFont = new Btn(btn_font, btnFontPos, null);
        btnCor = new Btn(btn_cor, btnCorPos, null);
        Component cp[] = {
            it.btnClose(), it.returnGames(this),
            btnFont, btnCor,
            new Lb(im.addImagem("back_store"), backPos)
        };
        pnIntro = new Pn(backPos, cp);
        add(pnIntro);
    }
    
    private Pn pnFonts;
    public void addFonts(){
        btnFont.setIcon(btnFont.getRolloverIcon());
        pnFonts = new Pn(); pnFonts.setLayout(null); pnFonts.setBounds(0, 0, 1200, 700);
        for(int i = 0; i<10; i++){
            pnFonts.add(new Lb(im.addImagem("bomb_cm_easy_"+ims[i]), posBtns[i]));
        }
        addBtnBasic(pnFonts, 0);
    }
    
    private Pn pnCores;
    public void addCores(){
        btnCor.setIcon(btnCor.getRolloverIcon());
        pnCores = new Pn(); pnCores.setLayout(null); pnCores.setBounds(0,0,1200,700);
        for(int i = 0; i<10; i++){
            pnCores.add(new Lb(im.addImagem("bomb_cm_easy_"+ims[i]), posBtns[i]));
        }
        addBtnBasic(pnCores, 1);
    }
    
}
