package padroes;

import componentes.Btn;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;

public class ItemsTela {
    private final ImageIcon imClose = new ImageIcon(getClass().getResource("imagens/btn_close.png"));
    public Btn btnClose(){
        int closePos[] = {1161,15,19,19};
        return new Btn(imClose, closePos, new EventClose());
    }
    private class EventClose implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            System.exit(0);
        }
    }
    
    private final ImageIcon imSom = new ImageIcon(getClass().getResource("imagens/btn_som.png"));
    private final ImageIcon imMute = new ImageIcon(getClass().getResource("imagens/btn_mute.png"));
    private Btn som;
    public Btn btnSom(){
        int somPos[] = {20,20,48,35};
        som = new Btn(imSom, somPos, new EventSom());
        return som;
    }
    private int vez = 1;
    public class EventSom implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            if(vez==1){som.setIcon(imMute);vez = 2;}else{som.setIcon(imSom);vez = 1;}
        }
    }
}
