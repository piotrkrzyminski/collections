package tree;

import java.util.NoSuchElementException;

import collections.Iterator;
import collections.Stack;
import list.LinkedList;
import tree.BinaryTree.Node;

public class BinaryTreeIterator<E> implements Iterator<E> {
	
	private Stack<Node> stack = new LinkedList<Node>();
	private Node current;
	
	public BinaryTreeIterator(Node root) {
		current = root;
	}

	public E next() throws NoSuchElementException {
		if(current == null)
			throw new NoSuchElementException();
		
		while(current != null) {
			stack.push(current);
			current = current.left;
		}
		
		current = stack.pop();
		Node node = current;
		current = current.right;
		
		return (E) node.element;
	}

	public boolean hasNext() {
		return (!stack.isEmpty() || current != null);
	}

}
