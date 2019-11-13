package componentes;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
public class Btn extends JButton{
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
    public Btn(){
        setLayout(null);
        setHorizontalAlignment((int)CENTER_ALIGNMENT);
        setFocusPainted(false);
    }
}
