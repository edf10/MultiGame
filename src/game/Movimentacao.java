package game;
import componentes.Lb;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
public class Movimentacao{
    private final ImageIcon walkRight1 = new ImageIcon(getClass().getResource("death_right_01.png"));
    private final ImageIcon walkRight2 = new ImageIcon(getClass().getResource("death_right_02.png"));
    private final ImageIcon walkRight3 = new ImageIcon(getClass().getResource("death_right_03.png"));
    private final ImageIcon walkRight4 = new ImageIcon(getClass().getResource("death_right_04.png"));
    
    private Lb lbdeath;
    
    private int posX = 100;
    private int posY = 300;
    
    public Movimentacao(){
    }
    
    
    
}
