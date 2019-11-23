package wordpuzzle;
import componentes.Pn;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import padroes.Fonts;
import padroes.Store;
public class StoreWP extends Store{
    
    private Fonts fs = new Fonts();
    private Color colorMarc = Color.blue;
    private Font fonte = new Font("Arial", Font.PLAIN, 18);
    
    private Pn pnIntro;
    @Override
    public void introStore(){
        int backPos[] = {0,0,1200,700};
        
        
        Component cp[] = {
            
        };
        
        pnIntro = new Pn(backPos, cp);
        add(pnIntro);
    }
    
    public Color corMarcar(){
        return colorMarc;
    }
    public Font fonte(){
        return fonte;
    }
    
}
