package campominado;
import java.awt.GridLayout;
import java.awt.Font;
import java.awt.Color;
import java.lang.Thread;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import componentes.Lb; 
import componentes.Pn;
import componentes.Btn;
import componentes.Frame;
import javax.swing.ImageIcon;
import padroes.Fonts;
import padroes.ItemsTela;
import padroes.WinOrGameOver;
import user.Conta;
import user.User;

public class TelaCM extends Frame{
    private Campo r;
    public void setR(Campo r) {this.r = r;}
    private User user = User.getUser();
    private int m5[][]; //1=posOpen 3=marcadores 2=minas abertas
    private String nivel;
    public void configuracoes(){
        it.setTelaAntIntro(1);
        x = r.getX(); y = r.getY();
        vet = new Button[x][y];
        m4 = new int[x][y];
        m3 = r.getM3(); posxM = r.getPosxM(); posyM = r.getPosyM();
        marc = new int[x][y];
        m5 = new int[x][y];
        for(int i = 0; i<x; i++){
            for(int j = 0; j<y; j++){
                marc[i][j] = 0;
                m3[i][j] = 0;
                m5[i][j] = 0;
            }
        }
        m = r.getM();
        if(x==16){
            botao = im.addImagem("btn_cm_medium");botao_p = im.addImagem("btn_cm_medium");botao_t = im.addImagem("btn_cm_medium");
            marcador = im.addImagem("flagM");minas = im.addImagem("bomb_cm_medium");
        }else if(x==18){
            botao = im.addImagem("btn_cm_medium");botao_p = im.addImagem("btn_cm_medium");botao_t = im.addImagem("btn_cm_medium");
            marcador = im.addImagem("flagD");minas = im.addImagem("bomb_cm_hard");
        }
        CM();
    }
    
    private int x; private int y; //Tamanho do campo
    public void setX(int x) {this.x = x;}
    public void setY(int y) {this.y = y;}
    private Button vet[][]; //Campo e vetor de btns
    private int[][] m3; private int[][] m; private int[] posxM; private int[] posyM; //Variáveis teste
    private Pn painelCampo; private Pn pnBorda;//Paineis
    private Lb lbsegundos; private Lb lbminutos; private Lb lbdoispontos; //Labels
    private ItemsTela it = new ItemsTela();
    private Fonts f = new Fonts(); 
    public void CM() {
        int lbBackCampoPos[] = {128,114,938,633};
        pnBorda = new Pn(); pnBorda.add(new Lb(im.addImagem("pn_back_campo_cm"), lbBackCampoPos));
        pnBorda.setBounds(128, 114, 938, 633);
        Font tempo = f.addNewFont("DS-DIGIT", 80);
        int lbSegundosP[] = {727,20,100,100};
        int lbMinutosP[] = {373,20,100,100};
        int lbdoispontosP[] = {555,18,100,100};
        lbsegundos = new Lb("00", tempo,lbSegundosP, Color.white);
        lbminutos = new Lb("00", tempo, lbMinutosP, Color.white);
        lbdoispontos = new Lb(":", tempo, lbdoispontosP, Color.white);
        int pnCampoP[] = {145,130,908,573};
        GridLayout mx = new GridLayout(x,y);
        painelCampo = new Pn(pnCampoP, mx);
        for(int i = 0; i<x; i++) {
            for(int j = 0; j<y; j++){
                String s = ""+m[i][j];
                vet[i][j] = new Button(s, i, j);
                painelCampo.add(vet[i][j]);//Adicionando vetor de btns no painelCampo
            }
        }
        painelCampo.setBackground(Color.black);
        add(painelCampo);
        pnBorda.setBackground(new Color(45,39,39));
        add(pnBorda);
        getContentPane().setBackground(new Color(45,39,39));
        add(it.btnClose());
        add(lbminutos);
        add(lbsegundos);
        add(lbdoispontos);
        add(it.returnGames(this));
    }
    public class contarTempo extends Thread{
        @Override
        public void run(){
            int s = 0; int m = 0; int so = 0; int mo = 0;
            while(true){
                try{Thread.sleep(1000);}catch(Exception e){};
                s++;
                if(s==10){so++; s = 0;}
                if(so==6&&s==0){
                    so = 0;m++;
                    if(m==10){mo++; m = 0;}
                    lbminutos.setText(mo+""+m+"");
                    s = 0;
                    lbsegundos.setText(so+""+s+"");
                }else{lbsegundos.setText(so+""+s+"");}
                
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
        WinOrGameOver go = new WinOrGameOver(this); go.setNivel(x); go.addGameOver(2);go.show();
    }
    public void Ganhar(){
        int abertos = 0;
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
            if(x==14){nivel = "EASY";}else if(x==16){nivel = "MEDIUM";}else{nivel = "HARD";}
            sc = new ScoreCM(scoreFat[0],scoreFat[1],scoreFat[2]); 
            sc.setNivel(x);sc.scoreRankingCM();
            user.setMoedas(sc.scoreMoedaCM());
            sc.gravar();//Grava, sequencia com o método leitura e grava de novo.
            Conta c = new Conta(user);
            c.gravar();
            WinOrGameOver w = new WinOrGameOver(this); w.setNivel(x); w.addWin(2);w.show();
        }
        abertos = 0;
    }
    
