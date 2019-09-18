package multigame;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Controle {
    //Labels
    
    //Buttons
    private JButton btnLeft;
    private JButton btnHomeGames;
    private JButton btnSom;
    private JButton btnPause;
    
    //ImageIcons
    private ImageIcon imLeft;
    private ImageIcon imHomeGames;
    private ImageIcon imSom;
    private ImageIcon imPause;
    
    public JButton setLeft(){
        imLeft = new ImageIcon(getClass().getResource(""));
        btnLeft = new JButton(imLeft);
        btnLeft.setBounds(0, 0, 100, 100);
        //btnLeft.setContentAreaFilled(false);
        btnLeft.setBackground(Color.white);
        btnLeft.setBorder(null);
        btnLeft.setFocusPainted(false);
        return btnLeft;
    }
    public void homeGames(){
        imHomeGames = new ImageIcon(getClass().getResource(""));
        btnHomeGames = new JButton(imHomeGames);
        btnHomeGames.setBounds(0, 0, 100, 100);
        btnHomeGames.setContentAreaFilled(false);
        btnHomeGames.setBorder(null);
        btnHomeGames.setFocusPainted(false);
    }
    public void som(){
        imSom = new ImageIcon(getClass().getResource(""));
        btnSom = new JButton(imSom);
        btnSom.setBounds(0, 0, 100, 100);
        btnSom.setContentAreaFilled(false);
        btnSom.setBorder(null);
        btnSom.setFocusPainted(false);
    }
    public void pause(){
        imPause = new ImageIcon(getClass().getResource(""));
        btnPause = new JButton(imPause);
        btnPause.setBounds(0, 0, 100, 100);
        btnPause.setContentAreaFilled(false);
        btnPause.setBorder(null);
        btnPause.setFocusPainted(false);
    }
    //public void configuracoes();
}
