package xyz.junjie.xu.exceptions;


/** 
 * 
 * This exception validates a username from a user registration form
 * 
 * 
 * */
public class InvalidUsernameException extends Exception{
	public InvalidUsernameException(String message) {
		super(message);
	}
}
