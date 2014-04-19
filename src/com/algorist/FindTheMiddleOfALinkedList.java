package com.algorist;

import java.util.Random;

public class FindTheMiddleOfALinkedList {

	public static void main(String[] args) {
		List ll = new List();
		Random r = new Random();
		int max = r.nextInt(10);
		for (int i = 1; i < max; i++) {
			ll.insert(i);
		}

		ll.print();

		printMiddle(ll);
	}

	public static void printMiddle(List ll) {
		Node node = ll.head;
		Node middle = node;
		int c = 1;
		while (node.next != null) {
			if (c % 2 == 0) {
				middle = middle.next;
			}
			node = node.next;
			c++;
		}

		System.out.printf("*** total=%d; middle=%d\n", c, middle.item);
	}
}
