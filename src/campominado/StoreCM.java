package campominado;
import componentes.Btn;
import componentes.Lb;
import componentes.Pn;
import java.awt.Component;
import javax.swing.ImageIcon;
import padroes.ItemsTela;
import padroes.Store;
public class StoreCM extends Store{
    private ItemsTela it = new ItemsTela();
    private Pn pnIntro;
    @Override
    public void intro(){
        int backPos[] = {0,0,1200,700}; int btnFlagPos[] = {150,38,255,72}; int btnButtonPos[] = {834,38,255,72};
        int btnBombsPos[] = {487,38,255,72};
        ImageIcon btn_flag[] = {im.addImagem("btn_flags_cm"),im.addImagem("btn_flags_cm_t"),im.addImagem("btn_flags_cm_p")};
        ImageIcon btn_bombs[] = {im.addImagem("btn_bombs_cm"),im.addImagem("btn_bombs_cm_t"),im.addImagem("btn_bombs_cm_p")};
        ImageIcon btn_buttons[] = {im.addImagem("btn_buttons_cm"),im.addImagem("btn_buttons_cm_t"),im.addImagem("btn_buttons_cm_p")};
        if(it.getTelaAntIntro()==0||it.getTelaAntIntro()==5){it.setTelaAntIntro(1);}
        Component cp[] = {
            it.btnClose(), it.returnGames(this),
            new Btn(btn_flag, btnFlagPos, null),
            new Btn(btn_bombs, btnBombsPos, null),
            new Btn(btn_buttons, btnButtonPos, null),
            new Lb(im.addImagem("back_store_cm"), backPos)
        };
        pnIntro = new Pn(backPos, cp);
        add(pnIntro);
    }
    
    public void definirTelaVoltar(int x){
        it.setTelaAntIntro(x);
    }
    
}
