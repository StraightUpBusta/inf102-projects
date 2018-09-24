
public class LinkedListStack<E> implements IStack<E> {
	private Node first;
	
	private class Node {
		E data;
		Node next;
	}
	
	@Override
	public E pop() {
		if (isEmpty()) throw new IllegalStateException("Stack is empty!");
		E ret = first.data;
		first = first.next;
		return ret;
	}

	@Override
	public void push(E data) {
		Node newNode = new Node();
		newNode.data = data;
		if (isEmpty()) {
			first = newNode;
		} else {
			Node oldFirst = first;
			first = newNode;
			first.next = oldFirst;
		}
	}

	@Override
	public boolean isEmpty() {
		return first == null;
	}

	@Override
	public E peek() {
		return first.data;
	}
}
