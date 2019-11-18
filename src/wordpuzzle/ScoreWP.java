package wordpuzzle;
public class ScoreWP {
    private int tempoSegundos;
    private int words;
    
    public ScoreWP(int tempoSegundos, int words){
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
}
