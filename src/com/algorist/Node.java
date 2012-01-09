package com.algorist;

public class Node {
	int item;
	Node next;

	public Node() {
	}
	
	public Node(int item) {
		this.item = item;
	}
	
	@Override
	public String toString() {
		return String.format("Node{%d}", item);
	}
}
