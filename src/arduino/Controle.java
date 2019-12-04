package arduino;
public class Controle extends Thread{
    private ArduinoSerial arduino = new ArduinoSerial("COM4");
    private String btn;
    private int acaoBtn = 0;
    
    @Override
    public void run(){
        String lido = "";
        while(true){
            try{Thread.sleep(100);}catch(Exception e){}
            System.out.println(arduino.read());
            if((lido = (arduino.read()!=null)?arduino.read():"0").equals(btn)){
                acoes();
                stop();
                break;
            }
        }
    }
    
    public Controle(String btn, int acaoBtn){
        arduino.initialize();
        this.btn = btn;
        this.acaoBtn = acaoBtn;
    }
    
    public void acoes(){
        switch(acaoBtn){
            case 1: exit(); break;
            default: break;
        }
    }
    
    public void exit(){
        System.exit(0);
    }
    
}
