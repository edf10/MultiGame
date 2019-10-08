package caçapalavras;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
public class Palavras {
    private Random embaralhar = new Random();
    private ArrayList<String[]> words = new ArrayList<String[]>();
    private final String[] alfabeto = {"A","B","C","D","E","F","G","H","I","J","K","L","M",
                                 "N","O","P","Q","R","S","T","U","V","W","X","Y","Z",};
    private int x, y = 8;
    private String[][] m;
    private int[][] m2; //Mapear palavras
    
    public void getPalvras(){
        try{
            FileInputStream f = new FileInputStream("questions/caçapalavras/words.txt");
            InputStreamReader i = new InputStreamReader(f);
            BufferedReader b = new BufferedReader(i);
            String linha;
            while((linha = b.readLine())!=null){
                String[] p = linha.split("");
                      
                words.add(p);
            }
            b.close();
            f.close();
        }catch(FileNotFoundException e){}catch(IOException e){}
    }
    
    public Palavras(){
        getPalvras();
        words();
        colocarWords(1,0);
        colocarWords(2,1);
        colocarWords(1,2);
        colocarWords(1,3);
        colocarWords(1,4);
        colocarWords(1,5);
        
    }
    
    public void colocarWords(int n, int w){
        int linha;
        int coluna = 0;
        String[] word = words.get(w);
        boolean ter = false;
        if(n==1){
            while(!ter){
                System.out.println("1");
                linha = embaralhar.nextInt(8);
                while(true){
                    int sort = embaralhar.nextInt(8);
                    if(sort+word.length<m.length){
                        coluna = sort;break;
                    }
                }
                int letra = 0; boolean ok = false;
                for(int i = linha; i<=linha; i++){
                    for(int j = coluna; j<coluna+word.length; j++){
                        if(m2[i][j]==1){
                            ok = true;
                        }
                    }
                }
                if(!ok){
                    for(int i = linha; i<=linha; i++){
                        for(int j = coluna; j<coluna+word.length; j++){
                            m[i][j] = word[letra].toUpperCase();
                            m2[i][j] = 1; 
                            if(letra<word.length){
                                letra++;
                            }
                            if(j==linha+word.length-1){
                                ter = true;
                            }
                        }
                    }
                }
                
            }
        }else if(n==2){
            while(!ter){
                System.out.println("ok");
                coluna = embaralhar.nextInt(8);
                while(true){
                    int sort = embaralhar.nextInt(8);
                    if(sort+word.length<m.length){
                        linha = sort;break;
                    }
                }
                int letra = 0;
                for(int i = coluna; i<=coluna; i++){
                    for(int j = linha; j<linha+word.length; j++){
                        System.out.println("tes");
                        if(m2[j][i]==1){
                            break;
                        }else{
                            m[j][i] = word[letra].toUpperCase();
                            m2[j][i] = 1; 
                            if(letra<word.length){
                                letra++;
                            }
                            if(j==linha+word.length-1){
                                ter = true;
                            }
                        }
                    }
                }
            }
        }else if(n==3){
            
        }
    }
    
    public void words(){
        m = new String[8][8];
        m2 = new int[8][8];
        for(int i = 0; i<8 ; i++){
            for(int j = 0; j<8; j++){
                m[i][j] = alfabeto[embaralhar.nextInt(8)];
                m2[i][j] = 0;
            }
        }
    }
    public String getM(int i, int j) {
        return m[i][j];
    }
}
