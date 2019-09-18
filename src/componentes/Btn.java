package componentes;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import javax.swing.border.Border;
public class Btn extends JButton{
    public Btn(ImageIcon im, Font f, Color c, int pos[], Border b, boolean area, ActionListener ac){
        setLayout(null);
        setIcon(im);
        setBorder(b);
        setBounds(pos[0], pos[1], pos[2], pos[3]);
        setContentAreaFilled(area);
        addActionListener(ac);
    }
    public Btn(ImageIcon im, int pos[], Border b, boolean focus, ActionListener ac){
        setLayout(null);
        setIcon(im);
        setBorder(b);
        setBounds(pos[0], pos[1], pos[2], pos[3]);
        setContentAreaFilled(focus);
        addActionListener(ac);
    }
    public Btn(String s, Font f, Color c, int pos[], Border b, boolean area, boolean focus, ActionListener ac){
        setText(s);
        setFont(f);
        setBackground(c);
        setBounds(pos[0], pos[1], pos[2], pos[3]);
        setBorder(b);
        setContentAreaFilled(area);
        setFocusPainted(focus);
        addActionListener(ac);
        setForeground(Color.black);
    }
    public Btn(){
        setLayout(null);
        setHorizontalAlignment((int)CENTER_ALIGNMENT);
        setFocusPainted(false);
        setBackground(Color.darkGray);
    }
}
