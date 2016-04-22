package sm130075.vl130298.crypto;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import java.security.Key;
import java.security.NoSuchAlgorithmException;

public class AES {
	private Key key;
	private byte[] encoded;
	private final String ivString = "AAAAAAAAAAAAAAAA";

	public AES(Key key) {
		this.key = key;
		encoded = key.getEncoded();
	}

	public AES() {
		//TODO change this to use newly added class
		KeyGenerator kgen;
		try {
			kgen = KeyGenerator.getInstance("AES");
			kgen.init(128);
			SecretKey aesKey = kgen.generateKey();
			key = aesKey;
			encoded = key.getEncoded();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}

	public String encrypt(String text) {
		try {
			IvParameterSpec iv = new IvParameterSpec(ivString.getBytes("UTF-8"));
			SecretKeySpec skeySpec = new SecretKeySpec(encoded, "AES");

			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
			cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);

			byte[] encrypted = cipher.doFinal(text.getBytes());

			return DatatypeConverter.printBase64Binary(encrypted);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return null;
	}

	public String decrypt(String text) {
		try {
			IvParameterSpec iv = new IvParameterSpec(ivString.getBytes("UTF-8"));
			SecretKeySpec skeySpec = new SecretKeySpec(encoded, "AES");

			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
			cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);

			byte[] original = cipher.doFinal(DatatypeConverter.parseBase64Binary(text));

			return new String(original);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return null;
	}
	/*public static void main(String[] argv){
		String Avax = "AVAXXXXAVAXXXXAVAXXXXAVAXXXXAVAXXXXAVAXXXXAVAXXXXAVAXXXXAVAXXXXAVAXXXXA\nVAXXXXAVAXXXXAVAXXXXAVAXXXXAVAXXXXAVAXXXXAVAXXXXAVAXXXX";
		AES aes = new AES();
		Avax = aes.encrypt(Avax);
		System.out.println(Avax);
		Avax = aes.decrypt(Avax);
		System.out.println(Avax);
	}*/
}