package org.assignment1.binarysearch;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Random;

public class RandomArray {
	
	Random rand = new Random();
	int limit = 100;
	int low;
	int high;
	static int[] randomArray;
	static int maxArraySize = 10;
	static int maxValue = 100;
	int experiments = 1;	// 1000
	int[] testArray;
	int target;
	int returnValue;
	
	public int[] generateRandomSortedArray(int maxArraySize, int maxValue) {
		int arraySize = 1 + rand.nextInt(maxArraySize);
		int[] randomArray = new int[arraySize];
		for (int i = 0; i < arraySize; i++) {
			randomArray[i] = rand.nextInt(maxValue);
		}
		Arrays.sort(randomArray);
		return randomArray;
	}
	
	
	public static void main(String[] args) {
		RandomArray testArray = new RandomArray();
		testArray.generateRandomSortedArray(maxArraySize, maxValue);
//		System.out.println(randomArray[0]);
		
		int[] array = { 1,2,3 }; 

		for (int i = 0; i < array.length; i++) {
//			randomArray[i] = rand.nextInt(100);
            System.out.println(array[i] + "  ");
		}
	}

}

