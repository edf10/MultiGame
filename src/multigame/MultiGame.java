package multigame;

import arduino.ArduinoSerial;

public class MultiGame {
    public static void main(String []args){
        MultiGameTela mg = new MultiGameTela();
        mg.intro();
        mg.show();
        /*EasterEgg e = new EasterEgg();
        e.addEasterCM();
        e.show();*/
        
    }
}
