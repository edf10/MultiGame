package componentes;
import java.awt.Color;
import java.awt.Component;
import java.awt.LayoutManager;
import javax.swing.JPanel;
public class Pn extends JPanel{
    public Pn(){
        
    }
    
    public Pn(int pos[], Component cp[]){
        setLayout(null);
        setBounds(pos[0], pos[1], pos[2], pos[3]);
        add(cp);
    }
    public Pn(int pos[], Component cp[], Color c){
        setLayout(null);
        setBackground(c);
        setBounds(pos[0], pos[1], pos[2], pos[3]);
        add(cp);
    }
    public void add(Component cp[]){
        for(Component c : cp){
            this.add(c);
        }
    }
    public Pn(int pos[], LayoutManager lm){
        setLayout(lm);
        setBounds(pos[0], pos[1], pos[2], pos[3]);
    }
}