package campominado;
import componentes.Pn;
import java.awt.Component;
import javax.swing.ImageIcon;
import padroes.Store;
public class StoreCM extends Store{
    
    private ImageIcon[] btnsCM = {im.addImagem("btn_cm_easy_01"),im.addImagem("btn_cm_medium_01"),im.addImagem("btn_cm_hard_01")};
    private ImageIcon[] btnsCMT = {im.addImagem("btn_cm_easy_t_01"),im.addImagem("btn_cm_medium_t_01"),im.addImagem("btn_cm_hard_t_01")};
    private ImageIcon[] btnsCMP = {im.addImagem("btn_cm_easy_p_01"),im.addImagem("btn_cm_medium_p_01"),im.addImagem("btn_cm_hard_p_01")};
    
    private ImageIcon[] minasCM = {im.addImagem("bomb_cm_easy_01"),im.addImagem("bomb_cm_medium_01"),im.addImagem("bomb_cm_hard_01")};
    
    private ImageIcon[] flagCM = {im.addImagem("flagF_01"),im.addImagem("flagM_01"),im.addImagem("flagD_01")};
    
    private Pn pnIntro;
    @Override
    public void introStore(){
        int backPos[] = {0,0,1200,700};
        
        
        Component cp[] = {
            
        };
        
        pnIntro = new Pn(backPos, cp);
        add(pnIntro);
    }
    
    public ImageIcon[] flags(){
        return flagCM;
    }
    public ImageIcon[] minas(){
        return minasCM;
    }
    public ImageIcon[] btns(){
        return btnsCM;
    }
    public ImageIcon[] btnsT(){
        return btnsCMT;
    }
    public ImageIcon[] btnsP(){
        return btnsCMP;
    }
}
