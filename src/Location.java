 /**
  * 
  * @author Wendy Li
  * student number 251026390 
  * CS2210 Assignment 4
  *
  */
public class Location {
	
	//declaring private variables
	private int xCoord;
	private int yCoord;
	
	/**
	 * Location sets this.x and this.y to the x and y coordinates
	 * @param x: the x coordinate
	 * @param y: the y coordinate
	 */
	public Location(int x, int y) {
		xCoord = x;
		yCoord = y;
	}

	/**
	 * This method returns the x coordinate of this
	 * @return int (x coordinate)
	 */
	public int xCoord() {
		return xCoord;
	}
	
	/**
	 * This method returns the y coordinate of
	 * @return int of y coordinate
	 */
	public int yCoord() {
		return yCoord;
	}
	
	/**
	 * This method compares the coordinates of p and the coordinates
	 * of this and returns -1 if it is smaller and 0 if it the same 
	 * and 1 if this is greater than p.
	 * @param p: The location p that you compare to this.xCoord and this.yCoord
	 * @return int 1 if this is greater than p, 0 if it the same as p
	 * -1 if is smaller than p 
	 */
	public int compareTo(Location p) {
		if (xCoord < p.xCoord) {
			return -1;
		}else if ((xCoord == p.xCoord) && (yCoord < p.yCoord)){
			return -1;
		}else if ((xCoord == p.xCoord) && (yCoord == p.yCoord)) {
			return 0;
		}else {
			return 1;
		}
	}

}
