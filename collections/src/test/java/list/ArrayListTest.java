package list;

import org.junit.*;
import static org.junit.Assert.*;

public class ArrayListTest {
	
	@Test
	public void testNonParameterConstructor() {
		List<Integer> list = new ArrayList<Integer>();
		assertTrue(list.isEmpty());
		assertEquals(list.size(), 0);
	}
	
	@Test
	public void testIntParameterConstructor() {
		List<Integer> list = new ArrayList<Integer>(10);
		assertTrue(list.isEmpty());
		assertEquals(list.size(), 0);
	}
	
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
	public void testAddElementNotNull() throws IndexOutOfBoundsException, EmptyListException {
		List<Integer> list = new ArrayList<Integer>(10);
		
		assertTrue(list.add(Integer.valueOf(1)));
		assertTrue(list.get(0) != null);
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
	
	@Test
	public void testGetElement() throws IllegalArgumentException {
		List<Integer> list = new ArrayList<Integer>(10);
		
		for(int i = 0; i < 5; i++)
			list.add(Integer.valueOf(i));
		
		for(int i = 0; i < 5; i++)
			assertTrue(list.get(i).equals(Integer.valueOf(i)));
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void testWrongElementIndex() throws IndexOutOfBoundsException {
		List<Integer> list = new ArrayList<Integer>(10);
		
		for(int i = 0; i < 5; i++)
			list.add(Integer.valueOf(i));
		
		list.get(-1);
	}
	
	@Test
	public void testRemoveElement() throws IndexOutOfBoundsException, EmptyListException {
		List<Integer> list = new ArrayList<Integer>(10);
		
		for(int i = 0; i < 5; i++)
			list.add(Integer.valueOf(i));
		
		assertTrue(list.remove(3).equals(Integer.valueOf(3)));
		assertEquals(list.get(3), Integer.valueOf(4));
	}
	
	@Test (expected = EmptyListException.class)
	public void testRemoveElementFromEmptyList() throws IndexOutOfBoundsException, EmptyListException {
		List<Integer> list = new ArrayList<Integer>(10);
		
		list.remove(0);
	}
	
	@Test (expected = IndexOutOfBoundsException.class)
	public void testRemoveElementWrongIndex() throws IndexOutOfBoundsException, EmptyListException {
		List<Integer> list = new ArrayList<Integer>(10);
		
		list.remove(-1);
	}
	
	@Test
	public void testListCloning() throws IndexOutOfBoundsException, EmptyListException {
		List<Integer> list = new ArrayList<Integer>(10);
		
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
		List<Integer> list = new ArrayList<Integer>(10);
		
		for(int i = 0; i < 5; i++)
			list.add(Integer.valueOf(i));
		
		assertTrue(list.contains(Integer.valueOf(0)));
		assertFalse(list.contains(Integer.valueOf(13424)));
	}
	
	@Test
	public void testIndexOfElement() {
		List<Integer> list = new ArrayList<Integer>(10);
		
		for(int i = 0; i < 5; i++)
			list.add(Integer.valueOf(i));
		
		assertEquals(list.indexOf(Integer.valueOf(2)), 2);
		assertEquals(list.indexOf(Integer.valueOf(42)), -1);
	}
	
	@Test
	public void testIndexOfElementEmptyList() {
		List<Integer> list = new ArrayList<Integer>(10);
		
		assertEquals(list.indexOf(Integer.valueOf(2)), -1);
	}
	
	@Test
	public void testReplacing() throws IndexOutOfBoundsException, EmptyListException {
		List<Integer> list = new ArrayList<Integer>(10);
		
		for(int i = 0; i < 5; i++)
			list.add(Integer.valueOf(i));
		
		assertTrue(list.replace(Integer.valueOf(10), 3));
		assertEquals(list.get(3), Integer.valueOf(10));
	}
	
	@Test (expected = IndexOutOfBoundsException.class)
	public void testReplacingInvalidIndex() {
		List<Integer> list = new ArrayList<Integer>(10);
		
		for(int i = 0; i < 5; i++)
			list.add(Integer.valueOf(i));
		
		list.replace(Integer.valueOf(10), 13);
		list.replace(Integer.valueOf(10), -1);
	}
	
	@Test
	public void testTrimToSize() {
		ArrayList<Integer> list = new ArrayList<Integer>(10);
		
		for(int i = 0; i < 5; i++)
			list.add(Integer.valueOf(i));
		
		list.trimToSize();
		
		assertEquals(list.size(), 5);
		
		for(int i = 0; i < 5; i++)
			assertEquals(list.get(i), Integer.valueOf(i));
	}
	
	@Test
	public void testToArrayConversion() {
		List<Integer> list = new ArrayList<Integer>(10);
		
		for(int i = 0; i < 5; i++)
			list.add(Integer.valueOf(i));
		
		Object[] array = list.toArray();
		
		for(int i = 0; i < 5; i++)
			assertEquals(list.get(i), array[i]);
	}
}
