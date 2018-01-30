package collections;

import java.util.EmptyStackException;

public interface Stack<E> {
	public boolean isEmpty();
	public void clear();
	public int size();
	public E pop() throws EmptyStackException;
	public boolean push(E e);
	public E peek() throws EmptyStackException;
}
