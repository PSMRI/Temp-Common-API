/*
* AMRIT – Accessible Medical Records via Integrated Technology 
* Integrated EHR (Electronic Health Records) Solution 
*
* Copyright (C) "Piramal Swasthya Management and Research Institute" 
*
* This file is part of AMRIT.
*
* This program is free software: you can redistribute it and/or modify
* it under the terms of the GNU General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* (at your option) any later version.
*
* This program is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
* GNU General Public License for more details.
*
* You should have received a copy of the GNU General Public License
* along with this program.  If not, see https://www.gnu.org/licenses/.
*/

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

    private static final String CIPHER_ALGORITHM = "AES/CBC/ISO10126Padding";
    private static final String SECRET_KEY_ALGORITHM = "PBKDF2WithHmacSHA512";


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
        	SecretKey key = generateKey(salt, passPhrase);
            byte[] encrypted;
            if (dataType.equals(DataType.HEX)) {
                encrypted = fromHex(cipherText);
            } else {
                encrypted = fromBase64(cipherText);
            }
            byte[] decrypted = doFinal(Cipher.DECRYPT_MODE, key, iv, encrypted);
            return new String(Objects.requireNonNull(decrypted), StandardCharsets.UTF_8);
        } catch (Exception e) {
            return null;
        }
    }

    public String decrypt(String passPhrase, String cipherText) {
        try {
        	String salt = cipherText.substring(0, saltLength);
            int ivLength = IV_SIZE / 4;
            String iv = cipherText.substring(saltLength, saltLength + ivLength);
            String ct = cipherText.substring(saltLength + ivLength);
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
    	return DatatypeConverter.parseHexBinary(str);
    }

    private static String toHex(byte[] ba) {
    	return DatatypeConverter.printHexBinary(ba);
    }

    private byte[] doFinal(int mode, SecretKey secretKey, String iv, byte[] bytes) throws IllegalBlockSizeException, BadPaddingException {
        try {
        	cipher.init(mode, secretKey, new IvParameterSpec(fromHex(iv)));
            return cipher.doFinal(bytes);
        } catch (InvalidAlgorithmParameterException | IllegalBlockSizeException | BadPaddingException
                | InvalidKeyException e) {
        	logger.info(e.getMessage());
        }
        return cipher.doFinal(bytes);
    }

    private static byte[] generateRandom(int length) {
        SecureRandom random = new SecureRandom();
        byte[] randomBytes = new byte[length];
        random.nextBytes(randomBytes);
        return randomBytes;
    }
    
    public String decryptExistingPwd(String passPhrase, String cipherText) {
        try {
        	String salt = cipherText.substring(0, saltLength);
            int ivLength = IV_SIZE / 4;
            String iv = cipherText.substring(saltLength, saltLength + ivLength);
            String ct = cipherText.substring(saltLength + ivLength);
            return decryptExistingPwd(salt, iv, passPhrase, ct);
        } catch (Exception e) {
            return null;
        }
    }
    
    public String decryptExistingPwd(String salt, String iv, String passPhrase, String cipherText) {
        try {
        	SecretKey key = generateKeyForExistingUser(salt, passPhrase);
            byte[] encrypted;
            if (dataType.equals(DataType.HEX)) {
                encrypted = fromHex(cipherText);
            } else {
                encrypted = fromBase64(cipherText);
            }
            byte[] decrypted = doFinal(Cipher.DECRYPT_MODE, key, iv, encrypted);
            return new String(Objects.requireNonNull(decrypted), StandardCharsets.UTF_8);
        } catch (Exception e) {
            return null;
        }
    }
    
    private SecretKey generateKeyForExistingUser(String salt, String passPhrase) {
        try {
            SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            KeySpec keySpec = new PBEKeySpec(passPhrase.toCharArray(), fromHex(salt), iterationCount, keySize);
            return new SecretKeySpec(secretKeyFactory.generateSecret(keySpec).getEncoded(), KEY_ALGORITHM);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
        	logger.info(e.getMessage());
        }
        return null;
    }
    
    public String decryptExistingPwdNew(String passPhrase, String password) {
    	
    	try {
    		String[] parts = password.split(":");
    		int iterations = Integer.parseInt(parts[0]);
    		String salt = parts[1];
    		String hash = parts[2];
    		SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
    		PBEKeySpec keySpec = new PBEKeySpec(passPhrase.toCharArray(), fromHex(salt), iterationCount, hash.length() * 4);
    		SecretKey key = secretKeyFactory.generateSecret(keySpec);
    		
    		byte[] decryptedHash = key.getEncoded();
    		return toHex(decryptedHash);
    	} catch (Exception e) {
    		throw new RuntimeException("Error decrypting password : " + e.getLocalizedMessage());
    	}
    }
    
   

}
