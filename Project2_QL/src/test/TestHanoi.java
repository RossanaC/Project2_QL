package test;
import model.*;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestHanoi {

	Hanoi h;
	LIFO l1;
	LIFO l2;
	LIFO l3;
	
	@Before
	public void setUp() throws Exception {
		h = new Hanoi(3);
		l1 = new LIFO(3);
			l1.push(1);
			l1.push(2);
			l1.push(3);
		l2 = new LIFO(3);
		l3 = new LIFO(3);   
	}

	@After
	public void tearDown() throws Exception {
		h = null;
		l1 = null;
		l2 = null;
		l3 = null;
	}

	@Test //test on moveADisck method
	public void testMoveADisk() {
		l1 = new LIFO(3);
			l1.push(1);
			l1.push(2);
			l1.push(3);
		l2 = new LIFO(3);
		h.moveADisk(l1, l2);
		assertEquals(2, l1.getNumberOfElements());
		assertEquals(1, l2.getNumberOfElements());
	}
	
	@Test //test on move method
	public void testMove() {
		l1 = new LIFO(3);
			l1.push(1);
			l1.push(2);
			l1.push(3);
		l2 = new LIFO(3);
		l3 = new LIFO(3);
		h.move(3, l1, l2, l3);
		assertEquals(0, l1.getNumberOfElements());
		assertEquals(3, l2.getNumberOfElements());
	}
}
