package caçapalavras;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;
public class Palavras {
    private Random embaralhar = new Random();
    private ArrayList<String[]> words = new ArrayList<String[]>();
    private final char[] alfabeto = {'A','B','C','D','E','F','G','H','I','J','K','L','M',
                                 'N','O','P','Q','R','S','T','U','V','W','X','Y','Z',};
    private int x, y = 8;
    private char[][] m;
    
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
        words();
    }
    
    public void colocarWords(){
        
    }
    
    public void words(){
        m = new char[8][8];
        for(int i = 0; i<8 ; i++){
            for(int j = 0; j<8; j++){
                m[i][j] = alfabeto[embaralhar.nextInt(8)];
            }
        }
    }
    public char getM(int i, int j) {
        return m[i][j];
    }
}
