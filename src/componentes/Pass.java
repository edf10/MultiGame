package componentes;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.border.Border;
public class Pass extends JPasswordField{
    public Pass(int pos[], Font f, Color c, Border b){
        setFont(f);
        setForeground(c);
        setBorder(b);
        setBounds(pos[0], pos[1], pos[2], pos[3]);
    }
}
