package list;

import java.util.NoSuchElementException;

import collections.Iterator;

public class ArrayListIterator<E> implements Iterator<E>{
	
	private int beginIndex;
	private int currentIndex;
	private final ArrayList<E> arrayList;
	
	public ArrayListIterator(ArrayList<E> arrayList) {
		this.beginIndex = 0;
		this.currentIndex = beginIndex;
		this.arrayList = arrayList;
	}
	
	
	public E next() throws NoSuchElementException {
		if(!this.hasNext()) 
			throw new NoSuchElementException();
		
		E element = arrayList.get(currentIndex++);
		
		return element;
	}

	public boolean hasNext() {
		if(currentIndex < arrayList.size())
			return true;
		
		return false;
	}
}
