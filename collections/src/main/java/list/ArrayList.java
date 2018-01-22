package list;

import collections.Collection;

public class ArrayList<E> implements List<E> {
	private int size;
	private int defaultSize;
	private int index;
	private E[] array;
	
	public ArrayList() {
		this.size = 100;
		this.defaultSize = this.size;
		array = (E[]) new Object[this.size]; 
		index = 0;
	}
	
	public ArrayList(int size) {
		this.size = size;
		this.defaultSize = size;
		array = (E[]) new Object[this.size]; 
		index = 0;
	}
	
	public ArrayList(List<E> list) throws IllegalArgumentException, EmptyListException {
		this.size = list.size();
		this.defaultSize = list.size();
		array = (E[]) new Object[this.size]; 
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

	public void clear() throws EmptyListException {
		if(this.isEmpty()) 
			throw new EmptyListException("List is already empty.");
		
		array = (E[]) new Object[defaultSize];
		index = 0;
	}

	public int size() {
		return index;
	}

	public E get(int index) throws IllegalArgumentException, EmptyListException {
		if(this.isEmpty()) 
			throw new EmptyListException("Can't get element because list is empty.");
		
		if(index < 0) 
			throw new IllegalArgumentException("Wrong index");
		
		return array[index];
	}

	public E remove(int index) throws IllegalArgumentException, EmptyListException {
		if(index < 0) 
			throw new IllegalArgumentException("Wrong index");
		
		if(this.isEmpty()) 
			throw new EmptyListException("Can't get element because list is empty.");	
		
		return array[index--];
	}
	
	private boolean isFull() {
		return (index == size);
	}
	
	private void resizeArray() {
		if(size*2 <= Integer.MAX_VALUE) {
			
			
			E[] newArray = (E[]) new Object[size*2];
			
			for(int i = 0; i < size; i++) {
				newArray[i] = array[i];
			}
			
			array = newArray;
			size *= 2;
		}
	}
}
