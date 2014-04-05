package generic;

public class PrintMatrixInSpiral {

	private static class Movements {
		private int cursor = -1;
		private char[] data = { 'R', 'D', 'L', 'U' };

		public char next() {
			cursor = (cursor + 1) % 4;
			return data[cursor];
		}
	}

	public static int start(int n) {
		if (n % 2 == 0) {
			// is even
			return (n / 2) - 1;
		} else {
			// go to next even and calculate
			n++;
			return (n / 2) - 1;
		}
	}

	public static void print(int[][] matrix) {
		int n = matrix.length;
		// determine start index
		int start = start(n);
		int row = start;
		int col = start;
		// print start cell
		System.out.print(matrix[row][col]);
		int totalNumberOfMoves = n + (n - 1);
		Movements movements = new Movements();
		int stepCount = 1;
		for (int i = 1; i <= totalNumberOfMoves; i++) {
			char next = movements.next();
			switch (next) {
			case 'R':
				for (int j = 0; j < stepCount; j++) {
					System.out.print("," + matrix[row][++col]);
				}
				break;
			case 'D':
				for (int j = 0; j < stepCount; j++) {
					System.out.print("," + matrix[++row][col]);
				}
				break;
			case 'L':
				for (int j = 0; j < stepCount; j++) {
					System.out.print("," + matrix[row][--col]);
				}
				break;
			case 'U':
				for (int j = 0; j < stepCount; j++) {
					System.out.print("," + matrix[--row][col]);
				}
				break;
			}
			if (i % 2 == 0 && i != (totalNumberOfMoves - 1)) {
				stepCount++;
			}
		}
	}

	public static void main(String[] args) {
		print(new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
				{ 13, 14, 15, 16 } });
	}
}
