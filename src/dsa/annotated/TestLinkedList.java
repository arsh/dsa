package dsa.annotated;
/**
 * This class tests my linked list implemantation
 * 
 * @author asantana
 * 
 */
public class TestLinkedList extends TestingClass {
	public static void main(String[] args) throws Exception {
		new TestLinkedList().runAllTest();
	}

	public void testAdd() {
		LinkedList ll = new LinkedList();
		ll.add(new Node(2));
		assert ll.head.equals(ll.tail);
		ll.add(new Node(3));
		assert !ll.head.equals(ll.tail);
	}

	public void testPrint() {
		LinkedList ll = new LinkedList();
		ll.add(new Node(2));
		ll.add(new Node(3));
		assert "2,3".equals(ll.toString());
	}

	public void testContains() {
		LinkedList ll = new LinkedList();
		ll.add(new Node(2));
		ll.add(new Node(3));
		ll.add(new Node(5));
		ll.add(new Node(9));
		assert ll.contains(new Node(9));
		assert !ll.contains(new Node(90));
	}

	public void testDelete() {
		LinkedList ll = new LinkedList();
		ll.add(new Node(2));
		ll.add(new Node(3));
		ll.add(new Node(5));
		assert ll.delete(new Node(3));
		assert !ll.delete(new Node(50));
		ll.delete(new Node(2));
		assert ll.head.equals(new Node(5));
		assert ll.head.equals(ll.tail);
	}

	public void testToStringReverse() {
		LinkedList ll = new LinkedList();
		ll.add(new Node(1));
		ll.add(new Node(2));
		ll.add(new Node(3));
		ll.add(new Node(4));
		ll.add(new Node(5));
		assert "5,4,3,2,1".equals(ll.toStringReverse()) : "failed at 1";
		ll.delete(new Node(3));
		assert "5,4,2,1".equals(ll.toStringReverse()) : "failed at 2";
		ll.delete(new Node(1));
		ll.delete(new Node(2));
		ll.delete(new Node(4));
		ll.delete(new Node(5));
		assert "".equals(ll.toStringReverse()) : "failed at 3";
	}
}
