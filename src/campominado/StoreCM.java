package campominado;
import componentes.Pn;
import java.awt.Component;
import javax.swing.ImageIcon;
import padroes.Store;
public class StoreCM extends Store{
    
    private ImageIcon[] btnsCM = {im.addImagem("btn_cm_easy"),im.addImagem("btn_cm_medium"),im.addImagem("btn_cm_hard")};
    private ImageIcon[] btnsCMT = {im.addImagem("btn_cm_easy_t"),im.addImagem("btn_cm_medium_t"),im.addImagem("btn_cm_hard_t")};
    private ImageIcon[] btnsCMP = {im.addImagem("btn_cm_easy_p"),im.addImagem("btn_cm_medium_p"),im.addImagem("btn_cm_hard_p")};
    
    private ImageIcon[] minasCM = {im.addImagem("bomb_cm_easy"),im.addImagem("bomb_cm_medium"),im.addImagem("bomb_cm_hard")};
    
    private ImageIcon[] flagCM = {im.addImagem("flagF"),im.addImagem("flagM"),im.addImagem("flagD")};
    
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
