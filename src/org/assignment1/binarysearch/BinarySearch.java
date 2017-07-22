package org.assignment1.binarysearch;

public class BinarySearch {
	
	public static int binarySearch(int[] a, int key) {
		int low = 0;
		int high = a.length - 1;
		
		while (low <= high ){
			int mid = (low + high) / 2;		// this is where the error occurs
			int midVal = a[mid];
			
			if (midVal < key)
				low = mid + 1;
			else if (midVal > key)
				high = mid - 1;
			else
				return mid; // key found
		}
		return -(low + 1);  // key not found.
		
	}
	
}
