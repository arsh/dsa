import java.io.BufferedReader;
import java.util.Stack;

public class BST {
	public BSTNode root;

	public void insert(int value) {
		if (root == null)
			root = new BSTNode(value);
		else
			insertNode(root, value);
	}

	public void insertNode(BSTNode current, int value) {
		if (value < current.value) {
			if (current.left == null)
				current.left = new BSTNode(value);
			else
				insertNode(current.left, value);

		} else {
			if (current.right == null)
				current.right = new BSTNode(value);
			else
				insertNode(current.right, value);
		}
	}

	public boolean contains(int value) {
		return contains(root, value);
	}

	public boolean contains(BSTNode current, int value) {
		if (current == null)
			return false;
		if (current.value == value) {
			return true;
		} else if (value < current.value) {
			return contains(current.left, value);
		} else {
			return contains(current.right, value);
		}
	}

	public boolean remove(int value) {
		BSTNode nodeToRemove = findNode(value);
		if (nodeToRemove == null)
			return false;
		BSTNode parent = findParent(value);
		if (countNodes() == 1) {
			root = null;
			return true;
		}
		if (parent != null) {
			if (nodeToRemove.left == null && nodeToRemove.right == null) {
				if (nodeToRemove.value < parent.value)
					parent.left = null;
				else
					parent.right = null;
			} else if (nodeToRemove.left == null && nodeToRemove.right != null) {
				if (nodeToRemove.value < parent.value)
					parent.left = nodeToRemove.right;
				else
					parent.right = nodeToRemove.right;
			} else if (nodeToRemove.left != null && nodeToRemove.right == null) {
				if (nodeToRemove.value < parent.value)
					parent.left = nodeToRemove.left;
				else
					parent.right = nodeToRemove.left;
			}
		}
		if (parent == null || (nodeToRemove.left != null && nodeToRemove.right != null)) {
			BSTNode largestValue = nodeToRemove.left;
			while (largestValue.right != null)
				largestValue = largestValue.right;

			BSTNode largestParent = findParent(largestValue.value);
			if (largestValue.value < largestParent.value)
				largestParent.left = null;
			else if (largestValue.value > largestParent.value)
				largestParent.right = null;
			nodeToRemove.value = largestValue.value;
		}
		return true;
	}

	public BSTNode findParent(int value, BSTNode root) {
		if (root == null || root.value == value)
			return null;
		if (value < root.value) {
			if (root.left == null)
				return null;
			else if (root.left.value == value)
				return root;
			else
				return findParent(value, root.left);
		} else {
			if (root.right == null)
				return null;
			else if (root.right.value == value)
				return root;
			else
				return findParent(value, root.right);
		}
	}

	public BSTNode findParent(int value) {
		return findParent(value, root);
	}

	public BSTNode findNode(BSTNode root, int value) {
		if (root == null)
			return null;
		if (root.value == value) {
			return root;
		} else if (value < root.value) {
			return findNode(root.left, value);
		} else
			return findNode(root.right, value);
	}

	public BSTNode findNode(int value) {
		return findNode(root, value);
	}

	public int countNodes(BSTNode root) {
		if (root == null)
			return 0;
		int count = 1;
		if (root.left != null)
			count += countNodes(root.left);
		if (root.right != null)
			count += countNodes(root.right);
		return count;
	}

	public int countNodes() {
		return countNodes(root);
	}

	public int findMin() {
		BSTNode current = root;
		while (current.left != null)
			current = current.left;
		return current.value;
	}

	public int findMax() {
		BSTNode current = root;
		while (current.right != null)
			current = current.right;
		return current.value;
	}

	public String preOrder() {
		String preOrder = preOrder(root);
		return preOrder.substring(0, preOrder.length() - 1);
	}

	public String preOrder(BSTNode root) {
		StringBuffer sb = new StringBuffer();
		if (root != null) {
			sb.append(root.value).append(",");
			sb.append(preOrder(root.left));
			sb.append(preOrder(root.right));
		}
		return sb.toString();
	}
}
