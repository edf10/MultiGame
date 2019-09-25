package user;
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
import javax.swing.ImageIcon;
import javax.swing.border.Border;
import multigame.MultiGameTela;
import user.Conta;

public class Cadastro extends Frame{
    public Cadastro(){
        super(800,600);
        tela();
        setVisible(true);
    }
    private Pn pnCadastro;
    private Txt txtName;
    private Pass txtPass;
    private final ImageIcon imUser = new ImageIcon(getClass().getResource("imagens/user.png"));
    private final ImageIcon imPass = new ImageIcon(getClass().getResource("imagens/pass.png"));
    private final ImageIcon imFundo = new ImageIcon(getClass().getResource("imagens/register.jpg"));
    public void tela(){
        Color back = new Color(145,135,125);
        getContentPane().setBackground(Color.black);
        int lbName[] = {35,200,50,50}; int txtNameP[] = {90,205,270,40};
        int lbPass[] = {35,270,50,50}; int txtPassP[] = {90,275,270,40};
        int btnRer[] = {125,360,150,50}; int lbtitle[] = {55,90,300,60};
        int lbfundo[] = {0,0,400,600};
        Font f = new Font("Arial", Font.PLAIN, 30);
        Font d = new Font("Arial", Font.PLAIN, 20);
        Border b = BorderFactory.createLineBorder(Color.black, 3);            
        txtName = new Txt(txtNameP, d, Color.black, b);
        txtPass = new Pass(txtPassP, d, Color.black, b);

        Component cp[] = {
            txtName, txtPass,
            new Lb("Cadastrar", f, lbtitle, Color.white, b),
            new Lb(imUser, lbName),
            new Lb(imPass, lbPass),
            new Btn("Cadastrar", f, Color.black, Color.white, btnRer, b, true, false, new Register()),
            new Lb(imFundo, lbfundo)
        };
        int pnC[] = {200,0,400,600};
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