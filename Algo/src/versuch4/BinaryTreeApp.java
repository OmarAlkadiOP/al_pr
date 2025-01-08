package versuch4;

public class BinaryTreeApp {
	public static void main(String[] args) {
		int[] arr = {5,3,7,6,10,12,9};
		
		BinarySearchTree myTree = new BinarySearchTree(5);
		for (int i=1; i<arr.length; i++) {
			myTree.insert(arr[i]);
		}
		
		System.out.println("Structure: " + myTree.structure());
		//System.out.println("Structure 2: " + myTree.inOrderAsList());
		System.out.println("PreOrder: " + myTree.preOrder());
		System.out.println("InOrder: " + myTree.inOrder());
		System.out.println("PostOrder: " + myTree.postOrder());
		
		System.out.println("Suche nach 12,8: "  + myTree.search(12) + "," + myTree.search(8));
		System.out.println("Lösche 12,8: " + myTree.delete(12) + "," + myTree.delete(8));
		System.out.println("Suche Minimum: " + myTree.getMin());
		System.out.println("Suche Nachfolger von 7,10,8: " + myTree.getSuccessor(7) + "," + myTree.getSuccessor(10) + "," + myTree.getSuccessor(8));
	}
}
