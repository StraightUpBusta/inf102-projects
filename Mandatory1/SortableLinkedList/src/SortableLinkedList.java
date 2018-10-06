import java.util.Iterator;

public class SortableLinkedList<E extends Comparable<E>> implements ISortableList<E> {
	private int size;
	private Node dummy = new Node(); // dummy.next is first element
	private Node last = dummy;
	
	private class Node {
		E element;
		Node next;
		
		public Node() {
			this.element = element;
		}
		
		public Node(E element) {
			this.element = element;
		}
	}
	
	private class ListIterator<E extends Comparable<E>> implements Iterator<E> {
		private int counter = size;
		private Node curr = dummy; 
		
		@Override
		public boolean hasNext() {
			return counter != 0;
		}

		@Override
		public E next() {
			curr = curr.next;
			--counter;
			return (E) curr.element;
		}
	}
	
	@Override
	public Iterator<E> iterator() {
		return new ListIterator<E>();
	}

	@Override
	public void add(E element) {
		Node nd = new Node(element);
		last.next = nd;
		last = nd;
		size++;
	}

	@Override
	public void add(int index, E element) {
		if (index < 0 || index > size) {
			throw new IllegalArgumentException("Index is out of range!");
		}
		connect(new Node(element), getNodeBeforeIndex(index)); // use node before index to connect
		size++;
	}
	
	// utility function
	public void connect(Node input, Node ndBeforeIndex) { 
		input.next = ndBeforeIndex.next;  
		ndBeforeIndex.next = input;
	}
	
	// utility function
	public Node getNodeBeforeIndex(int index) {
		if (index < 0 || index > size) {
			throw new IllegalArgumentException("Index is out of range!");
		}
		Node curr = dummy; // dummy.next has index 0
		for (int i = 0; i < index; i++) { 
			curr = curr.next;
		}
		return curr;
	}

	@Override
	public void clear() {
		last = dummy;
		dummy.next = last;
		size = 0;
	}

	@Override
	public E get(int index) {
		if (index < 0 || index >= size) {
			throw new IllegalArgumentException("Index is out of range!");
		}
		return getNodeBeforeIndex(index).next.element;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public E remove(int index) {
		if (index < 0 || index > size) {
			throw new IllegalArgumentException("Index is out of range!");
		}
		if (isEmpty()) {
			throw new IllegalStateException("List is empty!");
		}
		Node nd = getNodeBeforeIndex(index); // disconnect nd.next
		Node ret = nd.next; // to be returned 
		if (ret == last) { // update last
			last = nd;
		}
		nd.next = nd.next.next; // disconnect
		size--;
		return ret.element;
	}
	
	@Override
	public int size() {
		return size;
	}

	@Override
	public void sort() {
		for (int len = 1; len < size; len += len) { // length of partition
			Node lo = dummy; // lo.next is start of lower partition
			for (int i = 0; i < size; i += len+len) { 
				Node hi = lo; // hi.next will be start of upper partition
				int j = 0;
				while (j++ < len && hi.next != null) { // get starting position for hi
					hi = hi.next;
				}
				merge(lo, hi, len);
				j = 0;
				while (j++ < len+len && lo != null) { // move lo to next area
					lo = lo.next;
				}
			}
		}
	}
	
	public void merge(Node lo, Node hi, int len) {
		int counterLo = 0; // stay within partitions
		int counterHi = 0;
		while (hi.next != null) { // break if all nodes in last upper partition has been processed
			if (!lessOrEqual(lo.next, hi.next)) { 
				moveHi(lo, hi);
				if (++counterHi == len) { 
					break;
				}
				lo = lo.next;
			} else { // don't move anything, just increment lo pointer 
				if (++counterLo == len) {
					break;
				}
				lo = lo.next;
			}
		}
	}
	
	public void moveHi(Node lo, Node hi) {  
		Node temp = hi.next; // hi is one step behind, therefore move hi.next
		hi.next = hi.next.next; // disconnect 
		temp.next = lo.next; // connect to lower partition
		lo.next = temp; 
	}
	
	public boolean lessOrEqual(Node a, Node b) {
		return a.element.compareTo(b.element) <= 0;
	}

	@Override
	public E[] toArray(E[] a) {
		if (size > a.length) {
			throw new IndexOutOfBoundsException("Index out of bounds!");
		}
		Node curr = dummy.next;
		for (int i = 0; i < a.length; i++) {
			if (i >= size) {
				a[i] = null;
			} else {
				a[i] = curr.element;
				curr = curr.next;
			}
		}
		return a;
	}
}
