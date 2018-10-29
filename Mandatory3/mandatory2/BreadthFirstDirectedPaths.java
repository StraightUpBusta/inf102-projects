package no.uib.ii.inf102.f18.mandatory2;

public class BreadthFirstDirectedPaths {
	private final int INFINITY = Integer.MAX_VALUE;
	private boolean[] marked;
	private int[] edgeTo;
	private int[] distTo;
	
	public BreadthFirstDirectedPaths(Digraph G, int s) {
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		distTo = new int[G.V()];
		for (int i = 0; i < G.V(); i++) {
			distTo[i] = INFINITY;
		}
		bfs(G, s);
	}
	
	private void bfs(Digraph G, int s) {
		MyQueue<Integer> q = new MyQueue<>();
		marked[s] = true;
		distTo[s] = 0;
		q.enqueue(s);
		while(!q.isEmpty()) {
			int v = q.dequeue();
			for (int w : G.adj(v)) {
				if (!marked[w]) {
					marked[w] = true;
					edgeTo[w] = v;
					distTo[w] = distTo[v] + 1;
					q.enqueue(w);
				}
			}
		}
	}
	
	public boolean hasPathTo(int v) {
		return marked[v];
	}
	
	public int distTo(int v) {
		return distTo[v];
	}
}
