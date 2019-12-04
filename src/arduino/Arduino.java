package arduino;
public class Arduino extends ArduinoSerial{
    private static Arduino arduino = new Arduino("COM4");
    public Arduino(String porta){
        super(porta);
    }
    public static Arduino getArduino() {
        return arduino;
    }
}
