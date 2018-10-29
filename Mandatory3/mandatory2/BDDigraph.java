package no.uib.ii.inf102.f18.mandatory2;

import java.util.HashMap;
import java.util.Map;

public class BDDigraph {
	private final int V;
	private int E;
	private Map<String, MyBag<String>> adj;
	
	public BDDigraph(int V) {
		if (V < 0) throw new IllegalArgumentException("V can not be negative");
		this.V = V;
		this.E = 0;
		adj = new HashMap<>(V);
	}
	
	public int V() {
		return V;
	}

	public int E() {
		return E;
	}
	
	public void addEdge(String v, String w) {
		if (!adj.containsKey(v)) {
			adj.put(v, new MyBag<String>());
			adj.get(v).add(w);
		} else {
			adj.get(v).add(w);
		}
		E++;
	}
	
	public Iterable<String> adj(String v) {
		return adj.get(v);
	}
}
