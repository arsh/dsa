public class TestClass {

	public static void main(String[] args) {
		int[][] T = new int[3][28];
		// for (int i = 1; i < T.length; i++) {
		// for (int j = 0; j < T[i].length; j++)
		// T[i][j] = 1;
		// }

		T[1][1] = 2;
		T[2][1] = 2;

		String candidate = "ab";
		int state = 1;
		int ms = 2;
		for (char c : candidate.toCharArray()) {
			int i = c - 'a';
			state = T[state][i];
		}

		System.out.println("matched : " + (state == ms));
	}
}
