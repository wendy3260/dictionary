/**
 * 
 * @author Wendy Li
 * Student number: 251026390
 * CS2210 Assignment 4
 *
 */
public class DuplicatedKeyException extends RuntimeException{
	
	public DuplicatedKeyException(Pixel data) {
		super("The pixel " + data + " already exists."); //prints out that the node with Pixel data already exists in 
		//binary search tree
	}
}
