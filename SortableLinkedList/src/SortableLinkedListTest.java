import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Random;

import org.junit.jupiter.api.Test;
import java.util.UUID;


class SortableLinkedListTest {
	private static Random r = new Random();
	
	@Test
	void testBasicFunctions() {
		int N = 100;
		int M = 50;
		SortableLinkedList<Integer> li = new SortableLinkedList<>();
		
		// test size
		for (int i = 0; i < N; i++) li.add(i);
		assertEquals(li.size(), N);
		
		// test remove
		for (int i = 0; i < M; i++) li.remove(0);
		assertEquals(li.size(), M);
		for (int i = 0; i < M; i++) li.remove(0);
		assertTrue(li.isEmpty());
		li.add(1); li.add(2); li.add(3);
		li.remove(1); // remove 2
		assertEquals(1, (int) li.remove(0));
		assertEquals(3, (int) li.get(0));
		
		// test add to index
		li.add(0, 3); li.add(0, 2); li.add(0, 1);
		assertEquals((int) li.get(2), 3);
		li.add(3, 4);
		assertEquals((int) li.get(3), 4);
		li.add(2, 5);
		assertEquals((int) li.get(2), 5);
		assertEquals((int) li.get(4), 4);
		li.clear();
	}
	
	@Test
	void testSort() {
		SortableLinkedList<Integer> li = new SortableLinkedList<>();
		// test sort random integers
		int N = 100000;
		for (int i = 0; i < N; i++) li.add(r.nextInt());
		long c = System.currentTimeMillis();
		li.sort();
		long d = System.currentTimeMillis();
		System.out.println("Sort ints: " + (d-c) + " ms.");
		int e = Integer.MIN_VALUE;
		for (int i = 0; i < N/2-2; i++) {
			int f = li.remove(0);		
			assertTrue(e <= f);
			e = li.remove(0);
			assertTrue(f <= e);
		}
		
		// test sort Strings
		SortableLinkedList<String> liS = new SortableLinkedList<>();
		N = 100000;
		for (int i = 0; i < N; i++) liS.add(randomString());
		c = System.currentTimeMillis();
		liS.sort();
		d = System.currentTimeMillis();
		System.out.println("Sort strings: " + (d-c) + " ms.");
		String a = liS.remove(0);
		for (int i = 0; i < N/2-2; i++) {
			String b = liS.remove(0);		
			assertTrue(a.compareTo(b) <= 0);
			a = liS.remove(0);
			assertTrue(b.compareTo(a) <= 0);
		}
	}
	
	// generate random string
	public static String randomString() {
		String uuid = UUID.randomUUID().toString();
		return uuid;
	}
}
