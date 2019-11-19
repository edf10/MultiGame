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
import jogodavelha.IntroductionJDV;
import multigame.MultiGameTela;
import padroes.Fonts;
import padroes.ItemsTela;

public class Cadastro extends Frame{
    private Pn pnCadastro;
    private Txt txtName;
    private Pass txtPass;
    private User user;
    private ItemsTela it = new ItemsTela();
    private int redirecionamento;
    public void setRedirecionamento(int redirecionamento) {
        this.redirecionamento = redirecionamento;
    }
    
    public Cadastro(){}
    public Cadastro(User user){
        this.user = user;
    }
    
    public void telaRegister(){
        int txtUserPos[] = {725,253,369,68}; int txtPassPos[] = {725,350,369,68};
        int backQuadroPos[] = {0,0,587,700}; int barraPos[] = {587,0,5,700};
        int titlePos[] = {765,87,286,84}; int userIconPos[] = {666,264,40,46};
        int passIconPos[] = {666,362,38,44}; int btnRegisterPos[] = {814,463,190,62};
        Fonts fs = new Fonts();
        Font f = fs.addNewFont("DS-DIGIT", 40);
        Border b = BorderFactory.createLineBorder(new Color(52,103,77), 3);            
        txtName = new Txt(txtUserPos, f, Color.black, b);
        txtPass = new Pass(txtPassPos, f, Color.black, b);
        ImageIcon btn_register[] = {im.addImagem("btn_register"),im.addImagem("btn_register_t"),im.addImagem("btn_register_p")};
        Component cp[] = {
            txtName, txtPass,
            it.btnClose(),
            it.btnSomOutro(),
            new Lb(im.addImagem("barra"), barraPos),
            new Lb(im.addImagem("title_singup"), titlePos),
            new Lb(im.addImagem("avatar_icon"), userIconPos),
            new Lb(im.addImagem("pass_icon"), passIconPos),
            new Btn(btn_register, btnRegisterPos, new Register()),
            new Lb(im.addGif("back_quadro_naves"), backQuadroPos)
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
            if(txtName.getText().length()>0&&txtPass.getText().length()>0){
                User user = new User(txtName.getText(), txtPass.getText());
                user.addDataRegister();
                user.addDataRegister();
                Conta c = new Conta(user);
                c.gravar();
            }
            if(redirecionamento==1){
                MultiGameTela m = new MultiGameTela(); m.intro();m.show();
            }else{
                IntroductionJDV ijdv = new IntroductionJDV(); ijdv.intro(); ijdv.show();
            }
            
        }
    }
}