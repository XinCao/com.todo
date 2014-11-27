package com.xincao.todo_mvn.util.ncrypt;


import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.spec.RSAKeyGenParameterSpec;
import javax.crypto.NoSuchPaddingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Key generator. It generates keys or keyPairs for Blowfish and RSA
 *
 * @author -Nemesiss-
 *
 */
public class KeyGen {

    protected static final Logger logger = LoggerFactory.getLogger(KeyGen.class);
    /**
     * Key generator for blowfish
     */
    private static KeyGenerator blowfishKeyGen;
    /**
     * Public/Static RSA KeyPairs with encrypted modulus N
     */
    private static EncryptedRSAKeyPair[] encryptedRSAKeyPairs;

    /**
     * Initialize Key Generator (Blowfish keygen and RSA keygen)
     *
     * @throws GeneralSecurityException
     */
    public static void init() {
        logger.info("Initializing Key Generator...");
        try {
            blowfishKeyGen = KeyGenerator.getInstance("Blowfish");
        } catch (NoSuchAlgorithmException ex) {
            logger.error(ex.getMessage());
        }
        KeyPairGenerator rsaKeyPairGenerator = null;
        try {
            rsaKeyPairGenerator = KeyPairGenerator.getInstance("RSA");
        } catch (NoSuchAlgorithmException ex) {
            logger.error(ex.getMessage());
        }
        RSAKeyGenParameterSpec spec = new RSAKeyGenParameterSpec(1024, RSAKeyGenParameterSpec.F4);
        try {
            rsaKeyPairGenerator.initialize(spec);
        } catch (InvalidAlgorithmParameterException ex) {
            logger.error(ex.getMessage());
        }
        encryptedRSAKeyPairs = new EncryptedRSAKeyPair[10];
        for (int i = 0; i < 10; i++) {
            encryptedRSAKeyPairs[i] = new EncryptedRSAKeyPair(rsaKeyPairGenerator.generateKeyPair());
        }
        // Pre-init RSA cipher.. saving about 300ms
        Cipher rsaCipher = null;
        try {
            rsaCipher = Cipher.getInstance("RSA/ECB/nopadding");
        } catch (NoSuchAlgorithmException ex) {
            logger.error(ex.getMessage());
        } catch (NoSuchPaddingException ex) {
            logger.error(ex.getMessage());
        }
        try {
            rsaCipher.init(Cipher.DECRYPT_MODE, encryptedRSAKeyPairs[0].getRSAKeyPair().getPrivate());
        } catch (InvalidKeyException ex) {
            logger.error(ex.getMessage());
        }
    }

    /**
     * Generate and return blowfish key
     *
     * @return Random generated blowfish key
     */
    public static SecretKey generateBlowfishKey() {
        return blowfishKeyGen.generateKey();
    }

    /**
     * Get common RSA Public/Static Key Pair with encrypted modulus N
     *
     * @return encryptedRSAkeypairs
     */
    public static EncryptedRSAKeyPair getEncryptedRSAKeyPair() {
        return encryptedRSAKeyPairs[Rnd.nextInt(10)];
    }

}