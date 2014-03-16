package com.algorist;

import java.util.Random;

/**
 * Devide two integers without using / or *
 * 
 * @author andres
 * 
 */
public class Divide {

	public static void main(String[] args) {
		Random r = new Random();

		for (int i = 0; i < 100; i++) {
			int a = r.nextInt();
			int b = r.nextInt();
			int div1 = a / b;
			int div2 = div(a, b);
			if (div1 != div2) {
				System.err.printf("%d/%d --> div1=%d; div2=%d\n", a, b, div1,
						div2);
			}
		}
	}

	public static int div(int a, int b) {
		int c = 0;
		int sign = (a < 0) ^ (b < 0) ? -1 : 1;
		
		a = Math.abs(a);
		b = Math.abs(b);

		while (a >= b) {
			a -= b;
			c++;
		}
		return c * sign;
	}
}
