package org.assignment1.binarysearch;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * These JUnit tests aim to test all the conditions for the BinarySearch.java logic.
 * This includes tests for 
 * - low value / beyond low value
 * - mid value
 * - high value / beyone high value
 * - null value key
 * - MAX low value
 * - MAX high value
 * 
 * @author sonikp
 * @version Jul, 25, 2017
 *
 */

public class BinarySearchTests {
	
	
	int[] testArray;
	
	/**
	 * Set up for testing before testing begins, none needed for these test cases
	 */
	@Before
	public void setUp() {
		System.out.println("No items to set up before testing begins");
	}
	
	/**
	 * Assert to search for a non-existent key value in a small array returns -1 (not found response)
	 */
	@Test
	public void searchingForKeyNotInArrayIsMinusOne() {
		assertEquals(-1, binarySearch(new int[]{0}, 1));
	}
	
	
	/**
	 * Asserts that search for a non-existent key value in a 3 item array returns -1 (not found response)
	 */
	@Test
	public void searchingForKeyNotInLargerArrayIsMinusOne() {
		assertEquals(-1, binarySearch(new int[] {1, 2, 3}, 7));
	}
	
	/**
	 * Asserts that search for the key value 1, in a array with one item, correctly returns the correct
	 * location in the array, first location = 0
	 */
	@Test
	public void searchingForKeyPresentInArrayLengthOneIsZero() throws Exception {
		assertEquals(0, binarySearch(new int[]{1}, 1));
	}
	
	
	/**
	 * Asserts that search for the key value at midpoint exists, returns location = 1
	 */
	@Test
	public void searchingForKeyThatIsMidpointOfArrayLengthThreeIsOne() throws Exception {
		assertEquals(1, binarySearch(new int[] {1, 2, 3}, 2));	
	}
	
	/**
	 * Asserts that search for the key value in upper half exists, returns location = 2
	 */
	@Test
	public void searchingForKeyThatIsMidpointOfUpperHalfOfArrayLengthThreeIsTwo() throws Exception {
		assertEquals(2, binarySearch(new int[] {1, 2, 3}, 3));
	}
	
	/**
	 * Asserts that search for the key value in lower half exists, returns location = 0
	 */
	@Test
	public void searchingForKeyThatIsMidpointOfLowerHalfOfArrayLengthThreeIsZero() throws Exception {
		assertEquals(0, binarySearch(new int[] {1, 2, 3}, 1));
	}
	
	/**
	 * Expanded tests, two assertions
	 * Asserts larger array contains key value of 42, returns location = 2
	 * Asserts larger array does not contains key value of 43, returns non-existent value indicator = -1
	 */
	@Test
	public void smokeTestsForBinarySearch() throws Exception {
		int[] arrayWith42 = new int[] { 1, 4, 42, 55, 67, 87, 100, 245 };
		assertEquals(2, binarySearch(arrayWith42, 42));
		assertEquals(-1, binarySearch(arrayWith42, 43));
	}
	/**
	 * Assert that search key value does not exist in an empty array, returns non-existent value indicator = -1
	 */
	@Test
	public void searchEmptyArray() throws Exception {
		testArray = new int[] {};
		assertEquals(-1, binarySearch(testArray, 42));	
	}
	
	/**
	 * Assert single key value 42 exists in a single value array, returns location = 0
	 * Assert single key value 43 does not exist in a single value array, returns location = 0
	 */
	@Test
	public void searchArraySizeOfOne() throws Exception {
		testArray = new int[] { 42 };
		assertEquals(0, binarySearch(testArray, 42));
		assertEquals(-1, binarySearch(testArray, 43));
	}
	
