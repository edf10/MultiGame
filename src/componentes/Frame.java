package componentes;
import imagens.Im;
import javax.swing.JFrame;
public class Frame extends JFrame{
    public Im im = new Im();
    public Frame(){
        setSize(1200,700);
        setLayout(null);
        setUndecorated(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
}
