// stack based on linked list
public class LinkedStack<E> implements ILinkedStack<E> {
		private Node first;

		private class Node {
			E data;
			Node next;
			
			public Node(E data) {
				this.data = data;
			}
		}
		
		@Override
		public boolean isEmpty() {
			return first == null;
		}
		
		@Override
		public E pop() {
			if (isEmpty()) {
				throw new IllegalStateException("Stack is empty!");
			}
			E ret = first.data;
			first = first.next;
			return ret;
		}
		
		@Override
		public void push(E data) {
			Node nd = new Node(data);
			if (isEmpty()) {
				first = nd;
			} else {
				Node oldFirst = first;
				first = nd;
				first.next = oldFirst;
			}
		}
		
		@Override 
		public E peek() {
			return first.data;
		}
}