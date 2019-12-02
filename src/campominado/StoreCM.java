package campominado;
import componentes.Btn;
import componentes.Lb;
import componentes.Pn;
import java.awt.Component;
import javax.swing.ImageIcon;
import padroes.ItemsTela;
import padroes.Store;
public class StoreCM extends Store{
    
    private int[][] posBtns = {{158,214,65,41},{362,214,65,41},{576,214,65,41},{764,214,65,41},{969,214,65,41},
                               {158,431,65,41},{362,431,65,41},{576,431,65,41},{764,431,65,41},{969,214,65,41}};
    private int[][] posBtnsComprado = {{110,283,165,38},{318,214,165,38},{522,214,165,38},{717,214,165,38},{919,214,165,38},
                                       {110,500,165,38},{318,500,165,38},{522,500,165,38},{717,500,165,38},{919,500,165,38}};
    private int[][] posBtnsUso = {{110,331,165,38},{318,331,165,38},{522,331,165,38},{717,331,165,38},{919,331,165,38},
                                  {110,548,165,38},{318,548,165,38},{522,548,165,38},{717,548,165,38},{919,548,165,38}};
    
    private ImageIcon btn_niveis[];
    
    public ImageIcon[] btnNiveis(String nivel){
        if("1".equals(nivel)){
            ImageIcon btn_niveis[] = {im.addImagem("btn_cm_easy"),im.addImagem("btn_cm_medium"),im.addImagem("btn_cm_hard")};
            return btn_niveis;
        }else{
            ImageIcon btn_niveis[] = {im.addImagem("btn_cm_easy_"+nivel),im.addImagem("btn_cm_medium_"+nivel),im.addImagem("btn_cm_hard_"+nivel)};
            return btn_niveis;
        }
    }
    
    private ItemsTela it = new ItemsTela();
    private Pn pnIntro;
    public void loja(){
        int backPos[] = {0,0,1200,700}; int btnFlagPos[] = {150,38,255,72}; int btnButtonPos[] = {834,38,255,72};
        int btnBombsPos[] = {487,38,255,72};
        ImageIcon btn_flag[] = {im.addImagem("btn_flags_cm"),im.addImagem("btn_flags_cm_t"),im.addImagem("btn_flags_cm_p")};
        ImageIcon btn_bombs[] = {im.addImagem("btn_bombs_cm"),im.addImagem("btn_bombs_cm_t"),im.addImagem("btn_bombs_cm_p")};
        ImageIcon btn_buttons[] = {im.addImagem("btn_buttons_cm"),im.addImagem("btn_buttons_cm_t"),im.addImagem("btn_buttons_cm_p")};
        if(it.getTelaAntIntro()==0||it.getTelaAntIntro()==5){it.setTelaAntIntro(1);}else{it.setTelaAntIntro(5);}
        
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
    
    private Pn pnItemsButtons;
    public void addStoreButtons(){
        
        for(int i = 1; i<10; i++){
            
        }
        
        pnItemsButtons = new Pn(); pnItemsButtons.setLayout(null); pnItemsButtons.setBounds(0, 0, 1200, 700);
        pnItemsButtons.setBackground(null);
        add(pnItemsButtons);
    }
    
    public void definirTelaVoltar(int x){
        it.setTelaAntIntro(x);
    }
    public ImageIcon[] getBtn_niveis() {
        return btn_niveis;
    }
    
    
}
