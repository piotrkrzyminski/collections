package list;

import static org.junit.Assert.assertEquals;

import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

import collections.Iterator;

public class LinkedListIteratorTest {
	
	LinkedList<Integer> list;
	Iterator<Integer> it;
	
	@Before
	public void initialize() {
		list = new LinkedList<Integer>();
	}

	@Test (expected = NoSuchElementException.class)
	public void testHasNextEmptyList() throws NoSuchElementException {
		it = list.iterator();
		
		it.next();
	}
	
	@Test
	public void testGetElements() {
		for(int i = 0; i < 10; i++)
			list.add(Integer.valueOf(i));
		
		it = list.iterator();
		
		int i = 0;
		while(it.hasNext()) {
			assertEquals(it.next(), Integer.valueOf(i));
			i++;
		}
		
		assertEquals(list.size(), i);
	}
}
