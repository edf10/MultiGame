package componentes;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.Border;
public class Txt extends JTextField{
    public Txt(int pos[], Font f, Color c, Border b){
        setLayout(null);
        setBounds(pos[0], pos[1], pos[2], pos[3]);
        setFont(f);
        setForeground(c);
        setBorder(b);
        setHorizontalAlignment((int)CENTER_ALIGNMENT);
    }
}
