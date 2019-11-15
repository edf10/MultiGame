package wordpuzzle;
import componentes.Btn;
import componentes.Frame;
import componentes.Lb;
import componentes.Pn;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import padroes.Fonts;
import padroes.ItemsTela;
public class TelaWP extends Frame{
    private boolean[][] mWords;
    private ItemsTela it = new ItemsTela();
    public TelaWP(int n){
        p = new Palavras(n);
        x = y = p.getX();
        mWords = new boolean[x][y];
        CP();
        cont.start();
        show();
    }
    private int x; private int y;
    private Palavras p;
    private Pn pnWords;
    private Letra[][] letras;
    private String wordsLetras[][];
    private Contador cont = new Contador();
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
        add(it.btnClose()); add(it.returnGames(this)); add(it.btnSomOutro());
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
            JOptionPane.showMessageDialog(null, "You Win: M-"+lbminutos.getText()+" S-"+lbsegundos.getText());
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
        public Letra(String l, int x, int y, boolean conf){
            super();
            setText(l);
            this.caracterWord = conf;
            this.x = x; this.y = y;
            setBackground(Color.black);
            setForeground(Color.white);
            setFont(new Font("Arial", Font.PLAIN, 18));
            addActionListener(new Evento());
        }
        public class Evento implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(troca==1){setBackground(Color.blue); troca = 2; caracterWord = true;}else{setBackground(Color.black); troca = 1; caracterWord = false;}
                mWords[x][y] = caracterWord;
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
