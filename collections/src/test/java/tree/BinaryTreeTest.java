package tree;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

import collections.Tree;

public class BinaryTreeTest {

	Tree<Integer> tree;
	
	@Before
	public void initialize() {
		tree = new BinaryTree<Integer>();
	}
	
	@Test
	public void testAddElement() {
		tree.insert(Integer.valueOf(2));
		tree.insert(Integer.valueOf(1));
		tree.insert(Integer.valueOf(3));
	}
	
	@Test
	public void testGetRoot() {
		tree.insert(Integer.valueOf(2));
		tree.insert(Integer.valueOf(1));
		tree.insert(Integer.valueOf(3));
		
		assertEquals(tree.getRoot(), Integer.valueOf(2));
	}
	
	@Test (expected = NoSuchElementException.class)
	public void testGetNullRoot() {
		tree.getRoot();
	}
	
	@Test
	public void testCountEmptyTree() {
		assertEquals(tree.countNodes(), 0);
	}
	
	@Test
	public void testCountTree() {
		for(int i = 0; i < 10; i++) {
			tree.insert(i);
			assertEquals(tree.countNodes(), i+1);
		}
	}
	
	@Test
	public void testPrintAscending() {
		for(int i = 0; i < 10; i++)
			tree.insert((int) (Math.random() * 10000));
		
		tree.printAscending();
		System.out.println();
	}
	
	@Test
	public void testPrintDescending() {
		for(int i = 0; i < 10; i++)
			tree.insert((int) (Math.random() * 10000));
		
		tree.printDescending();
		System.out.println();
	}
	
	@Test
	public void testSearch() {
		tree.insert(Integer.valueOf(2));
		tree.insert(Integer.valueOf(1));
		tree.insert(Integer.valueOf(3));

		assertTrue(tree.contains(Integer.valueOf(2)));
		assertTrue(tree.contains(Integer.valueOf(3)));
		assertFalse(tree.contains(Integer.valueOf(6)));
	}
	
	@Test
	public void testSearchEmptyTree() {
		assertFalse(tree.contains(Integer.valueOf(1)));
	}
	
	@Test
	public void testIsEmptyTree() {
		assertTrue(tree.isEmpty());
		
		tree.insert(Integer.valueOf(2));
		tree.insert(Integer.valueOf(1));
		tree.insert(Integer.valueOf(3));
		
		assertFalse(tree.isEmpty());
	}
	
	@Test
	public void testFindMaximum() {
		tree.insert(Integer.valueOf(2));
		tree.insert(Integer.valueOf(14));
		tree.insert(Integer.valueOf(3));
		
		assertEquals(tree.maximum(), Integer.valueOf(14));
	}
	
	@Test (expected = NoSuchElementException.class)
	public void testFindMaximumEmptyTree() {
		tree.maximum();
	}
	
	@Test
	public void testFindMinimum() {
		tree.insert(Integer.valueOf(2));
		tree.insert(Integer.valueOf(14));
		tree.insert(Integer.valueOf(3));
		
		assertEquals(tree.minimum(), Integer.valueOf(2));
	}
	
	@Test (expected = NoSuchElementException.class)
	public void testFindMinimumEmptyTree() {
		tree.minimum();
	}
	
	@Test
	public void testClearTree() {
		for(int i = 0; i < 10; i++)
			tree.insert((int) (Math.random() * 10000));
		
		assertFalse(tree.isEmpty());
		tree.clear();
		assertTrue(tree.isEmpty());
		
		for(int i = 0; i < 10; i++)
			tree.insert((int) (Math.random() * 10000));
		
		assertFalse(tree.isEmpty());
	}
}
