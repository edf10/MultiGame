package wordpuzzle;
import java.util.ArrayList;
public class Palavra {
    private int orientacao;
    private boolean invertida;
    private String[] letras;
    private ArrayList<int[]> pos;
    
    public Palavra(String[] letras, int orientacao, boolean invertida){
        this.letras = letras;
        this.orientacao = orientacao;
        this.invertida = invertida;
        pos = new ArrayList<int[]>();
    }
    public String getPalavra(){
        String p  = "";
        for(int i = 0; i<letras.length; i++){
            p += letras[i];
        }
        return p;
    }
    public int quantLetras(){
        return letras.length;
    }
    public void addPosLetra(int x, int y){
        int p[] = {x,y};
        pos.add(p);
    }
    public int getOrientacao() {
        return orientacao;
    }
    public void setOrientacao(int orientacao) {
        this.orientacao = orientacao;
    }
    public boolean isInvertida() {
        return invertida;
    }
    public void setInvertida(boolean invertida) {
        this.invertida = invertida;
    }
    public String[] getLetras() {
        return letras;
    }
    public void setLetras(String[] letras) {
        this.letras = letras;
    }
    public ArrayList<int[]> getPos() {
        return pos;
    }
    public void setPos(ArrayList<int[]> pos) {
        this.pos = pos;
    }
}
