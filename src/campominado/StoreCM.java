package campominado;
import componentes.Btn;
import componentes.Lb;
import componentes.Pn;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import padroes.ItemsTela;
import padroes.Store;
import user.User;
public class StoreCM extends Store{
    private User user = User.getUser();
    private int[][] posBtns = {{158,214,65,41},{362,214,65,41},{576,214,65,41},{764,214,65,41},{969,214,65,41},
                               {158,431,65,41},{362,431,65,41},{576,431,65,41},{764,431,65,41},{969,431,65,41}};
    private int[][] posBtnsComprado = {{110,283,165,38},{318,283,165,38},{522,283,165,38},{717,283,165,38},{919,283,165,38},
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
    private Btn btnButtons;
    private Btn btnFlags;
    private Btn btnBombs;
    public void loja(){
        int backPos[] = {0,0,1200,700}; int btnFlagPos[] = {150,38,255,72}; int btnButtonPos[] = {834,38,255,72};
        int btnBombsPos[] = {487,38,255,72};
        ImageIcon btn_flag[] = {im.addImagem("btn_flags_cm"),im.addImagem("btn_flags_cm_t"),im.addImagem("btn_flags_cm_p")};
        ImageIcon btn_bombs[] = {im.addImagem("btn_bombs_cm"),im.addImagem("btn_bombs_cm_t"),im.addImagem("btn_bombs_cm_p")};
        ImageIcon btn_buttons[] = {im.addImagem("btn_buttons_cm"),im.addImagem("btn_buttons_cm_t"),im.addImagem("btn_buttons_cm_p")};
        if(it.getTelaAntIntro()==0){it.setTelaAntIntro(1);}else{it.setTelaAntIntro(5);}
        btnButtons = new Btn(btn_buttons, btnButtonPos, new EventBtnsIntro(3));
        btnFlags = new Btn(btn_flag, btnFlagPos, new EventBtnsIntro(1));
        btnBombs = new Btn(btn_bombs, btnBombsPos, new EventBtnsIntro(2));
        Component cp[] = {
            it.btnClose(), it.returnGames(this),
            btnButtons, btnFlags, btnBombs,
            new Lb(im.addImagem("back_store_cm"), backPos)
        };
        pnIntro = new Pn(backPos, cp);
        add(pnIntro);
    }
    public void loja(Pn pn){
        int backPos[] = {0,0,1200,700}; int btnFlagPos[] = {150,38,255,72}; int btnButtonPos[] = {834,38,255,72};
        int btnBombsPos[] = {487,38,255,72};
        ImageIcon btn_flag[] = {im.addImagem("btn_flags_cm"),im.addImagem("btn_flags_cm_t"),im.addImagem("btn_flags_cm_p")};
        ImageIcon btn_bombs[] = {im.addImagem("btn_bombs_cm"),im.addImagem("btn_bombs_cm_t"),im.addImagem("btn_bombs_cm_p")};
        ImageIcon btn_buttons[] = {im.addImagem("btn_buttons_cm"),im.addImagem("btn_buttons_cm_t"),im.addImagem("btn_buttons_cm_p")};
        btnButtons = new Btn(btn_buttons, btnButtonPos, new EventBtnsIntro(3));
        btnFlags = new Btn(btn_flag, btnFlagPos, new EventBtnsIntro(1));
        btnBombs = new Btn(btn_bombs, btnBombsPos, new EventBtnsIntro(2));
        Component cp[] = {
            it.btnClose(), it.returnGames(this),
            btnButtons, btnFlags, btnBombs,
            pn
        };
        pnIntro = new Pn(backPos, cp);
        add(pnIntro);
    }
    
    public class EventBtnsIntro implements ActionListener{
        private int btn;
        public EventBtnsIntro(int btn){
            this.btn = btn;
        }
        @Override
        public void actionPerformed(ActionEvent ae) {
            int backPos[] = {0,0,1200,700};
            pnIntro.setVisible(false);
            if(btn==1){
                loja(addStoreFlags());
            }else if(btn==2){
                loja(addStoreBombs());
            }else{
                loja(addStoreButtons());
            }
        }
    }
    
    private Pn pnItemsBombs;
    public Pn addStoreBombs(){
        int backPos[] = {0,0,1200,700};
        
        pnItemsBombs = new Pn(); pnItemsBombs.setBounds(0, 0, 1200, 700);
        pnItemsBombs.setBackground(Color.blue);
        return pnItemsBombs;
    }
    
    private Pn pnItemsFlags;
    public Pn addStoreFlags(){
        int backPos[] = {0,0,1200,700};
        
        pnItemsFlags = new Pn(); pnItemsFlags.setBounds(0, 0, 1200, 700);
        pnItemsFlags.setBackground(Color.yellow);
        return pnItemsFlags;
    }
    
    private Pn pnItemsButtons;
    public Pn addStoreButtons(){
        btnButtons.setIcon(btnButtons.getRolloverIcon());
        int backPos[] = {0,0,1200,700};
        String[] ims = {"01","02","03","04","05","06","07","08","09","10"};
        pnItemsButtons = new Pn(); pnItemsButtons.setLayout(null); pnItemsButtons.setBounds(0, 0, 1200, 700);
        for(int i = 0; i<10; i++){
            pnItemsButtons.add(new Btn(im.addImagem("btn_cm_easy_"+ims[i]), posBtns[i], null));
            if(user.getStoreCM().get(0).get(i).equals("1")){
                pnItemsButtons.add(new Btn(im.addImagem("comprado_store"), posBtnsComprado[i], null));
            }else{
                pnItemsButtons.add(new Btn(im.addImagem("valor_btn_cm_store"), posBtnsComprado[i], null));
            }
            if(user.getEmUsoCM().get(0).get(i).equals("1")){
                pnItemsButtons.add(new Btn(im.addImagem("btn_uso_store"), posBtnsUso[i], null));
            }else{
                pnItemsButtons.add(new Btn(im.addImagem("sem_uso_btn_cm_store"), posBtnsUso[i], null));
            }
        }
        pnItemsButtons.add(new Lb(im.addImagem("back_store_cm"), backPos));
        pnItemsButtons.setBackground(null);
        return pnItemsButtons;
    }
    
    public void definirTelaVoltar(int x){
        it.setTelaAntIntro(x);
    }
    public ImageIcon[] getBtn_niveis() {
        return btn_niveis;
    }
    
    
}
