package org.algoclass;

import java.util.Arrays;

public class MergeSort {

	public static int[] mergeSort(int[] input) {
		int len = input.length;
		if (len == 0 || len == 1)
			return input;
		int[] a = new int[len / 2];
		int[] b = new int[len / 2];
		System.arraycopy(input, 0, a, 0, len / 2);
		System.arraycopy(input, len / 2, b, 0, len / 2);
		return merge(mergeSort(a), mergeSort(b));
	}

	private static int[] merge(int[] a, int[] b) {
		int[] c = new int[a.length + b.length];
		int indexA = 0, indexB = 0;
		for (int indexC = 0; indexC < c.length; indexC++) {
			if (indexA < a.length && (indexB == b.length || a[indexA] <= b[indexB]))
				c[indexC] = a[indexA++];
			else if (indexB < b.length && (indexA == a.length || a[indexA] > b[indexB]))
				c[indexC] = b[indexB++];
		}
		return c;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(mergeSort(new int[] { 1, 4, 10, 2, 0, 4, 68, 56, 20, 0, 12 })));
	}
}
