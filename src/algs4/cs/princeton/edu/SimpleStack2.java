package algs4.cs.princeton.edu;

/**
 * Stack implementation using a LinkedList
 * 
 * @author andres
 * 
 * @param <T>
 *            item type to store in the Stack
 */
public class SimpleStack2<T> {

	private Node<T> head;
	private int size;

	public boolean isEmpty() {
		return head == null;
	}

	public int size() {
		return size;
	}

	private static class Node<T> {
		T item;
		Node<T> next;

		public Node(T item, Node<T> next) {
			super();
			this.item = item;
			this.next = next;
		}
	}

	public void push(T item) {
		if (isEmpty()) {
			head = new Node<T>(item, null);
		} else {
			Node<T> newHead = new Node<T>(item, head);
			head = newHead;
		}
		size++;
	}

	public T pop() {
		if (isEmpty()) {
			throw new RuntimeException("empty stack");
		}
		T item = head.item;
		Node<T> next = head.next;
		head.next = null;
		head = next;
		size--;
		assert size > 0;
		return item;
	}

	public static void main(String[] args) {
		SimpleStack2<Integer> ss = new SimpleStack2<>();
		ss.push(5);
		ss.push(4);
		ss.push(3);
		ss.push(2);
		ss.push(1);
		ss.push(0);

		while (ss.size() > 0) {
			System.out.println(ss.pop());
		}
	}
}
