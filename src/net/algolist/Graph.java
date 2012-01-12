package net.algolist;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Stack;

public class Graph {
	private boolean adjacencyMatrix[][];
	private int vertexCount;

	public Graph(int vertexCount) {
		this.vertexCount = vertexCount;
		adjacencyMatrix = new boolean[vertexCount][vertexCount];
	}

	public void addEdge(int i, int j) {
		if (valid(i) && valid(j)) {
			adjacencyMatrix[i][j] = true;
			adjacencyMatrix[j][i] = true;
		}
	}

	/**
	 * is valid index
	 */
	public boolean valid(int index) {
		return index >= 0 && index < vertexCount;
	}

	public void print() {
		System.out.print("\t");
		for (int i = 0; i < vertexCount; i++)
			System.out.print("" + i + "\t");
		System.out.println();
		System.out.println();

		for (int i = 0; i < vertexCount; i++) {
			System.out.print("" + i + "\t");
			for (int j = 0; j < vertexCount; j++) {
				System.out.print((adjacencyMatrix[i][j] ? "1" : "0") + "\t");
			}
			System.out.println();
		}
	}

	public boolean isEdge(int i, int j) {
		if (i >= 0 && i < vertexCount && j > 0 && j < vertexCount)
			return adjacencyMatrix[i][j];
		else
			return false;
	}

	public void rDFS() {
		rDFS(0, new boolean[vertexCount]);
	}

	public void rDFS(int current, boolean[] state) {
		state[current] = true;
		System.out.println((char) (current + 'A'));
		for (int i = 0; i < vertexCount; i++) {
			if (adjacencyMatrix[current][i] && !state[i]) {
				rDFS(i, state);
			}
		}
	}

	public void iDFS() {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(0);
		boolean[] visited = new boolean[vertexCount];
		while (!stack.empty()) {
			int current = stack.pop();
			visited[current] = true;
			System.out.println((char) (current + 'A'));
			for (int i = 0; i < vertexCount; i++) {
				if (adjacencyMatrix[current][i] && !visited[i]) {
					stack.push(i);
					visited[i] = true;
				}
			}
		}
	}

	public void iDFS2() {
		LinkedList<Integer> queue = new LinkedList<Integer>();
		queue.push(0);
		boolean[] visited = new boolean[vertexCount];
		while (!queue.isEmpty()) {
			int current = queue.pop();
			if (!visited[current])
				System.out.println((char) (current + 'A'));
			visited[current] = true;
			for (int i = 0; i < vertexCount; i++) {
				if (adjacencyMatrix[current][i] && !visited[i]) {
					queue.add(i);
				}
			}
		}
	}

	public void bfs() {
		LinkedList<Integer> q = new LinkedList<Integer>();
		q.push(0);
		boolean[] visited = new boolean[vertexCount];
		while (!q.isEmpty()) {
			int current = q.pop();
			visited[current] = true;
			System.out.println((char) (current + 'A'));
			for (int i = 0; i < vertexCount; i++) {
				if (adjacencyMatrix[current][i] && !visited[i]) {
					q.add(i);
				}
			}
		}
	}

	public static void main(String[] args) {
		Graph g = new Graph(7);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(0, 4);
		g.addEdge(1, 3);
		g.addEdge(1, 5);
		g.addEdge(2, 6);
		// g.addEdge(4, 5);
		System.out.println("------r------");
		g.rDFS();
		System.out.println("------i1------");
		g.iDFS();
		System.out.println("------i2------");
		g.iDFS2();
		System.out.println("------bfs------");
		g.bfs();

		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		pq.add(5);
		pq.add(3);
		pq.add(1);
		pq.add(7);
		while (!pq.isEmpty())
			System.out.println(pq.poll());
	}
}