    public int[] calcScore(){
        int p = 0; int m = 0;
        for(int i = 0; i<x; i++){
            for(int j = 0; j<y; j++){
                switch(m5[i][j]){
                    case 1: p++; break;
                    case 3: m++; break;
                    default: break;
                }
            }
        }
        
        int t = Integer.parseInt(lbminutos.getText())*60+Integer.parseInt(lbsegundos.getText());
        scoreFat[0] = p; scoreFat[1] = t; scoreFat[2] = m;
        return scoreFat;
    }
    
    public ScoreCM sc;
    public int scoreFat[] = new int[3];
    public boolean press = false; public boolean GO = false; public boolean win = false;
    public int iniciarJogo = 0; public int marc[][]; public int[][] m4;
    public ImageIcon minas = im.addImagem("bomb_cm_easy"); public ImageIcon marcador = im.addImagem("flagF");
    public ImageIcon botao = im.addImagem("btn_cm_easy"); 
    public ImageIcon botao_p = im.addImagem("btn_cm_easy_t");
    public ImageIcon botao_t = im.addImagem("btn_cm_easy_p");
    public Font btn = f.addNewFont("DS-DIGIT", 20);
    
    private class Button extends Btn{
        private String s; private int x; private int y;
        private Troca t = new Troca();
        
        public Button(String s, int x, int y) {
            super();
            setIcon(botao);
            setPressedIcon(botao_p);
            setRolloverIcon(botao_t);
            setBackground(Color.black);setFont(btn);
            this.s = s; //Evento do botão (tipo)
            this.x = x; this.y = y;//Posição do btn em relação a matriz
            addMouseListener(t);
        }
        public String getS(){return s;}
        public void btnsAbertos(String s) {
            scoreFat = calcScore();
            /*Se press==false, significa que nem uma mina foi clicada, caso contrário, ela foi acionada. Mas quando essa variável assume
              o valor true, não se consegue mais entrar nos ifs após a condição inicial, então quando o método GameOver for chamado, não
              poderá abrir as outras posições devido esta condição inicial. Por isso é necessário esta variável GO, onde quando uma mina
              é acionada e chama o método GameOver, este atribui o valor true para a variável GO, fazendo com que quando este método chamar
              o método btnsAbertos seja possível abrir o campo.*/
            if(press==false||GO==true){
                setPressedIcon(null); setRolloverIcon(null);
                if(marc[x][y]==1){
                    setIcon(marcador);
                    if(GO==false)m5[x][y] = 3;
                }else if(marc[x][y]==2){
                    if("-1".equals(s)) {
                        setIcon(minas);
                        if(GO==false)m5[x][y] = 2;
                        //Se win fosse true, sem essa condição, o código consideraria que o usuário perdeu e ganhou o jogo.
                        if(GO==false&&win==false){ //Caso win seja falso, significa que não ganhou-se o jogo.
                            press = true;GameOver();
                        }
                    }else if("0".equals(s)) {
                        setIcon(null);
                        if(GO==false)m5[x][y] = 1;
                    }else {
                        setIcon(null);setForeground(Color.white);setText(s);
                        if(GO==false)m5[x][y] = 1;
                    }
                    m4[x][y] = 1;
                }
                if(GO==false){Ganhar();}//Faz-se uma verificação a cada botão clicado.
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
                        if(marc[x][y]==1){setIcon(null);marc[x][y] = 0;setPressedIcon(botao_p);setIcon(botao);setRolloverIcon(botao_t);
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