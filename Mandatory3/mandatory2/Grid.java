package no.uib.ii.inf102.f18.mandatory2;

public class Grid {
	public static void main(String[] args) {
		Kattio io = new Kattio(System.in, System.out);
		int n = io.getInt(); // height
		int m = io.getInt(); // width
		int V = n * m;
		Digraph G = new Digraph(V);
		// calculate and add edges
		for (int i = 0; i < n; i++) {
			String line = io.getWord();
			for (int j = 0; j < m; j++) {
				int v = i * m + j; // current position
				int stpLn = Character.getNumericValue(line.charAt(j)); // step length
				// left
				if (j - stpLn >= 0) {
					G.addEdge(v, v - stpLn);
				}
				// right
				if (j + stpLn < m) {
					G.addEdge(v, v + stpLn);
				}
				// up
				if (v - stpLn * m >= 0) {
					G.addEdge(v, v - stpLn * m);
				}
				// down
				if (v + stpLn * m < V) {
					G.addEdge(v, v + stpLn * m);
				}
			}
		}
		BreadthFirstDirectedPaths bfdp = new BreadthFirstDirectedPaths(G, 0);
		int br = V - 1; // bottom right position
		if (bfdp.hasPathTo(br)) {
			io.println(bfdp.distTo(br));
		} else {
			io.println(-1);
		}
		io.close();
	}
}
