package campominado;
import java.util.Random;

public class Campo {
    private int x;
    private int y;
    private int[][] m;
    private int[] posxM;
    private int[] posyM;
    private int[][] m3;
    private int bombs;
    boolean minas[][];
    public Campo(int x, int y) {
        this.x = x; this.y = y;
        m = new int[x][y];
        m3 = new int[x][y];
        for(int i = 0; i<x; i++) {
            for(int j = 0; j<y; j++) {
                m[i][j] = 0;m3[i][j] = 0;
            }
        }
        switch (x) {
            case 14:sortMinas(20);break;
            case 16:sortMinas(25);break;
            case 18:sortMinas(30);break;
            default:break;
        }
        orgNumeros();
    }
    
    public int getX(){return x;}
    public int getY(){return y;}
    public int[][] getM(){return m;}
    public int[][] getM3(){return m3;}
    public int[] getPosxM(){return posxM;}
    public int[] getPosyM(){return posyM;}
    public int getBombs(){return bombs;}
    
    /* Sorteia as minas, tomando cuidado para não repetir posições e ao final adicionando estes pares ordenados, o x em um vetor e o y em outro */
    public void sortMinas(int quant) {
        Random posM = new Random();
        int cont = 0; bombs = quant;
        posxM = new int[bombs] ;posyM = new int[bombs];
        for(int i = 0; i<bombs; i++){ //Pra o valor inicial ser diferente de qualquer posição da matriz
            posxM[i] = x; posyM[i] = y;
        }
        minas = new boolean[x][y];
        while(cont<bombs){
            int l = posM.nextInt(x); int c = posM.nextInt(y);
            for(int i = 0; i<bombs; i++) {
                if(l!=posxM[i]&&c!=posyM[i]){
                    if(posxM[i]==x&&posyM[i]==y&&minas[l][c]==false){
                        minas[l][c] = true;
                        posxM[i] = l; posyM[i] = c;
                        cont++;
                    }
                }
            }
        }
        for(int i = 0; i<bombs ; i++) {
            m[posxM[i]][posyM[i]] = -1;
        }

    }
    //Organiza os números encontrados
    public void orgNumeros() {
        for(int i = 0; i<x; i++) {
            for(int j = 0; j<y; j++) {
                if(posBomba(i, j)==false){ numeros(i, j);}
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
    public boolean posBomba(int l, int c) {if(m[l][c] == -1){return true;}return false;}
    //Verifica se a posição é um número
    public boolean posNumero(int l, int c){if(m[l][c]>0){return true;}return false;}
}