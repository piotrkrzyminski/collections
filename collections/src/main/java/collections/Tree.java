package collections;

import java.util.NoSuchElementException;

public interface Tree<E> {
	public void insert(E e);
	public E getRoot() throws NoSuchElementException;
	public int countNodes();
	public void printAscending();
	public void printDescending();
	public boolean contains(E e);
	public boolean isEmpty();
	public E maximum() throws NoSuchElementException;
	public E minimum() throws NoSuchElementException;
	public void clear();
	public Iterator<E> iterator();
}