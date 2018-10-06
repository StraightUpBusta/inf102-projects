public class FaceboolQuickFind {
	public static void main(String[] args) {
		Kattio io = new Kattio(System.in, System.out);
		int n = io.getInt(); // number of accounts
		int m = io.getInt(); // number of lines
		int[] accounts = new int[n];
		for (int i = 0; i < n; i++) { // set root as self
			accounts[i] = i;
		}
		UnionQuickFind uqf = new UnionQuickFind();
		// get user ids
		for (int i = 0; i < m; i++) {
			int p = io.getInt(); 
			int q = io.getInt(); 
			uqf.union(accounts, p, q);
		}
		io.print(makeString(new StringBuilder(), accounts).toString());
		io.close();
	}
	
	// utility function
	public static StringBuilder makeString(StringBuilder sb, int[] accounts) {
		for (int i : accounts) {
			sb.append(Integer.toString(i).concat(" "));
		}
		return sb;
	}
}
