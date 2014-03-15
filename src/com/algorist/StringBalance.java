package com.algorist;

public class StringBalance {

	public static void main(String[] args) {
		System.out.println(isBalanced("(()()(()))"));
	}

	public static boolean isBalanced(String str) {
		// TODO check input
		int len = str.length();
		if (len % 2 != 0)
			return false;
		
		int sum = 0;
		for (int i = 0; i < len; i++) {
			char c = str.charAt(i);
			if (c == '(') {
				sum++;
			} else if (c == ')') {
				sum--;
				if (sum < 0) {
					return false;
				}
			}
		}
		return sum == 0;
	}

}
