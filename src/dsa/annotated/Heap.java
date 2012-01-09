package dsa.annotated;
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
		while (i > 0 && graph.get(i) < graph.get(getParent(i))) {
			swap(i, getParent(i));
			i = getParent(i);
		}
	}

	public void remove(int value) {
		int indexToDelete = graph.indexOf(value);
		if (indexToDelete < 0)
			return;
		int lastValue = graph.get(graph.size() - 1);
		graph.set(indexToDelete, lastValue);
		graph.remove(graph.size() - 1);

		while (getLeftChild(indexToDelete) < graph.size()
				&& (graph.get(indexToDelete) > graph
						.get(getLeftChild(indexToDelete)) || graph
						.get(indexToDelete) > graph
						.get(getRightChild(indexToDelete)))) {
			if (graph.get(getLeftChild(indexToDelete)) < graph
					.get(getRightChild(indexToDelete))) {
				swap(getLeftChild(indexToDelete), indexToDelete);
				indexToDelete = getLeftChild(indexToDelete);
			} else {
				swap(getRightChild(indexToDelete), indexToDelete);
				indexToDelete = getRightChild(indexToDelete);
			}

		}
	}

	public boolean contains(int value) {
		for (int n : graph)
			if (n == value)
				return true;
		return false;
	}

	public int indexOf(int value) {
		for (int i = 0; i < graph.size(); i++)
			if (graph.get(i).equals(value))
				return i;

		return -1;
	}

	public int getParent(int i) {
		return (i - 1) / 2;
	}

	public int getLeftChild(int i) {
		return (2 * i) + 1;
	}

	public int getRightChild(int i) {
		return (2 * i) + 2;
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
