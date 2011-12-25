import java.util.ArrayList;

/**
 * Min-Heap implementation
 */
public class Heap {
	/*
	 * here the graph/tree data structure is represented as an array, ordered
	 * top-bottom left-to-right
	 */
	public ArrayList<Integer> graph = new ArrayList<Integer>();

	public void add(int value) {
		graph.add(value);
		int i = graph.size() - 1;
		while (i > 0 && graph.get(i) < graph.get((i - 1) / 2)) {
			swap(i, (i - 1) / 2);
			i = (i - 1) / 2;
		}
	}

	private int getParent(int i) {
		return -1;
	}

	private int getLeftChild(int i) {
		return -1;
	}

	private int getRightChild(int i) {
		return -1;
	}

	public void swap(int i1, int i2) {
		int value1 = graph.get(i1);
		graph.set(i1, graph.get(i2));
		graph.set(i2, value1);
	}

	@Override
	public String toString() {
		return graph.toString();
	}
}
