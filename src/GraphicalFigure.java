
/**
 * 
 * @author Wendy Li
 * Student number: 251026390
 * CS2210 Assignment 4
 *
 */
public class GraphicalFigure implements GraphicalFigureADT{
	
	//initializing private variables
	private int id;
	private int width;
	private int height;
	private String type;
	private Location pos;
	private BinarySearchTree tree;
	
	/**
	 * constructor of the class and initializes a binary search tree
	 * @param id: set this.id to id
	 * @param width: set this.width to width
	 * @param height: set this.height to height
	 * @param type: set this.type to type
	 * @param pos: set this.pos to pos
	 */
	public GraphicalFigure(int id, int width, int height, String type, Location pos) {
		this.id = id;
		this.width = width;
		this.height = height;
		this.type = type;
		this.pos = pos;
		
		tree = new BinarySearchTree();
	}
	
	/**
	 * returns the type of this
	 * @param type: sets this.type to param type
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	/**
	 * returns the width of this
	 */
	public int getWidth() {
		return width;
	}
	
	/**
	 * returns the height of this
	 */
	public int getHeight() {
		return height;
	}
	
	/**
	 * returns the type of this
	 */
	public String getType() {
		return type;
	}

	/**
	 * returns the id of this
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * returns the pos of this (the offset in format of Location)
	 */
	public Location getOffset() {
		return pos;
	}
	
	/**
	 * sets this.pos to Location value
	 * @param value: setting this to value
	 */
	public void setOffset(Location value) {
		this.pos = value;
	}
	
	/**
	 * inserts Pixel pix into the binary search tree
	 * @param pix: the pixel that is inserted into the binary search tree
	 */
	public void addPixel(Pixel pix) throws DuplicatedKeyException{
			tree.put(this.tree.getRoot(), pix);
	}
	
	/*
	 * Checking if this intersects with graphical figure gobj. Returns true if it intersects, false othewise
	 * @param gobj: the graphical figure that we compare this to 
	 */
	public boolean intersects(GraphicalFigure gobj) {
		
		//initializing variables
		int x,y;
		int y_offset = getOffset().yCoord();
		int x_offset = getOffset().xCoord();
		int x_fig = gobj.getOffset().xCoord();
		int y_fig = gobj.getOffset().yCoord();
		Pixel smallest = null; 
		
		try {
			smallest = gobj.tree.smallest(tree.getRoot()); //getting the smallest value in binary search tree 
		}catch (EmptyTreeException e) {
			e.printStackTrace(); //catches an error if tree is empty
		}
		
		while(tree.successor(tree.getRoot(), smallest.getLocation()) != null) { //while the successor of binary search tree
			//does not equal to null
			x = smallest.getLocation().xCoord() + x_offset - x_fig; //setting x to the coordinate of smallest + y offset - y figure
			y = smallest.getLocation().yCoord() + y_offset - y_fig; //setting y to the coordinate of smallest + y  offset - y figure
			if (gobj.findPixel(new Location(x, y))) { //if the pixel exists in the tree return true
				return true;
			}
			smallest = tree.successor(tree.getRoot(), smallest.getLocation()); //now setting smallest to the smallest of 
			// the successor in binary search tree of its location
		}
		return false;
	}
	
	/**
	 * Finds if the pixel value is in the tree
	 * @param p: the pixel value
	 * @return: return true if pixel value is in tree, false otherwise
	 */
	private boolean findPixel(Location p) {
		Pixel pixel = tree.get(tree.getRoot(), p); //checking if pixel is in tree
		if (pixel == null) {
			return false; //return false if pixel is not in tree
		}else {
			return true; //return true if pixel is in tree
		}
	}
}
