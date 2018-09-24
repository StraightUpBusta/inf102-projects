package inf102;

public class Recursion {
	public static void main(String[] args) {
		rec(10);
	}
	
	public static void rec(int n) {
		System.out.println(n);
		
		if (n == 0) {
			return;
		} else {
			rec(n-1);
		}
	}
}
