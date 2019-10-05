package soletrando;

import componentes.Lb;
import componentes.Pn;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.border.Border;
import padroes.IntroductionGame;
public class IntroductionSol extends IntroductionGame{
    public IntroductionSol(){
        super(700,700);
        intro();
        setVisible(true);
    }
    
    @Override
    public void tutorial() {
    }

    private ImageIcon imIntro = new ImageIcon(getClass().getResource("imagens/intro.jpg"));
    private Pn pnIntro;
    @Override
    public void intro() {
        Font f = new Font("Arial", Font.PLAIN, 40);
        Border b = BorderFactory.createLineBorder(Color.black, 3);
        int pnIntroP[] = {0,0,700,700}; int lbIntroP[] = {0,0,700,700}; int lbtitleP[] = {150,50,400,70};
        Component cp[] = {
            new Lb("SOLETRANDO", f, lbtitleP, Color.black, b),
            new Lb(imIntro, lbIntroP)
        };
        
        pnIntro = new Pn(pnIntroP, cp);
        add(pnIntro);
    }
}
