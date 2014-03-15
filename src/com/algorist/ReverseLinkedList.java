package com.algorist;

import java.util.LinkedList;
import java.util.Random;
import java.util.Stack;

public class ReverseLinkedList {

	public static void main(String[] args) {
		LinkedList<Integer> ll = new LinkedList<Integer>();
		Random r = new Random();
		for (int i = 0; i < 10; i++) {
			ll.add(r.nextInt(20));
		}

		System.out.println("before:" + ll);

		ll = reverse(ll);

		System.out.println("after:" + ll);

	}

	public static LinkedList<Integer> reverse(LinkedList<Integer> ll) {
		Stack<Integer> stack = new Stack<Integer>();
		for (Integer i : ll) {
			stack.push(i);
		}

		LinkedList<Integer> reversedLinkedList = new LinkedList<Integer>();

		while (!stack.isEmpty()) {
			reversedLinkedList.add(stack.pop());
		}

		return reversedLinkedList;
	}
}
