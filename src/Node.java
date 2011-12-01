/**
 * This is a node for a Linked List data structure
 * 
 * @author asantana
 * 
 */
public class Node {
	int value;
	Node next;

	public Node(int value) {
		this.value = value;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Node))
			return false;
		Node other = (Node) obj;
		return other.value == value;
	}
}
