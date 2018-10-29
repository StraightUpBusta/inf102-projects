package no.uib.ii.inf102.f18.mandatory2;

import java.util.Iterator;

public class MyBag<E> implements Iterable<E> {
	private Node first;
	private int size;
	
	private class Node {
		Node next;
		E item;
	}
	
	private class MyLinkedListIterator implements Iterator {
		Node current = first;
		
		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public Object next() {
			E ret = current.item;
			current = current.next;
			return ret;
		}
	}
	
	@Override
	public Iterator<E> iterator() {
		return new MyLinkedListIterator();
	}
	
	public void add(E item) {
		if (first == null) {
			first = new Node();
			first.item = item;
		} else {
			Node temp = new Node();
			temp.item = item;
			temp.next = first;
			first = temp;
		}
		size++;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public int size() {
		return size;
	}
}
