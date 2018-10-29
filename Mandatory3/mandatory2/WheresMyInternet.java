package no.uib.ii.inf102.f18.mandatory2;

public class WheresMyInternet {
	public static void main(String[] args) {
		Kattio io = new Kattio(System.in, System.out);
		int N = io.getInt();
		int M = io.getInt();
		Graph G = new Graph(N);
		for (int i = 0; i < M; i++) {
			int v = io.getInt() - 1;
			int w = io.getInt() - 1;
			G.addEdge(v, w);
		}
		DepthFirstSearch dfs = new DepthFirstSearch(G, 1);
		MyQueue<Integer> noConn = new MyQueue<>();
		// vertices in Graph go from 0 to N-1. House 1 is therefore 0 and is already connected.
		for (int i = 1; i < N; i++) { 
			if (!dfs.hasPathTo(i)) { // put unconnected houses on queue
				noConn.enqueue(i + 1);
			}
		}
		if (noConn.isEmpty()) {
			System.out.println("Connected");
		} else {
			for (int house : noConn) {
				System.out.println(house);
			}
		}
		io.close();
	}
}
