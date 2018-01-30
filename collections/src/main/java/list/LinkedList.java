package list;

import java.util.NoSuchElementException;

import collections.Iterator;
import collections.List;
import collections.Queue;

public class LinkedList<E> implements List<E>, Queue<E> {
	
	@SuppressWarnings("hiding")
	class Node<E> {
		E element;
		Node<E> next;
		Node<E> previous;
		
		Node(E element) {
			this.element = element;
			next = null;
			previous = null;
		}
	}

	private int size;
	private Node<E> first;
	private Node<E> last;
	
	public LinkedList() {
		first = null;
		last = null;
		size = 0;
	}
	
	public LinkedList(LinkedList<E> list) {
		first = null;
		last = null;
		size = 0;
		
		Iterator<E> it = list.iterator();
		
		while(it.hasNext())
			this.add(it.next());
	}
	
	public Node<E> getFirst() {
		return first;
	}
	
	public Node<E> getLast() {
		return last;
	}
	
	public boolean isEmpty() {
		return (size == 0);
	}

	public boolean add(E e) {
		Node<E> node = new Node<E>(e);
		
		if(this.isEmpty()) {
			first = node;
			last = first;
		} else {
			last.next = node;
			node.previous = last;
			last = node;
		}
		
		if(last.element.equals(e)) {
			size++;
			return true;
		}
		
		return false;
	}

	public void clear() {
		while(!this.isEmpty()) {
			first = null;
			size = 0;
		}
	}

	public int size() {
		return size;
	}

	public E get(int index) throws IndexOutOfBoundsException {
		checkIndex(index);
		
		E element = null;
		
		Iterator<E> it = this.iterator();
		
		for(int i = 0; i <= index; i++)
			element = it.next();
		
		return element;
	}

	public E remove(int index) throws IndexOutOfBoundsException {
		checkIndex(index);
		
		E element = null;
	
		Node<E> deleteNode = first;
		
		for(int i = 0; i < index; i++)
			deleteNode = deleteNode.next;
		
		element = deleteNode.element;
		
		if(deleteNode.equals(first)) {
			first = first.next;
		} else if(deleteNode.equals(last)) {
			last = last.previous;
			last.next = null;
		} else {
			deleteNode.previous.next = deleteNode.next;
			deleteNode.next.previous = deleteNode.previous;
		}
		
		size--;
		
		return element;
	}

	public boolean contains(E e) {
		if(this.indexOf(e) != -1)
			return true;
		
		return false;
	}

	public int indexOf(E e) {
		int index = -1;
		
		Iterator<E> it = this.iterator();
		
		int counter = 0;
		while(it.hasNext()) {
			
			if(it.next().equals(e)) {
				index = counter;
				break;
			}
			else
				counter++;
		}
		
		return index;
	}

	public boolean replace(E e, int index) throws IndexOutOfBoundsException {
		checkIndex(index);
		
		Node<E> replaceNode = first;
		
		for(int i = 0; i < index; i++)
			replaceNode = replaceNode.next;
		
		replaceNode.element = e;
		
		if(replaceNode.element.equals(e))
			return true;
		
		return false;
	}

	public Object[] toArray() {
		Object[] returnArray = new Object[this.size];
		
		Iterator<E> it = this.iterator();
		
		int i = 0;
		while(it.hasNext()) {
			returnArray[i] = it.next();
			i++;
		}
		
		return returnArray;
	}

	public Iterator<E> iterator() {
		return new LinkedListIterator<E>(this);
	}
	
	private void checkIndex(int index) throws IndexOutOfBoundsException {
		if(index < 0 || index > size)
			throw new IndexOutOfBoundsException("Invalid index value");
	}
	
	//QUEUE METHODS

	public E get() throws NoSuchElementException {
		if(isEmpty())
			throw new NoSuchElementException();
		
		return this.get(0);
	}

	public E remove() throws NoSuchElementException {
		if(isEmpty())
			throw new NoSuchElementException();
		
		return this.remove(0);
	}
}
