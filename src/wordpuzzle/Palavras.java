package wordpuzzle;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
    private ArrayList<Palavra> palavras = new ArrayList<Palavra>();
    
    public Palavras(int n){
        niveis(n);
        m = new String[x][y];
        m2 = new String[x][y];
        escWords();
        letras();
    }
    
    public void escWords(){
        while(mapawords.size()<quantWords){
            int orien = sortear.nextInt(4)+1;
            boolean invertida = sortear.nextBoolean();
            int w = sortear.nextInt(words.size());
            if(words.get(w).length<x){
                if(mapawords.contains(words.get(w))==false){
                    boolean conf = addW(new Palavra(words.get(w), orien, invertida));
                    if(conf){mapawords.add(words.get(w));}
                }
            }
        }
        
    }
    
    public boolean addW(Palavra p){
        int linha = 0; int coluna = 0; 
        int cont = (p.isInvertida())?0:p.quantLetras()-1;
        int contWordCr = 0; boolean tudocerto = false;
        switch(p.getOrientacao()){
            case 1: linha = sortear.nextInt(x); coluna = lineAndColumn(p.quantLetras()); break;
            case 2: linha = lineAndColumn(p.quantLetras()); coluna = sortear.nextInt(x); break;
            case 3: linha = lineAndColumn(p.quantLetras()); coluna = lineAndColumn(p.quantLetras()); break;
            case 4: linha = lineAndColumn(p.quantLetras());coluna = linha+p.quantLetras()-1; break;
            default: break;
        }
        int i = linha; int j = coluna;
        while(true){
            if(p.getOrientacao()==1){if(j==coluna+p.quantLetras()&&tudocerto){break;}}else{if(i==linha+p.quantLetras()&&tudocerto){break;}}
            if(i==linha+p.quantLetras()||j==coluna+p.quantLetras()&&tudocerto==false){
                i = linha; j = coluna;
                if(cont==p.quantLetras()){cont = (p.isInvertida())?0:p.quantLetras()-1;}
                if(p.isInvertida()){cont++;}else{cont--;}
            }
            if(m[i][j]==null||m[i][j].equals(p.getLetras()[cont].toUpperCase())){
                contWordCr++;
            }else{return false;}
            
            if(contWordCr==p.quantLetras()*p.quantLetras()){tudocerto = true; i = linha; j = coluna; cont = (p.isInvertida())?0:p.quantLetras()-1;}
            if(tudocerto==true){
                m2[i][j] = p.getLetras()[cont].toUpperCase();
                m[i][j] = p.getLetras()[cont].toUpperCase();
                p.addPosLetra(i, j);
                if(p.isInvertida()){cont++;}else{cont--;}
            }
            switch(p.getOrientacao()){
                case 1: j++; break;
                case 2: i++; break;
                case 3: i++;j++; break;
                case 4: i++;j--; break;
                default: break;
            }
        }
        palavras.add(p);
        return true;
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
            case 1: x = y = 14; quantWords = 1; break;
            case 2: x = y = 16; quantWords = 14; break;
            case 3: x = y = 18; quantWords = 16; break;
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
    public ArrayList<Palavra> getPalavras() {
        return palavras;
    }
}
