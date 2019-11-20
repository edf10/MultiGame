package campominado;
import padroes.Score;
public class ScoreCM extends Score{
    private int minasNivel;
    private int posOpen; //campos diferentes de minas que estejam abertos
    private int tempoSegundos;
    public ScoreCM(){setArq("cm");leitura();}
    public ScoreCM(int posOpen, int tempoSegundos, int minasNivel){
        this.posOpen = posOpen;
        this.tempoSegundos = tempoSegundos;
        this.minasNivel = minasNivel;
        setArq("cm");leitura();
    }
    public int scoreRankingCM(){
        int score = 30*posOpen+30*minasNivel-40*tempoSegundos;
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
    public int scoreMoedaCM(){
        int moedas = 3*posOpen+3*minasNivel-4*tempoSegundos;
        if(moedas>0){
            return moedas;
        }else{
            return 0;
        }
    }
}
