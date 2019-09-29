package game;
import componentes.Frame;
import componentes.Lb;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
public class Movimentacao extends Frame{
    private final ImageIcon walkRight1 = new ImageIcon(getClass().getResource("imagens/00/death_right_01.png"));
    private final ImageIcon walkRight2 = new ImageIcon(getClass().getResource("imagens/00/death_right_02.png"));
    private final ImageIcon walkRight3 = new ImageIcon(getClass().getResource("imagens/00/death_right_03.png"));
    private final ImageIcon walkRight4 = new ImageIcon(getClass().getResource("imagens/00/death_right_04.png"));
    
    private Lb lbdeath;
    private JLabel lbfundo;
    
    private int posX = 84;
    private int posY = 300;
    private int imTroca = 0;
    private Dimension d = new Dimension(800,600);
    
    public Movimentacao(){
        super(800,600);
        lbfundo = new JLabel();
        lbfundo.setBounds(0, 0, 800, 600);
        lbfundo.setOpaque(true);
        lbfundo.setBackground(Color.yellow);
        int pDeath[] = {posX,posY,32,48};
        lbdeath = new Lb(walkRight1, pDeath);
        
        addMovimento();
        add(lbdeath);
        add(lbfundo);
        setVisible(true);
    }
    
    public void addMovimento(){
        addKeyListener(new KeyListener(){
            @Override
            public void keyTyped(KeyEvent e) {
                
            }
            @Override
            public void keyPressed(KeyEvent e) {
                //Up=38;Back=40;Left=37;Right=39
                switch(imTroca){
                    case 0:lbdeath.setIcon(walkRight1);imTroca = 1;break;
                    case 1:lbdeath.setIcon(walkRight2);imTroca = 2;break;
                    case 2:lbdeath.setIcon(walkRight3);imTroca = 3;break;
                    case 3:lbdeath.setIcon(walkRight4);imTroca = 0;break;
                    default:break;
                }
                //System.out.println(d.height+" "+d.width);
                System.out.println(posX+" "+posY);
                if(posX-4>80||posX+4<720){
                    switch(e.getKeyCode()){
                        case 38:posY-=4;break;
                        case 40:posY+=4;break;
                        case 37:posX-=4;break;
                        case 39:posX+=4;break;
                        default:break;
                    }
                }
                lbdeath.setBounds(posX, posY, 32, 48);
                System.out.println(posX+" "+posY);
                System.out.println(e.getKeyCode());
            }
            @Override
            public void keyReleased(KeyEvent e) {
                lbdeath.setIcon(walkRight1);
            }
        });
    }
}
