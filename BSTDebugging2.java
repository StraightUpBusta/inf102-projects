package no.uib.ii.inf102.f18.mandatory1;

public class BSTDebugging2 {
	public static void main(String[] args) {
		boolean isValid = debug();
		
		if (isValid) {
			System.out.print("valid");
		} else {
			System.out.print("invalid");
		}
	}
	
	public static boolean debug() {
		Kattio io = new Kattio(System.in, System.out);
		int n = io.getInt();
		int m = io.getInt();

		int compExpected = 0;
		int prev = io.getInt();
		
		if (m > prev) compExpected = 1;
		else if (m < prev) compExpected = -1;
		else {
			if (n > 1) return false;
			return true;
		}
		
		for (int i = 1; i < n; i++) {
			int comp = 0;
			int current = io.getInt();
			if (current > prev) comp = 1;
			else if (current < prev) comp = -1;
			
			if (comp != 0 && comp != compExpected) return false;
			
			if (m > current) compExpected = 1;
			else if (m < current) compExpected = -1;
			else {
				if (i < n-1) return false;
			}
			prev = current;
		}
		return true;
	}
}
