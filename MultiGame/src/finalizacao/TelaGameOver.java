package finalizacao;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class TelaGameOver extends JFrame{
    
    ImageIcon imFundo = new ImageIcon(getClass().getResource("gameover.gif"));
    JLabel lbFundo = new JLabel(imFundo);
    ImageIcon imSair = new ImageIcon(getClass().getResource(""));
    JButton btnSair = new JButton();
    
    public TelaGameOver(){
        setSize(380, 248);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setUndecorated(true);
        setOpacity(0.8f);
        
        lbFundo.setLayout(null);
        lbFundo.setBounds(-10, -50, 400, 300);
        
        add(lbFundo);
        
        setVisible(true);
    }
    
}
