package no.uib.ii.inf102.f18.mandatory2;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class BDDepthFirstSearch {
	private Map<String, Boolean> marked;
	private Map<String, Integer> postVal;
	private final String s; 
	private int counter;
	
	public BDDepthFirstSearch(BDDigraph G, String s) {
		this.s = s;
		marked = new HashMap<>(G.V());
		postVal = new HashMap<>(G.V());
		counter = 0;
		dfs(G, s);
	}
	
	public void dfs(BDDigraph G, String v) {
		marked.put(v, true);
		counter++;
		if (G.adj(v) == null) {
			postVal.put(v, ++counter);
			return;
		}
		for (String w : G.adj(v)) {
			if (marked.get(w) == null) {
				dfs(G, w);
			}
		}
		postVal.put(v, ++counter);
	}
	
	public HashMap post() {
		return (HashMap) postVal;
	}
}
