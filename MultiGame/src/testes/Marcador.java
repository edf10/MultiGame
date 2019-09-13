package testes;
import java.awt.event.MouseListener;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
public class Marcador implements MouseListener{
    
    private boolean press = false;

    @Override
    public void mouseClicked(MouseEvent me) {
        //System.out.println(me.getModifiers());
        switch(me.getModifiers()){
            case InputEvent.BUTTON1_MASK:
                press = false;
                break;
            case InputEvent.BUTTON3_MASK:
                press = true;
                break;
            default:
                break;
        }
    }
    @Override
    public void mousePressed(MouseEvent me) {}
    @Override
    public void mouseReleased(MouseEvent me) {}
    @Override
    public void mouseEntered(MouseEvent me) {}
    @Override
    public void mouseExited(MouseEvent me) {}
        
    public boolean getPress(){
        return press;
    }
}
