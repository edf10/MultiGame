package musics;
import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;
import java.util.Random;
public class Music {
    
    private URL url[] = {getClass().getResource("musics/music_01.wav"),getClass().getResource("musics/music_02.wav"),
                         getClass().getResource("musics/music_03.wav"),getClass().getResource("musics/music_04.wav")};
    private int duracaoAudios[] = {237,196,331,161};
    private AudioClip audio;
    private Tocar t = new Tocar();
    public Music(){
        t.start();
    }
    private int musicSorteada;
    public void sortearMusic(){
        Random r = new Random();
        musicSorteada = r.nextInt(url.length);
    }
    
    public void tocarMusic(){
        sortearMusic();
        audio = Applet.newAudioClip(url[musicSorteada]);
        audio.play();
    }
    
    public class Tocar extends Thread{
        @Override
        public void run(){
            int s = 0;
            while(true){
                try{Thread.sleep(1000);}catch(Exception e){}
                if(s==0){
                    tocarMusic();
                }
                s++;
                if(duracaoAudios[musicSorteada]+1==s){
                    tocarMusic();
                }
            }
        }
    }
    
    public void continuar(){
        audio.loop();
    }
    
    public void parar(){
        audio.stop();
    }
    
}
