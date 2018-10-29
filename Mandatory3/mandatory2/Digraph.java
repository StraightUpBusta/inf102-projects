package no.uib.ii.inf102.f18.mandatory2;

public class Digraph {
	private final int V;
	private int E;
	private MyBag<Integer>[] adj;
	
	public Digraph(int V) {
		if (V < 0) throw new IllegalArgumentException("V can not be negative");
		this.V = V;
		this.E = 0;
		adj = (MyBag<Integer>[]) new MyBag[V];
		for (int i = 0; i < V; i++) {
			adj[i] = new MyBag<Integer>();
		}
	}
	
	public int V() {
		return V;
	}

	public int E() {
		return E;
	}
	
	public void addEdge(int v, int w) {
		adj[v].add(w);
		E++;
	}
	
	public Iterable<Integer> adj(int v) {
		return adj[v];
	}
}
