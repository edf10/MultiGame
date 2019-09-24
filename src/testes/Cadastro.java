package testes;
import componentes.Btn;
import componentes.Frame;
import componentes.Lb;
import componentes.Pass;
import componentes.Pn;
import componentes.Txt;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import multigame.MultiGameTela;
import user.Conta;

public class Cadastro extends Frame{
    public Cadastro(){
        super(600,400);
        tela();
        setVisible(true);
    }
    private Pn pnCadastro;
    private Txt txtName;
    private Pass txtPass;
    public void tela(){
        int lbName[] = {80,140,100,50}; int txtNameP[] = {190,145,300,40};
        int lbPass[] = {80,200,100,50}; int txtPassP[] = {190,205,300,40};
        int btnRer[] = {400,275,150,50}; int lbtitle[] = {100,20,400,80};
        Font f = new Font("Arial", Font.PLAIN, 30);
        Font d = new Font("Arial", Font.PLAIN, 20);
        Border b = BorderFactory.createLineBorder(Color.black, 3);            
        txtName = new Txt(txtNameP, f, Color.red, b);
        txtPass = new Pass(txtPassP, f, Color.red, b);

        Component cp[] = {
            txtName, txtPass,
            new Lb("CADASTRAR", f, lbtitle, Color.white, b),
            new Lb("Username:", d, lbName, Color.black, null),
            new Lb("Password:", d, lbPass, Color.black, null),
            new Btn("Cadastrar", f, Color.black, Color.white, btnRer, b, true, false, new Register())
        };
        int pnC[] = {0,0,600,400};
        pnCadastro = new Pn(pnC, cp);
        add(pnCadastro);
    }
    
    public class Register implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ae) {
            dispose();
            Conta c = new Conta(txtName.getText(), txtPass.getText());
            c.gravar();
            MultiGameTela m = new MultiGameTela(1);
        }
    }
}