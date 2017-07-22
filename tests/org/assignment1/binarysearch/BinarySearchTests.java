package org.assignment1.binarysearch;

import static org.junit.Assert.*;

import org.junit.Test;

public class BinarySearchTests {
	
	@Test
	public void searchingForKeyNotInArrayIsMinusTwo() {
		assertEquals(-2, binarySearch(new int[]{0}, 1));
	}
	
	@Test
	public void searchingForKeyNotInLargerArrayIsMinusFour() {
		assertEquals(-4, binarySearch(new int[] {1, 2, 3}, 7));
	}
	
	@Test
	public void searchingForKeyPresentInArrayLengthOneIsZero() throws Exception {
		assertEquals(0, binarySearch(new int[]{1}, 1));
	}
	
	@Test
	public void searchingForKeyThatIsMidpointOfArrayLengthThreeIsOne() throws Exception {
		assertEquals(1, binarySearch(new int[] {1, 2, 3}, 2));
		
	}
	
	@Test
	public void searchingForKeyThatIsMidpointOfUpperHalfOfArrayLengthThreeIsTwo() throws Exception {
		assertEquals(2, binarySearch(new int[] {1, 2, 3}, 3));
	}
	
	@Test
	public void searchingForKeyThatIsMidpointOfLowerHalfOfArrayLengthThreeIsZero() throws Exception {
		assertEquals(0, binarySearch(new int[] {1, 2, 3}, 1));
	}

	protected int binarySearch(int[] a, int key) {
		return new BinarySearch().binarySearch(a, key);
	}
	


}
