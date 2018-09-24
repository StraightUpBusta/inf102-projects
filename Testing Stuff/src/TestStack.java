import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestStack {

	void testPush() {
		ArrayStack<Integer> as = new ArrayStack<>(5);
		for (int i = 0; i < 10; i++) {
			as.push(i);
		}
		
		for (int i = 0; i < 10; i++) {
			System.out.println(as.peek());
			System.out.println(as.pop());
		}
	}
	
	@Test
	void testStackList() {
		LinkedListStack<Integer> as = new LinkedListStack<>();
		for (int i = 0; i < 10; i++) {
			as.push(i);
		}
		
		for (int i = 0; i < 10; i++) {
			System.out.println(as.peek());
			System.out.println(as.pop());
		}
	}
}
