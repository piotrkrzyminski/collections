package list;

import collections.Collection;

public interface List<E> extends Collection<E> {
	public boolean isEmpty();
	public boolean add(E e);
	public void clear() throws EmptyListException;
	public int size();
	public E get(int index) throws IllegalArgumentException, EmptyListException;
	public E remove(int index) throws EmptyListException, IllegalArgumentException;
	boolean equals(Object o);
}

