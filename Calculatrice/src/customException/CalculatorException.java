package customException;

public class CalculatorException extends Exception{

	private String message;
	
	public CalculatorException(String message) {
		super(message);
		this.message = message;
	}

	public String getMessage() {
		return this.message;
	}
}
