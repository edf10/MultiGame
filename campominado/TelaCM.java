package campominado;
import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.lang.Thread;
import javax.swing.JOptionPane;

public class TelaCM extends JFrame{
    public TelaCM() {
        setSize(700, 700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        configTela();
        CM();

        setVisible(true);
    }
    
    private Campo r = new Campo(8, 8);
    private Btn vet[][] = new Btn[r.getX()][r.getY()];
    private int[][] m3 = new int[r.getX()][r.getY()];
    private int[][] m = new int[r.getX()][r.getY()];
    private int[] posxM = new int[r.getX()];
    private int[] posyM = new int[r.getX()];
    private JPanel painelCampo;
    private JPanel painelTempo;
    private JLabel lbsegundos;
    private JLabel lbminutos;
    private JLabel lbdoispontos;
    
    private void configTela(){
        r.declararVars();
        r.sortMinas();
        r.orgNumeros();
        m = r.getM();
        m3 = r.getM3();
        posxM = r.getPosxM();
        posyM = r.getPosyM();
        
        painelTempo = new JPanel();
        painelTempo.setBounds(0, 0, 700, 117);
        painelTempo.setBackground(Color.black);
        GridLayout t6x1 = new GridLayout(1,2);
        painelTempo.setLayout(t6x1);
        
        lbsegundos = new JLabel("00");
        lbminutos = new JLabel("00");
        lbdoispontos = new JLabel(":");
        lbsegundos.setBounds(0, 0, 100, 100);
        lbminutos.setBounds(0, 0, 100, 100);
        lbdoispontos.setBounds(0, 0, 100, 100);
        lbsegundos.setHorizontalAlignment((int)CENTER_ALIGNMENT);
        lbminutos.setHorizontalAlignment((int)CENTER_ALIGNMENT);
        lbdoispontos.setHorizontalAlignment((int)CENTER_ALIGNMENT);
        Font tempo = new Font("Arial", Font.PLAIN, 60);
        lbsegundos.setFont(tempo);
        lbminutos.setFont(tempo);
        lbdoispontos.setFont(tempo);
        lbsegundos.setForeground(Color.white);
        lbminutos.setForeground(Color.white);
        lbdoispontos.setForeground(Color.white);
        painelTempo.add(lbminutos);
        painelTempo.add(lbdoispontos);
        painelTempo.add(lbsegundos);
        
        painelCampo = new JPanel();
        GridLayout m8x8 = new GridLayout(r.getX(),r.getY());
        painelCampo.setLayout(m8x8);
        painelCampo.setBounds(-2, 114, 688, 550);
    }
    
    public contarTempo ct = new contarTempo();
    
    //Jogo
    private void CM() {
        //Adicionar butões na tela.
        for(int i = 0; i<r.getX(); i++) {
            for(int j = 0; j<r.getY(); j++){
                String s = r.Click();
                if(s == "-1") {
                    vet[i][j] = new Btn(s, i, j);
                }else if(s == "0") {
                    vet[i][j] = new Btn(s, i, j);
                }else {
                    vet[i][j] = new Btn(s, i, j);
                }
            }
        }
        for(int i = 0; i<r.getX(); i++){
            for(int j = 0; j<r.getY(); j++){
                m3[i][j] = 0;
            }
        }
        for(int i = 0; i<r.getX(); i++){
            for(int j = 0; j<r.getY(); j++){
                painelCampo.add(vet[i][j]);
            }
        }
        
        add(painelTempo);
        add(painelCampo);
    }
    
    private int minutosP = 0;
    private int segundosP = 0;
    
    public class contarTempo extends Thread{
        @Override
        public void run(){
            int s = 0;
            int m = 0;
            while(true){
                try{Thread.sleep(1000);}catch(Exception e){};
                s++;
                segundosP = s;
                if(s<60){
                    lbsegundos.setText(s+"");
                }else{
                    m++;
                    lbminutos.setText(m+"");
                    s = 0;
                    lbsegundos.setText(s+"");
                    minutosP = m;
                }
                
            }
        }
    }
    
    //Esta matriz (m3) ajuda a função "abrir" não entrar em um loop infinito.
    /*Pois quando se abre o arredor de uma posição, tem o arredor do arredor de posição e assim vai, sendo assim, algumas
    posições vai se repetir, causando um loop infinito na função, e para impedir isto, a matriz "m3" do tamanho da 
    matriz do campo minado, ajuda a saber quais posições estão repetindo, e como a "m3" é do tipo int, ela adiciona valores
    as posições utilizadas na função, sendo assim, se esse valor for igual ou maior a 2, significa que tá repetindo, então, 
    há um if impedindo a entrada/chamada para a função, utilizando como condição (m3[m2[i][0]][m2[i][j]] < 2)*/
    public void abrir(int l, int c){
        posAlt(l, c);
        //Verificação ao redor de uma certa posição
        int m2[][] = {{l+1,c-1},{l+1,c},{l+1,c+1},{l,c-1},{l,c+1},{l-1,c-1},{l-1,c},{l-1,c+1}};//Par ordenado
        for(int i = 0; i<8 ; i++){
            for(int j = 1; j<2;j++){
                if(m2[i][0]<r.getX() && m2[i][0]>-1 && m2[i][j]>-1 && m2[i][j]<r.getX()){
                    if(r.posNumero(m2[i][0], m2[i][1])){
                        posAlt(m2[i][0], m2[i][1]);
                    }else{
                        posAlt(m2[i][0], m2[i][j]);
                        m3[m2[i][0]][m2[i][j]]++;
                        if(m3[m2[i][0]][m2[i][j]] < 2){
                            abrir(m2[i][0], m2[i][j]);
                        }					
                    }
                }
            }
        }
    }
    //Aciona o evento de um determinado botão.
    public void posAlt(int l , int c){
        vet[l][c].btnsAbertos(vet[l][c].getS());
    }
    public void GameOver(){
        GO = true;
        if(press){
            for(int i = 0; i<r.getX(); i++){
                for(int j = 0; j<r.getY(); j++){
                    posAlt(i,j);
                }
            }
        }
        ct.stop();
        System.out.println("Perdeu.");
        JOptionPane.showMessageDialog(null, minutosP+":"+segundosP);
    }
    private int abertos = 0;
    public void Ganhar(){
        boolean conf = false;
        //A intenção com esta variável é que ela permaneça com o valor inicial ao final das verificações.
        //Isso significa que nem uma mina foi acionada.
        int minasAbertas = 0;
        for(int k = 0; k<r.getX(); k++){
            if(m4[posxM[k]][posyM[k]]==1){
                minasAbertas++;
            }
        }
        for(int i = 0; i<r.getX(); i++){
            for(int j = 0; j<r.getY(); j++){
                if(m4[i][j]==1){
                    abertos+=1;
                }
            }
        }
        //Para o caso de dar GameOver e a variável ter o valor de 64, que esta menos 8 é igual a 56. Sendo que o usuário perdeu.
        if(abertos==r.getX()*r.getY()-r.getX()){
            if(abertos-minasAbertas==r.getX()*r.getY()-r.getX()){
                win = true;
                for(int i = 0; i<r.getX(); i++){
                    posAlt(posxM[i], posyM[i]);
                }
                ct.stop();
                System.out.println("Ganhei.");
                JOptionPane.showMessageDialog(null, minutosP+":"+segundosP);
            }
        }
        abertos = 0;
    }
    
    public static boolean press = false;
    public static boolean GO = false;
    public int[][] m4 = new int[r.getX()][r.getY()];
    public static int iniciarJogo = 0;
    public static boolean win = false;
    
    private class Btn extends JButton{
        private ImageIcon imBtn;
        private String minas = "minesweeper_100815 (2).png";
        private String s;
        //Posição do botão em relação a matriz do campo.
        private int x;
        private int y;
        public Btn(String s, int x, int y) {
            setLayout(null);
            setHorizontalAlignment((int)CENTER_ALIGNMENT);
            setFocusPainted(false);
            setBackground(Color.darkGray);
            this.s = s;
            this.x = x;
            this.y = y;
            Troca t = new Troca(s);
            addActionListener(t);
        }
        public String getS(){
            return s;
        }
        public void btnsAbertos(String s) {
            if(press==false||GO==true){
                if(s == "-1") {
                    imBtn = new ImageIcon(getClass().getResource(minas));
                    setIcon(imBtn);
                    //caso pressione uma mina, o método Ganhar será acionado, pois tem de se ter 8 campos zerados na matriz m4.
                    m4[x][y] = 1;
                    if(GO==false&&win==false){
                        press = true;
                        GameOver();
                    }
                }else if(s == "0") {
                    setBackground(Color.BLACK);
                    m4[x][y] = 1;
                }else {
                    Font btn = new Font("Arial", Font.PLAIN, 60);
                    setForeground(Color.white);
                    setText(s);
                    setFont(btn);
                    m4[x][y] = 1;
                }
                Ganhar();
            }
        }
        public class Troca implements ActionListener{
            private String status = "0"; //Status do btn, se -1->Mina, se > 0->número, se - 0 - vazio.
            public Troca(String s) {
                status = s; 
            }
            public void actionPerformed(ActionEvent e) {
                iniciarJogo += 1;
                if(iniciarJogo==1){
                    ct.start();
                }
                if(r.posNumero(x, y)){
                    posAlt(x,y);
                }else{
                    abrir(x,y);
                }
            }
        }	
    }
}
