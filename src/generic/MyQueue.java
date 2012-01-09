package generic;
import dsa.annotated.Node;

public class MyQueue {
	Node head;
	Node tail;

	public void queue(int n) {
		if (tail == null) {
			head = tail = new Node(n);
		} else {
			tail.next = new Node(n);
			tail = tail.next;
		}
	}

	public Node dequeue() {
		Node d = head;
		if (d != null) {
			head = d.next;
			return d;
		} else
			return null;
	}

	public static void main(String[] args) {
		MyQueue q = new MyQueue();
		q.queue(1);
		q.queue(2);
		q.queue(3);
		q.queue(4);
		q.queue(5);
	}
}
