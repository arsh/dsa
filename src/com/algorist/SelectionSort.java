package com.algorist;

/**
 * Just testing if I can implement this algorithm from the top of my head
 * 
 * @author andres
 * 
 */
public class SelectionSort {
	
	
	public static void main(String[] args) {
		System.out.println(sort("selectionsort"));
	}
	

	public static String sort(String toSort) {
		char[] chars = toSort.toCharArray();

		for (int i = 0; i < chars.length; i++) {
			for (int j = i + 1; j < chars.length; j++) {
				if (chars[j] < chars[i]) {
					// swap
					char min = chars[j];
					chars[j] = chars[i];
					chars[i] = min;
				}
			}
		}

		return new String(chars);
	}
}
