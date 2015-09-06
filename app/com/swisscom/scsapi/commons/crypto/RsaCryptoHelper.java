package com.swisscom.scsapi.commons.crypto;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;


import java.nio.charset.Charset;
//import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import org.apache.commons.codec.binary.Base64;

public class RsaCryptoHelper {

	private static final String SYSTEM = "RSA";
	//private static final Charset CHAR_ENCODING = StandardCharsets.UTF_8;
	private static final Charset CHAR_ENCODING = Charset.forName("UTF-8");

	static public PrivateKey createPrivateKey(String base64EncodedPrivateKey) {
		PrivateKey privateKey = null;

		try {
			KeyFactory keyFactory = KeyFactory.getInstance(SYSTEM);
			byte[] privateKeyBytes = base64EncodedPrivateKey.getBytes();
			PKCS8EncodedKeySpec privateKeySpec = new PKCS8EncodedKeySpec(Base64.decodeBase64(privateKeyBytes));
			privateKey = keyFactory.generatePrivate(privateKeySpec);
		} catch (InvalidKeySpecException e) {}
		  catch (NoSuchAlgorithmException e) {}
		return privateKey;
	}

	static public PublicKey createPublicKey(String base64EncodedPublicKey) {
		PublicKey publicKey = null;

		try {
			KeyFactory keyFactory = KeyFactory.getInstance(SYSTEM);
			byte[] publicKeyBytes = base64EncodedPublicKey.getBytes();
			X509EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(Base64.decodeBase64(publicKeyBytes));
			publicKey = keyFactory.generatePublic(publicKeySpec);
		} catch (NoSuchAlgorithmException e) {
			//TODO
		} catch (InvalidKeySpecException e) {

		}

		return publicKey;
	}

	static public String encryptValueWithPrivateKey(PrivateKey privateKey, String secret) {
		byte[] encryptedSecret = null;

		try {
			final Cipher cipher = Cipher.getInstance(SYSTEM);

			cipher.init(Cipher.ENCRYPT_MODE, privateKey);
			encryptedSecret = cipher.doFinal(secret.getBytes(CHAR_ENCODING));
		} catch (NoSuchPaddingException e) {}
			catch (NoSuchAlgorithmException e) {
            //TODO
		} catch (InvalidKeyException e) {} 
		catch (BadPaddingException e) {} 
		catch (IllegalBlockSizeException e) {}

		return new String(Base64.encodeBase64(encryptedSecret),CHAR_ENCODING);
	}

	static public String encryptValueWithPrivateKey(String privateKeyBase64, String secret) {
		return encryptValueWithPrivateKey(createPrivateKey(privateKeyBase64), secret);
	}

	static public String decryptValueWithPublicKey(PublicKey publicKey, String encryptedSecretBase64)
			  {
		byte[] decryptedSecret = null;

		try {
			final Cipher cipher = Cipher.getInstance(SYSTEM);

			cipher.init(Cipher.DECRYPT_MODE, publicKey);
			decryptedSecret = cipher.doFinal(Base64.decodeBase64(encryptedSecretBase64.getBytes()));
		} catch (NoSuchPaddingException e) {} 
		catch (NoSuchAlgorithmException e) {} 
		catch (InvalidKeyException e) {} 
		catch (BadPaddingException e) {}
		catch (IllegalBlockSizeException e) {}

		return new String(decryptedSecret, CHAR_ENCODING);
	}

	static public String decryptValueWithPublicKey(String publicKeyBase64, String encryptedSecretBase64)
			  {
		return decryptValueWithPublicKey(createPublicKey(publicKeyBase64), encryptedSecretBase64);
	}

	static public KeyPair generateKeyPair() {
		KeyPairGenerator keyPairGenerator = null;
		try {
			keyPairGenerator = KeyPairGenerator.getInstance(SYSTEM);
		} catch (NoSuchAlgorithmException e) {
            //TODO
		}
		keyPairGenerator.initialize(2048);

		return keyPairGenerator.genKeyPair();
	}
}
