package net.algolist;

public class Util {
	public static void printMatrix(int[][] matrix) {
		System.out.print("\t");
		int len = matrix.length;
		for (int i = 0; i < len; i++)
			System.out.print("" + i + "\t");
		System.out.println();
		System.out.println();

		for (int i = 0; i < len; i++) {
			System.out.print("" + i + "\t");
			for (int j = 0; j < len; j++) {
				System.out.print(matrix[i][j] + "\t");
			}
			System.out.println();
		}
	}

}
