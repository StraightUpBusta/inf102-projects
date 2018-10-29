package no.uib.ii.inf102.f18.mandatory2;

public class PerfectHash {
	public static void main(String[] args) {
		Kattio io = new Kattio(System.in, System.out);
		int card = io.getInt(); // cardinality of S
		int M = card; // M can vary
		String[] strArr = new String[M];
		for (int i = 0; i < card; i++) {
			strArr[i] = io.getWord();
		}
		int a = 1;
		boolean success = true;
		while (M <= 500) { // try each M
			for (a = 1; a <= 500; a++) {  
				success = true;
				boolean[] st = new boolean[M];
				int i = 0;
				for (i = 0; i < card; i++) {
					int index = hash(strArr[i], a, M);
					if (st[index]) {
						success = false;
						break; // try new value for a
					}
					st[index] = true;
				}
				if (success) {
					System.out.print(a + " " + M);
					io.close();
					System.exit(0);
				}
			}
			M++;
		}
	}


	public static int hash(String s, int a, int M) {
		int hash = 0;
		for (int i = 0; i < s.length(); i++) {
			hash = (a * hash + s.charAt(i)) % M;
		}
		return hash;
	}
}
