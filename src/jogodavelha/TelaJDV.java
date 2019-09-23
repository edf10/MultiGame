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
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import componentes.Frame;

public class TelaJDV extends Frame{
    public TelaJDV(int ass, String jog1, String jog2){
        super(700,700);
        this.jog1 = jog1;
        this.jog2 = jog2;
        this.ass = ass;
        redeclaracoes();
        getContentPane().setBackground(Color.darkGray);
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
    public int getAss(){return ass;}
    private Button vet[][];
    private final Jogo j = new Jogo(this);
    
    private Pn pnCC;
    private Pn pnVez;
    private Lb lbJog;
    
    public void redeclaracoes(){
        j.jdvClassic();
        x = j.getX();
        y = j.getY();
        j.setJog1(jog1);
        j.setJog2(jog2);
        j.defIc(true, false);
        vez = j.sortVez();
    }
    
    private void JDV(){
        int lbVezP[] = {0,10,150,140};
        Font f = new Font("Arial", Font.PLAIN, 50);
        String s = (vez==1)? jog1:jog2;
        int lbJogP[] = {110,10,250,140};
        lbJog = new Lb(s, f, lbJogP, Color.yellow);
        Component cp[] = {
            new Lb("Vez:", f, lbVezP, Color.yellow),
            lbJog
        };
        int pnVezP[] = {100,10,500,140};
        pnVez = new Pn(pnVezP, cp, Color.darkGray);
        
        GridLayout mz = new GridLayout(x, y);
        int pnCCP[] = {100,162,500,500};
        pnCC = new Pn(pnCCP, mz);
        
        vet = new Button[x][y];
        for(int i = 0; i<x; i++){
            for(int j = 0; j<y ; j++){
                vet[i][j] = new Button(i, j);
            }
        }
        for(int i = 0; i<x; i++){
            for(int j = 0; j<y ; j++){
                pnCC.add(vet[i][j]);
            }
        }
        add(pnVez);
        add(pnCC);
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
        private final ImageIcon imX = new ImageIcon(getClass().getResource("x.png"));
        private final ImageIcon imO = new ImageIcon(getClass().getResource("o.png"));
        private final int x;
        private final int y;
        public Button(int x, int y){
            super();
            this.x = x;
            this.y = y;
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
                    Perguntas p = new Perguntas(ass, x, y);
                }
            }
        }
    }
    private boolean answer = false;
    private boolean clickBtn = false;
    private class Perguntas extends Frame{
        private final ReadQuestions rq = new ReadQuestions();
        private final Random escPer = new Random();
        private final contarTempo ct = new contarTempo();
        private int xb; private int yb;
        private int question = 0;
        public Perguntas(int ass, int xb, int yb){
            super(400,300);
            this.xb = xb;
            this.yb = yb;
            if(ass==1){
                tabuada();
            }
            
            tela();
            setVisible(true);
        }
        
        public void tabuada(){
            rq.readTabuada();
            while(question==0){
                question = escPer.nextInt(rq.getLengthHashTabuada());
            }
            quest = rq.getQuestionTabuada(question);
            res = rq.getAnswerTabuada(question);
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
            Component cp[] = {
                lbsegundos,
            };
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
