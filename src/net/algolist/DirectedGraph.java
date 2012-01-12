package net.algolist;

import java.util.PriorityQueue;

public class DirectedGraph {
	int max = 7;
	int[][] digraph = new int[max][max];
	int[][] cost = new int[max][max];

	/**
	 * is valid index
	 */
	public boolean valid(int index) {
		return index >= 0 && index < max;
	}

	public void add(int x, int j, int edgecost) {
		if (!valid(x) || !valid(j))
			throw new IllegalArgumentException(String.format("invalid indexes {x:%d j:%d}", x, j));
		digraph[x][j] = 1;
		cost[x][j] = edgecost;
	}

	public DirectedGraph() {
		// build graph
		add(0, 1, 5);
		add(0, 2, 3);
		add(0, 4, 6);
		add(2, 5, 4);
		add(2, 6, 3);
		add(1, 2, 3);
		add(2, 4, 2);
		add(6, 4, 5);
		add(5, 6, 5);
		add(5, 1, 2);
		add(1, 5, 1);
	}

	class Node implements Comparable<Node> {
		int value;
		int cost;

		public Node(int value, int cost) {
			this.value = value;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			Node other = (Node) o;
			if (this.cost < other.cost)
				return -1;
			if (this.cost > other.cost)
				return 1;
			return 0;
		}

		@Override
		public String toString() {
			return String.format("node{v:%s;c:%d}", String.valueOf((char) (value + 'A')), cost);
		}
	}

	public int shortestPath(int from, int to) {
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		pq.add(new Node(from, cost[from][from]));
		while (!pq.isEmpty()) {
			Node current = pq.poll();
			if (current.value == to)
				return current.cost;
			for (int i = 0; i < max; i++) {
				if (digraph[current.value][i] == 1)
					pq.add(new Node(i, current.cost + cost[current.value][i]));
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		DirectedGraph dg = new DirectedGraph();

		System.out.println(dg.shortestPath(2, 6));
	}
}
