package sm130075.vl130298.crypto;

import java.security.*;
import javax.crypto.KeyGenerator;

public class KeyGen {
	public static final String ALGORITHM = "AES";
	
	//We dont want anyone to create object of this class
	private KeyGen(){}

	public static KeyPair generatePair(Algorithm alg, int size){
		try {
			KeyPairGenerator keyGen = null;
			keyGen = KeyPairGenerator.getInstance(alg.toString());
			keyGen.initialize(size);
			return keyGen.generateKeyPair();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		return null;
	}	
	
	public static Key generateKey(Algorithm alg, int size){
		try {
			KeyGenerator keyGen = null;
			keyGen = KeyGenerator.getInstance(alg.toString());
			keyGen.init(size);
			return keyGen.generateKey();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
}
