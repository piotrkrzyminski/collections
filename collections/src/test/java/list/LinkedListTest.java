package list;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class LinkedListTest {
	
	private LinkedList<Integer> list;
	
	@Before
	public void initialize() {
		list = new LinkedList<Integer>();
	}
	
	@Test
	public void testNonParameterContructor() {
		assertEquals(list.size(), 0);
	}
	
	@Test
	public void testCopyingConstructor() {
		for(int i = 0; i < 10; i++)
			list.add(Integer.valueOf(i));
		
		LinkedList<Integer> copy = new LinkedList<Integer>(list);
		
		assertEquals(list.size(), copy.size());
		
		for(int i = 0; i < 10; i++) 
			assertEquals(list.get(i), copy.get(i));
	}
	
	@Test
	public void testListSize() {
		assertEquals(list.size(), 0);
		
		list.add(Integer.valueOf(0));
		
		assertEquals(list.size(), 1);
	}
	
	@Test
	public void testIsEmpty() {	
		assertEquals(list.size(), 0);
		assertTrue(list.isEmpty());
		
		list.add(Integer.valueOf(0));
		
		assertFalse(list.isEmpty());
	}
	
	@Test
	public void testAddElement() {
		assertEquals(list.size(), 0);
		assertTrue(list.isEmpty());
		
		list.add(Integer.valueOf(0));
		assertEquals(list.size(), 1);
		assertFalse(list.isEmpty());
		
		for(int i = 1; i < 10; i++) {
			list.add(Integer.valueOf(i));
			assertEquals(list.size(), i+1);
		}
	}
	
	@Test
	public void testClearing() {
		assertTrue(list.isEmpty());
		
		for(int i = 0; i < 10; i++)
			list.add(Integer.valueOf(i));
		
		assertEquals(list.size(), 10);
		
		list.clear();
		
		assertEquals(list.size(), 0);
		assertTrue(list.isEmpty());
	}
	
	@Test
	public void testGetElement() {
		for(int i = 0; i < 10; i++)
			list.add(Integer.valueOf(i));
		
		for(int i = 0; i < 10; i++)
			assertEquals(list.get(i), Integer.valueOf(i));
	}
	
	@Test (expected = IndexOutOfBoundsException.class)
	public void testGetElementWrongIndex() {
		for(int i = 0; i < 10; i++)
			list.add(Integer.valueOf(i));
		
		list.get(-1);
		list.get(100);
	}
	
	@Test
	public void testElementContain() {
		for(int i = 0; i < 10; i++)
			list.add(Integer.valueOf(i));
		
		for(int i = 0; i < 10; i++)
			assertTrue(list.contains(Integer.valueOf(i)));
		
		assertFalse(list.contains(Integer.valueOf(100)));
	}
	
	@Test
	public void testIndexOfNotFound() {
		for(int i = 0; i < 10; i++)
			list.add(Integer.valueOf(i));
		
		list.indexOf(Integer.valueOf(1000));
	}
	
	@Test
	public void testIndexOfElement() {
		for(int i = 0; i < 10; i++)
			list.add(Integer.valueOf(i));
		
		for(int i = 0; i < 10; i++)
			assertEquals(list.indexOf(Integer.valueOf(i)), i);
	}
	
	@Test
	public void testRemoveFirstElement() {
		for(int i = 0; i < 10; i++)
			list.add(Integer.valueOf(i));
		
		for(int i = 0; i < 10; i++)
			assertEquals(list.get(i), Integer.valueOf(i));
		
		assertEquals(list.remove(0), Integer.valueOf(0));
		
		
		assertEquals(list.size(), 9);
		
		for(int i = 1; i < 10; i++)
			assertEquals(list.get(i-1), Integer.valueOf(i));
	}
	
	@Test
	public void testRemoveMiddleElement() {
		for(int i = 0; i < 10; i++)
			list.add(Integer.valueOf(i));
		
		assertEquals(list.remove(5), Integer.valueOf(5));
		assertEquals(list.size(), 9);
		
		assertEquals(list.get(5), Integer.valueOf(6));
		assertEquals(list.get(6), Integer.valueOf(7));
	}
	
	@Test
	public void testRemoveLastElement() {
		for(int i = 0; i < 10; i++)
			list.add(Integer.valueOf(i));
		
		assertEquals(list.remove(9), Integer.valueOf(9));
		assertEquals(list.size(), 9);
		
		for(int i = 0; i < 9; i++)
			assertEquals(list.get(i), Integer.valueOf(i));
	}
	
	@Test (expected = IndexOutOfBoundsException.class)
	public void testRemoveElementWrongIndex() {
		for(int i = 0; i < 10; i++)
			list.add(Integer.valueOf(i));
		
		list.remove(-1);
		list.remove(113);
	}
	
	@Test
	public void testReplaceElement() {
		for(int i = 0; i < 10; i++)
			list.add(Integer.valueOf(i));
		
		assertTrue(list.replace(Integer.valueOf(100), 0));
		assertEquals(list.get(0), Integer.valueOf(100));
	}
	
	@Test (expected = IndexOutOfBoundsException.class)
	public void testReplaceElementWrongIndex() {
		for(int i = 0; i < 10; i++)
			list.add(Integer.valueOf(i));
		
		list.replace(Integer.valueOf(100), -1);
		list.replace(Integer.valueOf(13993), 2334);
	}
	
	@Test
	public void testToArrayConversion() {
		for(int i = 0; i < 5; i++)
			list.add(Integer.valueOf(i));
		
		Object[] array = list.toArray();
		
		for(int i = 0; i < 5; i++)
			assertEquals(list.get(i), array[i]);
	}
}	
