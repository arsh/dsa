package com.algorist;

public class ReverseMyLinkedList {

	public static class Node<E> {
		E item;
		Node<E> next;

		public Node(E item, Node<E> next) {
			this.item = item;
			this.next = next;
		}

		@Override
		public String toString() {
			return item.toString();
		}
	}

	public static void main(String[] args) {
		// build linked list
		Node<Integer> five = new Node(5, null);
		Node<Integer> four = new Node(4, five);
		Node<Integer> three = new Node(3, four);
		Node<Integer> two = new Node(2, three);
		Node<Integer> one = new Node(1, two);

		System.out.println("before");
		print(one);
		System.out.println("after");
		print(reverse(one));

	}

	public static Node<Integer> reverse(Node<Integer> root) {
		Node<Integer> p = root;
		Node<Integer> n = p.next;
		p.next = null;
		while (n != null) {
			Node<Integer> t = n.next;
			n.next = p;
			p = n;
			n = t;
		}
		return p;
	}

	public static void print(Node<Integer> root) {
		System.out.print("[" + root);
		while (root.next != null) {
			System.out.print("," + root.next);
			root = root.next;
		}
		System.out.print("]\n");
	}

}
