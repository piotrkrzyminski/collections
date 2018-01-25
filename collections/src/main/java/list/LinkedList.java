package list;

import collections.Iterator;

public class LinkedList<E> implements List<E> {
	
	@SuppressWarnings("hiding")
	class Node<E> {
		E element;
		Node<E> next;
		
		Node(E element) {
			this.element = element;
			next = null;
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
		if(index < 0 || index > size)
			throw new IndexOutOfBoundsException("Wrong index");
		
		E element = null;
		
		Iterator<E> it = this.iterator();
		
		for(int i = 0; i <= index; i++)
			element = it.next();
		
		return element;
	}

	public E remove(int index) throws IndexOutOfBoundsException {
		if(index < 0 || index > size)
			throw new IndexOutOfBoundsException("Wrong index");
		
		E element = null;
		
		if(index == 0) {
			element = first.element;
			
			first = first.next;
			
			size--;
			
			return element;
		}
				
		Node<E> deleteNode = first;
		
		for(int i = 1; i < index; i++ )
			deleteNode = deleteNode.next;
		
		element = deleteNode.next.element;
		deleteNode.next = deleteNode.next.next;
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
		if(index < 0 || index > size)
			throw new IndexOutOfBoundsException("Wrong index");
		
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

}
