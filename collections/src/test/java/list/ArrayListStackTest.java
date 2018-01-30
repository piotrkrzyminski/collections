package list;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.EmptyStackException;

import org.junit.Before;
import org.junit.Test;

import collections.List;
import collections.Stack;

public class ArrayListStackTest {
	
	private Stack<Integer> stack;
	
	@Before
	public void initialize() {
		stack = new ArrayList<Integer>(10);
	}
	
	@Test
	public void testNonParameterConstructor() {
		List<Integer> list1 = new ArrayList<Integer>();
		assertTrue(list1.isEmpty());
		assertEquals(list1.size(), 0);
	}
	
	@Test
	public void testIntParameterConstructor() {
		assertTrue(stack.isEmpty());
		assertEquals(stack.size(), 0);
	}
	
	@Test
	public void testEmptyList1() {
		assertTrue(stack.isEmpty());
	}
	
	@Test
	public void testEmptyList2() {
		stack.push(Integer.valueOf(1));
		
		assertFalse(stack.isEmpty());
	}
	
	@Test
	public void testListSize() {		
		for(int i = 0; i < 5; i++)
			stack.push(Integer.valueOf(i));
		
		assertEquals(stack.size(), 5);
	}
	
	@Test
	public void testPushElement() {
		assertTrue(stack.push(Integer.valueOf(1)));
		assertEquals(stack.size(),1);
	}
	
	@Test
	public void testPushElementNotNull() {
		assertTrue(stack.push(Integer.valueOf(1)));
		assertTrue(stack.pop() != null);
	}
	
	@Test
	public void testListResize() {
		for(int i = 0; i < 10; i++)
			stack.push(Integer.valueOf(i));
		
		assertEquals(stack.size(),10);
		stack.push(Integer.valueOf(10));
		
		assertEquals(stack.size(), 11);
	}
	
	@Test
	public void testListClear() {
		for(int i = 0; i < 5; i++)
			stack.push(Integer.valueOf(i));
		
		stack.clear();
		
		assertTrue(stack.isEmpty());
		assertEquals(stack.size(), 0);
	}
	
	@Test
	public void testPopElement() {
		for(int i = 0; i < 5; i++)
			stack.push(Integer.valueOf(i));
		
		for(int i = 0; i < 5; i++)
			assertEquals(stack.pop(), Integer.valueOf(4-i));
	}
	
	@Test
	public void testPeekElement() {
		stack.push(Integer.valueOf(1));
		assertEquals(stack.peek(), Integer.valueOf(1));
	}
	
	@Test (expected = EmptyStackException.class)
	public void testPopFromEmptyStack() {
		stack.pop();
	}
	
	@Test (expected = EmptyStackException.class)
	public void testPeekFromEmptyStack() {
		stack.peek();
	}
	
}
