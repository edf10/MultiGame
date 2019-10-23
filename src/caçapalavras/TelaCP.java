package caçapalavras;
import componentes.Btn;
import componentes.Frame;
import componentes.Pn;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class TelaCP extends Frame{
    private boolean[][] mWords;
    private int nivel;
    public TelaCP(int n){
        super(800,700);
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
        setVisible(true);
    }
    private int x; private int y;
    private Palavras p;
    private Pn pnWords;
    private Letra[][] letras;
    public void CP(){
        GridLayout campo = new GridLayout(x,y);
        int pnWordsP[] = {0,0,784,700};
        pnWords = new Pn(pnWordsP, campo);
        letras = new Letra[x][y];
        for(int i = 0; i<x ; i++){
            for(int j = 0; j<y ; j++){
                letras[i][j] = new Letra(p.getM(i, j),i,j);
                pnWords.add(letras[i][j]);
            }
        }
        add(pnWords);
    }
    
    public void ganhar(){
        int cont = 0;
        for(int i = 0; i<x; i++){
            for(int j = 0; j<y; j++){
                if(mWords[i][j]){cont++;}
            }
        }
        if(cont==quantCWords()){
            System.out.println("Ganhou");
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
        public Letra(String l, int x, int y){
            setText(l);
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
                mWords[x][y] = true;
                ganhar();
            }
        }
    }
    
}
