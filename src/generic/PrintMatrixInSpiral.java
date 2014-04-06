package generic;

/*
 Problem: Given an NxN matrix, print it in Spiral order moving clockwise starting from the center cell. 
 In some matrix there is no center cell instead a 2X2 matrix is the center, for example in a 6X6 matrix the center is a 2X2 matrix.
 In that case start printing from the upper left cell of the center matrix. 

 Also for a 2X2 matrix, start from the upper left cell.

 Samples:

 1)
 IN:
 1    2
 3    4
 OUT:
 1,2,4,3

 2) 
 IN:
 1    2    3
 4    5    6
 7    8    9
 OUT:
 5,6,9,8,7,4,1,2,3

 Solution: The idea to solve this problem is based on steps from a Start cell. For example: in a 2X2 matrix:

 1	2
 3	4

 the output should be --> 1, 2, 4, 3; here you can observe that we started from the cell 0,0 (row=0, column=0), the we moved one step to the RIGHT,
 then one step DOWN, then one step LEFT.

 In a similar way in a 3X3 matrix we have:

 1	2	3
 4	5	6
 7	8	9

 We start from cell 1,1, then move one step to the RIGHT, then one step DOWN, then two steps LEFT, then two steps UP and finally two steps RIGHT to output:
 5,6,9,8,7,4,1,2,3

 If we make a little table indicating the Step and how many times we repeat it we will have:

 2X2          
 | step | count |
 | R    |     1 |
 | D    |     1 |
 | L    |     1 |

 3X3
 | step | count |
 | R    | 1     |
 | D    | 1     |
 | L    | 2     |
 | U    | 2     |
 | R    | 2     | 

 4X4
 | step | count |
 | R    | 1     |
 | D    | 1     |
 | L    | 2     |
 | U    | 2     |
 | R    | 3     |
 | D    | 3     |
 | L    | 3     |

 R=Right, L=Left, D=Down, U=Up

 By now it should be clear that the steps are always in this cyclic order (note that U points to R):

 R --> D --> L --> U --
 |					  |
 ---------------------

 It's clear that if in an NxN matrix we start from a cell, then we should execute N+(N-1) total steps to cover the whole matrix.

 So for example if in a 3x3 matrix we start in a cell, then we need to do 5 different moves, namely:

 R --> D --> L --> U --> R

 Looking at the tables above it should be clear that the count of steps goes increasing by one with the exception that the last step keep the counter as the previous two, this idea
 explains this code below:

 if (i % 2 == 0 && i != (totalNumberOfMoves - 1)) {
 stepCount++;
 }

 Another important observation is where do we start as the Start cell?

 Looking at different matrix examples we have this:

 2X2 --> start at cell 0,0
 3X3 --> start at cell 1,1
 4X4 --> start at cell 1,1
 5X5 --> start at cell 2,2
 6X6 --> start at cell 2,2
 7X7 --> start at cell 3,3
 8X8 --> start at cell 3,3

 If we ignore the matrix with N being an odd number, we can deduce this:
 N = Length of the Matrix
 Start Point = (N / 2) - 1

 That said we can see from the table above that when N is odd it will have the
 value of the next even number, thus:

 N = Length of the Matrix
 if (N is odd) then
 // move to the next even number
 N = N + 1
 Start Point = (N / 2) - 1
 end

 */
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
