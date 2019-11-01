package campominado;
import java.awt.GridLayout;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.lang.Thread;
import finalizacao.TelaGOWin;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import componentes.Lb; 
import componentes.Pn;
import componentes.Btn;
import componentes.Frame;
import java.awt.Component;

public class TelaCM extends Frame{
    public TelaCM(int nivel, int x, int y) {
        //setUndecorated(win);
        this.x = x; this.y = y;
        redeclaracoes(nivel);
        setVisible(true);
    }
    private int x; private int y; //Tamanho do campo
    private Campo r; private Button vet[][]; //Campo e vetor de btns
    private int[][] m3; private int[][] m; private int[] posxM; private int[] posyM; //Variáveis teste
    private Pn painelCampo; private Pn painelTempo; //Paineis
    private Lb lbsegundos; private Lb lbminutos; private Lb lbdoispontos; //Labels
    //ImageIcons
    private static int nivel;
    public void redeclaracoes(int nil){
        //Redeclaração. Por causa da atualização de valores.
        r = new Campo(x, y);
        vet = new Button[x][y];
        m4 = new int[x][y];
        marc = new int[x][y];
        for(int i = 0; i<x; i++){
            for(int j = 0; j<y; j++){
                marc[i][j] = 0;
            }
        }
        nivel = nil;
        CM();
    }
    
    public int getN(){
        return nivel;
    }
    
    //Jogo
    public void CM() {
        /* Painel Tempo */
        Font tempo = new Font("Arial", Font.PLAIN, 60);
        int lbSegundosP[] = {460,15,100,100};
        int lbMinutosP[] = {130,15,100,100};
        int lbdoispontosP[] = {295,11,100,100};
        lbsegundos = new Lb("00", tempo,lbSegundosP, Color.white, null);
        lbminutos = new Lb("00", tempo, lbMinutosP, Color.white, null);
        lbdoispontos = new Lb(":", tempo, lbdoispontosP, Color.white, null);
        Component cp[] = {lbsegundos, lbminutos, lbdoispontos};
        int pnTempoP[] = {0,0,700,109};
        painelTempo = new Pn(pnTempoP, cp, Color.black);
        /* ------------------------------------------------------ */
        /* Definindo painel e gridlayout do campo */
        int pnCampoP[] = {0,109,684,552};
        GridLayout mx = new GridLayout(x,y);//Matriz
        painelCampo = new Pn(pnCampoP, mx);
        r.declararVars();//Configurações iniciais do campo
        if(nivel==1){
            r.sortMinas(20);//Input das minas
        }else if(nivel==2){
            setSize(800, 700);
            lbminutos.setBounds(175, 5, 100, 100);lbsegundos.setBounds(508, 5, 100, 100);
            lbdoispontos.setBounds(341, 1, 100, 100);painelCampo.setBounds(0, 101, 784, 560);
            painelTempo.setBounds(0, 0, 800, 101);btn = new Font("Arial", Font.PLAIN, 20);
            minas = "imagens/minasM.png"; marcador = "imagens/flagM.png"; r.sortMinas(25);
        }else if(nivel==3){
            setSize(1006, 732);
            lbminutos.setBounds(278, 5, 100, 100); lbsegundos.setBounds(611, 5, 100, 100);
            lbdoispontos.setBounds(444, 1, 100, 100); btn = new Font("Arial", Font.PLAIN, 17);
            painelTempo.setBounds(0, 0, 1006, 99); painelCampo.setBounds(0, 99, 990, 594);
            minas = "imagens/minasD.png"; marcador = "imagens/flagD.png";r.sortMinas(30);
        }
        /* -------------------------------------- */
        r.orgNumeros();
        setLocationRelativeTo(null);
        /* Variáveis de teste */
        m = r.getM(); m3 = r.getM3(); posxM = r.getPosxM(); posyM = r.getPosyM();
        /* Adicionar btns no vetor */
        for(int i = 0; i<x; i++) {
            for(int j = 0; j<y; j++){
                m3[i][j] = 0;//Zerando a matriz m3.
                String s = r.Click();
                vet[i][j] = new Button(s, i, j);
                painelCampo.add(vet[i][j]);//Adicionando vetor de btns no painelCampo
            }
        }
        /* Adicionando paineis na tela */
        add(painelTempo); add(painelCampo);
    }
    /* Contadores do tempo */
    private int minutosP = 0; private int segundosP = 0;
    /* ------------------- */
    public class contarTempo extends Thread{
        @Override
        public void run(){
            int s = 0; int m = 0;
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
            if(m2[i][0]<r.getX() && m2[i][0]>-1 && m2[i][1]>-1 && m2[i][1]<r.getX()){
                if(marc[m2[i][0]][m2[i][1]]!=1){marc[m2[i][0]][m2[i][1]] = 2;}
                if(r.posNumero(m2[i][0], m2[i][1])){posAlt(m2[i][0], m2[i][1]);
                }else{
                    posAlt(m2[i][0], m2[i][1]);
                    m3[m2[i][0]][m2[i][1]]++;
                    if(m3[m2[i][0]][m2[i][1]] < 2){abrir(m2[i][0], m2[i][1]);}					
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
                    marc[i][j] = 2;
                    posAlt(i,j);
                }
            }
        }
        ct.stop();//Para o cronômetro.
        TelaGOWin tgo = new TelaGOWin(minutosP+":"+segundosP, this, r, false);
    }
    private int abertos = 0;
    public void Ganhar(){
        //A intenção com esta variável é que ela permaneça com o valor inicial ao final das verificações.
        //Isso significa que nem uma mina foi acionada.
        int minasAbertas = 0;
        for(int k = 0; k<r.getBombs(); k++){
            if(m4[posxM[k]][posyM[k]]==1){minasAbertas++;}
        }
        for(int i = 0; i<x; i++){
            for(int j = 0; j<y; j++){
                if(m4[i][j]==1){abertos+=1;}
            }
        }
        //Para o caso de dar GameOver e a variável ter o valor do total de botões da matriz, 
        //que esta menos total de bombas é igual a o total de btns no campo. Sendo que o usuário perdeu.
        if(abertos==x*y-r.getBombs()&&abertos-minasAbertas==x*y-r.getBombs()){
            win = true;
            for(int i = 0; i<r.getBombs(); i++){
                marc[posxM[i]][posyM[i]] = 2;
                posAlt(posxM[i], posyM[i]);
            }
            ct.stop();//Para o cronômetro
            TelaGOWin tgo = new TelaGOWin(minutosP+":"+segundosP, this, r, true);
        }
        abertos = 0;
    }
    
