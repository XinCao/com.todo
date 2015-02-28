package com.xincao.todo.util;

import com.xincao.todo.util.ncrypt.CryptEngine;
import com.xincao.todo.util.ncrypt.EncryptedRSAKeyPair;
import com.xincao.todo.util.ncrypt.KeyGen;
import java.nio.ByteBuffer;
import java.security.interfaces.RSAPrivateKey;
import javax.crypto.SecretKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author caoxin
 */
public class NcryptUtil {

    private static final Logger logger = LoggerFactory.getLogger(NcryptUtil.class);

    private static CryptEngine cryptEngine;
    /**
     * Scrambled key pair for RSA
     */
    private static EncryptedRSAKeyPair encryptedRSAKeyPair;

    static {
        KeyGen.init();
        SecretKey blowfishKey = KeyGen.generateBlowfishKey();
        encryptedRSAKeyPair = KeyGen.getEncryptedRSAKeyPair();
        cryptEngine = new CryptEngine();
        cryptEngine.updateKey(blowfishKey.getEncoded());
    }

    public static boolean decrypt(ByteBuffer buf) {
        int size = buf.remaining();
        final int offset = buf.arrayOffset() + buf.position();
        boolean ret = cryptEngine.decrypt(buf.array(), offset, size);
        return ret;
    }

    /**
     * Encrypt packet.
     *
     * @param buf
     * @return encrypted packet size.
     */
    public static int encrypt(ByteBuffer buf) {
        int size = buf.limit() - 2;
        final int offset = buf.arrayOffset() + buf.position();
        size = cryptEngine.encrypt(buf.array(), offset, size);
        return size;
    }

    /**
     * Return Scrambled modulus
     *
     * @return Scrambled modulus
     */
    public static final byte[] getEncryptedModulus() {
        return encryptedRSAKeyPair.getEncryptedModulus();
    }

    /**
     * Return RSA private key
     *
     * @return rsa private key
     */
    public final RSAPrivateKey getRSAPrivateKey() {
        return (RSAPrivateKey) encryptedRSAKeyPair.getRSAKeyPair().getPrivate();
    }

    public static void main(String... args) {
        String account = "caoxin";
        ByteBuffer bb = ByteBuffer.wrap(account.getBytes());
        bb.flip();
        encrypt(bb);
        account = new String(bb.array());
        logger.info(account);
    }
}