package padroes;

import java.awt.Font;
import java.io.InputStream;

public class Fonts {
    private Font f;
    public Font addNewFont(String arquivo, int tamanho){
        try {
            InputStream is = getClass().getResourceAsStream("Fonts/"+arquivo+".ttf");
            f = Font.createFont(Font.TRUETYPE_FONT, is);
        }catch(Exception e){}
        Font r = f.deriveFont(0,tamanho);
        return r;
    }
}
