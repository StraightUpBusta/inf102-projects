package no.uib.ii.inf102.f18.mandatory2;

public class DepthFirstSearch {
	private boolean[] marked;
	private int[] edgeTo;
	private final int s; 
	
	public DepthFirstSearch(Graph G, int s) {
		this.s = s;
		edgeTo = new int[G.V()];
		marked = new boolean[G.V()];
		dfs(G, s);
	}
	
	public void dfs(Graph G, int v) {
		marked[v] = true;
		for (int w : G.adj(v)) {
			if (!marked[w]) {
				edgeTo[w] = v;
				dfs(G, w);
			}
		}
	}
	
	public boolean hasPathTo(int v) {
		return marked[v];
	}
}
