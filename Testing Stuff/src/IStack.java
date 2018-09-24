
public interface IStack<E> {
	public E pop();
	
	public void push(E data);
	
	public boolean isEmpty();
	
	public E peek();
}
