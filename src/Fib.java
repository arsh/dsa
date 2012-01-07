public class Fib {
	/**
	 * recursive impl
	 */
	public static int rFib(int n) {
		if (n == 1)
			return 0;
		else if (n == 2)
			return 1;
		return rFib(n - 1) + rFib(n - 2);
	}

	/**
	 * iterative impl
	 */
	public static int iFib(int n) {
		if (n == 1)
			return 0;
		else if (n == 2)
			return 1;
		int a = 0;
		int b = 1;
		n = n - 3;
		while (n-- > 0) {
			int c = a + b;
			a = b;
			b = c;
		}
		return a + b;
	}

	// test
	public static void main(String[] args) {
		System.out.println(Fib.rFib(21));
		System.out.println(Fib.iFib(21));
	}
}
