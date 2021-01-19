/**
 * 
 * @author Wendy Li
 * Student number: 251026390
 * CS2210 Assignment 4
 *
 */
public class BinaryNode {	
	//initializing private variables
	private Pixel value;
	private BinaryNode left;
	private BinaryNode right;
	private BinaryNode parent;
	
	/**
	 * constructor of the class
	 * @param value: this.value is set to value
	 * @param left: this.left is set to left
	 * @param right: this.right is set to right
	 * @param parent: this.parent is set to parent
	 */
	public BinaryNode(Pixel value, BinaryNode left, BinaryNode right, BinaryNode parent) {
		this.value = value;
		this.left = left;
		this.right = right;
		this.parent = parent;
	}
	
	/**
	 * creates a new BinaryNode type that is a leaf (where value, left, right
	 * and parent are all set to null)
	 */
	public BinaryNode() {
		this.value = null;
		this.left = null;
		this.right = null;
		this.parent = null;
	}
	
	/**
	 * This method returns the parent of this
	 * @return: the parent of the node
	 */
	public BinaryNode getParent() {
		return parent;
	}
	
	/**
	 * This method sets the node's parents to BinaryNode parent
	 * @param parent: the BinaryNode's parent 
	 */
	public void setParent(BinaryNode parent) {
		this.parent = parent;
	}
	
	/**
	 * This method sets the left of the node the the param BinaryNode p
	 * @param p: the left of the binary node
	 */
	public void setLeft(BinaryNode p) {
		this.left = p;
	}
	
	/**
	 * This method sets the right of the node the the param BinaryNode p
	 * @param p: the right of the binary node
	 */
	public void setRight(BinaryNode p) {
		this.right = p;
	}
	
	/**
	 * This method sets the data of the node to the param Pixel value
	 * @param value: set the data of the node to value
	 */
	public void setData(Pixel value) {
		this.value = value;
	}
	
	/**
	 * Checking to see if the node is a leaf
	 * @return: true if it is a leaf, false if it not a leaf
	 */
	public boolean isLeaf() {
		if ((right == null) && (left == null) && (value == null)) {// checking if node is a leaf
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * @return: returning value of this
	 */
	public Pixel getData() {
		return value;
	}
	
	/**
	 * 
	 * @return: returning the left node of this
	 */
	public BinaryNode getLeft() {
		return left;
	}
	
	/**
	 * 
	 * @return: returning the right node of this
	 */
	public BinaryNode getRight() {
		return right;
	}
}