	/**
	 * Asserts for boundary match testing, including array with negative numbers:
	 * - lower boundary = -324, returns location = 0
	 * - middle boundary = 0, returns location = 3
	 * - upper boundary = 101, returns location = 6
	 */	
	@Test
	public void testBoundaryCasesForItemLocation() throws Exception {
		testArray = new int[] { -324, -3, -1, 0, 42, 99, 101 };
		assertEquals(0, binarySearch(testArray, -324));
		assertEquals(3, binarySearch(testArray, 0));
		assertEquals(6, binarySearch(testArray, 101));
	}
	
	/**
	 * Assert for existence of max/min integer value in an array containing both max/min integer value
	 * - min, returns location = 0
	 * - max, returns location = 8
	 */
	@Test
	public void testForMinAndMaxInteger() throws Exception {
		testArray = new int[] { Integer.MIN_VALUE, -324, -3, -1, 0, 42, 99, 101, Integer.MAX_VALUE };
		assertEquals(0, binarySearch(testArray, Integer.MIN_VALUE));
		assertEquals(8, binarySearch(testArray, Integer.MAX_VALUE));
	}
	
	/**
	 * Test for exceptions
	 * Assert NumberFormatException error for a key value of 'null', 
	 * @throws Exception: returns expected NumberFormatException error condition
	 */
	@Test(expected=NumberFormatException.class)
	public void testForNullKeyValue() throws Exception {
		testArray = new int[] { Integer.MIN_VALUE, -324, -3, -1, 0, 42, 99, 101, Integer.MAX_VALUE };
		assertEquals(0, binarySearch(testArray, Integer.valueOf(null)));
	}
	
	/**
	 * Test for exceptions, tested 3x with different midpoint calculation methods
	 * TEST1: Test code containing bug, with large number values to prove and cause error condition.
	 * Assert test condition completes with low integer values, returns calculated values within Integer boundaries
	 * Assert test condition triggers exception with high/MAX/MIN integer values, 
	 * @throws Exception: triggers AssertionError as addition is out of integer boundaries
	 */
	@Test(expected=AssertionError.class)
	public void calculateMidpointWithBoundaryValuesWithBug() throws Exception {
		assertEquals(0, calculateMidpointContainingBug(0,1));
		assertEquals(1, calculateMidpointContainingBug(0,2));
		assertEquals(1200000000, calculateMidpointContainingBug (1100000000, 1300000000));		
		assertEquals(Integer.MAX_VALUE - 2, calculateMidpointContainingBug(Integer.MAX_VALUE-2, Integer.MAX_VALUE-1));
		assertEquals(Integer.MAX_VALUE - 1, calculateMidpointContainingBug(Integer.MAX_VALUE-1, Integer.MAX_VALUE));
	}
	
	/**
	 * Test for exceptions, tested 3x with different midpoint calculation methods
	 * TEST2: Test code fixed bug, subtract low value from high value.
	 * Assert test condition completes with low integer values, returns calculated values within Integer boundaries
	 * Assert test condition no longer triggers exception with high/MAX/MIN integer values.
	 */
	@Test
	public void calculateMidpointFixSubtractLowFromHighWithBoundaryValues() throws Exception {
		assertEquals(0, calculateMidpointFixSubtractLowFromHigh(0,1));
		assertEquals(1, calculateMidpointFixSubtractLowFromHigh(0,2));
		assertEquals(1200000000, calculateMidpointFixSubtractLowFromHigh (1100000000, 1300000000));		
		assertEquals(Integer.MAX_VALUE - 2, calculateMidpointFixSubtractLowFromHigh(Integer.MAX_VALUE-2, Integer.MAX_VALUE-1));
		assertEquals(Integer.MAX_VALUE - 1, calculateMidpointFixSubtractLowFromHigh(Integer.MAX_VALUE-1, Integer.MAX_VALUE));
	}
	
	/**
	 * Test for exceptions, tested 3x with different midpoint calculation methods
	 * TEST3: Test code fixed bug, uses signed shift bit.
	 * Assert test condition completes with low integer values, returns calculated values within Integer boundaries
	 * Assert test condition no longer triggers exception with high/MAX/MIN integer values.
	 */
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
