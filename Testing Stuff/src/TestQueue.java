import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestQueue {
	
	@Test
	void test() {
		MyArrayQueue<Integer> q = new MyArrayQueue<>(100);
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(3);
		q.dequeue();
		q.enqueue(4);
		for (int i = 0; i < 4; i++) {
			System.out.println(q.dequeue());
		}
	}
	
	void testResizeUpper() {
		int n = 80;
		MyArrayQueue<Integer> q = new MyArrayQueue<>(n/2);
		for (int i = 0; i < n; i++) {
			q.enqueue(i);
		}
		for (int i = 0; i < n; i++) {
			assertTrue(i == q.dequeue());
		}
	}
	void testCycle() {
		MyArrayQueue<Integer> q = new MyArrayQueue<>(5);
		for (int i = 0; i < 5; i++) {
			q.enqueue(i);
		}
		for (int i = 0; i < 4; i++) {
			q.dequeue();
		}
		for (int i = 5; i < 7; i++) {
			q.enqueue(i);
		}
		for (int i = 0; i < 3; i++) {
			assertTrue(i + 4 == q.dequeue());
		}
	}
	void testDequeue() {
		MyArrayQueue<Integer> q = new MyArrayQueue<>(5);
		for (int i = 0; i < 5; i++) {
			q.enqueue(i);
		}
		for (int i = 0; i < 2; i++) {
			q.dequeue();
		}
		for (int i = 5; i < 8; i++) {
			q.enqueue(i);
		}
		for (int i = 0; i < 6; i++) {
			assertTrue(i + 2 == q.dequeue());
		}
	}
	
	void timeTest() {
		MyArrayQueue<Integer> q = new MyArrayQueue<>(5);
		long start = System.currentTimeMillis();
		for (int i = 0; i < 100000000; i++) q.enqueue(1);
		long stop = System.currentTimeMillis();
		System.out.println(stop - start);
	}
}
