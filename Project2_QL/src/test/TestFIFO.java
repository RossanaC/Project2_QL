package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.FIFO;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestFIFO { 

	FIFO f1;
	FIFO f2;
	FIFO f3;
	
	@Before
	public void setUp() throws Exception {
		f1 = new FIFO(6); // f1 --> empty queue
		f2 = new FIFO(5); // f2 --> 1 element
			f2.push(10);
		f3 = new FIFO(6); // f3 --> full queue
			f3.push(1);
			f3.push(2);
			f3.push(3);
			f3.push(4);
			f3.push(5);
			f3.push(6);
	}

	@After
	public void tearDown() throws Exception {
		f1 = null;
		f2 = null;
		f3 = null;
	}

	@Test //test on getSize method
	public void testGetSize() {
		assertEquals(6, f1.getSize()); // f1 has dim = 6
		assertEquals(5, f2.getSize()); // f2 has dim = 5
		assertEquals(6, f3.getSize()); // f3 has dim = 6
	}
	
	@Test  //test on getNumberOfElements method
	public void testGetNumberOfElements() {
		assertEquals(0, f1.getNumberOfElements()); // f1 is empty
		assertEquals(1, f2.getNumberOfElements()); // f2 has 1 element
		assertEquals(6, f3.getNumberOfElements()); // f3 is full
	}
	
	@Test  //test on isEmpty method
	public void testIsEmpty() {
		assertTrue("Test failed: the stack should be empty", f1.isEmpty());
		assertFalse("Test failed: the stack should contains 1 element", f2.isEmpty());
		assertFalse("Test failed: the stack should be full", f3.isEmpty());
	}
	
	@Test  //test on isFull method
	public void testIsFull() {
		assertFalse("Test failed: the stack should be empty", f1.isFull());
		assertFalse("Test failed: the stack should contains only 1 element", f2.isFull());
		assertTrue("Test failed: the stack should be full", f3.isFull());
	}
	
	@Test  //test on head method
	public void testHead() {
		//assertEquals(-1, f1.head());
		assertEquals(10, f2.head()); 
		assertEquals(1, f3.head());
	}
	
	@Test  //test on tail method
	public void testTail() {
		assertEquals(-1, f1.tail());
		assertEquals(10, f2.tail());
		assertEquals(6, f3.tail());
	}
	
	@Test  //test on push method
	public void testPush() { 
		assertEquals(0, f1.getNumberOfElements()); // f1 is empty
		f1.push(5);
		assertEquals(1, f1.getNumberOfElements()); // f1 has 1 element
		assertEquals(1, f2.getNumberOfElements()); // f2 has 1 element
		f2.push(5);
		assertEquals(2, f2.getNumberOfElements()); // f2 has 2 elements
		/*assertEquals(6, f3.getNumberOfElements()); // f3 is full
		f3.push(5);
		assertEquals(6, f3.getNumberOfElements()); // f3 is full*/ // --> TEST EXCEPTION
	} 
	
	@Test  //test on pop method 
	public void testPop() {
		/*assertEquals(0, f1.getNumberOfElements()); // f1 is empty
		f1.pop();
		assertEquals(0, f1.getNumberOfElements()); // f1 remains empty*/ // TEST EXCEPTION
		assertEquals(1, f2.getNumberOfElements()); // f2 has 1 element
		f2.pop();
		assertEquals(0, f2.getNumberOfElements()); // f2 now is empty
		assertEquals(6, f3.getNumberOfElements()); // f3 is full
		f3.pop();
		assertEquals(5, f3.getNumberOfElements()); // f has 1 less element
	}
	
	/*
	 * The following tests are referred to the methods that launch the exception 
	 */
	@Test (expected = IllegalStateException.class)
	public void testQueueOverFlow() throws Exception {
		f3.push(7);
	}
	
	@Test (expected = IllegalStateException.class)
	public void testQueueUnderFlow() throws Exception {
		f1.pop();
	}
	
	@Test (expected = IllegalStateException.class)
	public void testHeadUnderFlow() throws Exception {
		f1.head();
	}

}
