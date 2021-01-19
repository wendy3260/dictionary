/**
 * 
 * @author Wendy Li
 * Student number: 251026390
 * CS2210 Assignment 4
 *
 */
public class BinarySearchTree {
	
	private BinaryNode root; //declaring the BinaryNode root
	/**
	 * the constructor of the class
	 */
	public BinarySearchTree() {
		this.root = new BinaryNode();  //creating a new binary tree with just the root
	}
	
	/**
	 * recursively searches through the binary search tree for Location key given in 
	 * parameter
	 * @param r: the root of the binary search tree
	 * @param key: the Location key that we are looking for
	 * @return returns the data of the node with Location key. Otherwise returns null
	 */
	public Pixel get(BinaryNode r, Location key) { 
		if (r.isLeaf()) {
			return r.getData();
		}else if (key.compareTo(r.getData().getLocation()) == 0) { //if they are equal, return the data of r
			return r.getData(); 
		}else if(key.compareTo(r.getData().getLocation()) > 0) { //if the key is greater than r, recursively search 
			//the right side of the binary search tree
			return get(r.getRight(),key); 
		}else if (key.compareTo(r.getData().getLocation()) < 0) { //if the key is smaller than r, recursively search
			//the left side of the binary search tree
			return get(r.getLeft(), key);
		}else { 
			return null; 
		}		 
	}

	/**
	 * Inserts node with Pixel data into the Binary search tree r, throws a DuplicatexKeyException if
	 * trying to insert in a node where left and right child aren't leaves
	 * @param r: the Pixel of the node we want to insert
	 * @throws DuplicatedKeyException: throws this exception if key with Pixel data already exists
	 */
	public void put(BinaryNode r, Pixel data) throws DuplicatedKeyException{
		BinaryNode node = getNode(r, data.getLocation());
		if ((node.getLeft() != null) || (node.getRight() != null)) { //if the left or tge right child  arent
			//leaves, throw a duplicated key 
			throw new DuplicatedKeyException(data);
		}else {
			node.setData(data);
			BinaryNode leftChild = new BinaryNode();
			BinaryNode rightChild = new BinaryNode();
			
			//have to create left and right child for node
			node.setLeft(leftChild); 
			node.setRight(rightChild);
			
			//need to link between node.children and the children and the node (its parents) 
			leftChild.setParent(node);
			rightChild.setParent(node);

		}
	}
	
	/**
	 * Removes the node with Location key in the binary search tree with root r
	 * @param r: the binary search tree
	 * @param key: removing the node with the Location key
	 * @throws InexistentKeyException: throws an InexistentKeyException if the key 
	 * we are trying to move does not exist
	 */
	public void remove(BinaryNode r, Location key) throws InexistentKeyException{
		//initializing variables
		BinaryNode node = getNode(r, key);
		BinaryNode parent = node.getParent();
		BinaryNode leftChild = new BinaryNode();
		BinaryNode rightChild = new BinaryNode();
		Pixel pixel;
		
		if (node.isLeaf()) {// if node is leaf then throw InexistentKeyException
			throw new InexistentKeyException(key);
		}else if(node.getLeft().isLeaf() || node.getRight().isLeaf()) {
			if (node.equals(r)) { //if node is the root of the binary search tree
				if (r.getLeft().isLeaf() && node.getRight().isLeaf()) {
					//set everything to null to create a new leaf
					node.setData(null);
					node.setLeft(null);
					node.setRight(null);
					node.setParent(null);
				}
			}else if(node.getLeft().isLeaf()) { //if the left child is a node
				rightChild = node.getRight(); //setting rightChild to the right child of node
				rightChild.setParent(parent); //setting rightChild's parent to parent
				if (node.getData().getLocation().compareTo(parent.getData().getLocation()) < 0) {//checking if node is
					//left child of parent
					parent.setLeft(rightChild);//removing node by setting parent's left child to its right child 
				}else {
					parent.setRight(rightChild); //else setting node's parent's right child to the right child of node
				}
			}else {
				leftChild = node.getLeft();
				if(node.getData().getLocation().compareTo(parent.getData().getLocation()) < 0) { //checking if node 
					//is left child of parent
					parent.setLeft(leftChild);//removing node by setting parent's right child to its left child 
				}else {
					parent.setRight(leftChild); //else setting node's parent's left child to the left child of node
				}
			}
		}else {//if both children of node are not leaves
			pixel = smallest(node.getRight()); //get the smallest pixel Value of node's right child
			BinaryNode smallest = getNode(r, pixel.getLocation()); //finding the node with the pixel value smallest
			node.setData(pixel); //setting the node's data to Location pixel
			remove(smallest, pixel.getLocation()); //removing the Location pixel in the sub binary tree with root smallest
		}
	}
	
