package collections;

import java.util.NoSuchElementException;

public interface Queue<E> extends Collection<E> {
	public boolean isEmpty();
	public boolean add(E e);
	public void clear();
	public int size();
	public E get() throws NoSuchElementException;
	public E remove() throws NoSuchElementException;
}
