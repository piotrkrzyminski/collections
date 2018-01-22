package collections;

import list.EmptyListException;

public interface Collection<E> {
	public boolean isEmpty();
	public boolean add(E e);
	public void clear() throws EmptyListException;
	public int size();
	boolean equals(Object o);
}
