package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.LIFO;

public class TestLIFO { 

	LIFO l1;
	LIFO l2;
	LIFO l3;
	
	@Before
	public void setUp() throws Exception {
		l1 = new LIFO(6); // l1 --> empty stack;
		l2 = new LIFO(5); // l2 --> contains 1 element;
			l2.push(10);
		l3 = new LIFO(6); // l3 --> full stack
			l3.push(1);
			l3.push(2);
			l3.push(3);
			l3.push(4);
			l3.push(5);
			l3.push(6);
	}

	@After
	public void tearDown() throws Exception {
		l1 = null;
		l2 = null;
		l3 = null;
	}

	@Test //test on getSize method
	public void testGetSize() {
		assertEquals(6, l1.getSize()); // l1 has dim = 6
		assertEquals(5, l2.getSize()); // l2 has dim = 5
		assertEquals(6, l3.getSize()); // l3 has dim = 6
	}
	
	@Test  //test on getNumberOfElements method
	public void testGetNumberOfElements() {
		assertEquals(0, l1.getNumberOfElements()); // l1 is empty
		assertEquals(1, l2.getNumberOfElements()); // l2 has 1 element
		assertEquals(6, l3.getNumberOfElements()); // l3 is full
	}
	
	@Test  //test on isEmpty method
	public void testIsEmpty() {
		assertTrue("Test failed: the stack should be empty", l1.isEmpty());
		assertFalse("Test failed: the stack should contains 1 element", l2.isEmpty());
		assertFalse("Test failed: the stack should be full", l3.isEmpty());
	}
	
	@Test  //test on isFull method
	public void testIsFull() {
		assertFalse("Test failed: the stack should be empty", l1.isFull());
		assertFalse("Test failed: the stack should contains only 1 element", l2.isFull());
		assertTrue("Test failed: the stack should be full", l3.isFull());
	}
	
	@Test  //test on head method
	public void testHead() {
		//assertEquals(-1, l1.head());
		assertEquals(10, l2.head());
		assertEquals(6, l3.head());
	}
	
	@Test  //test on push method
	public void testPush() { 
		assertEquals(0, l1.getNumberOfElements()); // l1 is empty
		l1.push(5);
		assertEquals(1, l1.getNumberOfElements()); // l1 has 1 element
		assertEquals(1, l2.getNumberOfElements()); // l2 has 1 element
		l2.push(5);
		assertEquals(2, l2.getNumberOfElements()); // l2 has 2 elements
		/*assertEquals(6, l3.getNumberOfElements()); // l3 is full
		l3.push(5);
		assertEquals(6, l3.getNumberOfElements());*/ // l3 is full --> TEST EXCEPTION STACK OVERFLOW
	} 
	
	@Test  //test on pop method
	public void testPop() {
		/*assertEquals(0, l1.getNumberOfElements()); // l1 is empty
		l1.pop();
		assertEquals(0, l1.getNumberOfElements()); // l1 remains empty*/ // l1 is empty --> TEST EXCEPTION STACK UNDERFLOW
		assertEquals(1, l2.getNumberOfElements()); // l2 has 1 element
		l2.pop();
		assertEquals(0, l2.getNumberOfElements()); // l2 now is empty
		assertEquals(6, l3.getNumberOfElements()); // l3 is full
		l3.pop();
		assertEquals(5, l3.getNumberOfElements()); // l3 has 1 less element
	}
	
	/*
	 * The following tests are referred to the methods that launch the exception 
	 */
	@Test (expected = IllegalStateException.class)
	public void testQueueOverFlow() throws Exception {
		l3.push(7);
	}
	
	@Test (expected = IllegalStateException.class)
	public void testQueueUnderFlow() throws Exception {
		l1.pop();
	}
	
	@Test (expected = IllegalStateException.class)
	public void testHeadUnderFlow() throws Exception {
		l1.head();
	}

}
