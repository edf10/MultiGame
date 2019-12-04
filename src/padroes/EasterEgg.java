package padroes;
import componentes.Frame;
import componentes.Lb;
import java.awt.Color;
import java.awt.Font;
public class EasterEgg extends Frame{
    public EasterEgg(){
        setSize(320, 240);
        setLocationRelativeTo(null);
    }
    
    private Lb lbCont;
    public void addEasterCM(){
        Fonts fs = new Fonts();
        Font f = fs.addNewFont("font_06", 20);
        int backPos[] = {0,0,320,240}; int contPos[] = {14,10,28,19};
        lbCont = new Lb("00",f,contPos, Color.white);
        add(lbCont);
        add(new Lb(im.addGif("aleatorio_gif_cm"), backPos));
        Apagar ap = new Apagar(); ap.start();
    }
    
    public class Apagar extends Thread{
        @Override
        public void run(){
            int s = 0;
            while(true){
                try{Thread.sleep(1000);}catch(Exception e){}
                s++;
                lbCont.setText("0"+s);
                if(s==9){
                    dispose();
                }
            }
        }
    }
    
}
