package jogodavelha;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class TelaJogoDaVelha extends JFrame{
    
    public TelaJogoDaVelha(){
        setSize(700, 700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        x = y = 3;
        JDV();
        
        setVisible(true);
    }
    
    //Tamanho da matriz
    private int x;
    private int y;
    
    private Btn vet[][];
    
    private JPanel pnCC;
    
    private void confgTela(){
        
    }
    
    private void JDV(){ 
        GridLayout mz = new GridLayout(x, y);
        pnCC = new JPanel();
        pnCC.setLayout(mz);
        pnCC.setBounds(100, 162, 500, 500);
        
        vet = new Btn[x][y];
        for(int i = 0; i<x; i++){
            for(int j = 0; j<y ; j++){
                vet[i][j] = new Btn();
            }
        }
        for(int i = 0; i<x; i++){
            for(int j = 0; j<y ; j++){
                pnCC.add(vet[i][j]);
            }
        }
        
        add(pnCC);
    }
    
    private class Btn extends JButton{
        private ImageIcon imX = new ImageIcon(getClass().getResource("x.png"));
        private ImageIcon imO = new ImageIcon(getClass().getResource("o.png"));
        public Btn(){
            setLayout(null);
            setHorizontalAlignment((int)CENTER_ALIGNMENT);
            setFocusPainted(false);
            setBackground(Color.white);
           
            Troca t = new Troca(2);
            addActionListener(t);
        }
        private class Troca implements ActionListener{
            private int n;
            public Troca(int n){
                this.n = n;
            }
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(n==1){
                    setIcon(imX);
                }else if(n==2){
                    setIcon(imO);
                }
            }
        }
    }
    
}
