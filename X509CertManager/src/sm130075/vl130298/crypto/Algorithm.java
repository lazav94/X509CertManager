package sm130075.vl130298.crypto;

public enum Algorithm{
	AES("AES"),
	RSA("RSA"),
	RSAwithSHA1("sha1WithRSA");
	
	String text;
	
	private Algorithm(String txt){
		text = txt;
	}
	
	public String toString(){
		return text;
	}
}
