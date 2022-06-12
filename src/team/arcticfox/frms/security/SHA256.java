package team.arcticfox.frms.security;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class SHA256 {
    public static String encode(String str) {
        try {
            byte[] bytes = MessageDigest.getInstance("SHA256").digest(str.getBytes());
            return new BigInteger(bytes).toString(16);
        } catch (NoSuchAlgorithmException e) {
            return "";
        }
    }
}
