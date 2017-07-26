package org.assignment1.binarysearch;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

/**
 * This set of JUnit tests aim to test extreme random sized and random valued arrays, including both random extreme sized existing 
 * and non-existing key sizes. Extreme integer values aim to testing integer boundary values sizes for MAX and MIN integer values. 
 * This includes tests for 
 * - Integer.MAX_VALUE
 * - Integer.MIN_VALUE
 * - extreme random array sizes
 * - extreme random existent and non-existent key values
 * 
 * @author sonikp
 * @version Jul, 25, 2017
 *
 */



public class BinarySearchTestTheories {
	
	Random rand;
	int maxArraySize = Integer.MAX_VALUE / 2 ;			// 100; // Integer.MAX_VALUE / 2;
	int maxValue = Integer.MAX_VALUE; // 100; // Integer.MAX_VALUE;
	int experiments = 1;	// 1000
	int[] testArray;
	int key;
	int returnValue;
	
	/**
	 * Set up for testing before testing begins, creates a "rand" random object
	 */
	@Before
	public void initialize() {
		rand = new Random();
	}
	
	/**
	 * Creates random sized arrays
	 * Populates random sized arrays with random integers, positive/negative in range of Integer.MIN_VALUE to Integer.MAX_VALUE
	 * Sorts arrays
	 * Generates a key value, either existent from array or non-existent
	 * Assert tests, test conditions
	 */
	@Test
	public void testTheories() throws Exception {
		System.out.println("Starting.....");
		System.out.println("ArraySize: " + maxArraySize);

		/**
		 * Runs the tests a specified number of times. Call BinarySearch 
		 * with the randomArray and a key value. Implement the assertEquals or the assertFalse
		 * to test for the different conditions
		 */
		while (experiments > 0) {
			System.out.println();
			testArray = generateRandomSortedArray(maxArraySize, maxValue);
			boolean randomBoolean = rand.nextBoolean();
			System.out.println("randomBoolean " + randomBoolean);
			if (randomBoolean) {
				key = testArray[rand.nextInt(testArray.length)];
				System.out.println("key " + key);
			}
			else {
				key = rand.nextInt();
				System.out.println("key " + key);
			}
			returnValue = BinarySearch.binarySearch(testArray, key);
			System.out.println("returnValue " + returnValue);
			assertTheory1(testArray, key, returnValue);
			assertTheory2(testArray, key, returnValue);
			System.out.println("returnValue " + returnValue);
			experiments--;
		}
		System.out.println(".....completed!");
	}
	
	/**
	 * Asserts that search for the key value in array that does not exist, returns location = 1
	 */
	public void assertTheory1(int[] testArray, int key, int returnValue) {
		System.out.println("Enter assertTheory1");
		if (returnValue == -1 ) {
			assertFalse(arrayContainsTarget(testArray, key));
		}
	}
	
	/**
	 * Asserts that search for the key value in array that does exist, returns location of key value
	 */
	public void assertTheory2(int[] testArray, int key, int returnValue) {
		System.out.println("Enter assertTheory2");
		if (returnValue >= 0 ) {
			assertEquals(key, testArray[returnValue]);	//key, testArray[returnValue]
		}
	}
	
	public boolean arrayContainsTarget(int[] testArray, int key) {
		System.out.println("Enter arrayContainsTarget");
		for (int i = 0; i < testArray.length; i++) {
			if (testArray[i] == key) {
				System.out.println("Enter arrayContainsTarget = TRUE");
				return true;
			}
		}
		System.out.println("Enter arrayContainsTarget = FALSE");
		return false;
	}


	/**
	 * Generates random arrays, based on maxArraySize and maxValue.
	 * @param maxArraySize
	 * @param maxValue
	 * @return randomArray
	 */
	public int[] generateRandomSortedArray(int maxArraySize, int maxValue) {
		int arraySize = 1 + rand.nextInt(maxArraySize);
		int[] randomArray = new int[arraySize];
		for (int i = 0; i < arraySize; i++) {
			randomArray[i] = rand.nextInt(maxValue);
		}
		Arrays.sort(randomArray);
		for (int i = 0; i < randomArray.length; i++){
			 System.out.println("Element at index " + randomArray[i]);
		}
		return randomArray;
		
	}
	

	
}