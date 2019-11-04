package testes;

import componentes.Btn;
import componentes.Frame;
import componentes.Lb;
import componentes.Pn;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import padroes.Fonts;

public class TestePaineis extends Frame{
    
    private Pn pn;
    private Btn m[][] = new Btn[14][14];
    private Fonts fs = new Fonts();
    private final ImageIcon im = new ImageIcon(getClass().getResource("btn.png"));
    private final ImageIcon back = new ImageIcon(getClass().getResource("back_intro_cm.png"));
    public TestePaineis(){
        pn = new Pn();
        pn.setLayout(new GridLayout(m.length,m.length));
        pn.setMaximumSize(new Dimension(900,500));
        pn.setBounds(150,130,900,570);
        for(int i = 0; i<m.length; i++){
            for(int j = 0; j<m[i].length; j++){
                m[i][j] = new Btn();
                m[i][j].setIcon(im);
                pn.add(m[i][j]);
            }
        }
        int p[] = {500,20,200,200}; int d[] = {0,0,1200,700};
        add(new Lb("00", fs.addNewFont("AIR_____", 80), p, Color.white));
        add(pn);
        add(new Lb(back, d));
        show();
    }
    
}
