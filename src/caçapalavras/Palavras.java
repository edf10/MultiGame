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
    private final Random sortear = new Random();
    private final ArrayList<String[]> words = new ArrayList<String[]>(); //Pavras do arquivo txt
    private final String[] alfabeto = {"A","B","C","D","E","F","G","H","I","J","K","L","M",
                                       "N","O","P","Q","R","S","T","U","V","W","X","Y","Z",};
    private ArrayList<String[]> mapawords = new ArrayList<String[]>(); //Mapear palavras na tela, para que não sejam repetidas.
    private int x, y;
    private int quantWords;
    private String[][] m; //Matriz de letras
    private String[][] m2; //Mapear palavras
    private int[][] m3; //Posições onde a String não pode ser alterada.
    
    public Palavras(int n){
        niveis(n);
        m = new String[x][y];
        m2 = new String[x][y];
        //addWord(4, 1, words.get(2));
        escWords();
        //letras();
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                System.out.print("|"+m2[i][j]+"|");
            }
            System.out.println();
        }
        for(int i = 0; i<mapawords.size(); i++){
            System.out.println(Arrays.toString(mapawords.get(i)));
        }
    }
    
    public void escWords(){
        while(mapawords.size()<quantWords){
            int orien = sortear.nextInt(4)+1;
            int invertida = sortear.nextInt(2)+1;
            int w = sortear.nextInt(words.size());
            if(words.get(w).length<x){
                if(mapawords.contains(words.get(w))==false){
                    boolean conf = addWord(orien, invertida, words.get(w));
                    if(conf){mapawords.add(words.get(w));}
                }
            }
        }
    }
    
    public boolean addWord(int orientacao, int invertida, String[] palavra){
        int tamWord = palavra.length;
        int linha = 0, coluna = 0;
        boolean ok = true;
        int cont = (invertida==1)?0:palavra.length-1; 
        ok = true; int contWordCr = 0; boolean tudocerto = false;
        if(orientacao==1){
            linha = sortear.nextInt(x);
            coluna = lineAndColumn(tamWord);
            int i = linha; int j = coluna;
            while(ok==true){
                if(j==coluna+palavra.length){break;}
                if(m[i][j]==null||m[i][j].equals(palavra[cont].toUpperCase())){
                    contWordCr++;
                }else{ok = false;}
                if(contWordCr==tamWord){tudocerto = true; j = coluna; continue;}
                if(tudocerto==true){
                    m2[i][j] = palavra[cont].toUpperCase();
                    m[i][j] = palavra[cont].toUpperCase();
                    if(invertida==1){cont++;}else{cont--;}
                }
                j++;
            }
        }else if(orientacao==2){
            linha = lineAndColumn(tamWord);
            coluna = sortear.nextInt(x);
            int i = linha; int j = coluna;
            while(ok==true){
                if(i==linha+palavra.length){break;}
                if(m[i][j]==null||m[i][j].equals(palavra[cont].toUpperCase())){
                    contWordCr++;
                }else{ok = false;}
                if(contWordCr==tamWord){tudocerto = true; i = linha; continue;}
                if(tudocerto==true){
                    m2[i][coluna] = palavra[cont].toUpperCase();
                    m[i][coluna] = palavra[cont].toUpperCase();
                    if(invertida==1){cont++;}else{cont--;}
                }
                i++;
            }
        }else if(orientacao==3){
            linha = lineAndColumn(tamWord);
            coluna = lineAndColumn(tamWord);
            int i = linha;int j = coluna;
            while(ok==true){
                if(i==linha+tamWord){break;}
                if(m[i][j]==null||m[i][j].equals(palavra[cont].toUpperCase())){
                    contWordCr++;
                }else{ok = false;}
                if(contWordCr==tamWord){tudocerto = true; i = linha; j = coluna; continue;}
                if(tudocerto==true){
                    m2[i][j] = palavra[cont].toUpperCase();
                    m[i][j] = palavra[cont].toUpperCase();
                    if(invertida==1){cont++;}else{cont--;}
                }
                i++;j++;
            }
        }else if(orientacao==4){
            linha = lineAndColumn(tamWord);coluna = linha+tamWord-1;
            int i = linha; int j = coluna;
            while(ok==true){
                if(i==linha+tamWord){break;}
                if(m[i][j]==null||m[i][j].equals(palavra[cont].toUpperCase())){
                   contWordCr++;
                }else{ok = false;}
                if(contWordCr==tamWord){tudocerto = true; i = linha; j = coluna; continue;}
                if(tudocerto==true){
                    m2[i][j] = palavra[cont].toUpperCase();
                    m[i][j] = palavra[cont].toUpperCase();
                    if(invertida==1){cont++;}else{cont--;}
                }
                i++;j--;
            }
        }
        if(ok){return true;}else{return false;}
    }
    
    public int lineAndColumn(int tamWord){
        while(true){
            int sorteado = sortear.nextInt(x);
            if(sorteado+tamWord-1<x){
                return sorteado;
            }
        }
    }
    private void niveis(int n){
        switch(n){
            case 1: x = y = 10; quantWords = 6; break;
            case 2: x = y = 14; quantWords = 8; break;
            case 3: x = y = 16; quantWords = 10; break;
            default: break;
        }
        arqGet();
    }
    public void arqGet(){ //Pegar palavras do arquivo txt.
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
    public void letras(){
        for(int i = 0; i<x ; i++){
            for(int j = 0; j<y; j++){
                if(m[i][j]==null){m[i][j] = alfabeto[sortear.nextInt(8)];}
            }
        }
    }
    public String getM(int i, int j) {
        return m[i][j];
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public String[][] getM2() {
        return m2;
    }
}
