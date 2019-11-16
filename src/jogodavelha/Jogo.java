package jogodavelha;
import java.util.Random;
import user.Conta;
import user.User;
public class Jogo {
    
    private int m[][];
    private final Random sortear = new Random();
    private int x;
    private int y;
    private boolean velha;
    
    public Jogo(){
        x = y = 3;
        this.m = new int[x][y];
    }
    
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
    public void addPress(int x, int y, int ic){
        m[x][y] = ic;
    }
    public void ganhar(User user1, User user2){
        System.out.println("oi");
        Conta c1 = new Conta(user1); Conta c2 = new Conta(user2); 
        int m2[][][] = {{{0,0},{1,0},{2,0}},{{0,0},{0,1},{0,2}},{{0,0},{1,1},{2,2}},{{0,1},{1,1},{2,1}},
                        {{1,0},{1,1},{1,2}},{{0,2},{1,1},{2,0}},{{0,2},{1,2},{2,2}},{{2,0},{2,1},{2,2}}};
        for(int i = 0; i<8; i++){
            if(m[m2[i][0][0]][m2[i][0][1]]==1&&m[m2[i][1][0]][m2[i][1][1]]==1&&m[m2[i][2][0]][m2[i][2][1]]==1){
                user1.addPartidaJDV("Win", user2.getUsername()); user2.addPartidaJDV("GameOver", user1.getUsername());
                c1.gravar(); c2.gravar();
            }
            if(m[m2[i][0][0]][m2[i][0][1]]==2&&m[m2[i][1][0]][m2[i][1][1]]==2&&m[m2[i][2][0]][m2[i][2][1]]==2){
                user2.addPartidaJDV("Win", user1.getUsername()); user1.addPartidaJDV("GameOver", user2.getUsername());
                c1.gravar(); c2.gravar();
            }
        }
        velha(user1,user2);
    }
    
    public void velha(User user1, User user2){
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
            user1.addPartidaJDV("Empate", user2.getUsername()); user2.addPartidaJDV("Empate", user1.getUsername());
            Conta c1 = new Conta(user1); Conta c2 = new Conta(user2); 
            c1.gravar(); c2.gravar();
        }
    }
    
    public int[] addQuestion(){
        int nums[] = {sortear.nextInt(11),sortear.nextInt(11)};
        return nums;
    }
    public int[] addDivision(){
        int nums[] = {sortear.nextInt(11),sortear.nextInt(11)};
        while(true){
            if(nums[0]%nums[1]==0){
                break;
            }
            nums[0] = sortear.nextInt(11);
            nums[1] = sortear.nextInt(10)+1;
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
