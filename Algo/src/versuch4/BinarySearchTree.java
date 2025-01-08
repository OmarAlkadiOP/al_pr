package versuch4;

import java.util.List;
import java.util.ArrayList;

public class BinarySearchTree{
	BinaryTreeNode root;
	
	public BinarySearchTree(int value) {
		root = new BinaryTreeNode(value);
	}
	
	
	public boolean search(int value) {
		BinaryTreeNode current = root; 
		while (current != null) {
			if (value < current.value) {
				current = current.leftChild; 
			} else if (value > current.value) { 
				current = current.rightChild; 
			} else {
				return true; 
			}
		} 
		return false;
	}
	
	
	public boolean insert(int value) { 
		if (root == null) { 
			root = new BinaryTreeNode(value); 
			return true;
		}
		
		BinaryTreeNode current = root; 
		BinaryTreeNode parent = null;
		while (current != null) {
			if (value < current.value) { 
				parent = current; 
				current = current.leftChild;
			} else if (value > current.value) { 
				parent = current; 
				current = current.rightChild; 
			} else { 
				current.value = value;
				return false; 
			}
		}
		
		if (value < parent.value) { 
			parent.leftChild = new BinaryTreeNode(value);
		} else {
			parent.rightChild = new BinaryTreeNode(value);
		}
		return true;
	}
	
	
	public String structure() {		
		return r_structure(root);
	}
	
	public String r_structure(BinaryTreeNode node) {
		String print=" "; 
		if (node != null) { 
			print += node.value; 
			print += " {" + r_structure(node.leftChild); 
			print += r_structure(node.rightChild) + " }";  
		} else {
			print += null;
		}

	    return print;
	}
	
//	public String inOrderAsList() {
//	    List<Integer> result = new ArrayList<>();
//	    r_inOrderAsList(root, result);
//	    return result.toString();
//	}
//
//	private void r_inOrderAsList(BinaryTreeNode node, List<Integer> result) {
//	    if (node != null) {
//	        r_inOrderAsList(node.leftChild, result);
//	        result.add(node.value);
//	        r_inOrderAsList(node.rightChild, result);
//	    }
//	}

	
	
	public String preOrder() {		
		return r_preOrder(root);
	}
	
	public String r_preOrder(BinaryTreeNode node) {
		String print = " " + node.value;
		if (node.leftChild != null) {
			 print += r_preOrder(node.leftChild);
		}
		if (node.rightChild != null) {
			 print += r_preOrder(node.rightChild);
		}
		return print;
	}
	
	
	public String inOrder() {
		return r_inOrder(root);
	}
	
	private String r_inOrder(BinaryTreeNode node) {
		String print = "";
		if (node.leftChild != null) {
			 print += r_inOrder(node.leftChild);
		}
		print += " " + node.value;
		if (node.rightChild != null) {
			 print += r_inOrder(node.rightChild);
		}
		return print;
	}
	
	
	public String postOrder() {
		return r_postOrder(root);
	}
	
	private String r_postOrder(BinaryTreeNode node) {
		String print = "";
		if (node.leftChild != null) {
			 print += r_postOrder(node.leftChild);
		}
		if (node.rightChild != null) {
			 print += r_postOrder(node.rightChild);
		}
		print += " " + node.value;
		return print;
	}

	
	public boolean delete(int value) {
		BinaryTreeNode current = root;
		BinaryTreeNode parent = null;
		boolean isLeftChild = false;
		
		while (current != null) {
			if (value < current.value) { 
				parent = current; 
				current = current.leftChild;
				isLeftChild = true;
			} else if (value > current.value) { 
				parent = current; 
				current = current.rightChild;
				isLeftChild = false;
			} else { 
				
				if (current.rightChild == null) {
					if (current.leftChild == null) {
						if (current == root) {
							root = null;
						} else if (isLeftChild == true) {
							parent.leftChild = null;
						} else {
							parent.rightChild = null;
						}
					} else {
						
						if (current == root) {
							root = current.leftChild;
						} else if (isLeftChild == true) {
							parent.leftChild = current.leftChild;
						} else {
							parent.rightChild = current.leftChild;
						}
					}
					
				} else if (current.leftChild == null) {
					if (current == root) {
						root = current.rightChild;
					} else if (isLeftChild == true) {
						parent.leftChild = current.rightChild;
					} else {
						parent.rightChild = current.rightChild;
					}
					
				} else {
					BinaryTreeNode successor = current.rightChild;
					BinaryTreeNode successorParent = parent;
					
					while (successor.leftChild != null) {
						successorParent = successor;
						successor = successor.leftChild;
					}
					
					current.value = successor.value;
					
					if (parent == successorParent) {
						current.rightChild = null;
					} else {
						successorParent.leftChild = null;
					}
				}
				return true; 
			}
		}
		return false;
	}
	
	
	public int getMin() { 
		BinaryTreeNode current = root;
		while (current.leftChild != null) {
			current = current.leftChild; 
		}
		return current.value;
	}
	
	
	public Integer getSuccessor(int value) {
		BinaryTreeNode current = root; 
		Integer nextBigger = Integer.MAX_VALUE; 
		
		while (current != null) { 
			if (current.value < nextBigger && current.value > value) {
				nextBigger = current.value; 
			}
			
			if (value < current.value) { 
				current = current.leftChild; 
			} else if (value > current.value) { 
				current = current.rightChild; 
			} else { 
				break; 
			} 
		}
		
		if (current == null || current.value != value) {
			return null; 
		}
		
		if (current.rightChild != null) { 
			current = current.rightChild; 
			while (current.leftChild != null) { 
				current = current.leftChild; 
			}
			return current.value; 
		} else {
			return (nextBigger < Integer.MAX_VALUE ? nextBigger : null);
		}
	} 
}
