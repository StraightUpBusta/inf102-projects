package no.uib.ii.inf102.f18.mandatory2;

import java.util.Iterator;

public class MyQueue<E> implements Iterable<E> {
	private Node first;
	private Node last;
	
	private class Node {
		Node next;
		E item;
	}
	
	private class MyQueueIterator implements Iterator {
		Node current = first;
		
		public boolean hasNext() {
			return current != null;
		}
		
		public Object next() {
			E ret = current.item;
			current = current.next;
			return ret;
		}
	}
	
	public Iterator<E> iterator() {
		return new MyQueueIterator();
	}
	
	public void enqueue(E item) {
		if (first == null) {
			first = new Node();
			first.item = item;
			last = first;
		} else {
			last.next = new Node(); 
			last = last.next;
			last.item = item;
		}
	}
	
	public E dequeue() {
		if (isEmpty()) throw new IllegalStateException("Queue is empty");
		E ret = first.item;
		first = first.next;
		return ret;
	}
	
	public boolean isEmpty() {
		return first == null;
	}
}
