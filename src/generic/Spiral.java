package generic;

public class Spiral {
	private static final int[] xd = { 1, 0, -1, 0 };
	private static final int[] yd = { 0, 1, 0, -1 };

	public static int[] go(int[][] matrix) {
		final int N = matrix.length;
		int[] res = new int[N * N];
		int x = (N - 1) / 2;
		int y = x;
		int r = 0;
		int d = 0;
		out: for (int i = 0; i < N; i++)
			for (int j = 0; j < 2; j++) {
				for (int k = 0; k <= i; k++) {
					if (r == res.length)
						break out;
					res[r++] = matrix[y][x];
					x += xd[d];
					y += yd[d];
				}
				d = (d + 1) % 4;
			}
		return res;
	}

	public static void main(String[] args) {
		go(new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
				{ 13, 14, 15, 16 } });
	}
}
