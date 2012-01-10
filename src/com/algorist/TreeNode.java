package com.algorist;

public class TreeNode {
	int item;
	TreeNode left;
	TreeNode right;

	public TreeNode() {
	}

	public TreeNode(int item) {
		this.item = item;
	}

	@Override
	public String toString() {
		return String.format("TreeNode{%d}", item);
	}
}
