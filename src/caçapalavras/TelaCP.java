package caçapalavras;
import componentes.Btn;
import componentes.Frame;
import componentes.Pn;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class TelaCP extends Frame{
    
    public TelaCP(){
        super(800,600);
        x = y = 8;
        CP();
        setVisible(true);
    }
    private int x; private int y;
    private Palavras p = new Palavras(1);
    private Pn pnWords;
    private Letra[][] letras;
    public void CP(){
        GridLayout campo = new GridLayout(8,8);
        int pnWordsP[] = {0,0,784,580};
        pnWords = new Pn(pnWordsP, campo);
        letras = new Letra[8][8];
        for(int i = 0; i<8 ; i++){
            for(int j = 0; j<8 ; j++){
                letras[i][j] = new Letra(p.getM(i, j),i,j);
                pnWords.add(letras[i][j]);
            }
        }
        
        add(pnWords);
    }
    
    public class Letra extends Btn{
        private int x, y;
        private String l;
        public Letra(String l, int x, int y){
            this.l = l;
            setText(""+l);
            this.x = x; this.y = y;
            setBackground(Color.black);
            setForeground(Color.white);
            addActionListener(new Evento());
        }
        
        public class Evento implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent ae) {
                setBackground(Color.blue);
            }
        }
        
    }
    
}
