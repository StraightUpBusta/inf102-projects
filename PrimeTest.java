package no.uib.ii.inf102.f18.mandatory2;

public class PrimeTest {
	public static void main(String[] args) {
		int counter = 1;
		for (int i = 3; i < 999; i += 2) {
			if (isPrime(i)) counter++;
		}
		System.out.println(counter);
	}

	public static boolean isPrime(int n) {
		if (n % 2 == 0) return false;
		for (int i = 3; i * i <= n; i += 2) {
			if (n % i == 0)	return false;
		}
		return true;
	}
}
