
public class MyLinkedListQueue<E> implements IQueue<E> {
	Node first;
	Node last;
	
	private class Node {
		E data;
		Node next;
	}
	
	@Override
	public boolean empty() {
		return first == null;
	}

	@Override
	public E dequeue() {
		if (empty()) throw new IllegalStateException("Queue is empty!");
		E ret = first.data;
		first = first.next;
		return ret;
	}

	@Override
	public E peek() {
		return first.data;
	}

	@Override
	public void enqueue(E item) {
		Node newNode = new Node();
		newNode.data = item;

		if (empty()) {
			first = newNode;
			last = newNode;
		} else {
			last.next = newNode;
			last = newNode;
		}
	}
}
