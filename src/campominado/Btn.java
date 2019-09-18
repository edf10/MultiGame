package campominado;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Btn extends JButton{
    private ImageIcon imBtn;
    private String minas = "minesweeper_100815 (2).png";
    public Btn(String s) {
        setLayout(null);
        setHorizontalAlignment((int)CENTER_ALIGNMENT);
        setFocusPainted(false);
        setBackground(Color.darkGray);
        //btnsAbertos(s);
        Troca t = new Troca(s);
        addActionListener(t);
    }
	
    public void btnsAbertos(String s) {
        if(s == "-1") {
            imBtn = new ImageIcon(getClass().getResource(minas));
            setIcon(imBtn);
        }else if(s == "0") {
            setBackground(Color.BLACK);
        }else {
            Font btn = new Font("Arial", Font.PLAIN, 60);
            setForeground(Color.white);
            setText(s);
            setFont(btn);
        }
    }
    public class Troca implements ActionListener{
        private String status = "0"; //Status do btn, se -1->Mina, se > 0->número, se - 0 - vazio.
        public Troca(String s) {
            status = s; 
        }
        public void actionPerformed(ActionEvent e) {
            if(status=="-1") {
                imBtn = new ImageIcon(getClass().getResource(minas));
                setIcon(imBtn);
            }else if(status=="0") {
                setBackground(Color.BLACK);
            }else{
                Font btn = new Font("Arial", Font.PLAIN, 60);
                setForeground(Color.white);
                setText(status);
                setFont(btn);
            }	
        }
    }	
}
