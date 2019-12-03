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
import padroes.Fonts;
import padroes.ItemsTela;
import padroes.WinOrGameOver;
import user.Conta;
import user.User;
public class TelaWP extends Frame{
    private ItemsTela it = new ItemsTela();
    private int nivel;
    public void setNivel(int nivel) {this.nivel = nivel;}
    public void configuracoes(){
        p = new Palavras(nivel);
        x = y = p.getX();
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
    private User user = User.getUser();
    public void setUser(User user) {this.user = user;}
    public void CP(){
        GridLayout campo = new GridLayout(x,y);
        int pnWordsP[] = {145,130,910,573};
        pnWords = new Pn(pnWordsP, campo);
        letras = new Letra[x][y];
        wordsLetras = p.getM2();
        for(int i = 0; i<x ; i++){
            for(int j = 0; j<y ; j++){
                if(wordsLetras[i][j]==null){
                    wordsLetras[i][j] = "0";
                }
            }
        }
        for(int i = 0; i<x ; i++){
            for(int j = 0; j<y ; j++){
                if(!"0".equals(wordsLetras[i][j])){letras[i][j] = new Letra(p.getM(i, j));
                }else{letras[i][j] = new Letra(p.getM(i, j));}
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
    private boolean win = true;
    public void ganhar(){
        int quantCaracWords = 0;
        for(int i = 0; i<x; i++){
            for(int j = 0; j<y; j++){
                if(!"0".equals(wordsLetras[i][j])){
                    quantCaracWords++;
                }
            }
        }
        int cont = 0;
        for(int i = 0; i<x; i++){
            for(int j = 0; j<y; j++){
                if(letras[i][j].isPermanente()==true){cont++;}
            }
        }
        if(cont==quantCaracWords){
            this.cont.stop();
            int tempo = Integer.parseInt(lbminutos.getText())*60+Integer.parseInt(lbsegundos.getText());int wordQuant = 0;
            if(nivel==1){wordQuant = 12;}else if(nivel==2){wordQuant = 14;}else{wordQuant = 16;}
            ScoreWP sc = new ScoreWP(tempo, wordQuant);
            sc.leitura(); sc.setNivel(x);sc.scoreRankingWP();
            user.setMoedas(sc.scoreMoedasWP());
            sc.gravar();
            Conta c = new Conta(user);
            c.gravar();
            if(win==true){win = false; WinOrGameOver w = new WinOrGameOver(this); w.setNivel(x); w.addWin(4); w.show();}
        }
    }
    
    private ArrayList<Boolean> wordsEnc = new ArrayList<Boolean>();
    public void wordsEncontradas(){
        boolean enc = false;
        wordsEnc.clear();
        int cont = 0;
        ArrayList<Palavra> palavras = p.getPalavras();
        for(int i = 0; i<palavras.size(); i++){//Array de words do wp
            ArrayList<int[]> pos = palavras.get(i).getPos();
            for(int j = 0; j<pos.size(); j++){//posições de cada palavras (suas letras)
                for(int k = 0; k<letras.length; k++){//Matriz letras
                    for(int h = 0; h<letras[k].length; h++){//Matriz letras
                        if(letras[pos.get(0)[0]][pos.get(0)[1]].isAcionado()&&letras[pos.get(pos.size()-1)[0]][pos.get(pos.size()-1)[1]].isAcionado()){
                            enc = true;
                        }
                        if(pos.get(j)[0]==k&&pos.get(j)[1]==h){
                            if(enc==true){
                                letras[k][h].acionar();
                            }
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
            cont = 0; enc = false;
        }
    }
    
    public class Letra extends Btn{
        private int troca = 1;
        private boolean acionado;
        private boolean permanente; //se for uma palavra não sai a marcação.
        private String l;
        public Letra(String l){
            super();
            this.l = l;
            setText(this.l);
            setBackground(Color.black);
            setForeground(Color.white);
            setFont(new Font("Arial", Font.PLAIN, 18));
            addActionListener(new Evento());
            acionado = false; permanente = false;
        }
        public boolean isAcionado() {
            return acionado;
        }
        public boolean isPermanente() {
            return permanente;
        }
        public void setPermanente(boolean permanente) {
            this.permanente = permanente;
        }
        public void acionar(){
            setBackground(Color.blue);
            acionado = true;
            permanente = true;
        }
        public class Evento implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(troca==1){setBackground(Color.blue); setForeground(Color.black); troca = 2;}else if(permanente==false){setBackground(Color.black); setForeground(Color.white); troca = 1;}
                acionado = true;
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
