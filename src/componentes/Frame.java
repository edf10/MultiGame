package componentes;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
public class Frame extends JFrame{
    private int x;
    private int y;
    public Frame(){
        setSize(1200,700);
        setLayout(null);
        setUndecorated(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
}
