public class UnionQuickFind {
	public void union(int[] accounts, int p, int q) {
		int prt = find(accounts, p); // p's root
		int qrt = find(accounts, q); // q's root
		if (prt == qrt) {
			return;
		}
		if (prt < qrt) { // set lower id as root
			for (int i = 0; i < accounts.length; i++) {
				if (accounts[i] == qrt) {
					accounts[i] = prt;
				}
			}
		} else {
			for (int i = 0; i < accounts.length; i++) {
				if (accounts[i] == prt) {
					accounts[i] = qrt;
				}
			}
		}
	}

	public int find(int[] accounts, int p) {
		return accounts[p];
	}
}
