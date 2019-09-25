package componentes;
import javax.swing.JFrame;
public class Frame extends JFrame{
    public Frame(int x, int y){
        setSize(x, y);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
}
