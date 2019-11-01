package componentes;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.border.Border;
public final class Lb extends JLabel{
    public void configBase(){
        setLayout(null);
        setHorizontalAlignment((int)CENTER_ALIGNMENT);
    }
    public Lb(String t, Font f, int pos[], Color c, Border b){
        configBase();setText(t);setFont(f);setForeground(c);setBorder(b);
        setBounds(pos[0], pos[1], pos[2], pos[3]);
    }
    public Lb(ImageIcon im, int pos[]){
        configBase();setIcon(im);
        setBounds(pos[0], pos[1], pos[2], pos[3]);
    }
    public Lb(Color c, int pos[]){
        configBase();setBackground(c);
        setBounds(pos[0], pos[1], pos[2], pos[3]);
    }
    public Lb(String t, Font f, int pos[], Color c){
        configBase();setText(t);setFont(f);setForeground(c);
        setBounds(pos[0], pos[1], pos[2], pos[3]);
    }
}
