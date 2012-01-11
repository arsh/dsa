package com.algorist;

import java.util.Arrays;

public class Heap {
	private int[] data;
	private int size;

	public Heap(int capacity) {
		data = new int[capacity];
		size = 0;
	}

	public int getParentIndex(int i) {
		return (i - 1) / 2;
	}

	public int getLeftChildIndex(int i) {
		return (i * 2) + 1;
	}

	public int getRightChildIndex(int i) {
		return (i * 2) + 2;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public String toString() {
		return Arrays.toString(data);
	}

	public int getLastIndex() {
		return size - 1;
	}

	private void swap(int i, int j) {
		int t = data[i];
		data[i] = data[j];
		data[j] = t;
	}

	public void insert(int value) {
		if (size == data.length)
			throw new RuntimeException("capacity exceeded");
		data[size] = value;
		int nodeIndex = size;
		size++;
		int parentIndex = getParentIndex(nodeIndex);
		while (parentIndex >= 0 && data[nodeIndex] < data[parentIndex]) {
			swap(parentIndex, nodeIndex);
			nodeIndex = parentIndex;
		}
	}

	public int removeMin() {
		int min = data[0];
		data[0] = data[getLastIndex()];
		data[getLastIndex()] = 0;
		size--;

		int leftChild, rightChild;
		leftChild = getLeftChildIndex(0);
		rightChild = getRightChildIndex(0);

		if (leftChild + rightChild < 0)
			return min;

		return min;
	}

	public static void main(String[] args) {
		Heap heap = new Heap(3);
		heap.insert(3);
		heap.insert(2);
		heap.insert(1);
		System.out.println(heap);
	}
}