	/**
	 * This function finds the smallest value greater than the node with Location key in the binary search tree 
	 * r
	 * @param r: the binary search tree
	 * @param key: finding the successor of BinaryNode with Location key
	 * @return: returns the the smallest value greater than the node with Location key in bst
	 */
	public Pixel successor(BinaryNode r, Location key) {
		BinaryNode node = getNode(r, key);
		BinaryNode parent = node.getParent();
		if (r.isLeaf()) { //if tree is empty, return null
			return null;
		}else {
			if (!node.isLeaf() && !node.getRight().isLeaf()) { //if node is an internal node
				return smallest(node.getRight());
			}else {
				while((node != r) && (parent.getRight().equals(node))) { //else if node is not an internal node
					//going up the bst until node is not the right child of node
					node = parent;
					parent = parent.getParent();
				}
				if (node == r) { //if node is the root, return null
					return null;
				}else {
					return parent.getData(); //return the parent of node
				}
			}
		}
	}
	
	/**
	 * This function finds the largest value smaller than the node with Location key in the binary search tree 
	 * r
	 * @param r: the binary search tree
	 * @param key: finding the predecessor of BinaryNode with Location key
	 * @return: return the predecessor of BinaryNode with Location key in the binary search tree with root r
	 */
	public Pixel predecessor(BinaryNode r, Location key) {
		BinaryNode node = getNode(r, key);
		BinaryNode parent = node.getParent();
		if (r == null) { //if tree is empty, return null
			return null;
		}else {
			if ((!node.getLeft().isLeaf() && !node.getRight().isLeaf()) &&
					!node.getRight().getLeft().isLeaf() && !node.getRight().getRight().isLeaf()) {  //if node is an internal node
				return largest(node.getLeft());
			}else {
				if(!parent.getLeft().isLeaf()) { //if node is an internal node
					if (parent.getLeft().getData().getLocation().compareTo(node.getData().getLocation()) != 0) {
						return largest(node.getLeft());
					}
					//else if node is not an internal node going up the bst until node is not the left child of node
					while((node != r) && (parent.getLeft().getData().getLocation().compareTo(node.getData().getLocation()) == 0)) {
						node = parent;
						parent = node.getParent();
					}
				}
				if (node == r) {//if node is the root, return null
					return null;
				}else {
					return parent.getData();//return the parent of node
				}
			}
		}
	}
	
	/**
	 * returns the largest pixel in binary search tree with root r
	 * @param r: the root of binary search tree
	 * @return: returns the largest Pixel value in the binary search tree with root r 
	 * @throws EmptyTreeException: throws this exception if the tree is empty
	 */
	public Pixel largest(BinaryNode r) throws EmptyTreeException{
		if (r.isLeaf()) { //if tree is empty throw EmptyTreeException
			throw new EmptyTreeException();
		}else {
			while (!r.getRight().isLeaf()) { //continue looping and getting the right child of r until r is a leaf
				r = r.getRight();
			}
			return r.getData(); //return the Pixel value that is the greatest
		}
	}
	
	/**
	 * returns the smallest pixel in binary search tree with root r
	 * @param r: the root of binary search tree
	 * @return: returns the smallest Pixel value in the binary search tree with root r 
	 * @throws EmptyTreeException: throws this exception if the tree is empty
	 */
	public Pixel smallest(BinaryNode r) throws EmptyTreeException{
		if (r.isLeaf()) {
			throw new EmptyTreeException();
		}else {
			while (!r.getLeft().isLeaf()) {//continue looping and getting the left child of r until r is a leaf
				r = r.getLeft();
			}
			return r.getData();//return the Pixel value that is the greatest
		}
	}
	
	/**
	 * 
	 * @return the root of this.tree
	 */
	public BinaryNode getRoot() {
		return this.root;
	}
	
	/**
	 * Returns the node with Location value key in the binary search tree with root r 
	 * @param r: binary search tree
	 * @param key: returning the node with the Location key
	 * @return returning the node that has the value Location key
	 */
	private BinaryNode getNode(BinaryNode r, Location key) {
		if (r.isLeaf()) { //if r is a leaf return r
			return r;
		}else if (key.compareTo(r.getData().getLocation()) == 0) { //if r is equal to the key, return r
			return r;
		}else if(key.compareTo(r.getData().getLocation()) > 0) { //if r is greater than the key, recursively search
			//right side of the tree
			return getNode(r.getRight(), key);
		}else if (key.compareTo(r.getData().getLocation()) < 0) { //if r is smaller than the key, recursively search
			//the left side of the tree
			return getNode(r.getLeft(), key);
		}else { //otherwise return binary node r
			return r;
		}
	}
	
}
