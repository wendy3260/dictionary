

/**
 * @author Wendy Li
 *Student number 251026390
 *CS2210 Assignment 4
 */
public class Pixel {
	//declaring private variables
	private Location pixel;
	private int c;
	
	/**
	 * Constructor of the class
	 * @param p: sets this.pixel to Location p
	 * @param color: sets this.c to int color
	 */
	public Pixel(Location p, int color) {
		pixel = p;
		c = color;
	}
	
	/**
	 * 
	 * @return this.pixel
	 */
	public Location getLocation() {
		return pixel;
	}
	
	/**
	 * 
	 * @return this.c (int color)
	 */
	public int getColor() {
		return c;
	}
}
