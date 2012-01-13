package generic;

import java.util.Arrays;

public class Sorting {

	public static void main(String[] args) {
		int[] a = new int[] { 2, 4, 6, 8 };
		int[] b = new int[] { 3, 5, 7, 9 };
		System.out.println(Arrays.toString(merge(a, b)));
	}

	public static int[] bubbleSort(int toSort[]) {
		int n = toSort.length;
		boolean switched = true;
		for (int i = 0; i < n && switched; i++) {
			switched = false;
			for (int y = 0; y < n - 1 - i; y++) {
				if (toSort[y] > toSort[y + 1]) {
					int max = toSort[y];
					toSort[y] = toSort[y + 1];
					toSort[y + 1] = max;
					switched = true;
				}

			}
		}
		return toSort;
	}

	public static int[] merge(int[] a, int[] b) {
		int[] c = new int[a.length + b.length];
		int i = 0, j = 0, k = 0;
		while (i < a.length && j < b.length) {
			if (a[i] < b[j]) {
				c[k++] = a[i++];
			} else if (a[i] > b[j]) {
				c[k++] = b[j++];
			}
		}
		while (i < a.length) {
			c[k++] = a[i++];
		}
		while (j < b.length) {
			c[k++] = b[j++];
		}
		return c;
	}
}
