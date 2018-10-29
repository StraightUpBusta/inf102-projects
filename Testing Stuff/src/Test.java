
public class Test {
	public static void main(String[] args) {
		int N = 16;
		int cnt = 0;
		for (int i = 1; i < N; i *= 2) {
			cnt++;
		}
		System.out.println(cnt);
		cnt = 0;
		for (int i = N; i > 0; i = i/2) {
			System.out.println(i);
			cnt++;
		}
		System.out.println(cnt);
	}
}
