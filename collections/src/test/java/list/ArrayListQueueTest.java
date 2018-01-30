package list;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

import collections.List;
import collections.Queue;

public class ArrayListQueueTest {
	
	private Queue<Integer> queue;
	
	@Before
	public void initialize() {
		queue = new ArrayList<Integer>(10);
	}
	
	@Test
	public void testNonParameterConstructor() {
		List<Integer> list1 = new ArrayList<Integer>();
		assertTrue(list1.isEmpty());
		assertEquals(list1.size(), 0);
	}
	
	@Test
	public void testIntParameterConstructor() {
		assertTrue(queue.isEmpty());
		assertEquals(queue.size(), 0);
	}
	
	@Test
	public void testEmptyList1() {
		assertTrue(queue.isEmpty());
	}
	
	@Test
	public void testEmptyList2() {
		queue.add(Integer.valueOf(1));
		
		assertFalse(queue.isEmpty());
	}
	
	@Test
	public void testListSize() {		
		for(int i = 0; i < 5; i++)
			queue.add(Integer.valueOf(i));
		
		
		assertEquals(queue.size(), 5);
	}
	
	@Test
	public void testAddElement() {
		assertTrue(queue.add(Integer.valueOf(1)));
		assertEquals(queue.size(),1);
	}
	
	@Test
	public void testAddElementNotNull() {
		assertTrue(queue.add(Integer.valueOf(1)));
		assertTrue(queue.get() != null);
	}
	
	@Test
	public void testListResize() {
		for(int i = 0; i < 10; i++)
			queue.add(Integer.valueOf(i));
		
		assertEquals(queue.size(),10);
		queue.add(Integer.valueOf(10));
		
		assertEquals(queue.size(), 11);
	}
	
	@Test
	public void testListClear() {
		for(int i = 0; i < 5; i++)
			queue.add(Integer.valueOf(i));
		
		queue.clear();
		
		assertTrue(queue.isEmpty());
		assertEquals(queue.size(), 0);
	}
	
	@Test
	public void testRemoveElement() {
		for(int i = 0; i < 5; i++)
			queue.add(Integer.valueOf(i));
		
		for(int i = 0; i < 5; i++)
			assertTrue(queue.remove().equals(Integer.valueOf(i)));
	}
	
	@Test
	public void testGetHeadElement() {
		queue.add(Integer.valueOf(0));
		queue.add(Integer.valueOf(1));
		
		assertTrue(queue.get().equals(Integer.valueOf(0)));
	}
	
	@Test (expected = NoSuchElementException.class)
	public void testGetFromEmptyQueue() {
		queue.get();
	}
	
	@Test (expected = NoSuchElementException.class)
	public void testRemoveFromEmptyQueue() {
		queue.remove();
	}
}
