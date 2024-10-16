package com.iemr.common.utils.aesencryption;

import java.io.UnsupportedEncodingException;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.spec.GCMParameterSpec;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.iemr.common.utils.aesencryption.AESEncryptionDecryption;


@Component
public class AESEncryptionDecryption {

	
	private static Logger logger = LoggerFactory.getLogger(AESEncryptionDecryption.class);

	private static SecretKeySpec secretKey;

	private static byte[] key;

	private static final String SECRET = "amrith$%2022@&*piramal@@swasthya!#";

	private static final int IV_SIZE = 12;

	private static final int TAG_SIZE = 128;

	private static final String UTF_8 = "UTF-8";
 
	public static void setKey(String myKey) {

		try {

			key = myKey.getBytes(UTF_8);

			MessageDigest sha = MessageDigest.getInstance("SHA-512");

			key = sha.digest(key);

			key = Arrays.copyOf(key, 16);

			secretKey = new SecretKeySpec(key, "AES");

		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {

			logger.error("context", e);

		}

	}
 
	public String encrypt(String strToEncrypt) throws Exception {

		if (secretKey == null)

			setKey(SECRET);

		Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
 
		// Generate IV

		byte[] iv = new byte[IV_SIZE];

		SecureRandom random = new SecureRandom();

		random.nextBytes(iv);

		cipher.init(Cipher.ENCRYPT_MODE, secretKey, new GCMParameterSpec(TAG_SIZE, iv));
 
		byte[] encryptedBytes = cipher.doFinal(strToEncrypt.getBytes(UTF_8));

		byte[] encryptedIvAndText = new byte[IV_SIZE + encryptedBytes.length];

		System.arraycopy(iv, 0, encryptedIvAndText, 0, IV_SIZE);

		System.arraycopy(encryptedBytes, 0, encryptedIvAndText, IV_SIZE, encryptedBytes.length);
 
		return Base64.getEncoder().encodeToString(encryptedIvAndText);

	}
 
	public String decrypt(String strToDecrypt) throws Exception {

		if (secretKey == null)

			setKey(SECRET);
 
		byte[] encryptedIvAndText = Base64.getDecoder().decode(strToDecrypt);

		byte[] iv = Arrays.copyOfRange(encryptedIvAndText, 0, IV_SIZE);

		byte[] encryptedBytes = Arrays.copyOfRange(encryptedIvAndText, IV_SIZE, encryptedIvAndText.length);
 
		Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");

		cipher.init(Cipher.DECRYPT_MODE, secretKey, new GCMParameterSpec(TAG_SIZE, iv));

		byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
 
		return new String(decryptedBytes, UTF_8);

	}
 
}
