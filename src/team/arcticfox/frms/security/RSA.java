package team.arcticfox.frms.security;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;

public class RSA {
    private final BigInteger p;
    private final BigInteger q;
    private final BigInteger n;
    private final BigInteger e;
    private final BigInteger d;
    private final BigInteger varphiN;

    public RSA() {
        p = new BigInteger("71065247938178632403540728757");
        q = new BigInteger("19004600296118742180338124947");
        n = new BigInteger("1350566632009661469563654094416991487281374561783302000879");
        e = new BigInteger("17");
        varphiN = new BigInteger("1350566632009661469563654094326921639047077187199423147176");
        d = new BigInteger("79445096000568321739038476136877743473357481599966067481");
    }

    public RSA(BigInteger p, BigInteger q, BigInteger e) {
        this.p = p;
        this.q = q;
        this.n = p.multiply(q);
        this.e = e;
        this.varphiN = p.subtract(new BigInteger("1")).multiply(q.subtract(new BigInteger("1")));
        this.d = e.modInverse(this.varphiN);
    }

    public BigInteger getVarphiN() {
        return varphiN;
    }

    public String encryption(String msg) {
        StringBuilder stringBuilder = new StringBuilder();
        byte[] bytes = msg.getBytes(StandardCharsets.UTF_8);
        for (byte b : bytes) {
            if (b < 100)
                stringBuilder.append('0');
            if (b < 10)
                stringBuilder.append('0');
            stringBuilder.append(b);
        }

        return new BigInteger(stringBuilder.toString()).modPow(e, n).toString(16);
    }

    public String decryption(String msg) {
        StringBuilder stringBuilder = new StringBuilder(new BigInteger(msg, 16).modPow(d, n).toString());
        int len = stringBuilder.length();
        while (len % 3 != 0) {
            stringBuilder.insert(0, '0');
            len++;
        }
        byte[] bytes = new byte[len / 3];
        for (int i = 0; i < len / 3; i++)
            bytes[i] = Byte.parseByte(stringBuilder.substring(3 * i, 3 * i + 3));
        return new String(bytes);
    }
}
