package controllers;

import java.util.Random;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

public class Aes128EncryptedString {

//	private byte[] iv;
//	private byte[] encrypted;
//
//	public Aes128EncryptedString(byte[] key, String value) throws Exception {
//			SecretKeySpec skeySpec = new SecretKeySpec(key, "AES");
//			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
//			cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
//			this.encrypted = cipher.doFinal(value.getBytes("UTF-8"));
//			this.iv = cipher.getIV();
//	}
//
//	public String getEncrypted() {
//		return Base64.encodeBase64String(this.encrypted);
//	}
//
//	public String getIv() {
//		return Base64.encodeBase64String(this.iv);
//	}
//
//
//	public static String decrypt(byte[] key, byte[] initializationVector, byte[] encrypted)
//			throws Exception {
//		IvParameterSpec iv = new IvParameterSpec(initializationVector);
//
//		SecretKeySpec skeySpec = new SecretKeySpec(key, "AES");
//		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
//		cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
//		byte[] original = cipher.doFinal(encrypted);
//
//		return new String(original, "UTF-8");
//	}
//
//	public static String getRandomKey() {
//		int len = 128 / 8; // 128bit
//		byte[] random = new byte[len];
//		new Random().nextBytes(random);		
//		return Base64.encodeBase64String(random);
//	}
}