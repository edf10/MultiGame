package jogodavelha;
import componentes.Btn;
import componentes.Lb;
import componentes.Pn;
import java.awt.Component;
import javax.swing.ImageIcon;
import padroes.ItemsTela;
import padroes.Store;
public class StoreJDV extends Store{
    private ItemsTela it = new ItemsTela();
    
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
        btnButtons = new Btn(btn_buttons, btnButtonPos, null);
        btnXs = new Btn(btn_xs, btnXPos, null);
        btnOs = new Btn(btn_os, btnOPos, null);
        Component cp[] = {
            it.btnClose(), it.returnGames(this),
            btnButtons, btnXs, btnOs,
            new Lb(im.addImagem("back_store"), backPos)
        };
        pnIntro = new Pn(backPos, cp);
        add(pnIntro);
    }
    
    public void definirTelaVoltar(int x){
        it.setTelaAntIntro(x);
    }
    
    
    
}
