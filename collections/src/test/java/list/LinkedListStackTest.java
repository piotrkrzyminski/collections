package list;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import collections.Stack;

public class LinkedListStackTest {
	
	private Stack<Integer> stack;
	
	@Before
	public void initialize() {
		stack = new LinkedList<Integer>();
	}
	
	@Test
	public void testNonParameterContructor() {
		assertEquals(stack.size(), 0);
	}
	
	@Test
	public void testListSize() {
		assertEquals(stack.size(), 0);
		
		stack.push(Integer.valueOf(0));
		
		assertEquals(stack.size(), 1);
	}
	
	@Test
	public void testIsEmpty() {	
		assertEquals(stack.size(), 0);
		assertTrue(stack.isEmpty());
		
		stack.push(Integer.valueOf(0));
		
		assertFalse(stack.isEmpty());
	}
	
	@Test
	public void testAddElement() {
		assertEquals(stack.size(), 0);
		assertTrue(stack.isEmpty());
		
		stack.push(Integer.valueOf(0));
		assertEquals(stack.size(), 1);
		assertFalse(stack.isEmpty());
		
		for(int i = 1; i < 10; i++) {
			stack.push(Integer.valueOf(i));
			assertEquals(stack.size(), i+1);
		}
	}
	
	@Test
	public void testClearing() {
		assertTrue(stack.isEmpty());
		
		for(int i = 0; i < 10; i++)
			stack.push(Integer.valueOf(i));
		
		assertEquals(stack.size(), 10);
		
		stack.clear();
		
		assertEquals(stack.size(), 0);
		assertTrue(stack.isEmpty());
	}
	
	@Test
	public void testPeekHeadElement() {
		stack.push(Integer.valueOf(0));
		stack.push(Integer.valueOf(1));
		
		assertEquals(stack.peek(), Integer.valueOf(1));
	}
	
	@Test
	public void testPopFirstElement() {
		for(int i = 0; i < 10; i++)
			stack.push(Integer.valueOf(i));
		
		assertEquals(stack.pop(), Integer.valueOf(9));
		
		assertEquals(stack.size(), 9);
		
		for(int i = 1; i < 10; i++)
			assertEquals(stack.pop(), Integer.valueOf(9 - i));
	}
}
