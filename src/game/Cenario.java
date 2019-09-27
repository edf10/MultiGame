package game;
import componentes.Frame;
public class Cenario extends Frame{
    public Cenario(){
        super(800,600);
        Movimentacao m = new Movimentacao();
        setVisible(true);
    }
    
}
