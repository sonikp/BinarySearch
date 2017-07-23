package org.assignment1.binarysearch;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;



public class BinarySearchTestTheories {
	
	Random rand;
	
	@Before
	public void initialize() {
		rand = new Random();
	}
	
	@Test
	public void testTheories() throws Exception {
		
		int maxArraySize = 1000;
		int maxValue = 1000;
		int experiments = 1000;
		int[] testArray;
		int target;
		int returnValue;
		
		while (experiments > 0) {
			testArray = generateRandomSortedArray(maxArraySize, maxValue);
			if (rand.nextBoolean()) {
				target = testArray[rand.nextInt(testArray.length)];
			}
			else {
				target = rand.nextInt();
			}
			returnValue = BinarySearch.binarySearch(testArray, target);
			assertTheory1(testArray, target, returnValue);
			assertTheory2(testArray, target, returnValue);
			
		}
		
	}
	
	public void assertTheory1(int[] testArray, int target, int returnValue) {
		if (returnValue == -1 ) {
			assertFalse(arrayContainsTarget(testArray, target));
		}
	}
	
	public void assertTheory2(int[] testArray, int target, int returnValue) {
		if (returnValue >= 0 ) {
			assertEquals(target, testArray[returnValue]);
		}
	}
	
	public boolean arrayContainsTarget(int[] testArray, int target) {
		for (int i = 0; i < testArray.length; i++) {
			if (testArray[i] == target) {
				return true;
			}
		}
		return false;
	}


	
	public int[] generateRandomSortedArray(int maxArraySize, int maxValue) {
		int arraySize = 1 + rand.nextInt(maxArraySize);
		int[] randomArray = new int[arraySize];
		for (int i = 0; i < arraySize; i++) {
			randomArray[i] = rand.nextInt(maxValue);
		}
		Arrays.sort(randomArray);
		return randomArray;
		
	}
	
}