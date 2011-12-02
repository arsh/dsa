/**
 * Testing my Binary Search Tree
 * 
 * @author asantana
 * 
 */
public class TestBST extends TestingClass {

	public static void main(String[] args) {
		new TestBST().runAllTest();
	}

	public void testInsert() {
		BST bst = new BST();
		bst.insert(23);
		assert bst.root != null : "root is null";
		assert bst.root.equals(new BSTNode(23)) : "root are not equals";
		bst.insert(14);
		assert bst.root.left != null;
		assert bst.root.left.equals(new BSTNode(14));
		bst.insert(31);
		assert bst.root.right != null;
		assert bst.root.right.equals(new BSTNode(31));
	}

	public void testContains() {
		BST bst = basicBST();
		assert bst.contains(14) : "contains 14";
		assert bst.contains(23) : "contains 23";
		assert bst.contains(31) : "contains 31";

		assert !bst.contains(235) : "contains 235";
		assert !bst.contains(20) : "contains 20";
	}

	private BST basicBST() {
		BST bst = new BST();
		bst.insert(23);
		bst.insert(14);
		bst.insert(31);
		bst.insert(7);
		bst.insert(17);
		bst.insert(9);
		return bst;
	}

	public void testRemove() {
		BST bst = basicBST();
		bst.remove(14);
		assert bst.root.left.equals(new BSTNode(9)) : "removed:14";
		bst.remove(31);
		assert bst.root.right == null : "removed:31";
		bst.remove(9);
		assert bst.root.left.right.equals(new BSTNode(17)) : "removed:9";
		bst.remove(17);
		assert bst.root.left.equals(new BSTNode(7)) : "removed:17";
		bst.remove(23);
		assert bst.root.equals(new BSTNode(7)) : "removed:23";
		bst.remove(7);
		assert bst.root == null : "removed:7";
	}

	public void testFindParent() {
		BST bst = basicBST();
		assert bst.findParent(9) != null : "findParent(9)";
		assert bst.findParent(9).equals(new BSTNode(7)) : "findParent(9).equals";
		assert bst.findParent(23) == null;
		assert bst.findParent(31) != null : "findParent(31)";
		assert bst.findParent(31).equals(new BSTNode(23)) : "findParent(31).equals";
	}

	public void testFindNode() {
		BST bst = basicBST();
		assert bst.findNode(9) != null : "findNode(9) != null";
		assert bst.findNode(9).equals(new BSTNode(9)) : "findNode(9).equals";
		assert bst.findNode(90) == null : "findNode(90) == null";
	}

	public void testCountNodes() {
		BST bst = basicBST();
		assert bst.countNodes() == 6 : "count 6";
		bst.remove(14);
		assert bst.countNodes() == 5 : "count 5";
		bst = new BST();
		assert bst.countNodes() == 0 : "count 0";
		bst.insert(3);
		assert bst.countNodes() == 1 : "count 1";

	}

	public void testFindMin() {
		BST bst = basicBST();
		assert bst.findMin() == 7 : "min:7";
		bst.remove(7);
		assert bst.findMin() == 9 : "min:9";
	}

	public void testFindMax() {
		BST bst = basicBST();
		assert bst.findMax() == 31 : "max:31";
		bst.remove(31);
		assert bst.findMax() == 23 : "max:23";
	}

	public void testPreOrder() {
		BST bst = basicBST();
		assert "23,14,7,9,17,31".equals(bst.preOrder()) : "preorder 1";
		assert "23,14,7,9,17,31".equals(bst.preOrderRecursive()) : "preorder recursive 1";
		bst.remove(14);
		assert "23,9,7,17,31".equals(bst.preOrder()) : "preorder 2";
		assert "23,9,7,17,31".equals(bst.preOrderRecursive()) : "preorder recursive 2";
	}
}
