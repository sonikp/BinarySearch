package org.assignment1.binarysearch;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class BinarySearchTests {
	
	
	int[] testArray;
	
	@Before
	// Set up for testing before testing begins, none needed for these test cases
	
	@Test
	public void searchingForKeyNotInArrayIsMinusOne() {
		assertEquals(-1, binarySearch(new int[]{0}, 1));
		// asserts that search for a non-existent key value in a small array returns -1 (not found response)
	}
	
	@Test
	public void searchingForKeyNotInLargerArrayIsMinusOne() {
		assertEquals(-1, binarySearch(new int[] {1, 2, 3}, 7));
		// asserts that search for a non-existent key value in a 3 item array returns -1 (not found response)
	}
	
	@Test
	public void searchingForKeyPresentInArrayLengthOneIsZero() throws Exception {
		assertEquals(0, binarySearch(new int[]{1}, 1));
		// asserts that search for the key value 1, in a array with one item, correctly returns the correct
		// location in the array, first location = 0
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
	
	
	
	@Test
	public void smokeTestsForBinarySearch() throws Exception {
		int[] arrayWith42 = new int[] { 1, 4, 42, 55, 67, 87, 100, 245 };
		assertEquals(2, binarySearch(arrayWith42, 42));
		assertEquals(-1, binarySearch(arrayWith42, 43));
	}
	
	@Test
	public void searchEmptyArray() throws Exception {
		testArray = new int[] {};
		assertEquals(-1, binarySearch(testArray, 42));
		
	}
	
	@Test
	public void searchArraySizeOfOne() throws Exception {
		testArray = new int[] { 42 };
		assertEquals(0, binarySearch(testArray, 42));
		assertEquals(-1, binarySearch(testArray, 43));
	}
	
	

	
	@Test
	public void testBoundaryCasesForItemLocation() throws Exception {
		testArray = new int[] { -324, -3, -1, 0, 42, 99, 101 };
		assertEquals(0, binarySearch(testArray, -324));
		assertEquals(3, binarySearch(testArray, 0));
		assertEquals(6, binarySearch(testArray, 101));
	}
	
	@Test
	public void testForMinAndMaxInteger() throws Exception {
		testArray = new int[] { Integer.MIN_VALUE, -324, -3, -1, 0, 42, 99, 101, Integer.MAX_VALUE };
		assertEquals(0, binarySearch(testArray, Integer.MIN_VALUE));
		assertEquals(8, binarySearch(testArray, Integer.MAX_VALUE));
	}
	
	@Test(expected=NumberFormatException.class)
	public void testForNullKeyValue() throws Exception {
		testArray = new int[] { Integer.MIN_VALUE, -324, -3, -1, 0, 42, 99, 101, Integer.MAX_VALUE };
		assertEquals(0, binarySearch(testArray, Integer.valueOf(null)));
	}
	
	@Test(expected=AssertionError.class)
	public void calculateMidpointWithBoundaryValues() throws Exception {
		assertEquals(0, calculateMidpointContainingBug(0,1));
		assertEquals(1, calculateMidpointContainingBug(0,2));
		assertEquals(1200000000, calculateMidpointContainingBug (1100000000, 1300000000));		
		assertEquals(Integer.MAX_VALUE - 2, calculateMidpointContainingBug(Integer.MAX_VALUE-2, Integer.MAX_VALUE-1));
		assertEquals(Integer.MAX_VALUE - 1, calculateMidpointContainingBug(Integer.MAX_VALUE-1, Integer.MAX_VALUE));
	}
	
	@Test
	public void calculateMidpointFixSubtractLowFromHighWithBoundaryValues() throws Exception {
		assertEquals(0, calculateMidpointFixSubtractLowFromHigh(0,1));
		assertEquals(1, calculateMidpointFixSubtractLowFromHigh(0,2));
		assertEquals(1200000000, calculateMidpointFixSubtractLowFromHigh (1100000000, 1300000000));		
		assertEquals(Integer.MAX_VALUE - 2, calculateMidpointFixSubtractLowFromHigh(Integer.MAX_VALUE-2, Integer.MAX_VALUE-1));
		assertEquals(Integer.MAX_VALUE - 1, calculateMidpointFixSubtractLowFromHigh(Integer.MAX_VALUE-1, Integer.MAX_VALUE));
	}
	
	@Test
	public void calculateMidpointFixShiftSignBitWithBoundaryValues() throws Exception {
		assertEquals(0, calculateMidpointFixShiftSignBit(0,1));
		assertEquals(1, calculateMidpointFixShiftSignBit(0,2));
		assertEquals(1200000000, calculateMidpointFixShiftSignBit (1100000000, 1300000000));		
		assertEquals(Integer.MAX_VALUE - 2, calculateMidpointFixShiftSignBit(Integer.MAX_VALUE-2, Integer.MAX_VALUE-1));
		assertEquals(Integer.MAX_VALUE - 1, calculateMidpointFixShiftSignBit(Integer.MAX_VALUE-1, Integer.MAX_VALUE));
	}
	

	
	protected int binarySearch(int[] a, int key) {
		return BinarySearch.binarySearch(a, key);
	}
	
	protected int calculateMidpointContainingBug(int low, int high) {
		return BinarySearch.calculateMidpointContainingBug(low, high);
	}
	
	protected int calculateMidpointFixSubtractLowFromHigh(int low, int high) {
		return BinarySearch.calculateMidpointFixSubtractLowFromHigh(low, high);
	}
	
	protected int calculateMidpointFixShiftSignBit(int low, int high) {
		return BinarySearch.calculateMidpointFixShiftSignBit(low, high);
	}
	
	
	


}
