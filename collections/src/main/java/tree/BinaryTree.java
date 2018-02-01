package tree;

import java.util.NoSuchElementException;

import collections.Iterator;
import collections.List;
import collections.Tree;
import list.ArrayList;

public class BinaryTree<E extends Comparable<E>> implements Tree<E> {
	
	class Node {
		E element;
		Node left;
		Node right;
		
		public Node(E e) {
			this.element = e;
			this.left = null;
			this.right = null;
		}
		
	}
	
	private Node root;
	
	public BinaryTree() {
		root = null;
	}

	public void insert(E e) {
		root = insert(root, e);
	}
	
	private Node insert(Node node, E e) {
		if(node == null) {
			node = new Node(e);
		} else {
			if(e.compareTo(node.element) < 0)
				node.right = insert(node.right, e);
			else
				node.left = insert(node.left, e);
		}
		
		return node;
	}
	
	public E getRoot() throws NoSuchElementException {
		if(root == null) 
			throw new NoSuchElementException();
		
		return root.element;
	}
	
	public int countNodes() {
		return countNodes(root);
	}
	
	private int countNodes(Node n) {
		if(n == null) {
			return 0;
		}
		
		int counter = 1;
		
		counter += countNodes(n.left);
		counter += countNodes(n.right);
	
		return counter;
	}
	
	public void printAscending() {
		printAscending(root);
	}
	
	private void printAscending(Node node) {
		if(node != null) {
			printAscending(node.left);
			System.out.print(node.element + " ");
			printAscending(node.right);
		}
	}
	
	public void printDescending() {
		printDescending(root);
	}
	
	private void printDescending(Node node) {
		if(node != null) {
			printDescending(node.right);
			System.out.print(node.element + " ");
			printDescending(node.left);
		}
	}
	
	public boolean contains(E e) {
		return contains(root, e);
	}
	
	private boolean contains(Node node, E e) {
		if(node == null)
			return false;
		
		if(node.element.equals(e))
			return true;
		
		if(e.compareTo(node.element) < 0)
			return contains(node.right, e);
		else 
			return contains(node.left, e);
	}
	
	public boolean isEmpty() {
		return (root == null);
	}
	
	public E maximum() throws NoSuchElementException {
		return maximum(root);
	}
	
	private E maximum(Node current) {
		if(isEmpty())
			throw new NoSuchElementException(); 
		
		E max = current.element;
		
		if(current.left != null)
			max = maximum(current.left);
		
		return max;
	}
	
	public E minimum() throws NoSuchElementException {
		return minimum(root);
	}
	
	private E minimum(Node current) {
		if(isEmpty())
			throw new NoSuchElementException(); 
		
		E max = current.element;
		
		if(current.right != null)
			max = maximum(current.right);
		
		return max;
	}
	
	public void clear() {
		if(root == null)
			return;
		
		root.left = null;
		root.right = null;
		root = null;
	}

	public Iterator<E> iterator() {
		return new BinaryTreeIterator<E>(root);
	}
	
	public List<E> toList() {
		List<E> list = new ArrayList<E>(this.countNodes());
		Iterator<E> it = this.iterator();
		
		while(it.hasNext())
			list.add(it.next());
		
		return list;
	}
}
