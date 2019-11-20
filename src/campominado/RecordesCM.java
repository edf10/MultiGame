package campominado;

import javax.swing.ImageIcon;
import padroes.Recordes;
public class RecordesCM extends Recordes{
    
    private ImageIcon[][] ims = {{im.addImagem("btn_easy_cm"),im.addImagem("btn_easy_cm_t"),im.addImagem("btn_easy_cm_p")},
                                   {im.addImagem("btn_medium_cm"),im.addImagem("btn_medium_cm_t"),im.addImagem("btn_medium_cm_p")},
                                   {im.addImagem("btn_hard_cm"),im.addImagem("btn_hard_cm_t"),im.addImagem("btn_hard_cm_p")},
                                   {im.addImagem("back_intro_cm")},
                                   {im.addImagem("barras_ranking_cm")},
                                   {im.addImagem("back_ranking_cm")}};

    public RecordesCM(){
        super();
        s = new ScoreCM();
        decVars();
        it.setTelaAntIntro(1);
        setIms(ims);
    }
    public void initial(){
        escRankingNivel(); show();
    }
    
}
