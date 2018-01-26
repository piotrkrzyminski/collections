package collections;

public interface Queue<E> extends Collection<E> {
	public boolean isEmpty();
	public boolean add(E e);
	public void clear();
	public int size();
	public E get();
	public E remove();
}
