package list;

import collections.Iterator;
import collections.List;

public class ArrayList<E> implements List<E> {
	
	private int size;
	private int defaultSize;
	private int index;
	private Object[] array;
	
	public ArrayList() {
		this.size = 100;
		this.defaultSize = this.size;
		array = new Object[this.size]; 
		index = 0;
	}
	
	public ArrayList(int size) {
		this.size = size;
		this.defaultSize = size;
		array = new Object[this.size]; 
		index = 0;
	}
	
	public ArrayList(List<E> list) {
		this.size = list.size();
		this.defaultSize = list.size();
		array = new Object[this.size]; 
		this.index = 0;
		
		for(int i = 0; i < list.size(); i++)
			this.add(list.get(i));
		
		this.index = list.size();
	}

	public boolean isEmpty() {
		return (index == 0);
	}

	public boolean add(E e) {
		if(this.isFull())
			this.resizeArray();
		
		array[index] = e;

		if(array[index++] == null)
			return false;
		
		return true;
	}

	public void clear() {
		if(this.isEmpty()) 
			return;
		
		array = new Object[defaultSize];
		index = 0;
	}

	public int size() {
		return index;
	}

	@SuppressWarnings("unchecked")
	public E get(int index) throws IndexOutOfBoundsException {
		checkIndex(index);
		
		return (E) array[index];
	}

	@SuppressWarnings("unchecked")
	public E remove(int index) throws IndexOutOfBoundsException {
		checkIndex(index);
		
		E element = (E) array[index];
		
		for(int i = index+1; i < this.index; i++)
			array[i-1] = array[i];
		
		this.index--;
		this.size--;
			
		return element;
	}
	
	public boolean contains(E e) {
		if(this.indexOf(e) != -1)
			return true;
		
		return false;
	}
	
	public int indexOf(E e) {
		int returnIndex = -1;
		
		if(this.isEmpty())
			return returnIndex;
	
		for(int i = 0; i < this.index; i++) {
			if(this.array[i].equals(e))
				returnIndex = i;
		}
		
		return returnIndex;
	}
	
	public boolean replace(E e, int index) throws IndexOutOfBoundsException {
		checkIndex(index);
		
		array[index] = e;
		
		if(array[index].equals(e))
			return true;
		
		return false;
	}
	
	public void trimToSize() {
		if(this.index == this.size) 
			return;
		
		Object[] newArray = new Object[this.index];
		
		for(int i = 0; i < this.index; i++)
			newArray[i] = array[i];
		
		array = newArray;
		this.size = this.index;
	}
	
	public Object[] toArray() {
		Object[] returnArray = new Object[this.size];
		
		for(int i = 0; i < this.size; i++)
			returnArray[i] = array[i];
		
		return returnArray;
	}
	
	public Iterator<E> iterator() {
		return new ArrayListIterator<E>(this);
	}
	
	private boolean isFull() {
		return (index == size);
	}
	
	@SuppressWarnings("unchecked")
	private void resizeArray() {
		if(size*2 <= Integer.MAX_VALUE) {
			Object[] newArray = new Object[size*2];
			
			for(int i = 0; i < size; i++)
				newArray[i] = (E) array[i];
			
			array = newArray;
			size *= 2;
		}
	}
	
	private void checkIndex(int index) throws IndexOutOfBoundsException {
		if(index < 0 || index > size)
			throw new IndexOutOfBoundsException("Invalid index value");
	}
}
