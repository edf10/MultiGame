package multigame;

import wordpuzzle.Perguntas;

public class MultiGame {
    public static void main(String []args){
        Perguntas p = new Perguntas();
        p.gravar("geometria");
        p.gravar("equacoes");
        MultiGameTela mg = new MultiGameTela();
        mg.intro();
        mg.show();
    }
}
