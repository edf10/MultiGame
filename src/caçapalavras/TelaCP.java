package caçapalavras;
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
import javax.swing.JOptionPane;
public class TelaCP extends Frame{
    private boolean[][] mWords;
    private int nivel;
    public TelaCP(int n){
        p = new Palavras(n);
        nivel = n;
        x = y = p.getX();
        mWords = new boolean[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                mWords[i][j] = false;
            }
        }
        CP();
        cont.start();
        setVisible(true);
    }
    private int x; private int y;
    private Palavras p;
    private Pn pnWords;
    private Pn pnCont;
    private Letra[][] letras;
    private String wordsLetras[][];
    private Contador cont = new Contador();
    public void CP(){
        GridLayout campo = new GridLayout(x,y);
        int pnWordsP[] = {0,100,784,550};
        pnWords = new Pn(pnWordsP, campo);
        letras = new Letra[x][y];
        wordsLetras = p.getM2();
        for(int i = 0; i<x ; i++){
            for(int j = 0; j<y ; j++){
                if(wordsLetras[i][j]!=null){
                    letras[i][j] = new Letra(p.getM(i, j),i,j,true);
                }else{
                    letras[i][j] = new Letra(p.getM(i, j),i,j,false);
                }
                
                pnWords.add(letras[i][j]);
            }
        }
        add(pnWords);
        
        Font f = new Font("Arial", Font.PLAIN, 60);
        int pnContP[] = {0,0,800,100}; int lbminP[] = {200,10,100,80}; 
        int lbpontos[] = {290,10,100,80}; int lbseg[] = {380,10,100,80};
        
        Component cp[] = {
            lbminutos = new Lb(""+minutos, f, lbminP, Color.white),
            new Lb(":", f, lbpontos, Color.white),
            lbsegundos = new Lb(""+segundos, f, lbseg, Color.white)
        };
        pnCont = new Pn(pnContP, cp,Color.black);
        add(pnCont);
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
            JOptionPane.showMessageDialog(null, "You Win: M-"+minutos+" S-"+segundos);
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
        public Letra(String l, int x, int y, boolean conf){
            setText(l);
            this.caracterWord = conf;
            this.x = x; this.y = y;
            setBackground(Color.black);
            setForeground(Color.white);
            setFont(new Font("Arial", Font.PLAIN, 9));
            addActionListener(new Evento());
        }
        
        public class Evento implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent ae) {
                setBackground(Color.blue);
                mWords[x][y] = (caracterWord);
                ganhar();
            }
        }
    }
    
    private Lb lbminutos;
    private Lb lbsegundos;
    private int segundos = 0;
    private int minutos = 0;
    
    public class Contador extends Thread{
        @Override
        public void run(){
            while(true){
                try{Thread.sleep(1000);}catch(Exception e){};
                segundos++;
                lbsegundos.setText(""+segundos);
                if(segundos==59){
                    segundos = 0;
                    minutos++;
                    lbminutos.setText(""+minutos);
                }
            }
        }
    }
    
}
