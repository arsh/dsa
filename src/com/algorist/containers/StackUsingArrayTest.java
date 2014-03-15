package com.algorist.containers;

import junit.framework.TestCase;

public class StackUsingArrayTest extends TestCase {

	public void testPushAndPop() {
		StackUsingArray stack = new StackUsingArray(5);
		stack.push(3);
		stack.push(4);
		stack.push(8);

		assertEquals(8, stack.pop());
		assertEquals(2, stack.size());
		assertEquals(4, stack.pop());
		assertEquals(1, stack.size());
		assertEquals(3, stack.pop());
		assertTrue(stack.isEmpty());
	}
}
