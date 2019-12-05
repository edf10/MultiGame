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
import java.util.ArrayList;
import javax.swing.ImageIcon;
import jogodavelha.StoreJDV;
import user.Conta;
import user.User;
import wordpuzzle.StoreWP;
public class Store extends Frame{
    protected int[][] posBtns = {{158,214,65,41},{362,214,65,41},{576,214,65,41},{764,214,65,41},{969,214,65,41},
                               {158,431,65,41},{362,431,65,41},{576,431,65,41},{764,431,65,41},{969,431,65,41}};
    protected int[][] posBtnsComprado = {{110,283,165,38},{318,283,165,38},{522,283,165,38},{717,283,165,38},{919,283,165,38},
                                       {110,500,165,38},{318,500,165,38},{522,500,165,38},{717,500,165,38},{919,500,165,38}};
    protected int[][] posBtnsUso = {{110,331,165,38},{318,331,165,38},{522,331,165,38},{717,331,165,38},{919,331,165,38},
                                  {110,548,165,38},{318,548,165,38},{522,548,165,38},{717,548,165,38},{919,548,165,38}};
    protected User user = User.getUser();
    protected String[] ims = {"01","02","03","04","05","06","07","08","09","10"};
    private ItemsTela it = new ItemsTela();
    
    public Store(){
        
    }
    
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
                case 1: StoreCM scm = new StoreCM(); scm.definirTelaVoltar(5); scm.intro(); scm.show(); break;
                case 2: StoreJDV sjdv = new StoreJDV(); sjdv.definirTelaVoltar(5); sjdv.intro(); sjdv.show(); break;
                case 3: StoreWP swp = new StoreWP(); swp.definirTelaVoltar(5); swp.intro(); swp.show(); break;
                default: break;
            }
        }
    }
    private Btn btnsComprado[][] = new Btn[3][10];
    private Btn btnsUso[][] = new Btn[3][10];
    public void addBtnBasic(Pn pn, int tipo){
        int backPos[] = {0,0,1200,700};
        for(int i = 0; i<10; i++){
            if(store.get(tipo).get(i).equals("1")){
                btnsComprado[tipo][i] = new Btn(im.addImagem("comprado_store"), posBtnsComprado[i], new EventComprar(i, tipo));
            }else{
                btnsComprado[tipo][i] = new Btn(im.addImagem("valor_btn_cm_store"), posBtnsComprado[i], new EventComprar(i, tipo));
            }
            if(emUso.get(tipo).get(i).equals("1")){
                btnsUso[tipo][i] = new Btn(im.addImagem("btn_uso_store"), posBtnsUso[i], new EventUso(i, tipo));
            }else{
                btnsUso[tipo][i] = new Btn(im.addImagem("sem_uso_btn_cm_store"), posBtnsUso[i], new EventUso(i, tipo));
            }
            pn.add(btnsComprado[tipo][i]);
            pn.add(btnsUso[tipo][i]);
        }
        pn.add(new Lb(im.addImagem("back_store"), backPos));
    }
    
    private ArrayList<ArrayList<String>> store = new ArrayList<>();
    private ArrayList<ArrayList<String>> emUso = new ArrayList<>();
    public ArrayList<ArrayList<String>> getStore() {
        return store;
    }
    public void setStore(ArrayList<ArrayList<String>> store) {
        this.store = store;
    }
    public ArrayList<ArrayList<String>> getEmUso() {
        return emUso;
    }
    public void setEmUso(ArrayList<ArrayList<String>> emUso) {
        this.emUso = emUso;
    }
    
    public class EventComprar implements ActionListener{
        private int btn; private int tipo;
        public EventComprar(int btn, int tipo){
            this.btn = btn; this.tipo = tipo;
        }
        @Override
        public void actionPerformed(ActionEvent ae) {
            if(store.get(tipo).get(btn).equals("0")&&user.getMoedas()-1000>=0){
                store.get(tipo).set(btn, "1");
                user.setMoedas(-1000);
                btnsComprado[tipo][btn].setIcon(im.addImagem("comprado_store"));
                Conta c = new Conta(user); c.gravar(); User.setUser(user);
            }else if(store.get(tipo).get(btn).equals("1")){
                System.out.println("Item já foi comprado");
            }else{
                System.out.println("Dinheiro insuficiente");
            }
        }
    }
    protected int botao = 11;
    protected boolean adItems = false;
    public class EventUso implements ActionListener{
        public int btn; private int tipo;
        public EventUso(int btn, int tipo){
            this.btn = btn; this.tipo = tipo;
        }
        @Override
        public void actionPerformed(ActionEvent ae) {
            //System.out.println(emUso.get(tipo).get(btn));
            if(emUso.get(tipo).get(btn).equals("0")&&store.get(tipo).get(btn).equals("1")){
                btnsUso[tipo][emUso.get(tipo).indexOf("1")].setIcon(im.addImagem("sem_uso_btn_cm_store"));
                emUso.get(tipo).set(emUso.get(tipo).indexOf("1"), "0");
                emUso.get(tipo).set(btn, "1");
                System.out.println(emUso.toString());
                btnsUso[tipo][btn].setIcon(im.addImagem("btn_uso_store"));
                botao = btn;
            }
        }
    }
    
}
