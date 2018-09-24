package inf102;

public class Test {
	public static void main(String[] args) {
		long a = System.currentTimeMillis();
		
		for (int i = 0; i < 999999999; i++) {
			int s = i;
		}
		long b = System.currentTimeMillis();
		System.out.println(b-a);
	}
	
}
