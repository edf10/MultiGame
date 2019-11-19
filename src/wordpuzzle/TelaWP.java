package wordpuzzle;
import componentes.Btn;
import componentes.Frame;
import componentes.Lb;
import componentes.Pn;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import padroes.Fonts;
import padroes.ItemsTela;
import user.Conta;
import user.User;
public class TelaWP extends Frame{
    private boolean[][] mWords;
    private ItemsTela it = new ItemsTela();
    private int nivel;
    public void setNivel(int nivel) {this.nivel = nivel;}
    public void configuracoes(){
        p = new Palavras(nivel);
        x = y = p.getX();
        mWords = new boolean[x][y];
        words = p.getPalavras();
        it.setTelaAntIntro(3); 
        CP();
        cont.start();
    }
    private int x; private int y;
    private Palavras p;
    private Pn pnWords;
    private Letra[][] letras;
    private String wordsLetras[][];
    private Contador cont = new Contador();
    private User user = new User();
    public void setUser(User user) {this.user = user;}
    public void CP(){
        GridLayout campo = new GridLayout(x,y);
        int pnWordsP[] = {145,130,908,573};
        pnWords = new Pn(pnWordsP, campo);
        letras = new Letra[x][y];
        wordsLetras = p.getM2();
        for(int i = 0; i<x ; i++){
            for(int j = 0; j<y ; j++){
                if(wordsLetras[i][j]!=null){letras[i][j] = new Letra(p.getM(i, j),i,j,true);
                }else{letras[i][j] = new Letra(p.getM(i, j),i,j,false);}
                pnWords.add(letras[i][j]);
            }
        }
        pnWords.setBackground(Color.black);
        add(pnWords); int lbBlackPos[] = {135,125,918,578};
        add(new Lb(Color.black, lbBlackPos));
        int lbBackCampoPos[] = {128,114,944,639};
        add(new Lb(im.addImagem("pn_back_campo_wp"), lbBackCampoPos));
        Fonts fs = new Fonts();
        Font f = fs.addNewFont("DS-DIGIT", 80);
        int lbminP[] = {373,15,100,100}; int lbpontos[] = {555,13,100,100}; int lbseg[] = {727,15,100,100};
        lbminutos = new Lb("00", f, lbminP, Color.white); lbsegundos = new Lb("00", f, lbseg, Color.white);
        lbdoispontos = new Lb(":", f, lbpontos, Color.white);
        getContentPane().setBackground(new Color(54,54,58));
        add(lbminutos);
        add(lbdoispontos);
        add(lbsegundos);
        barraWords();
        add(it.btnClose()); add(it.returnGames(this)); add(it.btnSomOutro());
    }
    
    private Lb lbWord;
    private int palavraDaVez = 0;
    private ArrayList<Palavra> words = new ArrayList<>();
    private Pn pnW;
    public void barraWords(){
        int btnLeftPos[] = {0,0,21,37}; int btnRigthPos[] = {233,0,21,37};
        int lbWordPos[] = {0,0,254,37}; int pnPos[] = {870,45,254,37};
        Font f = new Font("Arial", Font.PLAIN, 25); 
        ImageIcon btn_arrow_left[] = {im.addImagem("arrow_left_wp"),im.addImagem("arrow_left_wp_t")};
        ImageIcon btn_arrow_rigth[] = {im.addImagem("arrow_rigth_wp"),im.addImagem("arrow_rigth_wp_t")};
        if(words.size()>0){lbWord = new Lb(words.get(0).getPalavra().toUpperCase(), f, lbWordPos, Color.white);}
        else{lbWord = new Lb("--END--".toUpperCase(), f, lbWordPos, Color.white);}
        Component cp[] = {
            new Btn(btn_arrow_left, btnLeftPos, new EventSetas(2)),
            new Btn(btn_arrow_rigth, btnRigthPos, new EventSetas(1)),
            lbWord
        };
        pnW = new Pn(pnPos, cp);
        pnW.setBackground(null);
        add(pnW);
    }
    
    public class EventSetas implements ActionListener{
        private int direcao;
        public EventSetas(int n){direcao = n;}
        @Override
        public void actionPerformed(ActionEvent ae) {
            if(direcao==1&&palavraDaVez+1<p.getPalavras().size()){//rigth
                palavraDaVez++;lbWord.setText(words.get(palavraDaVez).getPalavra().toUpperCase());
            }else if(direcao==2&&palavraDaVez-1>=0){//left
                palavraDaVez--;lbWord.setText(words.get(palavraDaVez).getPalavra().toUpperCase());
            }
        }
    }
    
