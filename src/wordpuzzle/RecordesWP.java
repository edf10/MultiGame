package wordpuzzle;

import javax.swing.ImageIcon;
import padroes.Recordes;

public class RecordesWP extends Recordes{
    private ImageIcon ims[][] = {{im.addImagem("btn_easy_wp"),im.addImagem("btn_easy_wp_t"),im.addImagem("btn_easy_wp_p")},
                                 {im.addImagem("btn_medium_wp"),im.addImagem("btn_medium_wp_t"),im.addImagem("btn_medium_wp_p")},
                                 {im.addImagem("btn_hard_wp"),im.addImagem("btn_hard_wp_t"),im.addImagem("btn_hard_wp_p")},
                                 {im.addImagem("back_intro_wp")},
                                 {im.addImagem("barras_ranking_wp")},
                                 {im.addImagem("back_ranking_wp")}};
    
    public RecordesWP(){
        super();
        s = new ScoreWP();
        decVars();
        it.setTelaAntIntro(3);
        setIms(ims);
    }
    
    public void initial(){
        escRankingNivel(); show();
    }
    
}
