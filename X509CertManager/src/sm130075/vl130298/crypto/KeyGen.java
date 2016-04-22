package sm130075.vl130298.crypto;
import java.security.*;

public class KeyGen {
	public static final String ALGORITHM = "AES";
	
	//We dont want anyone to create object of this class
	private KeyGen(){}

	KeyPair generatePair(){
		try {
			KeyPairGenerator keyGen = null;
			keyGen = KeyPairGenerator.getInstance(Algorithm.AES.toString());
			return keyGen.generateKeyPair();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		return null;
	}	
}
