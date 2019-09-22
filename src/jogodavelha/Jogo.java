package jogodavelha;
import java.util.Random;
public class Jogo {
    
    private int m[][];
    //tamanho da matriz
    private String jog1;
    private String jog2;
    //True=X and False=O
    private boolean icJog1;
    private boolean icJog2;
    private final Random gVez = new Random();
    private int x;
    private int y;
    
    public Jogo(){}

    public String getJog1(){return jog1;}
    public void setJog1(String jog1){this.jog1 = jog1;}
    public String getJog2(){return jog2;}
    public void setJog2(String jog2){this.jog2 = jog2;}
    public boolean isIcJog1(){return icJog1;}
    public void setIcJog1(boolean icJog1){this.icJog1 = icJog1;}
    public boolean isIcJog2(){return icJog2;}
    public void setIcJog2(boolean icJog2){this.icJog2 = icJog2;}
    public void setM(int m[][]){this.m = m;}
    public int getX(){return x;}
    public void setX(int x){this.x = x;}
    public int getY(){return y;}
    public void setY(int y){this.y = y;}
    
    public int sortVez(){
        return gVez.nextInt(2)+1; //Varia de acordo com o ícone
    }
    public void defIc(boolean icJog1, boolean icJog2){
        this.icJog1 = icJog1;
        this.icJog2 = icJog2;
    }
    public void addPress(int x, int y, int ic){
        m[x][y] = ic;
        System.out.println("");
        System.out.println("");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("|"+m[i][j]+"|"+" ");
            }
            System.out.println("");
        }
    }
    
    public void ganhar(){
        int m2[][][] = {{{0,0},{1,0},{2,0}},{{0,0},{0,1},{0,2}},{{0,0},{1,1},{2,2}},{{0,1},{1,1},{2,1}},
                        {{1,0},{1,1},{1,2}},{{0,2},{1,1},{2,0}},{{0,2},{1,2},{2,2}},{{2,0},{2,1},{2,2}}};
        for(int i = 0; i<8; i++){
            if(m[m2[i][0][0]][m2[i][0][1]]==1&&m[m2[i][1][0]][m2[i][1][1]]==1&&m[m2[i][2][0]][m2[i][2][1]]==1){
                System.out.println("Ganhou 01");
            }
            if(m[m2[i][0][0]][m2[i][0][1]]==2&&m[m2[i][1][0]][m2[i][1][1]]==2&&m[m2[i][2][0]][m2[i][2][1]]==2){
                System.out.println("Ganhou 02");
            }
        }
    }
    
    public void jdvClassic(){
        x = y = 3;
        this.m = new int[x][y];
    }
}
