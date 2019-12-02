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
public class Store extends Frame{
    private ItemsTela it = new ItemsTela();
    private Pn pnIntro;
    public void intro(){
        int gifRightPos[] = {759,139,500,500}; int gifLeftPos[] = {-29,139,500,500}; int titlePos[] = {442,43,317,96};
        int cmPos[] = {398,257,405,43}; int jdvPos[] = {385,350,431,43}; int wpPos[] = {415,446,388,43};
        ImageIcon btn_cm[] = {im.addImagem("title_cm_store"),im.addImagem("title_cm_store_t"),im.addImagem("title_cm_store_p")};
        ImageIcon btn_jdv[] = {im.addImagem("title_jdv_store"),im.addImagem("title_jdv_store_t"),im.addImagem("title_jdv_store_p")};
        ImageIcon btn_wp[] = {im.addImagem("title_wp_store"),im.addImagem("title_wp_store_t"),im.addImagem("title_wp_store_p")};
        it.setTelaAntIntro(4);
        Component cp[] = {
            it.btnClose(), it.btnSomOutro(), it.returnGames(this),
            new Lb(im.addImagem("title_store"), titlePos),
            new Btn(btn_cm, cmPos, new EventBtns(1)),
            new Btn(btn_jdv, jdvPos, new EventBtns(2)),
            new Btn(btn_wp, wpPos, new EventBtns(3)),
            new Lb(im.addGif("back_gif_store_in"), gifRightPos),
            new Lb(im.addGif("back_gif_store"), gifLeftPos)
        };
        int backPos[] = {0,0,1200,700};
        pnIntro = new Pn(backPos, cp);
        pnIntro.setBackground(Color.black);
        add(pnIntro);
    }
    public class EventBtns implements ActionListener{
        private int esc;
        public EventBtns(int esc){
            this.esc = esc;
        }
        @Override
        public void actionPerformed(ActionEvent ae) {
            dispose();
            switch(esc){
                case 1: StoreCM scm = new StoreCM(); scm.definirTelaVoltar(5); scm.loja(); scm.show(); break;
                case 2: break;
                case 3: break;
                default: break;
            }
        }
    }
}
