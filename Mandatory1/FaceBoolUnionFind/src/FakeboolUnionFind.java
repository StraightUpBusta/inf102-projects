public class FakeboolUnionFind {
	public static void main(String[] args) {
		Kattio io = new Kattio(System.in, System.out);
		int n = io.getInt(); // number of accounts
		int q = io.getInt(); // number of queries
		int[] accounts = new int[n];
		for (int i = 0; i < n; i++) { // set root as self
			accounts[i] = i;
		}
		StringBuilder sb = new StringBuilder();
		UnionFindPathCompress ufpc = new UnionFindPathCompress();
		// process data
		for (int i = 0; i < q; i++) {
			if (io.getWord().equals("DAEMON")) {
				ufpc.union(accounts, io.getInt(), io.getInt());
			} else {
				sb.append(ufpc.find(accounts, io.getInt()));
				sb.append("\n");
			}
		}
		io.print(sb.toString());
		io.close();
	}
}
