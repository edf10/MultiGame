package componentes;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import javax.swing.border.Border;
public class Btn extends JButton{
    
    public void configBase(){
        setLayout(null);
    }
    
    public Btn(ImageIcon ims[], int pos[], ActionListener ac){
        setLayout(null);
        setIcon(ims[0]);
        setContentAreaFilled(false);
        setBorder(null);
        setBounds(pos[0], pos[1], pos[2], pos[3]);
        addActionListener(ac);
        setRolloverIcon(ims[1]);
        if(ims.length<3){setPressedIcon(ims[1]);}else{setPressedIcon(ims[2]);}
    }
    
    public Btn(ImageIcon im, int pos[], ActionListener ac){
        setLayout(null);
        setIcon(im);
        setBorder(null);
        setBounds(pos[0], pos[1], pos[2], pos[3]);
        setContentAreaFilled(false);
        addActionListener(ac);
    }
    
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
    public Btn(String s, Font f, Color bc, Color fg, int pos[], Border b, boolean area, boolean focus, ActionListener ac){
        setText(s);
        setFont(f);
        setBackground(bc);
        setBounds(pos[0], pos[1], pos[2], pos[3]);
        setBorder(b);
        setContentAreaFilled(area);
        setFocusPainted(focus);
        addActionListener(ac);
        setForeground(fg);
    }
    public Btn(){
        setLayout(null);
        setHorizontalAlignment((int)CENTER_ALIGNMENT);
        setFocusPainted(false);
    }
}
