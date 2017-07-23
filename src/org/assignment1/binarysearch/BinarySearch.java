package org.assignment1.binarysearch;

public class BinarySearch {
	
	public static int binarySearch(int[] a, int key) {
		int low = 0;
		int high = a.length - 1;
		
		while (low <= high ){
//			int mid = (low + high) / 2;		// original code: replaced this line of code for testing this specific point of failure
			int mid = calculateMidpointContainingBug(low, high);
			
			// This allows you to try out the fixes
//			int mid = calculateMidpointFixSubtractLowFromHigh(low, high);
//			int mid = calculateMidpointFixShiftSignBit(low, high);
			
			int midVal = a[mid];
			
			if (midVal < key)
				low = mid + 1;
			else if (midVal > key)
				high = mid - 1;
			else
				return mid; // key found
		}
//		return -(low + 1);  // key not found.  !! original provided in class, but returns different value for testing. 
		return -1;			// changed so JUnit always returns same value when running tests
	}
	
	public static int calculateMidpointContainingBug(int low, int high) {
		return (low + high) / 2;		// code that fails because 2^31 (MAX_VALUE) causes the counter to roll-over to a negative integer
	}
	
	public static int calculateMidpointFixSubtractLowFromHigh(int low, int high) {
		return low + ((high - low) / 2);// keeps the total sum for the addition of high value high/low under the Integer.MAX_VALUE 
	}
	
	public static int calculateMidpointFixShiftSignBit(int low, int high) {
		return (low + high) >>> 1;		// uses the unused sign-bit to perform a correct average of non-negative numbers
	}
	
}
