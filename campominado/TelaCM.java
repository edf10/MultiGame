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
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import multigame.MultiGameTela;

public class TelaCM extends JFrame{
    public TelaCM() {
        /* Definições Padrão da TELA */
        setSize(700, 700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        /* ------------------------- */
        
        configTela();
        
        setVisible(true);
    }
    
    private int x;
    private int y;
    
    //Campo do jogo
    private Campo r = new Campo(x, y);
    
    //Vetor de btns
    private Btn vet[][]; 
    
    //Variáveis testes
    private int[][] m3 = new int[r.getX()][r.getY()];
    private int[][] m = new int[r.getX()][r.getY()];
    private int[] posxM = new int[r.getX()];
    private int[] posyM = new int[r.getX()];

    //Paineis
    private JPanel painelCampo;
    private JPanel painelTempo;
    private JPanel painelJogo;
    private JPanel painelNiveis;
        
    //Labels
    private JLabel lbsegundos;
    private JLabel lbminutos;
    private JLabel lbdoispontos;
    private JLabel lbFundo;
    private JLabel lbAnima;
    
    //Buttons
    private JButton btnFacil;
    private JButton btnMedio;
    private JButton btnDificil;
    private JButton btnLeft;
    
    //ImageIcons
    private ImageIcon imFundo;
    private ImageIcon imAnima;
    private ImageIcon imLeft;
    
    private void configTela(){
        /* Btns e ImageIcons Setas */
        imLeft = new ImageIcon(getClass().getResource("seta-rigth.png"));
        btnLeft = new JButton(imLeft);
        btnLeft.setBounds(0, 0, 100, 100);
        btnLeft.setContentAreaFilled(false);
        btnLeft.setBorder(null);
        btnLeft.setFocusPainted(false);
        /*------------*/
        
        /* Painel dos Niveis */
        painelNiveis = new JPanel();
        painelNiveis.setLayout(null);
        painelNiveis.setBounds(0, 0, 700, 700);
        /* ------------------ */
        
        /* Configuração ImageIcons - Painel Niveis */
        imFundo = new ImageIcon(getClass().getResource("6537.jpg"));
        imAnima = new ImageIcon(getClass().getResource("Bomba.gif"));
        /* --------------------------------------- */
        
        /* Configuração Labels e btns- PainelNiveis */
        Font nivel = new Font("Arial", Font.PLAIN, 30);
        Color bgBtn = new Color(231, 218, 87);
        
        btnFacil = new JButton("FÁCIL");
        btnMedio = new JButton("MÉDIO");
        btnDificil = new JButton("DIFÍCIL");
        lbFundo = new JLabel(imFundo);
        lbAnima = new JLabel(imAnima);

        btnFacil.setLayout(null);
        btnMedio.setLayout(null);
        btnDificil.setLayout(null);
        
        btnFacil.setFont(nivel);
        btnMedio.setFont(nivel);
        btnDificil.setFont(nivel);
        
        btnFacil.setHorizontalAlignment((int)CENTER_ALIGNMENT);
        btnMedio.setHorizontalAlignment((int)CENTER_ALIGNMENT);
        btnDificil.setHorizontalAlignment((int)CENTER_ALIGNMENT);
        
        btnFacil.setForeground(Color.black);
        btnMedio.setForeground(Color.black);
        btnDificil.setForeground(Color.black);
        
        btnFacil.setBorder(BorderFactory.createLineBorder(Color.black, 3));
        btnMedio.setBorder(BorderFactory.createLineBorder(Color.black, 3));
        btnDificil.setBorder(BorderFactory.createLineBorder(Color.black, 3));
        
        btnFacil.setFocusPainted(false);
        btnMedio.setFocusPainted(false);
        btnDificil.setFocusPainted(false);
        
        btnFacil.setBackground(bgBtn);
        btnMedio.setBackground(bgBtn);
        btnDificil.setBackground(bgBtn);
        
        btnFacil.setBounds(240, 270, 220, 50);
        btnMedio.setBounds(240, 340, 220, 50);
        btnDificil.setBounds(240, 410, 220, 50);
        lbFundo.setBounds(0, 0, 700, 700);
        lbAnima.setBounds(250, 250, 200, 200);
        
        btnFacil.setContentAreaFilled(false);
        btnMedio.setContentAreaFilled(false);
        btnDificil.setContentAreaFilled(false);
        
        Nivel btnF = new Nivel(1);
        btnFacil.addActionListener(btnF);
        Nivel btnM = new Nivel(2);
        btnMedio.addActionListener(btnM);
        Nivel btnD = new Nivel(3);
        btnDificil.addActionListener(btnD);
        /* ---------------------------------- */
        
        /* Adicionando componentes - Painel Niveis */
        painelNiveis.add(btnFacil);
        painelNiveis.add(btnMedio);
        painelNiveis.add(btnDificil);
        //painelNiveis.add(lbAnima);
        painelNiveis.add(lbFundo);
        /* ------------------------------- */
        
        /* Painel do Cronometro e do Campo - Configurações do Game*/
        painelJogo = new JPanel();
        painelJogo.setLayout(null);
        painelJogo.setBounds(0, 0, 700, 700);
        
        painelTempo = new JPanel();
        painelTempo.setBounds(0, 0, 700, 117);
        painelTempo.setBackground(Color.black);
        painelTempo.setLayout(null);
        /* ------------------------------------------------------ */
        
        /* Configurações Labels - Painel Jogo e tempo*/
        Font tempo = new Font("Arial", Font.PLAIN, 60);//Fonte
        
        //Declarações finais
        lbsegundos = new JLabel("00");
        lbminutos = new JLabel("00");
        lbdoispontos = new JLabel(":");
        
        //Alinhamento central interno
        lbsegundos.setHorizontalAlignment((int)CENTER_ALIGNMENT);
        lbminutos.setHorizontalAlignment((int)CENTER_ALIGNMENT);
        lbdoispontos.setHorizontalAlignment((int)CENTER_ALIGNMENT);
        
        lbsegundos.setBounds(460, 15, 100, 100);
        lbdoispontos.setBounds(295, 11, 100, 100);
        lbminutos.setBounds(130, 15, 100, 100);
        
        //Adicionando fonte
        lbsegundos.setFont(tempo);
        lbminutos.setFont(tempo);
        lbdoispontos.setFont(tempo);
        
        //Adicionando cor para as letras
        lbsegundos.setForeground(Color.white);
        lbminutos.setForeground(Color.white);
        lbdoispontos.setForeground(Color.white);
        /* ---------------------- */
        
        /* Adicionando lbs no painelTempo */
        painelTempo.add(lbminutos);
        painelTempo.add(lbdoispontos);
        painelTempo.add(lbsegundos);
        //painelTempo.add(btnLeft);
        /* ------------------------------ */
        add(painelNiveis);
    }
    
    public boolean start = false;
    //Evento btns niveis
    private class Nivel implements ActionListener{
        private int n = 0;
        private Nivel(int n){
            this.n = n;
        }
        public void actionPerformed(ActionEvent e){
            start = true;
            painelNiveis.setVisible(false);
            switch(n){
                case 1:
                    x = y = 8;
                    break;
                case 2:
                    x = y = 9;
                    break;
                case 3:
                    x = y = 10;
                    break;
                default:
                    break;
            }
            //Redeclaração. Por causa da atualização de valores.
            r = new Campo(x, y);
            vet = new Btn[r.getX()][r.getY()];
            m4 = new int[r.getX()][r.getY()];
            CM(n);
        }
    }
    
    //Jogo
    private void CM(int n) {
        /* Definindo painel e gridlayout do campo */
        painelCampo = new JPanel();
        GridLayout m8x8 = new GridLayout(x,y);//Matriz
        painelCampo.setLayout(m8x8);
        if(n==1){
            painelCampo.setBounds(-2, 114, 688, 550);    
        }else if(n==2){
            painelCampo.setBounds(-2, 117, 688, 548);
            painelTempo.setBounds(0, 0, 700, 121);
        }else if(n==3){
            minas = "minas(2).png";
            btn = new Font("Arial", Font.PLAIN, 50);
            setSize(704, 701);
            painelTempo.setBounds(0, 0, 700, 122);
            painelCampo.setBounds(-1, 118, 690, 549);
        }
        
        /* -------------------------------------- */
        
        /* Variáveis de teste */
        r.declararVars();
        r.sortMinas();
        r.orgNumeros();
        m = r.getM();
        m3 = r.getM3();
        posxM = r.getPosxM();
        posyM = r.getPosyM();
        /* ------------------ */
        
        /* Adicionar btns no vetor */
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
        /* ------------------------ */
        
        //Zerando a matriz m3.
        for(int i = 0; i<r.getX(); i++){
            for(int j = 0; j<r.getY(); j++){
                m3[i][j] = 0;
            }
        }
        
        /* Adicionando vetor de btns no painelCampo */
        for(int i = 0; i<r.getX(); i++){
            for(int j = 0; j<r.getY(); j++){
                painelCampo.add(vet[i][j]);
            }
        }
        /* ---------------------------------------- */
        
        /* Adicionando paineis no painelJogo */
        painelJogo.add(painelTempo);
        painelJogo.add(painelCampo);
        add(painelJogo);
        
        /* ---------------------------------------- */
    }
    
    /* Contadores do tempo */
    private int minutosP = 0;
    private int segundosP = 0;
    /* ------------------- */
    
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
        posAlt(l, c);//Abrir a posição acionada.
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
    
    //Instância ContarTempo
    public contarTempo ct = new contarTempo();
    
    public void GameOver(){
        GO = true;
        //Quando dá GameOver, todas as posições são abertas.
        if(press){
            for(int i = 0; i<r.getX(); i++){
                for(int j = 0; j<r.getY(); j++){
                    posAlt(i,j);
                }
            }
        }
        ct.stop();//Para o cronômetro.
        //System.out.println("Perdeu.");
        JOptionPane.showMessageDialog(null, minutosP+":"+segundosP);
    }
    private int abertos = 0;
    public void Ganhar(int x, int y){
        boolean conf = false;
        //A intenção com esta variável é que ela permaneça com o valor inicial ao final das verificações.
        //Isso significa que nem uma mina foi acionada.
        int minasAbertas = 0;
        for(int k = 0; k<x; k++){
            if(m4[posxM[k]][posyM[k]]==1){
                minasAbertas++;
            }
        }
        for(int i = 0; i<x; i++){
            for(int j = 0; j<y; j++){
                if(m4[i][j]==1){
                    abertos+=1;
                }
            }
        }
        //Para o caso de dar GameOver e a variável ter o valor do total de botões da matriz, 
        //que esta menos total de bombas é igual a o total de btns no campo. Sendo que o usuário perdeu.
        if(abertos==x*y-x){
            if(abertos-minasAbertas==x*y-x){
                win = true;
                for(int i = 0; i<x; i++){
                    posAlt(posxM[i], posyM[i]);
                }
                ct.stop();//Para o cronômetro
                //System.out.println("Ganhei.");
                JOptionPane.showMessageDialog(null, minutosP+":"+segundosP);
            }
        }
        abertos = 0;
    }
    
    /* Variáveis Estáticas */
    public boolean press = false;
    public boolean GO = false;
    public int[][] m4;
    public int iniciarJogo = 0;
    public boolean win = false;
    public String minas = "minesweeper_100815 (2).png";
    public Font btn = new Font("Arial", Font.PLAIN, 60);
    /* ------------------- */
    
    private class Btn extends JButton{
        private ImageIcon imBtn;
        private String s;
        //Posição do botão em relação a matriz do campo.
        private int x;
        private int y;
        
        //Contruct
        public Btn(String s, int x, int y) {
            /* Configurações padrão do Btn */
            setLayout(null);
            setHorizontalAlignment((int)CENTER_ALIGNMENT);
            setFocusPainted(false);
            setBackground(Color.darkGray);
            /* --------------------------- */
            
            /* Variaveis */
            this.s = s; //Evento do botão (tipo)
            this.x = x; //Posição x
            this.y = y; //Posição y
            /* --------- */
            
            /* Adicionando evento do botão */
            Troca t = new Troca(s);
            addActionListener(t);
            /* -------------------------- */
        }
        public String getS(){
            return s;
        }
        public void btnsAbertos(String s) {
            /*Se press==false, significa que nem uma mina foi clicada, caso contrário, ela foi acionada. Mas quando essa variável assume
              o valor true, não se consegue mais entrar nos ifs após a condição inicial, então quando o método GameOver for chamado, não
              poderá abrir as outras posições devido esta condição inicial. Por isso é necessário esta variável GO, onde quando uma mina
              é acionada e chama o método GameOver, este atribui o valor true para a variável GO, fazendo com que quando este método chamar
              o método btnsAbertos seja possível abrir o campo.*/
            if(press==false||GO==true){
                if(s == "-1") {
                    imBtn = new ImageIcon(getClass().getResource(minas));
                    setIcon(imBtn);
                    
                    //caso pressione uma mina, o método Ganhar será acionado, pois tem de se ter 8 campos zerados na matriz m4.
                    m4[x][y] = 1;
                    
                    //Se win fosse true, sem essa condição, o código consideraria que o usuário perdeu e ganhou o jogo.
                    if(GO==false&&win==false){ //Caso win seja falso, significa que não ganhou-se o jogo.
                        press = true;
                        GameOver();
                    }
                }else if(s == "0") {
                    setBackground(Color.BLACK);
                    m4[x][y] = 1;
                }else {
                    setForeground(Color.white);
                    setText(s);
                    setFont(btn);
                    m4[x][y] = 1;
                }
                //Faz-se uma verificação a cada botão clicado.
                Ganhar(r.getX(), r.getY());
            }
        }
        public class Troca implements ActionListener{
            private String status = "0"; //Status do btn, se -1->Mina, se > 0->número, se - 0 - vazio.
            public Troca(String s) {
                status = s; 
            }
            public void actionPerformed(ActionEvent e) {
                //Iniciar o cronômetro quando um btn for clicado.
                //Essa variável, iniciarJogo, faz com que o cronômetro seja iniciado um vez apenas.
                iniciarJogo += 1;
                if(iniciarJogo==1){
                    ct.start();
                }
                if(r.posNumero(x, y)){
                    //Caso seja número, abrir só essa posição.
                    posAlt(x,y);
                }else{
                    //Caso seja vazio, abre-se até os números através deste método.
                    abrir(x,y);
                }
            }
        }	
    }
}
