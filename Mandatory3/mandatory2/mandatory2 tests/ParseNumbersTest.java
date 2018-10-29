package no.uib.ii.inf102.f18.mandatory2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ParseNumbersTest {

	@Test
	void test() {
		String test = "00000123456";
		int[] res = parseNumbers(test, 11);
		for (int i = 0; i < 11; i++) {
			System.out.print(res[i]);
		}
	}
	
	public int[] parseNumbers(String line, int length) {
		int[] ret = new int[length];
		String str = String.valueOf(line);
		System.out.println(str);
		for (int i = 0; i < length; i++) {
			ret[i] = Character.getNumericValue(str.charAt(i));
		}
		return ret;
	}
}
