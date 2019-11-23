package campominado;
import componentes.Btn;
import componentes.Lb;
import componentes.Pn;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import padroes.ItemsTela;
import padroes.Store;
import user.Conta;
import user.User;
public class StoreCM extends Store{
    private ItemsTela it = new ItemsTela();
    private User user = User.getUser();
    private ImageIcon[] btnsCM = {im.addImagem("btn_cm_easy_01"),im.addImagem("btn_cm_medium_01"),im.addImagem("btn_cm_hard_01")};
    private ImageIcon[] btnsCMT = {im.addImagem("btn_cm_easy_t_01"),im.addImagem("btn_cm_medium_t_01"),im.addImagem("btn_cm_hard_t_01")};
    private ImageIcon[] btnsCMP = {im.addImagem("btn_cm_easy_p_01"),im.addImagem("btn_cm_medium_p_01"),im.addImagem("btn_cm_hard_p_01")};
    
    private ImageIcon[] minasCM = {im.addImagem("bomb_cm_easy_01"),im.addImagem("bomb_cm_medium_01"),im.addImagem("bomb_cm_hard_01")};
    
    private ImageIcon[] flagCM = {im.addImagem("flagF_01"),im.addImagem("flagM_01"),im.addImagem("flagD_01")};
    
    private int[][] posBtns01 = {{110,283,165,38},{318,283,165,38},{522,283,165,38},{717,283,165,38},{919,283,165,38},
                                 {110,500,165,38},{318,500,165,38},{522,500,165,38},{717,500,165,38},{919,500,165,38}};
    private int[][] posBtns02 = {{110,331,165,38},{318,331,165,38},{522,331,165,38},{717,331,165,38},{919,331,165,38},
                                 {110,548,165,38},{318,548,165,38},{522,548,165,38},{717,548,165,38},{919,548,165,38}};
    private int[][] posBtns = {{158,214,65,41},{362,214,65,41},{576,214,65,41},{764,214,65,41},{969,214,65,41},
                               {158,431,65,41},{362,431,65,41},{576,431,65,41},{764,431,65,41},{969,431,65,41}};
    
    private Pn pnIntro;
    private Btn btnFlags;
    private Btn btnBombs;
    private Btn btnButtons;
    @Override
    public void introStore(){
        int backPos[] = {0,0,1200,700}; int btnFlagsPos[] = {150,38,255,72}; int btnBombsPos[] = {487,38,255,72}; int btnButtonsPos[] = {834,38,255,72};
        ImageIcon btn_flags[] = {im.addImagem("btn_flags_cm"),im.addImagem("btn_flags_cm_t"),im.addImagem("btn_flags_cm_p")};
        ImageIcon btn_bombs[] = {im.addImagem("btn_bombs_cm"),im.addImagem("btn_bombs_cm_t"),im.addImagem("btn_bombs_cm_p")};
        ImageIcon btn_buttons[] = {im.addImagem("btn_buttons_cm"),im.addImagem("btn_buttons_cm_t"),im.addImagem("btn_buttons_cm_p")};
        btnFlags = new Btn(btn_flags, btnFlagsPos, null);
        btnBombs = new Btn(btn_bombs, btnBombsPos, null);
        btnButtons = new Btn(btn_buttons, btnButtonsPos, null);
        it.setTelaAntIntro(4); it.setTelaAtual(this);
        Component cp[] = {
            btnFlags,
            btnBombs,
            btnButtons,
            it.btnClose(),
            it.returnGames(),
        };
        pnIntro = new Pn(backPos, cp);
        addButtons(); btnButtons.setIcon(im.addImagem("btn_buttons_cm_t"));
        add(pnIntro);
    }
    
    private ArrayList<Btn> comprar = new ArrayList<>();
    public void addButtons(){
        int btnCompradoPos[] = {posBtns01[0][0], posBtns01[0][1], posBtns01[0][2], posBtns01[0][3]};
        int btnUsoPos[] = {posBtns02[0][0], posBtns02[0][1], posBtns02[0][2], posBtns02[0][3]};
        pnIntro.add(new Btn(im.addImagem("comprado_store"), btnCompradoPos, null));
        pnIntro.add(new Btn(im.addImagem("btn_uso_store"), btnUsoPos, null));
        for(int i = 1; i<10; i++){
            pnIntro.add(new BtnComprar(2,i));
            int pos2[] = {posBtns02[i][0], posBtns02[i][1], posBtns02[i][2], posBtns02[i][3]};
            pnIntro.add(new Btn(im.addImagem("sem_uso_btn_cm_store"), pos2, null));
        }
        for(int i = 1; i<=9; i++){
            int pos[] = {posBtns[i-1][0], posBtns[i-1][1], posBtns[i-1][2], posBtns[i-1][3]};
            pnIntro.add(new Btn(im.addImagem("btn_cm_easy_0"+i), pos, null));
        }
        int pos[] = {posBtns[9][0], posBtns[9][1], posBtns[9][2], posBtns[9][3]};
        pnIntro.add(new Btn(im.addImagem("btn_cm_easy_10"), pos, null));
        
        int backPos[] = {0,0,1200,700};
        pnIntro.add(new Lb(im.addImagem("back_store_cm"), backPos));
    }
    
    public class BtnUso extends Btn{
        
    }
    
    public class BtnComprar extends Btn{
        private int tipo;
        public BtnComprar(int tipo, int num){
            super();
            this.tipo = tipo;
            if(tipo==1){
                setIcon(im.addImagem("comprado_store"));
            }else{
                setIcon(im.addImagem("valor_btn_cm_store"));
            }
            setBounds(posBtns01[num][0], posBtns01[num][1], posBtns01[num][2], posBtns01[num][3]);
            addActionListener(new EventBtnComprar());
        }
        
        public class EventBtnComprar implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ae) {
                if(user.getMoedas()-1000>0&&tipo==2){
                    user.comprar(1000); setIcon(im.addImagem("comprado_store")); tipo = 1;
                    Conta c = new Conta(user); c.gravar(); User.setUser(user);
                    JOptionPane.showMessageDialog(null, "Comprado");
                }else if(tipo==1){
                    JOptionPane.showMessageDialog(null, "Este item já foi comprado");
                }else{
                    JOptionPane.showMessageDialog(null, "Não tem dinheiro suficiente");
                }

            }
        }
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
