package jogodavelha;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import componentes.Btn;
import componentes.Lb;
import componentes.Pn;
import componentes.Txt;
import java.awt.Component;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import componentes.Frame;
import padroes.Fonts;
import padroes.ItemsTela;

public class TelaJDV extends Frame{
    public TelaJDV(int ass){
        j.jdvClassic();
        x = j.getX();
        y = j.getY();
        jog1 = "User";
        jog2 = "User";
        j.setJog1(jog1);
        j.setJog2(jog2);
        j.defIc(true, false);
        vez = j.sortVez();
        this.ass = ass;
        JDV();
        
        setVisible(true);
    }
    //Tamanho da matriz
    private int x;
    private int y;
    private int ass;
    private String jog1;
    private String jog2;
    public String getJog1() {return jog1;}
    public String getJog2() {return jog2;}
    private Button vet[][];
    private final Jogo j = new Jogo();
    private ItemsTela it = new ItemsTela();
    
    private Pn pnCC;
    private Lb lbJog;
    private Pn pnGame;
    
    private void JDV(){
        Fonts fs = new Fonts();
        Font f = fs.addNewFont("DIMITRI_", 80);
        String s = (vez==1)? jog1:jog2;
        int lbJogP[] = {238,25,700,140};
        lbJog = new Lb(s, f, lbJogP, Color.white);
        
        GridLayout mz = new GridLayout(x, y);
        int pnCCP[] = {248,166,703,534};
        pnCC = new Pn(pnCCP, mz);
        
        vet = new Button[x][y];
        for(int i = 0; i<x; i++){
            for(int j = 0; j<y ; j++){
                vet[i][j] = new Button(i, j);
                pnCC.add(vet[i][j]);
            }
        }
        int backPos[] = {0,0,1200,700};
        int backTabPos[] = {240,158,719,541};
        int backBackPos[] = {228,147,750,561};
        Component cp[] = {
            pnCC,lbJog,
            it.btnClose(),it.returnGames(),it.btnSomOutro(),
            new Lb(im.addImagem("back_tab_jdv"), backTabPos),
            new Lb(im.addImagem("back_back_jdv"), backBackPos),
            new Lb(im.addImagem("back_game_jdv"), backPos)
        };
        pnGame = new Pn(backPos, cp);
        add(pnGame);
    }
    public void vez(){
        vez = (vez==1)? 2:1;
        if(vez==1){
            lbJog.setText(jog1);
        }else if(vez==2){
            lbJog.setText(jog2);
        }
    }
    private int vez; //Determina de qual jogador é a vez.
    private class Button extends Btn{
        private final ImageIcon imX = new ImageIcon(getClass().getResource("imagens/x.png"));
        private final ImageIcon imO = new ImageIcon(getClass().getResource("imagens/o.png"));
        private final int x;
        private final int y;
        public Button(int x, int y){
            super();
            this.x = x;
            this.y = y;
            setIcon(im.addImagem("btn_jdv_game"));
            setBackground(Color.gray);
            addActionListener(new Troca());
        }
        public void altBtn(){
            if(!press&&!answer){
                if(vez==1){
                    setIcon(imX);
                }else if(vez==2){
                    setIcon(imO);
                }
                press = true;
                j.addPress(x, y, vez);
                j.ganhar();
            }
        }
        private boolean press = false;
        
        private class Troca implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(!press&&!clickBtn){
                    answer = true;
                    clickBtn = true;
                    Perguntas p = new Perguntas(x, y);
                }
            }
        }
    }
    private boolean answer = false;
    private boolean clickBtn = false;
    private class Perguntas extends Frame{
        private final contarTempo ct = new contarTempo();
        private int xb; private int yb;
        public Perguntas(int xb, int yb){
            this.xb = xb;
            this.yb = yb;
            question();
            tela();
            setVisible(true);
        }
        
        public void question(){
            int nums[] = j.addQuestion();
            if(ass==1){
                quest = nums[0]+" + "+nums[1]+" = ";
                res = j.addAnswer(nums[0],nums[1], 1)+"";
            }else if(ass==2){
                nums = j.addDivision();
                quest = nums[0]+" / "+nums[1]+" = ";
                res = j.addAnswer(nums[0],nums[1], 2)+"";
            }else if(ass==3){
                quest = nums[0]+" - "+nums[1]+" = ";
                res = j.addAnswer(nums[0],nums[1], 3)+"";
            }else if(ass==4){
                quest = nums[0]+" x "+nums[1]+" = ";
                res = j.addAnswer(nums[0],nums[1], 4)+"";
            }
        }
        
        private Pn pnTempo;
        private Txt txtRes;
        private String quest;
        private String res;
        private final Enter e = new Enter();
        public void tela(){
            int lbper[] = {50,120,200,100}; int txtResP[] = {250,145,60,50};
            int lbseg[] = {145,0,100,100};
            Font ms = new Font("Arial", Font.PLAIN, 70);
            lbsegundos = new Lb("0", ms, lbseg, Color.blue, null);
            Font f = new Font("Arial", Font.PLAIN, 40);
            Border b = BorderFactory.createLineBorder(Color.black, 3);
            txtRes = new Txt(txtResP, f, Color.black, b);
            txtRes.addActionListener(e);
            Component cp[] = {lbsegundos};
            int pnTemP[] = {0,0,400,100};
            pnTempo = new Pn(pnTemP, cp, Color.DARK_GRAY);
            add(pnTempo);
            add(new Lb(quest, f, lbper, Color.black, null));
            add(txtRes);
            ct.start();
        }
        private Lb lbsegundos;
        public class contarTempo extends Thread{
            @Override
            public void run(){
                int s = 0;
                while(true){
                    try{Thread.sleep(1000);}catch(Exception e){};
                    s++;
                    lbsegundos.setText(""+s);
                    if(s==5){
                        Perguntas.this.dispose();
                        answer = false; vez();
                        clickBtn = false;
                        this.stop();
                    }
                }
            }
        }
        private class Enter implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent ae) {
                clickBtn = false;
                ct.stop();
                Perguntas.this.dispose();
                answer = false;
                if(txtRes.getText().equals(res)){
                    vet[xb][yb].altBtn();
                }
                vez();
            }
        }
    }
    
}
