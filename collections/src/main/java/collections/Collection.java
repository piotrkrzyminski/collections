package collections;

public interface Collection<E> {
	public boolean isEmpty();
	public boolean add(E e);
	public void clear();
	public int size();
	public boolean equals(Object o);
}
