package caçapalavras;
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
    private int x, y;
    private String[][] m; //Matriz de letras
    private int[][] m2; //Mapear palavras
    
    public Palavras(int n){
        niveis(n);
        m = new String[x][y];
        m2 = new int[x][y];
        letras();
        colocarWord(1, 1, words.get(0));
        colocarWord(2, 2, words.get(1));
        colocarWord(1, 2, words.get(2));
        colocarWord(1, 2, words.get(3));
        colocarWord(2, 1, words.get(4));
        colocarWord(1, 1, words.get(5));
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(m2[i][j]);
            }
            System.out.println();
        }
    }
    
    private void niveis(int n){
        switch(n){
            case 1: x = y = 8; break;
            case 2: x = y = 10; break;
            case 3: x = y = 12; break;
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
    public void colocarWord(int orientacao, int ordem, String[] palavra){
        int linha = 0,coluna = 0, tamWord, cont = 0;
        boolean inverter; boolean stop = false;
        if(orientacao==1){ //Horizontais
            while(!stop){
                cont = 0;
                linha = sortear.nextInt(x);
                coluna = sortLC(palavra.length);
                for(int i = coluna; i<coluna+palavra.length; i++){
                    if(m2[linha][i]!=1){
                        cont++;
                    }
                    if(cont==palavra.length){
                        stop = true;
                    }
                }
            }
            tamWord = (ordem==1) ? 0:palavra.length-1; inverter = (ordem != 1);
            for(int j = coluna; j<coluna+palavra.length; j++){
                m2[linha][j] = 1;
                m[linha][j] = palavra[tamWord].toUpperCase();
                if(!inverter){tamWord++;}else{tamWord--;}
            }
        }else if(orientacao==2){ //Verticais
            while(!stop){
                cont = 0;
                coluna = sortear.nextInt(x);
                linha = sortLC(palavra.length);
                for(int i = linha; i<linha+palavra.length; i++){
                    if(m2[i][coluna]!=1){
                        cont++;
                    }
                    if(cont==palavra.length){
                        stop = true;
                    }
                    
                }
            }
            tamWord = (ordem==1) ? 0:palavra.length-1; inverter = (ordem != 1);
            for(int j = linha; j<linha+palavra.length; j++){
                m2[j][coluna] = 1;
                m[j][coluna] = palavra[tamWord].toUpperCase();
                if(!inverter){tamWord++;}else{tamWord--;}
            }
        }
        
    }
    
    public int sortLC(int tamWord){ //sortear linha ou coluna ou os dois
        int pos;
        while(true){
            int sorteado = sortear.nextInt(x);
            if(sorteado+tamWord<x){pos = sorteado;break;}
        }
        return pos;
    }

    public String[] sortWord(){
        return words.get(sortear.nextInt(words.size()));
    }
    
    public void letras(){
        for(int i = 0; i<x ; i++){
            for(int j = 0; j<y; j++){
                m[i][j] = alfabeto[sortear.nextInt(8)];
            }
        }
    }
    public String getM(int i, int j) {
        return m[i][j];
    }
}
