public class TestHeap extends TestingClass {
	public static void main(String[] args) {
		new TestHeap().runAllTest();
	}

	public void testAdd() {
		Heap heap = new Heap();
		heap.add(23);
		heap.add(7);
		assert "[7, 23]".equals(heap.toString()) : "add 1 failed:" + heap.toString();
		heap.add(6);
		assert "[6, 23, 7]".equals(heap.toString()) : "add 2 failed:" + heap.toString();
		heap.add(5);
		assert "[5, 6, 7, 23]".equals(heap.toString()) : "add 3 failed:" + heap.toString();
	}

	public void testSwap() {
		Heap heap = new Heap();
		// test without testing add
		heap.graph.add(3);
		heap.graph.add(4);
		heap.swap(0, 1);

		assert heap.graph.get(0).equals(4) : "swap 1";
		assert heap.graph.get(1).equals(3) : "swap 2";
	}
}
