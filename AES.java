import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.SecureRandom;


public class AESEncryptDecrypt {

    
    
    public static byte[] encrypt(byte[] plaintext, SecretKey key) throws Exception{
        
        
        Cipher cipher = Cipher.getInstance("AES");
        
        cipher.init(Cipher.ENCRYPT_MODE, key);
                
        return cipher.doFinal(plaintext);
        
        
        
    }
    
    public static byte[] decrypt(byte[] ciphertext, SecretKey key) throws Exception
    {
        
        Cipher cipher = Cipher.getInstance("AES");
        
        cipher.init(Cipher.DECRYPT_MODE, key);
        
        return cipher.doFinal(ciphertext);
        
        
    }
    
    
    public static void main(String[] args) throws NoSuchAlgorithmException, Exception  {
        
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        
        keyGenerator.init(128, new SecureRandom());
        
        SecretKey key = keyGenerator.generateKey();
        
        byte[] plaintext = "This is a secret Message".getBytes();
        
        byte[] ciphertext = encrypt(plaintext, key);
        
        byte[] decryptedText = decrypt(ciphertext, key);
        
        System.out.println("\nPlaintext: "+ new String(plaintext));
        
        System.out.println("\nCiphertext: "+ new String(ciphertext));
        
        System.out.println("\nDecrypted text: "+ new String(decryptedText));
    }
    
}
