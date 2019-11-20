package jogodavelha;

import componentes.Frame;
import componentes.Lb;
import componentes.Pn;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import padroes.Fonts;
import padroes.ItemsTela;
import user.User;

public class HistoricJDV extends Frame{
    //As 10 últimas partidas realizadas pelo usuário.
    private ArrayList<String> users = new ArrayList<>();
    private ArrayList<String> assuntos = new ArrayList<>();
    private ArrayList<String> resultados = new ArrayList<>();
    private Pn pnUsers;
    private Pn pnAss;
    private Pn pnRes;
    private ItemsTela it = new ItemsTela();
    private User user = User.getUser();
    
    public HistoricJDV(){it.setTelaAntIntro(2);lerHistoric();tabela();show();}
    
    public void lerHistoric(){
        for(int i = 0; i<user.getHistoricJDV().size(); i++){
            resultados.add(user.getHistoricJDV().get(i).get(0));
            users.add(user.getHistoricJDV().get(i).get(1));
            assuntos.add(user.getHistoricJDV().get(i).get(2));
        }
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
        for(int i = 0; i<users.size(); i++){
            pnUsers.add(new Lb(users.get(i),f,Color.white));
            pnAss.add(new Lb(assuntos.get(i),f,Color.white));
            pnRes.add(new Lb(resultados.get(i),f,Color.white));
        }
        for(int i = users.size(); i<10; i++){
            pnUsers.add(new Lb("-",f,Color.white));
            pnAss.add(new Lb("-",f,Color.white));
            pnRes.add(new Lb("-",f,Color.white));
        }
        
        add(it.btnClose()); add(it.returnGames(this)); int backPos[] = {0,0,1200,700}; int barrasPos[] = {94,247,1009,360};
        add(new Lb(im.addImagem("barras_ranking_cm"), barrasPos));
        add(pnUsers);add(pnAss);add(pnRes);
        add(new Lb(im.addImagem("back_historic_jdv"), backPos));
    }
    
    
}
