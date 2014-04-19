package algs4.cs.princeton.edu;

/**
 * Simple Stack implementation
 * 
 * @author andres
 * 
 */
public class SimpleStack<T> {

	private T[] a;
	private int size;

	@SuppressWarnings("unchecked")
	public SimpleStack(int initialSize) {
		size = 0;
		a = (T[]) new Object[initialSize];
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int size() {
		return size;
	}

	@SuppressWarnings("unchecked")
	public void resize(int max) {
		T[] temp = (T[]) new Object[max];
		System.arraycopy(a, 0, temp, 0, size);
		a = temp;
	}

	public void push(T item) {
		if (size == a.length) {
			// grow
			resize(a.length * 2);
		}
		a[size++] = item;
	}

	public T pop() {
		if (isEmpty()) {
			throw new RuntimeException("empty stack");
		}
		T t = a[--size];
		// clean
		a[size] = null;

		if (size > 0 && size == (a.length / 4)) {
			// make some space by resizing
			resize(a.length / 2);
		}

		return t;
	}

	public static void main(String[] args) {
		SimpleStack<Integer> ss = new SimpleStack<>(5);
		ss.push(5);
		ss.push(4);
		ss.push(3);
		ss.push(2);
		ss.push(1);
		ss.push(0);

		while (!ss.isEmpty()) {
			System.out.println(ss.pop());
		}
	}
}
