package list;

import java.util.NoSuchElementException;

import collections.Iterator;
import list.LinkedList.Node;

public class LinkedListIterator<E> implements Iterator<E> {
	
	private Node firstNode;
	private final LinkedList<E> list;
	private Node currentNode;
	private Node lastNode;
	private int size;
	
	public LinkedListIterator(LinkedList<E> list) {
		this.list = list;
		firstNode = list.getFirst();
		currentNode = firstNode;
		lastNode = list.getLast();
		size = list.size();
	}

	@SuppressWarnings("unchecked")
	public E next() throws NoSuchElementException {
		if(currentNode == null)
			throw new NoSuchElementException();
		
		E element = (E) currentNode.element;
		currentNode = currentNode.next;
		return element;
	}

	public boolean hasNext() {
		return (currentNode != null);
	}
}