    public void ganhar(){
        int cont = 0;
        for(int i = 0; i<x; i++){
            for(int j = 0; j<y; j++){
                if(mWords[i][j]){cont++;}
            }
        }
        if(cont==quantCWords()){
            this.cont.stop();
            int tempo = Integer.parseInt(lbminutos.getText())*60+Integer.parseInt(lbsegundos.getText());int wordQuant = 0;
            String nil = "";if(nivel==1){nil = "EASY"; wordQuant = 12;}else if(nivel==2){nil = "MEDIUM"; wordQuant = 14;}else{nil = "HARD"; wordQuant = 16;}
            ScoreWP sc = new ScoreWP(tempo, wordQuant);
            user.addScoreWP(sc.scoreRankingWP(), nil);
            user.setMoedas(sc.scoreMoedasWP());
            System.out.println(sc.scoreRankingWP());
            Conta c = new Conta(user);
            c.gravar();
            JOptionPane.showMessageDialog(null, "You Win: M-"+lbminutos.getText()+" S-"+lbsegundos.getText());
        }
    }
    
    private ArrayList<Boolean> wordsEnc = new ArrayList<Boolean>();
    public void wordsEncontradas(){
        wordsEnc.clear();
        int cont = 0;
        ArrayList<Palavra> palavras = p.getPalavras();
        for(int i = 0; i<palavras.size(); i++){//Array de words do wp
            ArrayList<int[]> pos = palavras.get(i).getPos();
            for(int j = 0; j<pos.size(); j++){//posições de cada palavras (suas letras)
                for(int k = 0; k<letras.length; k++){//Matriz letras
                    for(int h = 0; h<letras[k].length; h++){//Matriz letras
                        if(pos.get(j)[0]==k&&pos.get(j)[1]==h){
                            if(letras[k][h].isAcionado()){
                                cont++;
                            }
                        }
                    }
                }
            }
            if(cont==pos.size()){wordsEnc.add(true);words.remove(i);pnW.setVisible(false);barraWords();pnW.setVisible(true);
                for(int j = 0; j<pos.size(); j++){//posições de cada palavras (suas letras)
                    for(int k = 0; k<letras.length; k++){//Matriz letras
                        for(int h = 0; h<letras[k].length; h++){//Matriz letras
                            if(pos.get(j)[0]==k&&pos.get(j)[1]==h){
                                letras[k][h].setPermanente(true);
                            }
                        }
                    }
                }
            }else{wordsEnc.add(false);}
            cont = 0;
        }
    }
    public int quantCWords(){
        String[][] m2 = p.getM2();
        int quantCaracWords = 0;
        for(int i = 0; i<x; i++){
            for(int j = 0; j<y; j++){
                if(m2[i][j]!=null){
                    quantCaracWords++;
                }
            }
        }
        return quantCaracWords;
    }
    
    public class Letra extends Btn{
        private int x, y;
        private boolean caracterWord;
        private int troca = 1;
        private boolean acionado;
        private boolean permanente; //se for uma palavra não sai a marcação.
        private String l;
        public Letra(String l, int x, int y, boolean conf){
            super();
            this.l = l;
            setText(this.l);
            this.caracterWord = conf;
            this.x = x; this.y = y;
            setBackground(Color.black);
            setForeground(Color.white);
            setFont(new Font("Arial", Font.PLAIN, 18));
            addActionListener(new Evento());
            acionado = false; permanente = false;
        }
        public boolean isAcionado() {
            return acionado;
        }
        public void setPermanente(boolean permanente) {
            this.permanente = permanente;
        }
        public class Evento implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(troca==1){setBackground(Color.blue); troca = 2; caracterWord = true;}else if(permanente==false){setBackground(Color.black); troca = 1; caracterWord = false;}
                mWords[x][y] = (caracterWord); acionado = true;
                wordsEncontradas();
                ganhar();
            }
        }
    }
    
    private Lb lbminutos;
    private Lb lbsegundos;
    private Lb lbdoispontos;
    
    public class Contador extends Thread{
        @Override
        public void run(){
            int s = 0; int m = 0; int so = 0; int mo = 0;
            while(true){
                try{Thread.sleep(1000);}catch(Exception e){};
                s++;
                if(s==10){so++; s = 0;}
                if(so==6&&s==0){
                    so = 0;m++;
                    if(m==10){mo++; m = 0;}
                    lbminutos.setText(mo+""+m+"");
                    s = 0;
                    lbsegundos.setText(so+""+s+"");
                }else{lbsegundos.setText(so+""+s+"");}
                
            }
        }
    }
    
}
