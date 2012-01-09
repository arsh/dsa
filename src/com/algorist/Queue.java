package com.algorist;

public class Queue {
	private List list;
	private Node tail;
	
	public Queue() {
		list = new List();
	}

	public void queue(int item) {
		list.insert(item);
		if (tail == null)
			tail = list.head;
	}

	public Node dequeue() {
		if (tail == null)
			return null;

		Node parent = list.iParent(tail.item);
		list.delete(tail.item);
		Node ret = tail;
		tail = parent;
		return ret;
	}
	
	public static void main(String[] args) {
		Queue q = new Queue();
		q.queue(1);
		q.queue(2);
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
	}
}
