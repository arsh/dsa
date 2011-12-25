import java.util.Arrays;

public class Sorting {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(bubbleSort(new int[] { 4, 56, 34, 3,
				2, 55, 1 })));
	}

	public static int[] bubbleSort(int toSort[]) {
		int n = toSort.length;
		boolean switched = true;
		for (int i = 0; i < n && switched; i++) {
			switched = false;
			for (int y = 0; y < n - 1 - i; y++) {
				if (toSort[y] > toSort[y + 1]) {
					int max = toSort[y];
					toSort[y] = toSort[y + 1];
					toSort[y + 1] = max;
					switched = true;
				}

			}
		}
		return toSort;
	}
}
