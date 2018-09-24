import org.junit.jupiter.api.Test;

class TestListQueue {

	@Test
	void testEnqueue() {
		MyLinkedListQueue<Integer> q = new MyLinkedListQueue<>();
		for (int i = 0; i < 100; i++) q.enqueue(i);
	}

	@Test
	void testDequeue() {
		MyLinkedListQueue<Integer> q = new MyLinkedListQueue<>();
		for (int i = 0; i < 999; i++) q.enqueue(i);
		for (int i = 0; i < 999; i++) q.dequeue();
	}
	
	@Test
	void timeTest() {
		MyLinkedListQueue<Integer> q = new MyLinkedListQueue<>();
		long start = System.currentTimeMillis();
		for (int i = 0; i < 10000000; i++) q.enqueue(1);
		long stop = System.currentTimeMillis();
		System.out.println(stop - start);
	}
	@Test
	void printQueue() {
		MyLinkedListQueue<Integer> q = new MyLinkedListQueue<>();
		for (int i = 0; i < 100; i++) {
			q.enqueue(i);
		}
		while (!q.empty()) {
			System.out.println(q.dequeue());
		}
	}
}
