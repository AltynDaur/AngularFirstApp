package security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class EncryptByMD5 {
    private static MessageDigest md;

    public static byte[] encrypt(String pass, String salt){

        try {
            md = MessageDigest.getInstance("MD5");
            md.reset();
            byte[] passBytes = pass.getBytes();
            byte[] saltBytes = salt.getBytes();
            md.update(saltBytes);
            byte[] digested = md.digest(passBytes);
            byte[] result = new byte[0];
            for(int i=0;i<digested.length;i++){
                result[i]= (byte) (0xff & digested[i]);
            }
            return result;
        } catch (NoSuchAlgorithmException ex) {

        }
        return null;


    }

    public static String generateSalt(){
        SecureRandom secureRandom = new SecureRandom();
        return secureRandom.generateSeed(32).toString();
    }
}