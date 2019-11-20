package wordpuzzle;

import padroes.Score;
public class ScoreWP extends Score{
    private int tempoSegundos;
    private int words;
    
    public ScoreWP(){setArq("wp");leitura();}
    public ScoreWP(int tempoSegundos, int words){
        this.tempoSegundos = tempoSegundos;
        this.words = words;setArq("wp");leitura();
    }
    
    public int scoreRankingWP(){
        int score = 110*words-4*tempoSegundos;
        if(score>0){
            switch (nivel) {
                case 14:rankingEasy.add(""+score);usersEasy.add(user.getUsername());break;
                case 16:rankingMedium.add(""+score);usersMedium.add(user.getUsername());break;
                default:rankingHard.add(""+score);usersHard.add(user.getUsername());break;
            }
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
