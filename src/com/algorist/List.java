package com.algorist;

public class List {
	Node head;

	public void insert(int item) {
		if (head == null)
			head = new Node(item);
		else {
			Node newHead = new Node(item);
			newHead.next = head;
			head = newHead;
		}
	}

	public void print() {
		Node t = head;
		while (t != null) {
			System.out.println(t.item);
			t = t.next;
		}
	}

	public Node rSearch(Node root, int item) {
		if (root == null)
			return null;
		if (root.item == item)
			return root;
		return rSearch(root.next, item);
	}

	public Node iSearch(int item) {
		Node t = head;
		while (t != null) {
			if (t.item == item)
				return t;
			t = t.next;
		}
		return null;
	}

	public boolean delete(int item) {
		if (isEmpty())
			return false;

		Node parent = iParent(item);

		if (parent == null) {
			// item is head
			head = head.next;
			return true;
		}

		Node toDelete = parent.next;
		parent.next = toDelete.next;
		return true;
	}

	public boolean isEmpty() {
		return head == null;
	}

	public Node iParent(int item) {
		Node t = head;
		while (t != null && t.next != null) {
			if (t.next.item == item)
				return t;
			t = t.next;
		}
		return null;
	}

	public Node rParent(Node root, int item) {
		if (root == null || root.next == null)
			return null;
		if (root.next.item == item)
			return root;
		else
			return rParent(root.next, item);
	}

	public static void main(String[] args) {
		List list = new List();
		list.insert(5);
		list.insert(6);
		list.insert(7);
		list.insert(9);
		list.insert(2);
		list.print();
		System.out.println("--------");
		list.delete(6);
		list.print();

	}
}
