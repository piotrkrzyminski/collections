package list;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import collections.Queue;

public class LinkedListQueueTest {
	private Queue<Integer> queue;
	
	@Before
	public void initialize() {
		queue = new LinkedList<Integer>();
	}
	
	@Test
	public void testNonParameterContructor() {
		assertEquals(queue.size(), 0);
	}
	
	@Test
	public void testListSize() {
		assertEquals(queue.size(), 0);
		
		queue.add(Integer.valueOf(0));
		
		assertEquals(queue.size(), 1);
	}
	
	@Test
	public void testIsEmpty() {	
		assertEquals(queue.size(), 0);
		assertTrue(queue.isEmpty());
		
		queue.add(Integer.valueOf(0));
		
		assertFalse(queue.isEmpty());
	}
	
	@Test
	public void testAddElement() {
		assertEquals(queue.size(), 0);
		assertTrue(queue.isEmpty());
		
		queue.add(Integer.valueOf(0));
		assertEquals(queue.size(), 1);
		assertFalse(queue.isEmpty());
		
		for(int i = 1; i < 10; i++) {
			queue.add(Integer.valueOf(i));
			assertEquals(queue.size(), i+1);
		}
	}
	
	@Test
	public void testClearing() {
		assertTrue(queue.isEmpty());
		
		for(int i = 0; i < 10; i++)
			queue.add(Integer.valueOf(i));
		
		assertEquals(queue.size(), 10);
		
		queue.clear();
		
		assertEquals(queue.size(), 0);
		assertTrue(queue.isEmpty());
	}
	
	@Test
	public void testGetHeadElement() {
		queue.add(Integer.valueOf(0));
		queue.add(Integer.valueOf(1));
		
		assertEquals(queue.get(), Integer.valueOf(0));
	}
	
	@Test
	public void testRemoveFirstElement() {
		for(int i = 0; i < 10; i++)
			queue.add(Integer.valueOf(i));
		
		assertEquals(queue.remove(), Integer.valueOf(0));
		
		assertEquals(queue.size(), 9);
		
		for(int i = 1; i < 10; i++)
			assertEquals(queue.remove(), Integer.valueOf(i));
	}
}
