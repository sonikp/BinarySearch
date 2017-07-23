package org.assignment1.binarysearch;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;



public class BinarySearchTestTheories {
	
	Random rand;
	int maxArraySize = 10;
	int maxValue = Integer.MAX_VALUE;
	int experiments = 10;	// 1000
	int[] testArray;
	int target;
	int returnValue;
	
	@Before
	public void initialize() {
		rand = new Random();
	}
	
	@Test
	public void testTheories() throws Exception {
		System.out.println("Starting.....");
		System.out.println("ArraySize: " + maxArraySize);

		
		while (experiments > 0) {
			System.out.println();
			testArray = generateRandomSortedArray(maxArraySize, maxValue);
			boolean randomBoolean = rand.nextBoolean();
			System.out.println("randomBoolean " + randomBoolean);
			if (randomBoolean) {
				target = testArray[rand.nextInt(testArray.length)];
				System.out.println("target " + target);
			}
			else {
				target = rand.nextInt();
				System.out.println("target " + target);
			}
			returnValue = BinarySearch.binarySearch(testArray, target);
			assertTheory1(testArray, target, returnValue);
			assertTheory2(testArray, target, returnValue);
			System.out.println("returnValue " + returnValue);
			experiments--;
		}
		
	}
	
	public void assertTheory1(int[] testArray, int target, int returnValue) {
		System.out.println("Enter assertTheory1");
		if (returnValue == -1 ) {
			assertFalse(arrayContainsTarget(testArray, target));
		}
	}
	
	public void assertTheory2(int[] testArray, int target, int returnValue) {
		System.out.println("Enter assertTheory2");
		if (returnValue >= 0 ) {
			assertEquals(target, testArray[returnValue]);
		}
	}
	
	public boolean arrayContainsTarget(int[] testArray, int target) {
		System.out.println("Enter arrayContainsTarget");
		for (int i = 0; i < testArray.length; i++) {
			if (testArray[i] == target) {
				System.out.println("Enter arrayContainsTarget = TRUE");
				return true;
			}
		}
		System.out.println("Enter arrayContainsTarget = FALSE");
		return false;
	}


	
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