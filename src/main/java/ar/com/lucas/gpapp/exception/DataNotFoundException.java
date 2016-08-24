package ar.com.lucas.gpapp.exception;

public class DataNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1405763881080261962L;
	
	public DataNotFoundException(String e){
		super(e);
	}
}
