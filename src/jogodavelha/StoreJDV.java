package jogodavelha;
import componentes.Pn;
import java.awt.Component;
import javax.swing.ImageIcon;
import padroes.Store;
public class StoreJDV extends Store{
    
    private ImageIcon btn = im.addImagem("btn_jdv_game");
    private ImageIcon x = im.addImagem("icone_x_jdv");
    private ImageIcon o = im.addImagem("icone_o_jdv");
    
    private Pn pnIntro;
    @Override
    public void introStore(){
        int backPos[] = {0,0,1200,700};
        
        
        Component cp[] = {
            
        };
        
        pnIntro = new Pn(backPos, cp);
        add(pnIntro);
    }
    
    public ImageIcon btn(){
        return btn;
    }
    public ImageIcon x(){
        return x;
    }
    public ImageIcon o(){
        return o;
    }
    
}
