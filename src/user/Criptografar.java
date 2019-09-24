package user;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class Criptografar {
    
    private String chave;
    private String texto;
    private SecretKey key;
    private byte[] tencrip;
    private byte[] tdencrip;
    private Cipher cp;
    
    public Criptografar(String chave, String texto){
        this.chave = chave;
        key = new SecretKeySpec(this.chave.getBytes(), "AES");
        this.texto = texto;
    }
    
    public byte[] encriptar(){
        try{
            cp = Cipher.getInstance("AES");
            cp.init(Cipher.ENCRYPT_MODE, key);
            tencrip = cp.doFinal(texto.getBytes());
            return tencrip;
        }catch(Exception e){}
        return null;
    }
    
    public byte[] descriptar(){
        try{
            cp = Cipher.getInstance("AES");
            cp.init(Cipher.DECRYPT_MODE, key);
            tdencrip = cp.doFinal(tencrip);
            return tdencrip;
        }catch(Exception e){}
        return null;
    }
    
}
