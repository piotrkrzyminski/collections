package list;

import org.junit.*;
import static org.junit.Assert.*;

public class ArrayListTest {
	
	@Test
	public void testEmptyList1() {
		List<Integer> list = new ArrayList<Integer>(10);
		assertTrue(list.isEmpty());
	}
	
	@Test
	public void testEmptyList2() {
		List<Integer> list = new ArrayList<Integer>(10);
		list.add(Integer.valueOf(1));
		
		assertFalse(list.isEmpty());
	}
	
	@Test
	public void testListSize() {
		List<Integer> list = new ArrayList<Integer>(10);
		
		for(int i = 0; i < 5; i++)
			list.add(Integer.valueOf(i));
		
		
		assertEquals(list.size(), 5);
	}
	
	@Test
	public void testAddElement() {
		List<Integer> list = new ArrayList<Integer>(10);
		
		assertTrue(list.add(Integer.valueOf(1)));
		assertEquals(list.size(),1);
	}
	
	@Test
	public void testListResize() {
		List<Integer> list = new ArrayList<Integer>(10);
		
		for(int i = 0; i < 10; i++)
			list.add(Integer.valueOf(i));
		
		assertEquals(list.size(),10);
		list.add(Integer.valueOf(10));
		
		assertEquals(list.size(), 11);
	}
	
	@Test
	public void testListClear() throws EmptyListException {
		List<Integer> list = new ArrayList<Integer>(10);
		
		for(int i = 0; i < 5; i++)
			list.add(Integer.valueOf(i));
		
		list.clear();
		
		assertTrue(list.isEmpty());
		assertEquals(list.size(), 0);
	}
	
	@Test(expected = EmptyListException.class)
	public void testClearEmptyList() throws EmptyListException {
		List<Integer> list = new ArrayList<Integer>(10);
		list.clear();
	}
	
	@Test
	public void testGetElement() throws IllegalArgumentException, EmptyListException {
		List<Integer> list = new ArrayList<Integer>(10);
		
		for(int i = 0; i < 5; i++)
			list.add(Integer.valueOf(i));
		
		for(int i = 0; i < 5; i++)
			assertTrue(list.get(i).equals(Integer.valueOf(i)));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testWrongElementIndex() throws IllegalArgumentException, EmptyListException {
		List<Integer> list = new ArrayList<Integer>(10);
		
		for(int i = 0; i < 5; i++)
			list.add(Integer.valueOf(i));
		
		list.get(-1);
	}
	
	@Test(expected = EmptyListException.class)
	public void testGetElementFromEmptyList() throws IllegalArgumentException, EmptyListException {
		List<Integer> list = new ArrayList<Integer>(10);
		
		list.get(0);
	}
	
	@Test
	public void testRemoveElement() throws IllegalArgumentException, EmptyListException {
		List<Integer> list = new ArrayList<Integer>(10);
		
		for(int i = 0; i < 5; i++)
			list.add(Integer.valueOf(i));
		
		for(int i = 0; i < 5; i++)
			assertTrue(list.remove(i).equals(Integer.valueOf(i)));
	}
	
	@Test (expected = EmptyListException.class)
	public void testRemoveElementFromEmptyList() throws IllegalArgumentException, EmptyListException {
		List<Integer> list = new ArrayList<Integer>(10);
		
		list.remove(0);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testRemoveElementWrongIndex() throws IllegalArgumentException, EmptyListException {
		List<Integer> list = new ArrayList<Integer>(10);
		
		list.remove(-1);
	}
}
