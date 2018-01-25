package list;

import collections.Collection;
import collections.Iterator;

public interface List<E> extends Collection<E> {
	public boolean isEmpty();
	public boolean add(E e);
	public void clear();
	public int size();
	public E get(int index) throws IndexOutOfBoundsException;
	public E remove(int index) throws IndexOutOfBoundsException;
	public boolean contains(E e);
	public int indexOf(E e);
	public boolean replace(E e, int index) throws IndexOutOfBoundsException;
	public Object[] toArray();
	public Iterator<E> iterator();
}

