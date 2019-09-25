package testes;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.Cipher;
public class Criptografia {
    
    private String IV = "AAAAAAAAAAAAAAAA";
    private String textopuro = "teste texto 12345678\0\0\0";
    private String chave = "1234567891234567";//16 bits na chave
 
    public Criptografia(){
        try{
            System.out.println("Texto puro: "+textopuro);
            
            byte[] textoencriptado = encrypt();
            
            System.out.print("Texto Encriptado: ");
            
            for(int i = 0; i<textoencriptado.length; i++){
                System.out.print(new Integer(textoencriptado[i])+" ");
            }
            
            System.out.println("");
            
            String textodescriptado = decrypt(textoencriptado);
            System.out.println("Texto Descriptado: "+textodescriptado);
        }catch(Exception e){
            e.printStackTrace();
        }
    } 
    
    public byte[] encrypt() throws Exception{
        
        Cipher encripta = Cipher.getInstance("AES/CBC/PKCS5Padding", "SunJCE");
        SecretKeySpec key = new SecretKeySpec(chave.getBytes("UTF-8"), "AES");
        encripta.init(Cipher.ENCRYPT_MODE, key, new IvParameterSpec(IV.getBytes("UTF-8")));
        return encripta.doFinal(textopuro.getBytes("UTF-8"));
    }
    
    public String decrypt(byte[] textoencriptado) throws Exception{
        Cipher decripta = Cipher.getInstance("AES/CBC/PKCS5Padding", "SunJCE");
        SecretKeySpec key = new SecretKeySpec(chave.getBytes("UTF-8"), "AES");
        decripta.init(Cipher.DECRYPT_MODE, key, new IvParameterSpec(IV.getBytes("UTF-8")));
        return new String(decripta.doFinal(textoencriptado), "UTF-8");
    }
    
}