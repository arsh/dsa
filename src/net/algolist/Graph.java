package net.algolist;

import javax.net.ssl.SSLEngineResult.Status;

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

	enum VertexState {
		White, Gray, Black
	}

	public void dfs() {
		VertexState[] state = new VertexState[vertexCount];
		for (int i = 0; i < vertexCount; i++)
			state[i] = VertexState.White;

	}

	public void runDFS(int u, VertexState[] state) {
		state[u] = VertexState.Gray;
		
		for (int v = 0; v < vertexCount; v++)
			if (isEdge(u, v) && state[v] == VertexState.White)
				runDFS(v, state);
		
		state[u] = VertexState.Black;

	}

	public static void main(String[] args) {
		Graph g = new Graph(5);
		g.addEdge(0, 3);
		g.addEdge(1, 3);
		g.addEdge(1, 4);
		g.addEdge(2, 4);
		g.addEdge(3, 4);
		g.print();
	}
}
