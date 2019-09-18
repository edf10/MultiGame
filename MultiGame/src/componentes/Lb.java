package componentes;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.border.Border;
public class Lb extends JLabel{
    public Lb(String t, Font f, int pos[], Color c, Border b){
        setText(t);
        setLayout(null);
        setFont(f);
        setHorizontalAlignment((int)CENTER_ALIGNMENT);
        setBounds(pos[0], pos[1], pos[2], pos[3]);
        setForeground(c);
        setBorder(b);
    }
    public Lb(ImageIcon im, int pos[]){
        setIcon(im);
        setBounds(pos[0], pos[1], pos[2], pos[3]);
        setHorizontalAlignment((int)CENTER_ALIGNMENT);
    }
}
