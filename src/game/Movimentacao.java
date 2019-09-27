package game;
import componentes.Frame;
import componentes.Lb;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
public class Movimentacao extends Frame{
    private final ImageIcon walkRight1 = new ImageIcon(getClass().getResource("imagens/00/death_right_01.png"));
    private final ImageIcon walkRight2 = new ImageIcon(getClass().getResource("imagens/00/death_right_02.png"));
    private final ImageIcon walkRight3 = new ImageIcon(getClass().getResource("imagens/00/death_right_03.png"));
    private final ImageIcon walkRight4 = new ImageIcon(getClass().getResource("imagens/00/death_right_04.png"));
    
    private Lb lbdeath;
    
    private int posX = 100;
    private int posY = 300;
    
    public Movimentacao(){
        super(800,600);
        addMovimento();
        setVisible(true);
    }
    
    public void addMovimento(){
        addKeyListener(new KeyListener(){
            @Override
            public void keyTyped(KeyEvent e) {
                
            }
            @Override
            public void keyPressed(KeyEvent e) {
                System.out.println("OK");
            }
            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
    }
    
}
