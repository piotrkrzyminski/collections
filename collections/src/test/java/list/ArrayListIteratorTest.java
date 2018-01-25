package list;

import static org.junit.Assert.assertEquals;

import java.util.NoSuchElementException;

import org.junit.BeforeClass;
import org.junit.Test;

import collections.Iterator;

public class ArrayListIteratorTest {
	
	static ArrayList<Integer> arrayList;
	static Iterator<Integer> iterator;
	
	@BeforeClass
	public static void initialize() {
		arrayList = new ArrayList<Integer>();
		
		for(int i = 0; i < 10; i++)
			arrayList.add(Integer.valueOf(i));
		
		iterator = arrayList.iterator();
	}
	
	@Test
	public void testIteratorHasNext() {
		int i = 0;
		while(iterator.hasNext()) {
			assertEquals(iterator.next(), Integer.valueOf(i));
			i++;
		}
	}
	
	@Test (expected = NoSuchElementException.class)
	public void testEmptyListIteratorNext() {
		ArrayList<Integer> arrayList2 = new ArrayList<Integer>(0);
		Iterator<Integer> iterator2 = arrayList2.iterator();
		
		iterator2.next();
		
	}
}
