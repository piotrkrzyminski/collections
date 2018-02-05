package tree;

import java.util.NoSuchElementException;

import collections.Iterator;
import collections.Stack;
import list.LinkedList;
import tree.BinaryTree.Node;

public class BinaryTreeIterator<E> implements Iterator<E> {
	
	private Stack<Node> stack = new LinkedList<Node>();
	
	public BinaryTreeIterator(Node root) {
		if(root == null)
			return;
		
		stack.push(root);
		
		while(root.left != null) {
			stack.push(root.left);
			root = root.left;
		}
	}

	public E next() throws NoSuchElementException {
		if(!hasNext())
			throw new NoSuchElementException();
		
		Node current = stack.pop();
		
		if(current.right != null) {
			Node temp = current.right;
			stack.push(temp);
			
			while(temp.left != null) {
				stack.push(temp.left);
				temp = temp.left;
			}
		}
		
		return (E) current.element;
	}

	public boolean hasNext() {
		return (stack.size() > 0);
	}

}
