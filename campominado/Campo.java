package campominado;
import java.util.Random;

public class Campo {
    private int x;
    private int y;
    private int[][] m = new int[x][y];
    private int[] posxM = new int[x];
    private int[] posyM = new int[x];
    private int[][] m3 = new int[x][y];
    
    //Construct
    public Campo(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    /* Getters */
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public int[][] getM(){
        return m;
    }
    public int[][] getM3(){
        return m3;
    }
    public int[] getPosxM(){
        return posxM;
    }
    public int[] getPosyM(){
        return posyM;
    }
    /* -------- */
    
    //Zerar e configurar váriaveis
    protected void declararVars() {
        m = new int[x][y];
        posxM = new int[x];
        posyM = new int[y];
        m3 = new int[x][y];
        for(int i = 0; i<x; i++) {
            for(int j = 0; j<y; j++) {
                m[i][j] = 0;
            }
            posxM[i] = 0;
            posyM[i] = 0;
        }
        for(int i = 0; i<x; i++) {
            for(int j = 0; j<y; j++) {
                m3[i][j] = 0;
            }
        }
    }
    
    //Retorna cada posição da matriz do campo, com um controle para não repetir posições.
    protected String Click() {
        String s = "";
        for(int i = 0; i<x; i++) {
            for(int j = 0; j<y; j++) {
                if(m3[i][j]!=-2) {
                    if(m[i][j]==-1) {
                        m3[i][j] = -2;
                        s = "-1";
                        return s;
                    }else if(m[i][j]>0) {
                        m3[i][j] = -2;
                        s = ""+m[i][j];
                        return s;
                    }else {
                        m3[i][j] = -2;
                        s = "0";
                        return s;
                    }
                }
            }
        }
       
        return "";
    }

    /* Sorteia as minas, tomando cuidado para não repetir posições e ao final adicionando estes pares ordenados, o x em um vetor e o y em outro */
    public void sortMinas() {
        Random posM = new Random();
        int cont = 0;
        boolean igual = false;
        boolean conf = false;
        while(cont<x){
            for(int i = 0; i<x; i++) {
                conf = false;
                igual = false;
                int l = posM.nextInt(x);
                int c = posM.nextInt(x);
                for(int k = 0; k<x; k++){
                    if (posxM[k]==l&&posyM[k]==c) {
                        igual = true;
                        continue;
                    }
                }
                if(posxM[i]==0&&posyM[i]==0&&igual==false) {
                    posxM[i] = l;
                    posyM[i] = c;
                    conf = true;
                    cont++;
                }
            }
        }
        for(int i = 0; i<x ; i++) {
            m[posxM[i]][posyM[i]] = -1;
        }

    }
    
    //Organiza os números encontrados
    public void orgNumeros() {
        for(int i = 0; i<x; i++) {
            for(int j = 0; j<y; j++) {
                if(posBomba(i, j)==false) {
                    numeros(i, j);
                }
            }
        }
    }
    
    //Encontra os números e armazena na matriz.
    private void numeros(int l, int c) {
        int[][] maux = {{l+1, c+1},{l-1, c-1},{l+1, c-1},{l-1, c+1},{l, c+1},{l, c-1},{l+1, c},{l-1, c}};
        int cont = 0;
        for(int i = 0; i<8; i++) {
            if(maux[i][0]<x&&maux[i][0]>-1&&maux[i][1]<x&&maux[i][1]>-1) {
                if(m[maux[i][0]][maux[i][1]] == -1) {
                    cont++;
                }
            }
        }
        if(cont>0) {
            m[l][c] = cont;
        }
    }
    
    //Verifica se a posição é uma bomba
    public boolean posBomba(int l, int c) {
        if(m[l][c] == -1) {
            return true;
        }
        return false;
    }
    
    //Verifica se a posição é um número
    public boolean posNumero(int l, int c){
        if(m[l][c]>0){
            return true;
        }
        return false;
    }
    
    //Verifica se a posição é um vazio
    public boolean posVazio(int l, int c){
        if(m[l][c]==0){
            return true;
        }
        return false;
    }
}


