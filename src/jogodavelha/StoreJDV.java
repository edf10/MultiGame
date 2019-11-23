package jogodavelha;
import componentes.Pn;
import java.awt.Component;
import padroes.Store;
public class StoreJDV extends Store{
    private Pn pnIntro;
    @Override
    public void introStore(){
        int backPos[] = {0,0,1200,700};
        
        
        Component cp[] = {
            
        };
        
        pnIntro = new Pn(backPos, cp);
        add(pnIntro);
    }
}
