package sm130075.vl130298.exception;

public class StartFrameException extends Exception {

	
	private static final long serialVersionUID = -8833221876242774777L;
	
	public static final String[] messages = {"Key size must be greater or greater or equal to 512!\n  " //0
		                                	,"Experation (valid date) must be after current date! Please check out your input!" //1
			                                ,"Field E doesnt have valid email format!" //2
			                                , "One of these fields must be filled: CN, OU, O, L, ST, C, E!" //3
			                                , "Insert serial number" //4 
			                                , "Depth of the certification path field is not filled" //5
			                                , "Insert key size"};//6
	
	public StartFrameException(int exception_id) {
		super(messages[exception_id]);
	}

	


}
