package org.assignment1.binarysearch;

public class BinarySearch {
	
	public static int binarySearch(int[] a, int key) {
		int low = 0;
		int high = a.length - 1;
		
		while (low <= high ){
//			int mid = (low + high) / 2;		// replaced this line of code for testing this specific point of failure
			int mid = calculateMidpoint(low, high);
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
	
	public static int calculateMidpoint(int low, int high) {
//		return (low + high) / 2;		// code that fails 2^31 is causes the counter to roll-over to a -ve integer
		return low + ((high - low) / 2);// keeps the addition of the high/low under the Integer.MAX_VALUE 
//		return (low + high) >>> 1;		// uses the unused sign-bit to perform a correct average of non-negative numbers

	}
	
}
