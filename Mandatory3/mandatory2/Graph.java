package no.uib.ii.inf102.f18.mandatory2;

public class Graph {
	private final int V; // vertices
	private int E; // edges
	private MyBag<Integer>[] adj;
	
	public Graph(int V) {
		if (V < 0) throw new IllegalArgumentException("V can not be negative");
		this.V = V;
		this.E = 0;
		adj = (MyBag<Integer>[]) new MyBag[V];
		for (int i = 0; i < V; i++) {
			adj[i] = new MyBag<Integer>();
		}
	}
	
	public void addEdge(int v, int w) {
		E++;
		adj[v].add(w);
		adj[w].add(v);
	}
	
	public Iterable<Integer> adj(int v) {
		return adj[v];
	}
	
	public int V() {
		return V;
	}
	
	public int E() {
		return E;
	}
}
