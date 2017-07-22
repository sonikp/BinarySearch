package org.assignment1.binarysearch;

import static org.junit.Assert.*;

import org.junit.Test;

public class BinarySearchTests {
	
	int[] testArray;
	/*
	@Test
	public void searchingForKeyNotInArrayIsMinusOne() {
		assertEquals(-1, binarySearch(new int[]{0}, 1));
	}
	
	@Test
	public void searchingForKeyNotInLargerArrayIsMinusOne() {
		assertEquals(-1, binarySearch(new int[] {1, 2, 3}, 7));
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
	*/
	
	/*
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
	*/
	
	@Test
	public void calculateMidpointWithBoundaryValues() throws Exception {
		assertEquals(0, calculateMidpoint(0,1));
		assertEquals(1, calculateMidpoint(0,2));
		assertEquals(1200000000, calculateMidpoint (1100000000, 1300000000));
//		assertEquals(1200000000, calculateMidpoint (1100000000, 1300000000));		
//		assertEquals(Integer.MAX_VALUE - 2, calculateMidpoint (Integer.MAX_VALUE-2, Integer.MAX_VALUE-1));
//		assertEquals(Integer.MAX_VALUE - 1, calculateMidpoint (Integer.MAX_VALUE-1, Integer.MAX_VALUE));
	}
	
	protected int binarySearch(int[] a, int key) {
		return BinarySearch.binarySearch(a, key);
	}
	
	protected int calculateMidpoint(int low, int high) {
		return BinarySearch.calculateMidpoint(low, high);
	}
	


}
