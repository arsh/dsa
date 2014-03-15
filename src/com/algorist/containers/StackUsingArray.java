package com.algorist.containers;

import java.util.Arrays;

/**
 * Implementation of a Stack using array. This is a fixed stack, it doesn't grow automatically
 * 
 * @author hernaa
 * 
 */
public class StackUsingArray {
	private final int[] data;
	private int length;

	public StackUsingArray(int capacity) {
		data = new int[capacity];
		length = 0;
	}

	public boolean isFull() {
		return length == data.length;
	}
	
	public boolean isEmpty() {
		return length == 0;
	}
	
	public int size() {
		return length;
	}

	public void push(int item) {
		if (isFull()) {
			throw new RuntimeException("full stack");
		}
		data[length++] = item;
	}

	public int pop() {
		if (length == 0) {
			throw new RuntimeException("empty stack");
		}
		int popped = data[--length];
		data[length] = 0;
		return popped;
	}

	@Override
	public String toString() {
		return Arrays.toString(data);
	}
}
