package padroes;
import campominado.StoreCM;
import componentes.Btn;
import componentes.Frame;
import componentes.Lb;
import componentes.Pn;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import jogodavelha.StoreJDV;
import wordpuzzle.StoreWP;
public class Store extends Frame{
    private ItemsTela it = new ItemsTela();
    
    private Pn pnIntroStore;
    public void introStore(){
        int btnCMPos[] = {398,258,405,43}; int btnJDVPos[] = {385,350,431,43}; int btnWPPos[] = {415,446,388,43};
        getContentPane().setBackground(Color.black); int titlePos[] = {442,43,317,96}; int backPos[] = {0,0,1200,700};
        int gif1Pos[] = {-29,139,500,500}; int gif2Pos[] = {759,139,500,500};
        ImageIcon btn_cm[] = {im.addImagem("title_cm_store"),im.addImagem("title_cm_store_t"),im.addImagem("title_cm_store_p")};
        ImageIcon btn_jdv[] = {im.addImagem("title_jdv_store"),im.addImagem("title_jdv_store_t"),im.addImagem("title_jdv_store_p")};
        ImageIcon btn_wp[] = {im.addImagem("title_wp_store"),im.addImagem("title_wp_store_t"),im.addImagem("title_wp_store_p")};
        Btn menu[] = it.menuOpWithHome(this);
        Component cp[] = {
            it.btnClose(), menu[0], menu[1], menu[2], 
            new Btn(btn_cm, btnCMPos, null),
            new Btn(btn_jdv, btnJDVPos, null),
            new Btn(btn_wp, btnWPPos, null),
            new Lb(im.addImagem("title_store"), titlePos),
            new Lb(im.addGif("back_gif_store"), gif1Pos),
            new Lb(im.addGif("back_gif_store_in"), gif2Pos)
        };
        
        pnIntroStore = new Pn(backPos, cp);
        pnIntroStore.setBackground(Color.black);
        add(pnIntroStore);
    }
    
    public class EventBtnsLojas implements ActionListener{
        private int esc;
        public EventBtnsLojas(int esc){this.esc = esc;}
        @Override
        public void actionPerformed(ActionEvent ae) {
            
            switch(esc){
                case 1: StoreCM cm = new StoreCM();break;
                case 2: StoreJDV jdv = new StoreJDV();break;
                case 3: StoreWP wp = new StoreWP();break;
                default: break;
            }
            
        }
    }
    
    
    public void lerItems(String arq){
        
    }
    
    public void gravarItems(String arq){
        
    }
 
}