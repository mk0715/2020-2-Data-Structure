// Lab 010	: Natural Merge
// Name :
// Student ID :

import java.util.*;


class NaturalMerge {
	int noe;  // the number of elements
	private int[] inputArray; // input array 
	int[] outputArray; // output array 


	NaturalMerge() { 
		noe = 0;
	}

	void Init(int [] arr, int n) { 
		noe = n;
		inputArray = new int[noe];
		System.arraycopy(arr, 0, inputArray, 0, n);

		outputArray = new int[noe];
	}

	void Merge() { 
		int m = 0;
		int n = noe;
		for(int i = 0; i < n; i ++) {
			
			if(inputArray[i+1] < inputArray[i]) {
				
				m = i+1;
				break;
			}
		}

		System.out.println("m = " + m + ", n = " + noe);

		// NEED TO IMPLEMENT
		
		
		int leftIndex = 0;
		int rightIndex = m;
		int pos = 0;
		
		
		while((leftIndex < m) && (rightIndex < noe)) {
			
			if(inputArray[leftIndex] <= inputArray[rightIndex]) {
				
				outputArray[pos] = inputArray[leftIndex];
				pos++;
				leftIndex ++;
				
			}else {
				
				outputArray[pos] = inputArray[rightIndex];
				pos++;
				rightIndex ++;
				
			}
			
		}
		
		for(;leftIndex < m; leftIndex++) {
			
			outputArray[pos] = inputArray[leftIndex];
			pos++;
			
		}
		
		for(;pos < noe; ) {
			
			outputArray[pos] = inputArray[rightIndex++];
			pos++;
			
		}
		
	}


}


