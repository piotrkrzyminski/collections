package list;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import collections.List;

public class ArrayListTest {
	
	private ArrayList<Integer> list;
	
	@Before
	public void initialize() {
		list = new ArrayList<Integer>(10);
	}
	
	@Test
	public void testNonParameterConstructor() {
		List<Integer> list1 = new ArrayList<Integer>();
		assertTrue(list1.isEmpty());
		assertEquals(list1.size(), 0);
	}
	
	@Test
	public void testIntParameterConstructor() {
		assertTrue(list.isEmpty());
		assertEquals(list.size(), 0);
	}
	
	@Test
	public void testEmptyList1() {
		assertTrue(list.isEmpty());
	}
	
	@Test
	public void testEmptyList2() {
		list.add(Integer.valueOf(1));
		
		assertFalse(list.isEmpty());
	}
	
	@Test
	public void testListSize() {		
		for(int i = 0; i < 5; i++)
			list.add(Integer.valueOf(i));
		
		
		assertEquals(list.size(), 5);
	}
	
	@Test
	public void testAddElement() {
		assertTrue(list.add(Integer.valueOf(1)));
		assertEquals(list.size(),1);
	}
	
	@Test
	public void testAddElementNotNull() throws IndexOutOfBoundsException {
		assertTrue(list.add(Integer.valueOf(1)));
		assertTrue(list.get(0) != null);
	}
	
	@Test
	public void testListResize() {
		for(int i = 0; i < 10; i++)
			list.add(Integer.valueOf(i));
		
		assertEquals(list.size(),10);
		list.add(Integer.valueOf(10));
		
		assertEquals(list.size(), 11);
	}
	
	@Test
	public void testListClear() {
		for(int i = 0; i < 5; i++)
			list.add(Integer.valueOf(i));
		
		list.clear();
		
		assertTrue(list.isEmpty());
		assertEquals(list.size(), 0);
	}
	
	@Test
	public void testGetElement() throws IllegalArgumentException {
		for(int i = 0; i < 5; i++)
			list.add(Integer.valueOf(i));
		
		for(int i = 0; i < 5; i++)
			assertTrue(list.get(i).equals(Integer.valueOf(i)));
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void testWrongElementIndex() throws IndexOutOfBoundsException {
		for(int i = 0; i < 5; i++)
			list.add(Integer.valueOf(i));
		
		list.get(-1);
	}
	
	@Test
	public void testRemoveElement() throws IndexOutOfBoundsException {
		for(int i = 0; i < 5; i++)
			list.add(Integer.valueOf(i));
		
		assertTrue(list.remove(3).equals(Integer.valueOf(3)));
		assertEquals(list.get(3), Integer.valueOf(4));
	}
	
	@Test (expected = IndexOutOfBoundsException.class)
	public void testRemoveElementWrongIndex() throws IndexOutOfBoundsException {
		list.remove(-1);
	}
	
	@Test
	public void testListCloning() throws IndexOutOfBoundsException {
		for(int i = 0; i < 5; i++)
			list.add(Integer.valueOf(i));
		
		List<Integer> clonedList = new ArrayList<Integer>(list);
		
		assertEquals(list.size(), clonedList.size());
		
		for(int i = 0; i < 5; i++) {
			assertTrue(list.get(i) != null);
			assertTrue(list.get(i).equals(clonedList.get(i)));
		}
		
	}
	
	@Test
	public void testContainsElement() {
		for(int i = 0; i < 5; i++)
			list.add(Integer.valueOf(i));
		
		assertTrue(list.contains(Integer.valueOf(0)));
		assertFalse(list.contains(Integer.valueOf(13424)));
	}
	
	@Test
	public void testIndexOfElement() {
		for(int i = 0; i < 5; i++)
			list.add(Integer.valueOf(i));
		
		assertEquals(list.indexOf(Integer.valueOf(2)), 2);
		assertEquals(list.indexOf(Integer.valueOf(42)), -1);
	}
	
	@Test
	public void testIndexOfElementEmptyList() {
		assertEquals(list.indexOf(Integer.valueOf(2)), -1);
	}
	
	@Test
	public void testReplacing() throws IndexOutOfBoundsException {
		for(int i = 0; i < 5; i++)
			list.add(Integer.valueOf(i));
		
		assertTrue(list.replace(Integer.valueOf(10), 3));
		assertEquals(list.get(3), Integer.valueOf(10));
	}
	
	@Test (expected = IndexOutOfBoundsException.class)
	public void testReplacingInvalidIndex() {
		for(int i = 0; i < 5; i++)
			list.add(Integer.valueOf(i));
		
		list.replace(Integer.valueOf(10), 13);
		list.replace(Integer.valueOf(10), -1);
	}
	
	@Test
	public void testTrimToSize() {
		for(int i = 0; i < 5; i++)
			list.add(Integer.valueOf(i));
		
		list.trimToSize();
		
		assertEquals(list.size(), 5);
		
		for(int i = 0; i < 5; i++)
			assertEquals(list.get(i), Integer.valueOf(i));
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
