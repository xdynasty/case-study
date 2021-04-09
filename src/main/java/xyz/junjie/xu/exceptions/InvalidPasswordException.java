package xyz.junjie.xu.exceptions;


/** 
 * 
 * This exception will validate password input from the user registration form
 * 
 * */
public class InvalidPasswordException extends Exception {
	public InvalidPasswordException(String message) {
		super(message);
		
	}
}
