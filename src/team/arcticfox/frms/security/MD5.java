package team.arcticfox.frms.security;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {
    public static String encode(String str) {
        try {
            byte[] bytes = MessageDigest.getInstance("MD5").digest(str.getBytes());
            return new BigInteger(bytes).toString(16);
        } catch (NoSuchAlgorithmException e) {
            return "";
        }
    }
}
