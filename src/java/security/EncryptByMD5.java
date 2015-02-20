package security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class EncryptByMD5 {
    private static MessageDigest md;

    public static byte[] encrypt(byte[] pass, byte[] salt){

        try {
            md = MessageDigest.getInstance("MD5");
            md.reset();
            md.update(salt);
            byte[] digested = md.digest(pass);
            byte[] result = new byte[0];
            for(int i=0;i<digested.length;i++){
                result[i]= (byte) (0xff & digested[i]);
            }
            return result;
        } catch (NoSuchAlgorithmException ex) {

        }
        return null;


    }

    public static byte[] generateSalt(){
        SecureRandom secureRandom = new SecureRandom();
        return secureRandom.generateSeed(32);
    }
}