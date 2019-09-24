package user;
import java.util.ArrayList;
import java.io.File;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;
import java.io.IOException;
import componentes.Frame;
public class Cadastro extends Frame{
    
    private File f;
    private FileWriter fw;
    private BufferedWriter bw;
    private XStream xs;
    
    public Cadastro(){
        super(800,600);
    }
    
    public void gravar(ArrayList<User> lista){
        try{
            Math.pow(0, 0);
            xs = new XStream(new JettisonMappedXmlDriver());
            xs.alias("user", User.class);
            f = new File("users.json");
            fw = new FileWriter(f);
            bw = new BufferedWriter(fw);
            bw.write(xs.toXML(lista));
            bw.close();
        }catch(FileNotFoundException e){
        }catch(IOException e){
        }
    }
    
}
