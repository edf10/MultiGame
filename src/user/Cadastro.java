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
import padroes.ItemsTela;

public class Cadastro extends Frame{
    private Pn pnCadastro;
    private Txt txtName;
    private Pass txtPass;
    private ItemsTela it = new ItemsTela();
    private final ImageIcon imBackQuadro = new ImageIcon(getClass().getResource("imagens/back_quadro_naves.gif"));
    private final ImageIcon imBarra = new ImageIcon(getClass().getResource("imagens/barra_im.png"));
    private final ImageIcon imTitleC = new ImageIcon(getClass().getResource("imagens/title_singup.png"));
    private final ImageIcon imUserIcon = new ImageIcon(getClass().getResource("imagens/avatar_icon.png"));
    private final ImageIcon imPassIcon = new ImageIcon(getClass().getResource("imagens/pass_icon.png"));
    private final ImageIcon imRegisterBtn = new ImageIcon(getClass().getResource("imagens/btn_register.png"));
    private final ImageIcon imRegisterBtnT = new ImageIcon(getClass().getResource("imagens/btn_register_t.png"));
    private final ImageIcon imRegisterBtnP = new ImageIcon(getClass().getResource("imagens/btn_register_p.png"));
    public Cadastro(){
        int txtUserPos[] = {725,253,369,68}; int txtPassPos[] = {725,350,369,68};
        int backQuadroPos[] = {0,0,587,700}; int barraPos[] = {587,0,5,700};
        int titlePos[] = {765,87,286,84}; int userIconPos[] = {666,264,40,46};
        int passIconPos[] = {666,362,38,44}; int btnRegisterPos[] = {814,463,190,62};
        Font f = new Font("Arial", Font.PLAIN, 20);
        Border b = BorderFactory.createLineBorder(new Color(52,103,77), 3);            
        txtName = new Txt(txtUserPos, f, Color.black, b);
        txtPass = new Pass(txtPassPos, f, Color.black, b);
        ImageIcon btn_register[] = {imRegisterBtn,imRegisterBtnT,imRegisterBtnP};
        Component cp[] = {
            txtName, txtPass,
            it.btnClose(),
            it.btnSomOutro(),
            new Lb(imBarra, barraPos),
            new Lb(imTitleC, titlePos),
            new Lb(imUserIcon, userIconPos),
            new Lb(imPassIcon, passIconPos),
            new Btn(btn_register, btnRegisterPos, new Register()),
            new Lb(imBackQuadro, backQuadroPos)
        };
        int pnC[] = {0,0,1200,700};
        pnCadastro = new Pn(pnC, cp, Color.black);
        add(pnCadastro);
        setVisible(true);
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