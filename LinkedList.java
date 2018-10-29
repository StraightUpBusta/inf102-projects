package no.uib.ii.inf102.f18.mandatory2;

public class LinkedList<E> {
	private Node first;
	private Node last;
	
	private class Node {
		Node next;
		E data;
	}
	
	public void add(E data) {
		if (first == null) {
			first = new Node();
			first.data = data;
			last = first;
		} else {
			last.next = new Node();
			last = last.next;
			last.data = data;
		}
	}
}
