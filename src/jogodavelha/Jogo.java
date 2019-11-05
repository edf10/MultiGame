package jogodavelha;
import java.util.Random;
public class Jogo {
    
    private int m[][];
    private boolean icJog1;
    private boolean icJog2;
    private final Random sortear = new Random();
    private int x;
    private int y;
    private boolean velha;
    private String jog1;
    private String jog2;
    
    public void setJog1(String jog1) {this.jog1 = jog1;}
    public void setJog2(String jog2) {this.jog2 = jog2;}
    public boolean isIcJog1(){return icJog1;}
    public void setIcJog1(boolean icJog1){this.icJog1 = icJog1;}
    public boolean isIcJog2(){return icJog2;}
    public void setIcJog2(boolean icJog2){this.icJog2 = icJog2;}
    public void setM(int m[][]){this.m = m;}
    public int getX(){return x;}
    public void setX(int x){this.x = x;}
    public int getY(){return y;}
    public void setY(int y){this.y = y;}
    public boolean isVelha(){return velha;}
    public void setVelha(boolean velha){this.velha = velha;}
    
    public int sortVez(){
        return sortear.nextInt(2)+1; //Varia de acordo com o ícone
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
            }
            if(m[m2[i][0][0]][m2[i][0][1]]==2&&m[m2[i][1][0]][m2[i][1][1]]==2&&m[m2[i][2][0]][m2[i][2][1]]==2){
            }
        }
        velha();
    }
    
    public void velha(){
        int cont = 0;
        for(int i = 0; i<x; i++){
            for(int j = 0; j<y; j++){
                if(m[i][j]!=0){
                    cont++;
                }
            }
        }
        if(cont==x*y){
            velha = true;
            //TelaGOWin tgw = new TelaGOWin("Velha",jdv);
        }
    }
    
    public void jdvClassic(){
        x = y = 3;
        this.m = new int[x][y];
    }
    
    public int[] addQuestion(){
        int nums[] = {sortear.nextInt(11),sortear.nextInt(11)};
        return nums;
    }
    public int[] addDivision(){
        int nums[] = {sortear.nextInt(101),sortear.nextInt(101)};
        while(true){
            if(nums[0]%nums[1]==0){
                break;
            }
            nums[0] = sortear.nextInt(11);
            nums[1] = sortear.nextInt(11);
        }
        return nums;
    }
    public int addAnswer(int a, int b, int operacao){
        switch(operacao){
            case 1:return a+b;
            case 2:return a/b;
            case 3:return a-b;
            case 4:return a*b;
            default:return 0;
        }
    }
    
    
}
