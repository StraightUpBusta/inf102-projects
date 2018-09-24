public interface IList<E> {
	public E dequeue();

	public void enqueue(E data);
	
	public boolean empty();

	public void insert(E data);

	public MyLinkedList<E>.Node getNext();
	
	public MyLinkedList<E>.Node getPrev();
}
