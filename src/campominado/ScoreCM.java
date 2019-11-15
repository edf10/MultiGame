package campominado;
public class ScoreCM {
    private final int minasNivel;
    private final int posOpen; //campos diferentes de minas que estejam abertos
    private final int tempoSegundos;
    private int scoreCM;
    
    public ScoreCM(int posOpen, int tempoSegundos, int minasNivel){
        this.posOpen = posOpen;
        this.tempoSegundos = tempoSegundos;
        this.minasNivel = minasNivel;
    }
    public int getScoreCM() {
        return scoreCM;
    }
    public int scoreRankingCM(){
        int score = 30*posOpen+30*minasNivel-40*tempoSegundos;
        if(score>0){
            return score;
        }else{
            return 0;
        }
    }
    
    public int scoreMoedaCM(){
        int score = 3*posOpen+3*minasNivel-4*tempoSegundos;
        if(score>0){
            return score;
        }else{
            return 0;
        }
    }

    public int getMinasNivel() {
        return minasNivel;
    }
    public int getTempoSegundos() {
        return tempoSegundos;
    }
    public int getPosOpen() {
        return posOpen;
    }
    
}
