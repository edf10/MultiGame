package testes;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.lang.Thread;
import javax.swing.JPanel;

public class Cronometro extends JFrame{
    
    private JLabel n = new JLabel("0");
    private JPanel p = new JPanel();
    private JLabel m = new JLabel("OI");
    
    public Cronometro(){
        setSize(200, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        
        p.setLayout(null);
        p.setBounds(0,0,200,200);
       
        n.setHorizontalAlignment((int)CENTER_ALIGNMENT);
        n.setBounds(50, 50, 100, 100);
        m.setHorizontalAlignment((int)CENTER_ALIGNMENT);
        m.setBounds(0, 0, 100, 100);
        
        add(n);
        add(m);
        
        setVisible(true);
        contagem();
    }
    
    public void contagem(){
        int n = 0;
        while(n<=60){
            this.n.setText(n+"");
            n++;
            try{Thread.sleep(1000);}catch(Exception erro){};
        }
    }
    
}
