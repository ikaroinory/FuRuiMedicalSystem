package team.arcticfox.frms.security;

import java.nio.charset.StandardCharsets;

public final class Base64 {
    public static String encode(String str) {
        return java.util.Base64.getEncoder().encodeToString(str.getBytes(StandardCharsets.UTF_8));
    }

    public static String decode(String str) {
        return new String(java.util.Base64.getDecoder().decode(str), StandardCharsets.UTF_8);
    }
}
