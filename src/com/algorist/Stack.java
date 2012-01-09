package com.algorist;

public class Stack {
	private List list;

	public Stack() {
		this.list = new List();
	}

	public Node pop() {
		Node head = list.head;
		if (head != null)
			list.delete(head.item);
		return head;
	}

	public void push(int item) {
		list.insert(item);
	}

	public static void main(String[] args) {
		Stack q = new Stack();
		q.push(5);
		q.push(7);
		q.push(1);

		System.out.println(q.pop());
		System.out.println(q.pop());
		System.out.println(q.pop());
		System.out.println(q.pop());

	}
}