    /* Variáveis Auxiliares */
    public boolean press = false; public boolean GO = false; public boolean win = false;
    public int iniciarJogo = 0; public int marc[][]; public int[][] m4;
    public String minas = "imagens/minasF.png"; public String marcador = "imagens/flagF.png";
    public Font btn = new Font("Arial", Font.PLAIN, 40);
    
    private class Button extends Btn{
        private ImageIcon imBtn; private ImageIcon imMar;
        private String s; private int x; private int y;
        private Troca t = new Troca();
        
        public Button(String s, int x, int y) {
            super();
            setBackground(Color.darkGray);
            this.s = s; //Evento do botão (tipo)
            this.x = x; this.y = y;//Posição do btn em relação a matriz
            addMouseListener(t);
        }
        public String getS(){return s;}
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
                    if("-1".equals(s)) {
                        imBtn = new ImageIcon(getClass().getResource(minas));
                        setIcon(imBtn);
                        //Se win fosse true, sem essa condição, o código consideraria que o usuário perdeu e ganhou o jogo.
                        if(GO==false&&win==false){ //Caso win seja falso, significa que não ganhou-se o jogo.
                            press = true;
                            GameOver();
                        }
                    }else if("0".equals(s)) {
                        setBackground(Color.BLACK);
                    }else {
                        setForeground(Color.white);
                        setText(s);
                        setFont(btn);
                    }
                    m4[x][y] = 1;
                }
                Ganhar();//Faz-se uma verificação a cada botão clicado.
            }
        }
        public class Troca implements MouseListener{
            @Override
            public void mouseClicked(MouseEvent me) {
                iniciarJogo += 1;//Essa variável, iniciarJogo, faz com que o cronômetro seja iniciado um vez apenas.
                if(iniciarJogo==1){ct.start();}
                switch(me.getModifiers()){
                    case InputEvent.BUTTON1_MASK:
                        if(marc[x][y]==0){marc[x][y] = 2;}
                        if(marc[x][y]==2){
                            //Caso seja número, abrir só essa posição. //Caso seja vazio, abre-se até os números através deste método.
                            if(r.posNumero(x, y)){posAlt(x,y);}else{abrir(x,y);}
                        }
                        break;
                    case InputEvent.BUTTON3_MASK:
                        if(marc[x][y]==1){setIcon(null);marc[x][y] = 0;
                        }else if(marc[x][y]==0){marc[x][y] = 1;posAlt(x, y);}
                        break;
                    default:break;
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
        }	
    }
}
