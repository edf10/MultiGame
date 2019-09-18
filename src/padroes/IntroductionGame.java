package padroes;
import javax.swing.JFrame;
public abstract class IntroductionGame extends JFrame{
    public IntroductionGame(int x, int y){
        setSize(x, y);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
    }
    public abstract void niveis();
    public abstract void tutorial();
    public abstract void intro();
    
}
