package dsa.aho;

import java.util.Arrays;

public class Sorting {

	private static int swapCount = 0;

	/**
	 * from the book
	 */
	public static void bubblesort(int[] elements) {
		int n = elements.length;
		for (int i = 0; i < n; i++)
			for (int j = n - 1; j > i; j--)
				if (elements[j] < elements[j - 1])
					swap(elements, j, j - 1);
	}

	/**
	 * my implementation
	 */
	public static void bubblesort2(int[] elements) {
		boolean switched = true;
		int n = elements.length;
		for (int i = 0; switched && i < n; i++) {
			switched = false;
			for (int j = 0; j < n - 1; j++) {
				if (elements[j] > elements[j + 1]) {
					swap(elements, j, j + 1);
					switched = true;
				}
			}
		}
	}

	/**
	 * my implementation
	 */
	public static void insertionsort2(int[] elements) {
		int n = elements.length;
		for (int i = 1; i < n; i++) {
			int j = i;
			while (j > 0 && (elements[j] < elements[j - 1])) {
				swap(elements, j, j - 1);
				j--;
			}
		}
	}

	/**
	 * 
	 * my implementation
	 * 
	 */
	public static void selectionsort2(int[] elements) {
		for (int i = 0; i < elements.length; i++) {
			for (int j = i + 1; j < elements.length; j++) {
				if (elements[j] < elements[i]) {
					swap(elements, i, j);
				}
			}
		}
	}

	private static void swap(int[] elements, int x, int y) {
		swapCount++;
		int t = elements[x];
		elements[x] = elements[y];
		elements[y] = t;
	}

	private static int partition2(int[] arr, int l, int h) {
		int i;
		int p;
		int firsthigh;
		p = h;
		firsthigh = l;
		for (i = l; i < h; i++)
			if (arr[i] < arr[p]) {
				swap(arr, i, firsthigh);
				firsthigh++;
			}
		swap(arr, p, firsthigh);

		return firsthigh;
	}

	private static int partition(int[] arr, int left, int right) {
		int p = arr[(left + right) / 2];
		while (left <= right) {
			while (arr[left] < p)
				left++;
			while (arr[right] > p)
				right--;
			if (left <= right) {
				swap(arr, left, right);
				left++;
				right--;
			}
		}
		return left;
	}

	public static void quicksort(int[] arr, int left, int right) {
		if (right - left > 0) {
			int index = partition2(arr, left, right);
			quicksort(arr, left, index - 1);
			quicksort(arr, index, right);
		}
	}

	public static int[] array() {
		return new int[] { 4, 2, 5, 8, 0, 1 };
	}

	public static void main(String[] args) {
		int[] e = array();
		quicksort(e, 0, e.length - 1);
		System.out.println(Arrays.toString(e));

	}
}
