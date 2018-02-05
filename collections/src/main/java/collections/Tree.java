package collections;

import java.util.NoSuchElementException;

public interface Tree<E> {
	void insert(E e);
	E getRoot() throws NoSuchElementException;
	int countNodes();
	void printAscending();
	void printDescending();
	boolean contains(E e);
	boolean isEmpty();
	E maximum() throws NoSuchElementException;
	E minimum() throws NoSuchElementException;
	void clear();
	Iterator<E> iterator();
	List<E> toList();
}