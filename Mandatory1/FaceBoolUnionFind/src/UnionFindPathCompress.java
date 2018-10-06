public class UnionFindPathCompress {
	public void union(int[] accounts, int p, int q) {
		int prt = find(accounts, p); // p's root
		int qrt = find(accounts, q); // q's root
		if (prt == qrt) {
			return;
		}
		// set lower id as root
		if (prt < qrt) {
			accounts[qrt] = prt;
		} else {
			accounts[prt] = qrt;
		}
	}

	public int find(int[] accounts, int p) {
		int q = p;
		int prev; 
		while (accounts[p] != p) {
			p = accounts[p];
		}
		// path compression
		while (accounts[q] != q) { 
			prev = q;
			q = accounts[q];
			accounts[prev] = p;
		}
		return p;
	}
}
