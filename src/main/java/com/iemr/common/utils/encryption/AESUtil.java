package com.iemr.common.utils.encryption;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Objects;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class AESUtil {
	public enum DataType {
        HEX,
        BASE64
    }

    private static final Logger logger = LoggerFactory.getLogger(AESUtil.class);
    private static final String CIPHER_ALGORITHM = "AES/CBC/PKCS5Padding";
    private static final String SECRET_KEY_ALGORITHM = "PBKDF2WithHmacSHA1";
    private static final String KEY_ALGORITHM = "AES";

    private final int IV_SIZE = 128;

    private int iterationCount = 1989;
    private int keySize = 256;

    private int saltLength;

    private final DataType dataType = DataType.BASE64;

    private Cipher cipher;

    public AESUtil() {
        try {
            cipher = Cipher.getInstance(CIPHER_ALGORITHM);
            saltLength = this.keySize / 4;
        } catch (NoSuchPaddingException | NoSuchAlgorithmException e) {
            logger.info(e.getMessage());
        }
    }

    public AESUtil(int keySize, int iterationCount) {
        this.keySize = keySize;
        this.iterationCount = iterationCount;
        try {
            cipher = Cipher.getInstance(CIPHER_ALGORITHM);
            saltLength = this.keySize / 4;
        } catch (NoSuchPaddingException | NoSuchAlgorithmException e) {
        	logger.info(e.getMessage());
        }
    }

    public String decrypt(String salt, String iv, String passPhrase, String cipherText) {
        try {
        	logger.info("passPhrase : " + passPhrase);
            SecretKey key = generateKey(salt, passPhrase);
            logger.info("key : " + key);
            byte[] encrypted;
            if (dataType.equals(DataType.HEX)) {
                encrypted = fromHex(cipherText);
                logger.info("encrypted 1 : " + encrypted);
            } else {
                encrypted = fromBase64(cipherText);
                logger.info("encrypted 2 : " + encrypted);
            }
            byte[] decrypted = doFinal(Cipher.DECRYPT_MODE, key, iv, encrypted);
            logger.info("decrypted : " + decrypted);
            return new String(Objects.requireNonNull(decrypted), StandardCharsets.UTF_8);
        } catch (Exception e) {
            return null;
        }
    }

    public String decrypt(String passPhrase, String cipherText) {
        try {
        	logger.info("cipherText : " + cipherText);
            String salt = cipherText.substring(0, saltLength);
            logger.info("salt : " + salt);
            int ivLength = IV_SIZE / 4;
            logger.info("ivLength : " + ivLength);
            String iv = cipherText.substring(saltLength, saltLength + ivLength);
            logger.info("iv : " + iv);
            String ct = cipherText.substring(saltLength + ivLength);
            logger.info("ct : " + ct);
            return decrypt(salt, iv, passPhrase, ct);
        } catch (Exception e) {
            return null;
        }
    }

    private SecretKey generateKey(String salt, String passPhrase) {
        try {
            SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance(SECRET_KEY_ALGORITHM);
            KeySpec keySpec = new PBEKeySpec(passPhrase.toCharArray(), fromHex(salt), iterationCount, keySize);
            return new SecretKeySpec(secretKeyFactory.generateSecret(keySpec).getEncoded(), KEY_ALGORITHM);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
        	logger.info(e.getMessage());
        }
        return null;
    }

    private static byte[] fromBase64(String str) {
        return DatatypeConverter.parseBase64Binary(str.trim());
    }

    private static String toBase64(byte[] ba) {
        return DatatypeConverter.printBase64Binary(ba);
    }

    private static byte[] fromHex(String str) {
    	logger.info("fromHex " + str);
        return DatatypeConverter.parseHexBinary(str);
    }

    private static String toHex(byte[] ba) {
    	logger.info("toHex " + ba);
        return DatatypeConverter.printHexBinary(ba);
    }

    private byte[] doFinal(int mode, SecretKey secretKey, String iv, byte[] bytes) throws IllegalBlockSizeException, BadPaddingException {
        try {
        	logger.info("Indide do finel method ");
            cipher.init(mode, secretKey, new IvParameterSpec(fromHex(iv)));
            logger.info("Indide do finel method 2 : "+bytes);
            return cipher.doFinal(bytes);
        } catch (InvalidAlgorithmParameterException | IllegalBlockSizeException | BadPaddingException
                | InvalidKeyException e) {
        	logger.info(e.getMessage());
        }
        logger.info("outside of dofinal : "+ bytes);
        return cipher.doFinal(bytes);
    }

    private static byte[] generateRandom(int length) {
        SecureRandom random = new SecureRandom();
        byte[] randomBytes = new byte[length];
        random.nextBytes(randomBytes);
        return randomBytes;
    }
}
