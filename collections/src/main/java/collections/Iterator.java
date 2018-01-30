package collections;

import java.util.NoSuchElementException;

public interface Iterator<E> {
	public E next() throws NoSuchElementException;
	public boolean hasNext();
}
