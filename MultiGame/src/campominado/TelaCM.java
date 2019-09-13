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
import multigame.Controle;
import finalizacao.TelaGameOver;
import testes.Marcador;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class TelaCM extends JFrame{
    public TelaCM() {
        /* Definições Padrão da TELA */
        setSize(700, 700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        //setUndecorated(win);
        /* ------------------------- */
        
        configTela();
        
        setVisible(true);
    }
    private int x; 
    private int y;
    
    //Campo do jogo
    private Campo r;
    
    //Vetor de btns
    private Btn vet[][]; 
    
    //Variáveis testes
    private int[][] m3;
    private int[][] m;
    private int[] posxM;
    private int[] posyM;

    //Paineis
    private JPanel painelCampo;
    private JPanel painelTempo;
    private JPanel painelNiveis;
        
    //Labels
    private JLabel lbsegundos = lbsTempo("00", 460, 15);
    private JLabel lbminutos = lbsTempo("00", 130, 15);
    private JLabel lbdoispontos = lbsTempo(":", 295, 11);
    private JLabel lbFundo;
    
    //ImageIcons
    private ImageIcon imFundo;
    
    private JButton btnsNiveis(String s, int y, int event){
        Font nivel = new Font("Arial", Font.PLAIN, 30);
        Color bgBtn = new Color(231, 218, 87);
        Nivel btnE = new Nivel(event);
        
        JButton btn = new JButton(s);
        
        btn.setLayout(null);
        btn.setHorizontalAlignment((int)CENTER_ALIGNMENT);
        btn.setFont(nivel);
        btn.setForeground(Color.black);
        btn.setBorder(BorderFactory.createLineBorder(Color.black, 3));
        btn.setFocusPainted(false);
        btn.setBackground(bgBtn);
        btn.setContentAreaFilled(false);
        btn.setBounds(240, y, 220, 50);
        btn.addActionListener(btnE);
        
        return btn;
    }
    private JLabel lbsTempo(String t, int x, int y){
        Font tempo = new Font("Arial", Font.PLAIN, 60);
        JLabel lb = new JLabel(t);
        
        lb.setLayout(null);
        lb.setHorizontalAlignment((int)CENTER_ALIGNMENT);
        lb.setBounds(x, y, 100, 100);
        lb.setFont(tempo);
        lb.setForeground(Color.white);
        return lb;
    }
    private void configTela(){
        Controle contr = new Controle();
        
        /* Painel dos Niveis */
        painelNiveis = new JPanel();
        painelNiveis.setLayout(null);
        painelNiveis.setBounds(0, 0, 700, 700);
        /* ------------------ */
        
        /* Configuração Label - PainelNiveis */
        imFundo = new ImageIcon(getClass().getResource("fundoNiveis.jpg"));
        lbFundo = new JLabel(imFundo);
        lbFundo.setBounds(0, 0, 700, 700);
        /* ---------------------------------- */
        
        /* Adicionando componentes - Painel Niveis */
        painelNiveis.add(btnsNiveis("FÁCIL", 270, 1));
        painelNiveis.add(btnsNiveis("MÉDIO", 340, 2));
        painelNiveis.add(btnsNiveis("DIFÍCIL", 410, 3));
        painelNiveis.add(lbFundo);
        /* ------------------------------- */
        
        /* Painel do Cronometro - Configurações do Game*/
        painelTempo = new JPanel();
        painelTempo.setBounds(0, 0, 700, 109);
        painelTempo.setBackground(Color.black);
        painelTempo.setLayout(null);
        /* ------------------------------------------------------ */
        
        /* Adicionando lbs no painelTempo */
        painelTempo.add(lbsegundos);
        painelTempo.add(lbminutos);
        painelTempo.add(lbdoispontos);
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
        @Override
        public void actionPerformed(ActionEvent e){
            start = true;
            painelNiveis.setVisible(false);
            switch(n){
                case 1:
                    x = y = 12;
                    break;
                case 2:
                    x = y = 16;
                    break;
                case 3:
                    x = y = 18;
                    break;
                default:
                    break;
            }
            //Redeclaração. Por causa da atualização de valores.
            r = new Campo(x, y);
            vet = new Btn[r.getX()][r.getY()];
            m4 = new int[r.getX()][r.getY()];
            marc = new int[r.getX()][r.getY()];
            for(int i = 0; i<r.getX(); i++){
                for(int j = 0; j<r.getY(); j++){
                    marc[i][j] = 0;
                }
            }
            CM(n);
        }
    }
    
    //Jogo
    private void CM(int n) {
        /* Definindo painel e gridlayout do campo */
        painelCampo = new JPanel();
        GridLayout mx = new GridLayout(x,y);//Matriz
        painelCampo.setLayout(mx);
        System.out.println(getSize());
        r.declararVars();//Configurações iniciais do campo
        if(n==1){
            painelCampo.setBounds(0, 109, 684, 552);   
            r.sortMinas(20);//Input das minas
        }else if(n==2){
            setSize(800, 700);
            painelCampo.setBounds(0, 101, 784, 560);
            painelTempo.setBounds(0, 0, 800, 101);
            btn = new Font("Arial", Font.PLAIN, 20);
            minas = "minasM.png";
            marcador = "flagM.png";
            r.sortMinas(25);
        }else if(n==3){
            setSize(1006, 732);
            minas = "minasD.png";
            marcador = "flagD.png";
            btn = new Font("Arial", Font.PLAIN, 17);
            painelTempo.setBounds(0, 0, 1006, 99);
            painelCampo.setBounds(0, 99, 990, 594);
            r.sortMinas(30);
        }
        
        setLocationRelativeTo(null);
        /* -------------------------------------- */
        
        r.orgNumeros();
        
        /* Variáveis de teste */
        m = r.getM();
        m3 = r.getM3();
        posxM = r.getPosxM();
        posyM = r.getPosyM();
        /* ------------------ */
        
        /* Adicionar btns no vetor */
        for(int i = 0; i<r.getX(); i++) {
            for(int j = 0; j<r.getY(); j++){
                String s = r.Click();
                vet[i][j] = new Btn(s, i, j);
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
        
        /* Adicionando paineis na tela */
        add(painelTempo);
        add(painelCampo);
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
                    if(marc[m2[i][0]][m2[i][1]]!=1){
                        marc[m2[i][0]][m2[i][1]] = 2;
                    }
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
                    if(marc[i][j]!=1){
                        marc[i][j] = 2;
                    }
                    posAlt(i,j);
                }
            }
        }
        ct.stop();//Para o cronômetro.
        //System.out.println("Perdeu.");
        //TelaGameOver tgo = new TelaGameOver();
        JOptionPane.showMessageDialog(null, minutosP+":"+segundosP);
    }
    private int abertos = 0;
    public void Ganhar(int x, int y){
        //A intenção com esta variável é que ela permaneça com o valor inicial ao final das verificações.
        //Isso significa que nem uma mina foi acionada.
        int minasAbertas = 0;
        for(int k = 0; k<r.getBombs(); k++){
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
        if(abertos==x*y-r.getBombs()){
            if(abertos-minasAbertas==x*y-r.getBombs()){
                win = true;
                for(int i = 0; i<r.getBombs(); i++){
                    marc[posxM[i]][posyM[i]] = 2;
                    posAlt(posxM[i], posyM[i]);
                }
                ct.stop();//Para o cronômetro
                //System.out.println("Ganhei.");
                JOptionPane.showMessageDialog(null, minutosP+":"+segundosP);
            }
        }
        abertos = 0;
    }
    
    /* Variáveis Auxiliares */
    public boolean press = false;
    public boolean GO = false;
    public int[][] m4;
    public int iniciarJogo = 0;
    public boolean win = false;
    public int marc[][];
    public String minas = "minasF.png";
    public String marcador = "flagF.png";
    public Font btn = new Font("Arial", Font.PLAIN, 40);
    /* ------------------- */
    
    private class Btn extends JButton{
        private ImageIcon imBtn;
        private ImageIcon imMar;
        private String s;
        //Posição do botão em relação a matriz do campo.
        private int x;
        private int y;
        
        private Troca t = new Troca(s);
        
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
            
            //addActionListener(t);
            addMouseListener(t);
            //System.out.println(InputEvent.BUTTON2_MASK);
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
                if(marc[x][y]==1){
                    imMar  = new ImageIcon(getClass().getResource(marcador));
                    setIcon(imMar);
                }else if(marc[x][y]==2){
                    if(s == "-1") {
                        imBtn = new ImageIcon(getClass().getResource(minas));
                        setIcon(imBtn);
                        //Se win fosse true, sem essa condição, o código consideraria que o usuário perdeu e ganhou o jogo.
                        if(GO==false&&win==false){ //Caso win seja falso, significa que não ganhou-se o jogo.
                            press = true;
                            GameOver();
                        }
                    }else if(s == "0") {
                        setBackground(Color.BLACK);
                    }else {
                        setForeground(Color.white);
                        setText(s);
                        setFont(btn);
                    }
                    m4[x][y] = 1;
                }
                
                //Faz-se uma verificação a cada botão clicado.
                Ganhar(r.getX(), r.getY());
                
            }
        }
        public class Troca implements MouseListener{
            private String status = "0"; //Status do btn, se -1->Mina, se > 0->número, se 0 - vazio.
            public Troca(String s) {
                status = s; 
            }
            private boolean pressM = false;

            @Override
            public void mouseClicked(MouseEvent me) {
                //System.out.println(me.getModifiers());
                iniciarJogo += 1;
                if(iniciarJogo==1){
                    ct.start();
                }
                switch(me.getModifiers()){
                    case InputEvent.BUTTON1_MASK:
                        if(marc[x][y]==0){
                            marc[x][y] = 2;
                        }
                        if(marc[x][y]==2){
                            //Iniciar o cronômetro quando um btn for clicado.
                            //Essa variável, iniciarJogo, faz com que o cronômetro seja iniciado um vez apenas.
                            if(r.posNumero(x, y)){
                                //Caso seja número, abrir só essa posição.
                                posAlt(x,y);
                            }else{
                                //Caso seja vazio, abre-se até os números através deste método.
                                abrir(x,y);
                            }
                        }
                        break;
                    case InputEvent.BUTTON3_MASK:
                        if(marc[x][y]==1){
                            setIcon(null);
                            marc[x][y] = 0;
                        }else if(marc[x][y]==0){
                            marc[x][y] = 1;
                            posAlt(x, y);
                        }
                        break;
                    default:
                        break;
                    }
                }
                @Override
                public void mousePressed(MouseEvent me) {}
                @Override
                public void mouseReleased(MouseEvent me) {}
                @Override
                public void mouseEntered(MouseEvent me) {}
                @Override
                public void mouseExited(MouseEvent me) {}

                public boolean getPressM(){
                    return pressM;
                }
            
        }	
    }
}
