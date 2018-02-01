package tree;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

import collections.Iterator;
import collections.Tree;

public class BinaryTreeIteratorTest {

	Tree<Integer> tree;
	Iterator<Integer> it;
	
	@Before
	public void initialize() {
		tree = new BinaryTree<Integer>();
	}
	
	@Test
	public void testHasNextEmptyTree() {
		it = tree.iterator();
		assertFalse(it.hasNext());
	}
	
	@Test
	public void testHasNext() {
		tree.insert(Integer.valueOf(1));
		tree.insert(Integer.valueOf(2));
		
		it = tree.iterator();
		
		assertTrue(it.hasNext());
	}
	
	@Test (expected = NoSuchElementException.class)
	public void testNextEmptyTree() {
		it = tree.iterator();
		
		it.next();
	}
	
	@Test
	public void testNext() {
		for(int i = 0; i >= 10; i++)
			tree.insert(Integer.valueOf(i));
		
		it = tree.iterator();
		
		int i = 0;
		while(it.hasNext())
			assertEquals(it.next(), Integer.valueOf(i++));
	}
	
}
