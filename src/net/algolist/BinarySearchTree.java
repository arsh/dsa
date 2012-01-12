package net.algolist;

public class BinarySearchTree {
	private BSTNode root;

	public BinarySearchTree() {
		root = null;
	}

	public boolean add(int value) {
		if (root == null) {
			root = new BSTNode(value);
			return true;
		}
		return add(root, value);
	}

	public boolean add(BSTNode node, int value) {
		if (value < node.value)
			if (node.left != null)
				return add(node.left, value);
			else {
				node.left = new BSTNode(value);
				return true;
			}
		else if (value > node.value)
			if (node.right != null)
				return add(node.right, value);
			else {
				node.right = new BSTNode(value);
				return true;
			}
		return false;
	}

	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		bst.add(5);
		bst.add(7);
	}
}