package no.uib.ii.inf102.f18.mandatory2;

public class WheresMyInternet {
	public static void main(String[] args) {
		Kattio io = new Kattio(System.in, System.out);
		int N = io.getInt();
		int M = io.getInt();
		Graph G = new Graph(N + 1);
		for (int i = 0; i < M; i++) {
			int v = io.getInt();
			int w = io.getInt();
			G.addEdge(v, w);
		}
		DepthFirstSearch dfs = new DepthFirstSearch(G, 1);
		boolean allConn = true;
		for (int i = 1; i <= N; i++) { 
			if (!dfs.hasPathTo(i)) { // put unconnected houses on queue
				io.println(i);
				allConn = false;
			}
		}
		if (allConn) io.println("Connected");
		io.close();
	}
}
