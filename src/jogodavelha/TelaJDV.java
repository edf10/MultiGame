package jogodavelha;
import java.awt.Color;
import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import componentes.Btn;
import componentes.Lb;
import componentes.Pn;
import java.awt.Component;
import java.awt.Font;

public class TelaJDV extends JFrame{
    
    public TelaJDV(IntroductionJDV i){
        setSize(700, 700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        jog1 = i.getJog1().getText();
        jog2 = i.getJog2().getText();
        redeclaracoes();
        getContentPane().setBackground(Color.darkGray);
        JDV();
        
        setVisible(true);
    }
    
    //Tamanho da matriz
    private int x;
    private int y;
    private String jog1;
    private String jog2;
    
    private Button vet[][];
    private final Jogo j = new Jogo();
    
    private Pn pnCC;
    private Pn pnVez;
    private Lb lbJog;
    
    public void redeclaracoes(){
        j.jdvClassic();
        x = j.getX();
        y = j.getY();
        j.defIc(true, false);
        vez = j.sortVez();
    }
    
    private void JDV(){
        int lbVezP[] = {0,10,150,140};
        Font f = new Font("Arial", Font.PLAIN, 50);
        String s = (vez==1)? jog1:jog2;
        int lbJogP[] = {110,10,250,140};
        lbJog = new Lb(s, f, lbJogP, Color.yellow);
        Component cp[] = {
            new Lb("Vez:", f, lbVezP, Color.yellow),
            lbJog
        };
        int pnVezP[] = {100,10,500,140};
        pnVez = new Pn(pnVezP, cp, Color.darkGray);
        
        GridLayout mz = new GridLayout(x, y);
        int pnCCP[] = {100,162,500,500};
        pnCC = new Pn(pnCCP, mz);
        
        vet = new Button[x][y];
        for(int i = 0; i<x; i++){
            for(int j = 0; j<y ; j++){
                vet[i][j] = new Button(i, j);
            }
        }
        for(int i = 0; i<x; i++){
            for(int j = 0; j<y ; j++){
                pnCC.add(vet[i][j]);
            }
        }
        add(pnVez);
        add(pnCC);
    }
    
    private int vez; //Determina de qual jogador é a vez.
    private class Button extends Btn{
        private final ImageIcon imX = new ImageIcon(getClass().getResource("x.png"));
        private final ImageIcon imO = new ImageIcon(getClass().getResource("o.png"));
        private final int x;
        private final int y;
        public Button(int x, int y){
            super();
            this.x = x;
            this.y = y;
            setBackground(Color.gray);
            addActionListener(new Troca());
        }
        private boolean press = false;
        private class Troca implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent ae) {
                j.addPress(x, y, vez);
                j.ganhar();
                if(!press){
                    if(vez==1){
                        setIcon(imX);
                        lbJog.setText(jog2);
                        vez = 2;
                    }else if(vez==2){
                        setIcon(imO);
                        lbJog.setText(jog1);
                        vez = 1;
                    }
                    press = true;
                }
            }
        }
    }
}
