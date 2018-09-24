
public class MyArrayQueue<E> implements IQueue<E> {
	private E[] q;
	private int first;
	private int last;
	private int size;
	
	public MyArrayQueue(int cap) {
		q = (E[]) new Object[cap];
		first = 0;
		last = 0;
		size = 0;
	}
	
	@Override
	public boolean empty() {
		return size == 0;
	}

	@Override
	public E dequeue() {
		if (empty()) throw new IllegalStateException("Queue is empty!");
		if (size == q.length / 4) resize(q.length / 2);
		if (first == q.length) first = 0;
		E ret = q[first];
		q[first++] = null;
		size--;
		return ret;
	}

	@Override
	public E peek() {
		if (empty()) throw new IllegalStateException("Queue is empty!");
		return q[first];
	}

	@Override
	public void enqueue(E item) {
		if (size == q.length) resize(q.length * 2);
		if (last == q.length) last = 0;
		q[last++] = item;
		size++;
	}
	
	public void resize(int cap) {
		E[] newArr = (E[]) new Object[cap];
		for (int i = 0; i < size; i++) {
			newArr[i] = q[(i + first) % q.length];
		}
		q = newArr;
		first = 0;
		last = size;
	}
}
