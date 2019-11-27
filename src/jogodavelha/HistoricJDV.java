package jogodavelha;

import componentes.Frame;
import componentes.Lb;
import componentes.Pn;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import padroes.Fonts;
import padroes.ItemsTela;
import user.User;

public class HistoricJDV extends Frame{
    //As 10 últimas partidas realizadas pelo usuário.
    private Pn pnUsers;
    private Pn pnAss;
    private Pn pnRes;
    private ItemsTela it = new ItemsTela();
    private User user = User.getUser();
    
    public HistoricJDV(){
        it.setTelaAntIntro(2);
        tabela();show();
    }
    
    public void tabela(){
        GridLayout col = new GridLayout(10,1);
        int pnUsersPos[] = {100,207,332,442}; int pnAssPos[] = {436,207,329,442}; int pnResPos[] = {768,207,332,442};
        
        pnUsers = new Pn(pnUsersPos, col);
        pnAss = new Pn(pnAssPos, col);
        pnRes = new Pn(pnResPos, col);
        
        pnUsers.setBackground(new Color(59,57,57));
        pnAss.setBackground(new Color(59,57,57));
        pnRes.setBackground(new Color(59,57,57));
        
        Fonts fs = new Fonts(); Font f = fs.addNewFont("DS-DIGIT", 30);
        if(user.getHistoricJDV().size()>10){
            for(int i = user.getHistoricJDV().size()-1; i>user.getHistoricJDV().size()-11; i--){
                pnUsers.add(new Lb(user.getHistoricJDV().get(i).get(0),f,Color.white));
                pnAss.add(new Lb(user.getHistoricJDV().get(i).get(2),f,Color.white));
                pnRes.add(new Lb(user.getHistoricJDV().get(i).get(1),f,Color.white));
            } 
        }else{
            for(int i = user.getHistoricJDV().size()-1; i>=0; i--){
                pnUsers.add(new Lb(user.getHistoricJDV().get(i).get(0),f,Color.white));
                pnAss.add(new Lb(user.getHistoricJDV().get(i).get(2),f,Color.white));
                pnRes.add(new Lb(user.getHistoricJDV().get(i).get(1),f,Color.white));
            }
        }
        for(int i = user.getHistoricJDV().size(); i<10; i++){
            pnUsers.add(new Lb("-",f,Color.white));
            pnAss.add(new Lb("-",f,Color.white));
            pnRes.add(new Lb("-",f,Color.white));
        }
        add(it.btnClose()); add(it.returnGames(this)); int backPos[] = {0,0,1200,700}; int barrasPos[] = {94,247,1009,360};
        add(it.btnSomOutro());
        add(new Lb(im.addImagem("barras_ranking_cm"), barrasPos));
        add(pnUsers);add(pnAss);add(pnRes);
        add(new Lb(im.addImagem("back_historic_jdv"), backPos));
    }
    
    
}
