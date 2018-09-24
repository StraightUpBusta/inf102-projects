
public class ArrayStack<E> implements IStack<E> {
	private E[] s;
	private int first; // first free slot. also refers to size 
	
	public ArrayStack(int cap) {
		s = (E[]) new Object[cap];
		first = 0;
	}
	
	@Override
	public E pop() {
		if (isEmpty()) throw new IllegalStateException("Stack is empty!");
		if (first == s.length / 4) resize(s.length / 2);
		E ret = s[--first];
		s[first] = null;
		return ret;
	}

	@Override
	public void push(E data) {
		if (first == s.length) resize(s.length * 2);
		s[first++] = data;
	}

	@Override
	public boolean isEmpty() {
		return first == 0;
	}

	@Override
	public E peek() {
		if (isEmpty()) throw new IllegalStateException("Stack is empty!");
		return s[first-1];
	}
	
	public void resize(int cap) {
		E[] newArr = (E[]) new Object[cap];
		for (int i = 0; i < first; i++) {
			newArr[i] = s[i];
		}
		s = newArr;
	}
}
