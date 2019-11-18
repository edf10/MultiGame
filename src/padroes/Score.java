package padroes;
public class Score {
    private int minasNivel;
    private int posOpen; //campos diferentes de minas que estejam abertos
    private int tempoSegundos;
    private int words;
    
    public Score(int tempoSegundos, int words){
        this.tempoSegundos = tempoSegundos;
        this.words = words;
    }
    
    public int scoreRankingWP(){
        int score = 110*words-4*tempoSegundos;
        if(score>0){
            return score;
        }else{
            return 0;
        }
    }
    
    public int scoreMoedasWP(){
        int moedas = 60*words-4*tempoSegundos;
        if(moedas>0){
            return moedas;
        }else{
            return 0;
        }
    }
    
    public Score(int posOpen, int tempoSegundos, int minasNivel){
        this.posOpen = posOpen;
        this.tempoSegundos = tempoSegundos;
        this.minasNivel = minasNivel;
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
        int moedas = 3*posOpen+3*minasNivel-4*tempoSegundos;
        if(moedas>0){
            return moedas;
        }else{
            return 0;
        }
    }
}
