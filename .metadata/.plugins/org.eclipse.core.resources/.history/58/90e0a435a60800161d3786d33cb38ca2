import java.security.*;
import javax.crypto.*;

enum Algorithm{
	AES("AES");
	
	String text;
	
	private Algorithm(String txt){
		text = txt;
	}
	
	public String toString(){
		return text;
	}
}

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
