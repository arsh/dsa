package dsa.annotated;
/**
 * Binary Search Tree node
 * 
 * @author asantana
 * 
 */

public class BSTNode {
	public int value;
	public BSTNode left;
	public BSTNode right;

	public BSTNode(int value) {
		this.value = value;
	}

	public BSTNode(int value, BSTNode left, BSTNode right) {
		this.value = value;
		this.left = left;
		this.right = right;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof BSTNode))
			return false;
		BSTNode other = (BSTNode) obj;
		return this.value == other.value;
	}

	@Override
	public String toString() {
		return "" + value;
	}
}
