public class Factorial {

	/**
	 * recursive
	 */
	public static int rFact(int n) {
		if (n == 1 || n == 0)
			return 1;
		return n * rFact(n - 1);
	}

	/**
	 * iterative
	 */
	public static int iFact(int n) {
		int fact = 1;
		while (n > 0)
			fact *= n--;
		return fact;
	}

	public static void main(String[] args) {
		System.out.println(Factorial.rFact(9));
		System.out.println(Factorial.iFact(9));
	}
}
