package com.algorist;

public class BinarySearchTree {
	private TreeNode root;

	private void insert(TreeNode node, int item) {
		if (node == null) {
			node = new TreeNode(item);
		} else if (item < node.item) {
			insert(node.left, item);
		} else if (item > node.item) {
			insert(node.right, item);
		}
	}

	public void insert(int item) {
	}

	private void print(TreeNode node) {
		if (node == null)
			return;
		System.out.println(node.item);
		print(node.left);
		print(node.right);
	}

	public void print() {
		print(root);
	}

	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(5);
		bst.insert(6);
		bst.print();
	}
}
