package org.kodluyoruz;

public class InvalidSizeException extends ArithmeticException {
	
	public InvalidSizeException(String message) {
		super(message);
	}

	@Override
	public void printStackTrace() {
		System.out.println("The size value is not valid!");
	}

}
