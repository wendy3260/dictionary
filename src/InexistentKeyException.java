/**
 * 
 * @author Wendy Li
 * Student number 25102390
 * CS2210 Assignment 4
 *
 */
public class InexistentKeyException extends RuntimeException{
	
	//catches the exception
	public InexistentKeyException(Location key) {
		super("This location " + key + " does not exist"); //prints this message
	}
}
