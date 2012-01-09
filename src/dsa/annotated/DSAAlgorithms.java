package dsa.annotated;
/**
 * Different DSA algorithms covered at the beginning of the book
 * 
 * @author asantana
 * 
 */
public class DSAAlgorithms {
	public static boolean isPalindrome(String value) {
		String word = value.toUpperCase();
		int left = 0;
		int right = word.length() - 1;
		while (word.charAt(left) == word.charAt(right) && left < right) {
			left++;
			right--;
		}
		return word.charAt(left) == word.charAt(right);
	}

	public static void testFibonacci2() {
		assert 885444751 == fibonacci2(71);
	}

	public static int fibonacci2(int n) {
		if (n < 1)
			return 0;
		if (n < 2)
			return 1;
		int p = 0;
		int c = 1;
		int t = 0;
		while (n-- > 2) {
			t = p + c;
			p = c;
			c = t;
		}
		return p + c;
	}

	public static int fibonacci(int n) {
		if (n < 1)
			return 0;
		if (n < 2)
			return 1;
		return fibonacci(n - 1) + fibonacci(n - 2);
	}

	public static void main(String[] args) {
		testFibonacci2();
		long start = System.currentTimeMillis();
		int n = 70;
		System.out.print(fibonacci2(n));
		start = System.currentTimeMillis();
		System.out.printf(" fibonacci2 done in %d ms \n", (System.currentTimeMillis() - start));
		System.out.print(fibonacci(n));
		System.out.printf(" fibonacci done in %d ms \n", (System.currentTimeMillis() - start));

	}
}
