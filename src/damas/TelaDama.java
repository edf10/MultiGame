package damas;
import componentes.Frame;
import componentes.Lb;
import java.awt.Color;
import java.awt.GridLayout;
public class TelaDama extends Frame{
    public TelaDama(){
        super(800,600);
        tabuleiro();
        setVisible(true);
    }
    
    private Lb tab[][] = new Lb[8][8];
    
    public void tabuleiro(){
        GridLayout m = new GridLayout(8,8);
        setLayout(m);
        for(int i = 0; i<8; i++){
            for(int j = 0; j<8; j++){
                if(j%2==0){
                    tab[i][j] = new Label(1);
                }else{
                    tab[i][j] = new Label(2);
                }
                add(tab[i][j]);
            }
        }
    }
    
    private class Label extends Lb{
        private int pw;
        public Label(int pw){
            this.pw = pw;
            if(pw==1){
                setBackground(Color.white);
            }else{
                setBackground(Color.black);
            }
        }
        
    }
    
}
